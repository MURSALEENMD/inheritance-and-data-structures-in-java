/**
 * Represents a fraction with numerator and denominator.
 * @author lbrandon
 *
 */
public class Fraction {
	
	//instance vars
	
	/**
	 * Numerator for fraction.
	 */
	int numerator;
	
	/**
	 * Denominator for fraction.
	 */
	int denominator;
	
	//constructor
	
	/**
	 * Creates a fraction with the given numerator and denominator.
	 * @param numerator for fraction
	 * @param denominator for fraction
	 */
	public Fraction(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	/**
	 * Compares two fractions for equality by comparing their numerators and denominators.
	 */
	@Override
	public boolean equals(Object obj) {
		//cast given object to Fraction
		Fraction otherFraction = (Fraction) obj;
		
		//compare numerator and denominator of both fractions
		return (this.numerator == otherFraction.numerator 
				&& this.denominator == otherFraction.denominator);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
