package shiva.metamusic.util;

import static java.lang.Math.*;

public class PitchBendUtils {

	
	private static double sigmoid(double x) {
		return 1/(1 + Math.exp(-x));
	}
	
	private static double scaledsin(double r, double x) {
		return sin(x * PI/r);
	}
	
	private static double scaledhalfsin(double r, double x) {
		return sin(x * PI/(2 *r));
	}
	
	private static double scaledshiftedhalfsin(double a, double b, double x) {
		return scaledhalfsin(b-a, x - a);
	}
	private static double scaledhalfcos(double r, double x) {
		return cos(x * PI/(2*r));
	}
	
	private static double scaledshiftedhalfcos(double a, double b, double x) {
		return scaledhalfcos(b-a, x - a);
	}
	
	static double peaked(double a, double m, double b, double x) {
		if (x < m) {
			return scaledshiftedhalfsin(a, m, x);
		} else {
			return scaledshiftedhalfcos(m, b, x);
		}
	}
	
	public static void main(String[] args) {
		double a = 10, b = 40;
		double m = 20;
		double r = b - a;
		for (double i = a; i < b; i += r/20) {
			System.out.printf("%.3f  %.6f  %.6f\n", i, peaked(a, m, b, i), scaledshiftedhalfcos(a, b, i));
		}
	}
	
}
