package shiva.music.generate;

import java.util.ArrayList;
import java.util.List;

import shiva.music.generate.GenerateUtils.IndexPair;

public class EulerConsonance {

	// http://www.mathematik.com/Piano/
	/*
	 * In western music an octave is devided into 12 equal steps. The frequencies
	 * form a geometric sequence with factor 2 1/12 . This multiplicative structure
	 * comes from the fact that the human ear listens logarithmically. Rational
	 * Frequency relations are considered "harmonic" . A geometric sequence is
	 * translational invariant but can only approximate rational numbers. With 12
	 * steps, this can be achieved well, better for example than in Stockhausen's 5
	 * 1/5 scale.
	 * 
	 */

	/*
	 * Gradus Suavitatis: April 11, 2000 (corrections and updates April 2012, thanks
	 * to Vicente Liern) (an other correction April 2014, thanks to Michael Somos).
	 * Euler introduced a functional on rational numbers called "Gradus Suavis"
	 * which means "degree of sweetness". It is a measure of harmony of that ratio.
	 * Let's call E(n) = sum e(p) (p-1) where the sum runs over all prime factors of
	 * n and where e(p) is the multiplicity. It is a functional on the integers
	 * called euler_gradus. For example E(60) = E(2^2*3*5) = 2*1+1*2+1*4
	 * Gradussuavis G(n,m) is defined as euler_gradus n*m+1, where n/m is a reduced
	 * fraction. In other words G(n,m) = euler_gradus n*m/gcd(n,m)^2 + 1.
	 */

	/**
	 * 
	 * @param note1 : midi value of note 1
	 * @param note2 : midi value of note 2
	 * @return
	 */
	public static int eulerConsonance(int note1, int note2) {
		int[] ratio = getIntegerFrequencyRatio(note1, note2);
		int g =  gradus_suavitalis(ratio[0] * ratio[1]);
		System.out.printf("%d  %d r=%d/%d  c=%d\n", note1, note2, ratio[0], ratio[1], g);
		return g;
		
	}

	/*
     * Java method to find GCD of two number using Euclid's method
     * @return GDC of two numbers in Java
     */
    private static int gcd(int number1, int number2) {
        //base case
        if(number2 == 0){
            return number1;
        }
        return gcd(number2, number1%number2);
    }
    
	private static int gradus_suavitalis(int n) {
		List<PrimeMultiplicity> pml = primeFactors(n);
		int g = 1;
		for (PrimeMultiplicity pm : pml) {
			g += pm.mult * (pm.prime - 1);
		}
		return g;
	}

	// A function to print all prime factors
	// of a given number n
	public static List<PrimeMultiplicity> primeFactors(int n) {
		List<PrimeMultiplicity> pfl = new ArrayList<>();
		// Print the number of 2s that divide n
		PrimeMultiplicity ip = new PrimeMultiplicity(2, 0);
		while (n % 2 == 0) {
			ip.mult++;
			n /= 2;
		}
		if (ip.mult > 0) {
			pfl.add(ip);
		}
		// n must be odd at this point. So we can
		// skip one element (Note i = i +2)
		for (int i = 3; i <= Math.sqrt(n); i += 2) {
			PrimeMultiplicity pm = new PrimeMultiplicity(i, 0);
			// While i divides n, print i and divide n
			while (n % i == 0) {
				pm.mult++;
				n /= i;
			}
			if (pm.mult > 0) {
				pfl.add(pm);
			}
		}

		// This condition is to handle the case whien
		// n is a prime number greater than 2
		if (n > 2) {
			pfl.add(new PrimeMultiplicity(n, 1));
		}
		return pfl;
	}
/*
	// n and m are the numerator and denominator of the (integer) frequency ratio
	private static int gradus_suavis(int n, int m) {
		int g, h;
		g = dijkstra_gcd(n, m);
		h = 1 + n * m / (g * g);
		return (euler_gradus(h));
	}

	private static int euler_gradus(int n) { // sum e_i (p-1) of primefactors p of n
		int k = n, s = 1, p;
		p = 2;
		while (Math.floor(k / p) == k / p) {
			k = k / p;
			s++;
		}
		for (p = 3; p <= n; p = p + 2) {
			while (Math.floor(k / p) == k / p) {
				k = k / p;
				s = s + p - 1;
			}
		}
		return (s);
	}

	private static int dijkstra_gcd(int a, int b) {
		if (a == b) {
			return (a);
		}
		if (a > b) {
			return dijkstra_gcd(a - b, b);
		} else {
			return dijkstra_gcd(a, b - a);
		}
	}
*/
	/**
	 * Calculates a rational ratio close to the actual frequency ratio
	 * @param note1 midi value
	 * @param note2 midi value
	 * @return
	 */
	// The ratio of 1 semitone is 2^(1/12)
	private static int[] getIntegerFrequencyRatio(int note1, int note2) {
		double factor = Math.pow(2, 1.0/12);
		int semitones = Math.abs(note1 - note2);
		double ratio = Math.pow(factor, semitones);
		int precision = 4;  // i.e; 10^4
		int denom = 1;
		for (int i = 0; i < precision; i++) {
			ratio *= 10;
			denom *= 10;
		}
		int num = (int) ratio;
		int gcd = gcd(num, denom);
		int[] r = new int[2];
		r[0] = num/gcd;
		r[1] = denom/gcd;
		return r;
		
	}
	
	private static class PrimeMultiplicity {
		int prime;
		int mult;
		public PrimeMultiplicity(int prime, int mult) {
			super();
			this.prime = prime;
			this.mult = mult;
		}
		
		
	}

}
