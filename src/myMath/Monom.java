
package myMath;

/**
 * This class represents a simple "Monom" of shape a*x^b, where a is a real
 * number and a is an integer (summed a none negative), see:
 * https://en.wikipedia.org/wiki/Monomial The class implements function and
 * support simple operations as: construction, value at x, derivative, add and
 * multiply.
 * 
 * @author Boaz
 *
 */
public class Monom implements function {

	private double _coefficient;
	private int _power;
	
	/**
	 * Monom 
	 * A constructor that receives two parameters a and and creates a monom object.
	 * @param a - monom coefficient
	 * @param b - monom power
	 */
	public Monom(double a, int b) {
		this.set_coefficient(a);
		this.set_power(b);
	}

	/**
	 * Monom
	 * A copier constructor who gets an object to him and creates a new one just like him.
	 * @param ot - the copied monom object
	 */
	public Monom(Monom ot) {
		this(ot.get_coefficient(), ot.get_power());
	}

	/**
	 * set_coefficient
	 * Set the monom coefficient.
	 * @param a - monom coefficient
	 */
	private void set_coefficient(double a) {
		this._coefficient = a;
	}

	/**
	 * set_power
	 * Set the monom power.
	 * @param p - monom power
	 */
	private void set_power(int p) {

		//Negative power this is an invalid input so an error should be thrown in this case.
		if (p < 0) {
			throw new RuntimeException("the monom power should be a non-negative integer");
		} else {
			this._power = p;
		}
	}

	/**
	 * get_coefficient
	 * get the monom coefficient.
	 * @return - monom coefficient
	 */
	public double get_coefficient() {
		return _coefficient;
	}

	/**
	 * get_power
	 * get the monom power.
	 * @return - monom power
	 */
	public int get_power() {
		return _power;
	}


	/**
	 * f
	 * Calculation y=f(x).
	 * @param x - the x value for him we want to calculate the function value
	 * @return - f(x) value
	 */
	public double f(double x) {

		// if the x or the monom coefficient are '0' return 0
		if (x == 0 || get_coefficient() == 0) {

			// private case when 0^0=1
			if (x == 0 && get_power() == 0) {
				return get_coefficient();
			}

			else {
				return 0;
			}

			//calculation of f(x).
		} else {
			return get_coefficient() * Math.pow(x, get_power());
		}
	}

	/**
	 * add
	 * Add between two monoms (update 'this' monom with the result).
	 * @param other - added monom
	 */
	public void add(Monom other) {
		
		//if they are with the same power - add other monom to this monom
		if (_power == other.get_power()) {
			_coefficient = _coefficient + other.get_coefficient();
			
		//if they are not with the same power - the operation cannot be dome and throw an error
		} else {
			throw new RuntimeException("Cannot add 2 monoms with a different powers");
		}
	}

	/**
	 * multiply
	 * Multiplication between two monoms (update 'this' monom with the result).
	 * @param other - multiply monom
	 */
	public void multiply(Monom other) {

		//If one of the monoms has a coefficient of '0' then the product result is zero.
		if (_coefficient == 0 || other.get_coefficient() == 0) {
			_coefficient = 0;
			_power = 0;
			
		//else calculates the product result
		} else {
			_coefficient = _coefficient * other.get_coefficient();
			_power = _power + other.get_power();
		}
	}

	/**
	 * derivative
	 * Calculation the monom derivative.
	 * @return monom object of 'this' monom derivative
	 */
	public Monom derivative() {

		double new_coefficient;
		int new_power;

		//derivative of number is zero
		if (_coefficient == 0 || _power == 0) {
			new_coefficient = 0;
			new_power = 0;
		}

		//calculation the monom derivative
		else {
			new_coefficient = _coefficient * _power;
			new_power = _power - 1;
		}

		//create the monom object of 'this' monom derivative
		Monom Dmonom = new Monom(new_coefficient, new_power);

		return Dmonom;
	}

	/**
	 * equals
	 * Checks whether the monoms are the same (equals).
	 * @param other - the second monom
	 * @return - true if they equals, otherwise false
	 */
	public boolean equals(Monom other) {

		//two monoms are equals if they have the same coefficient and power.
		if (_coefficient == other.get_coefficient() && _power == other.get_power()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * toString
	 * Displays the monom as a string.
	 * @return - monom as a string
	 */
	public String toString() {

		if (get_coefficient() == 1) {

			if (get_power() == 1) {
				return "x";
			}

			else if (get_power() == 0) {
				return "1.0";
			}

			else {
				return "x^" + get_power();
			}
		}

		else if (get_coefficient() == -1) {

			if (get_power() == 1) {
				return "-x";
			} else if (get_power() == 0) {
				return "-1.0";
			} else {
				return "-x^" + get_power();
			}
		}

		else if (get_power() == 1) {

			if (get_coefficient() == 0) {
				return "0";
			}

			else {
				return get_coefficient() + "x";
			}
		}

		else if (get_power() == 0) {
			return String.valueOf(get_coefficient());
		}

		else if (get_coefficient() == 0) {
			return "0";
		}

		else {
			return get_coefficient() + "x^" + get_power();
		}
	}
	
	/**
	 * Subtraction
	 * Subtraction between two monoms (update 'this' monom with the result).
	 * @param other - subtracted monom
	 */
	public void subtraction(Monom other) {
		
		//if they are with the same power - Subtract their sons
		if (_power == other.get_power()) {
			_coefficient = _coefficient - other.get_coefficient();
			
		//if they are not with the same power - the operation cannot be dome and throw an error
		} else {
			throw new RuntimeException("Cannot substract between 2 monoms with a different powers");
		}
	}
}
