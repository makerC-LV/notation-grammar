package shiva.music.generate.counterpoint;

import java.util.function.Predicate;

public class Rules {

	public static class RuleResult {
		public String name;
		public boolean pass;
		public double scoreBefore;
		public double scoreAfter;
		public RuleResult(String name, double scoreBefore) {
			super();
			this.name = name;
			this.scoreBefore = scoreBefore;
		}
		
		public void set(Boolean pass, double scoreAfter) {
			this.pass = pass;
			this.scoreAfter = scoreAfter;
		}
		@Override
		public String toString() {
			return String.format("RR %b  [ %.3f -> %.3f ] %s", pass, scoreBefore, scoreAfter, name);
		}
	}
	
	
	abstract private static class ACRule implements CRule {
		int penalty;
		String name;
		boolean debug;
		
		public ACRule(String name, int penalty) {
			super();
			this.penalty = penalty;
			this.name = name;
		}

		@Override
		public void score(RuleContext rc) {
			RuleResult rr = new RuleResult(name, rc.sn.score);
			boolean b = pass(rc);
			if (!b) {
				rc.sn.score += penalty;
				rr.set(false, rc.sn.score);
			} else {
				rr.set(true, rc.sn.score);
			}
			if (debug && rc.sn.debug) {
				printDebug(rc, b);
			}
			rc.sn.addResult(rr);
		}

		protected void printDebug(RuleContext rc, Object... oa) {
			StringBuilder sb = new StringBuilder();
			sb.append("Applying: " + name + " to " + rc.sn.toStringSimple() + " : " );
			for (Object o : oa) {
				sb.append(o.toString());
				sb.append(" ");
			}
			System.out.println(sb.toString());
		}

		protected abstract boolean pass(RuleContext rc);
		
		
	}
	
	public static class GRule extends ACRule {

		protected Predicate<RuleContext> condition;
		protected Predicate<RuleContext> test;
		
		public GRule() {
			super(null, 0);
		}
		
		public GRule(String name, int penalty, Predicate<RuleContext> cond) {
			this(name, penalty, rc -> {return true;}, cond);
		}

		public GRule(String name, int penalty, Predicate<RuleContext> condition, Predicate<RuleContext> test) {
			super(name, penalty);
			this.condition = condition;
			this.test = test;
		}
		
		public GRule debug() {
			this.debug = true;
			return this;
		}
		
		
		@Override
		public void score(RuleContext rc) {
			boolean applies = condition.test(rc);
			if (applies) {
				super.score(rc);
			}
		}

		@Override
		protected boolean pass(RuleContext rc) {
			return test.test(rc);
		}

	}
	
	
}
