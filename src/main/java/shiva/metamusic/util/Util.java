package shiva.metamusic.util;

public class Util {

	/* Function to check if x is power of 2*/
	public static boolean isPowerOfTwo(int n) 
	{ 
		if(n==0) 
			return false; 

		return (int)(Math.ceil((Math.log(n) / Math.log(2)))) ==  
				(int)(Math.floor(((Math.log(n) / Math.log(2))))); 
	} 

}
