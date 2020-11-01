package digitsOfPi;


/**
 * Digits of Pi Circuit (software simulation)
 * @author Matthew McBurnie
 * @version November 01, 2020
 *
 */
public class DigitsOfPi {

	/**
	 * 
	 * For testing purposes only.
	 * 
	 * @param args: Unused.
	 */
	public static void main(String[] args) {

		// Note: a = a3, b = a2, c = a1, d = a0
		boolean a = false;
		boolean b = false;
		boolean c = false;
		boolean d = false;
		
		
		// Initial Output
		System.out.println("|        INPUTS        ||           OUTPUTS           |");
		System.out.println("|======================||=============================|");
		System.out.println("|a3 a2 a1 a0 | decimal || b3 | b2 | b1 | b0 | decimal |");
		System.out.println("|============|=========||====|====|====|====|=========|");
		
		/* This loop helps generate the table.
		 * 
		 * The loop only executes 11 times, as we only care about the first 10 digits
		 * of pi after the decimal place. If this loop executes 16 times, the outputs
		 * would all be 0, which is irrelevant information. 
		 */
		for(int i = 1; i <= 11; i++) {
			
			// Conversions
			byte b3 = boolToBinary(Output_b3(a, b, c, d));
			byte b2 = boolToBinary(Output_b2(a, b, c, d));
			byte b1 = boolToBinary(Output_b1(a, b, c, d));
			byte b0 = boolToBinary(Output_b0(a, b, c, d));
			
			byte a3 = boolToBinary(a);
			byte a2 = boolToBinary(b);
			byte a1 = boolToBinary(c);
			byte a0 = boolToBinary(d);
			
			byte decimalIn = convertToDecimal(a3, a2, a1, a0);
			byte decimalOut = convertToDecimal(b3, b2, b1, b0);
			
			
			/* Formatted Output: This will generate a table of numbers.
			 * 
			 * The terms (a3, a2, a1, a0, b3, b2, b1, b0) will either be a 0 or a 1
			 * (false or true respectively).
			 * 
			 * The decimal column converts the binary inputs from each of the terms
			 * and generates a decimal number, making it easily readable.
			 */
			System.out.printf("|%2s %2s %2s %2s | %7s || %2s | %2s | %2s | %2s | %7s |\n",
					a3, a2, a1, a0, decimalIn, b3, b2, b1, b0, decimalOut);
			
			// Alternate boolean expressions for inputs
			if(i % 8 == 0) {
				a = !a;
			}
			
			if(i % 4 == 0) {
				b = !b;
			}
			
			if(i % 2 == 0) {
				c = !c;
			}
			
			d = !d;
			
		}
		
		
		
	}
	
	
	/**
	 * Converts a boolean value to a binary number.
	 * 
	 * @param b: a boolean value.
	 * @return 0 if b is false, 1 if b is true.
	 */
	public static byte boolToBinary(boolean b) {
		
		byte output = 0;
		
		if(b)
			output = 1;
		
		return output;
		
	}
	
	
	/**
	 * Returns a boolean value representing an equation for b3
	 * 
	 * @param a: a boolean value.
	 * @param b: a boolean value.
	 * @param c: a boolean value.
	 * @param d: a boolean value.
	 * @return a true or false given the outcome of the equation
	 */
	public static boolean Output_b3(boolean a, boolean b, boolean c, boolean d) {
		
		boolean b3 = (!a && b && !c && d);
		return b3;
		
	}
	
	
	/**
	 * Returns a boolean value representing an equation for b2
	 * 
	 * @param a: a boolean value.
	 * @param b: a boolean value.
	 * @param c: a boolean value.
	 * @param d: a boolean value.
	 * @return a true or false given the outcome of the equation
	 */
	public static boolean Output_b2(boolean a, boolean b, boolean c, boolean d) {
		
		boolean b2 = (!a && !b && c && !d) || (!a && b && !c && !d) || (!a && b && c && d) || (a && !b && !c && !d) || (a && !b && c && !d);
		return b2;
		
	}
	
	
	/**
	 * Returns a boolean value representing an equation for b1
	 * 
	 * @param a: a boolean value.
	 * @param b: a boolean value.
	 * @param c: a boolean value.
	 * @param d: a boolean value.
	 * @return a true or false given the outcome of the equation
	 */
	public static boolean Output_b1(boolean a, boolean b, boolean c, boolean d) {
		
		boolean b1 = (!a && !b && !c && !d) || (a && !b && !c && d) || (!a && b && c);
		return b1;
		
	}
	
	
	/**
	 * Returns a boolean value representing an equation for b0
	 * 
	 * @param a: a boolean value.
	 * @param b: a boolean value.
	 * @param c: a boolean value.
	 * @param d: a boolean value.
	 * @return a true or false given the outcome of the equation
	 */
	public static boolean Output_b0(boolean a, boolean b, boolean c, boolean d) {
		
		boolean b0 = (a && !b && c && !d) || (a && !b && !c) || (!a && !b && d) || (!a && !c);
		return b0;
	}
	
	
	/**
	 * Converts a binary value to a decimal value
	 * 
	 * @param a: a binary value.
	 * @param b: a binary value.
	 * @param c: a binary value.
	 * @param d: a binary value.
	 * @return a value from 0 to 9
	 */
	public static byte convertToDecimal(byte a, byte b, byte c, byte d) {
		
		byte decimal = (byte) ((Math.pow(2, 3) * a) + (Math.pow(2, 2) * b) + (Math.pow(2, 1) * c)+ (Math.pow(2, 0) * d));
		return decimal;
		
	}
	
	
	
	

}
