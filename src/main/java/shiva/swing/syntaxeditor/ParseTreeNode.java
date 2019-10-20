package shiva.swing.syntaxeditor;

import javax.swing.tree.DefaultMutableTreeNode;

import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.Tree;

import shiva.song4.Song4Parser;

@SuppressWarnings("serial")
public class ParseTreeNode extends DefaultMutableTreeNode {

		final Song4Parser parser;

		ParseTreeNode(ParseTree tree, Song4Parser parser) {
			super(tree);
			this.parser = parser;
			
			
		}

		@Override
		public String toString() {
			if (this.getUserObject() == null) {
				return "";
			}
			Object o =  ((ParseTree) this.getUserObject()).getPayload();
			if (o instanceof RuleContext) {
				RuleContext r = (RuleContext) o; 
				return getRuleName(r.getRuleIndex());
			} else if (o instanceof Token) {
				Token t = (Token) o;
				return t.getText();
			} else {
				System.out.println(o.getClass().getName());
				return "Unknown " + o.getClass().getName();
				
			}
		}

		private String getRuleName(int ruleIndex) {
			return parser.getRuleNames()[ruleIndex];
		}
	}
