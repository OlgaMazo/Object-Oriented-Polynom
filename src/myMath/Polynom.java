package myMath;

import java.util.ArrayList;
import java.util.Iterator;

import myMath.Monom;

/**
 * This class represents a Polynom with add, multiply functionality, it also
 * should support the following: 1. Riemann's Integral:
 * https://en.wikipedia.org/wiki/Riemann_integral 2. Finding a numerical value
 * between two values (currently support root only f(x)=0). 3. Derivative
 * 
 * @author Boaz
 *
 */
public class Polynom implements Polynom_able {

	private ArrayList<Monom> polynom_array_list;

	/**
	 * Polynom 
	 * Default constructor.
	 */
	public Polynom() {
		this.polynom_array_list = new ArrayList<Monom>();
	}

	/**
	 * Polynom 
	 * A constructor that receives a polynom in a string type.
	 * @param string_polynom - polynom in a string type
	 */
	public Polynom(String string_polynom) {

		// if the input string is empty go to the default constructor
		if (string_polynom == "") {
			this.polynom_array_list = new ArrayList<Monom>();
			return;
		}
		string_polynom = string_polynom.replaceAll(" ", "");
		string_polynom = string_polynom.replace("*", "");
		string_polynom = string_polynom.toLowerCase();
		char[] char_array = string_polynom.toCharArray();
		if (stringValid(char_array)) {
			this.polynom_array_list = new ArrayList<Monom>();
			from_chararray_to_monoms(char_array);
		}
	}

	/**
	 * Polynom 
	 * A copier constructor who gets an object to him and creates a new one just like him.
	 * @param other_polynom - the copied monom object
	 */
	public Polynom(Polynom other_polynom) {
		
		this();
		Iterator<Monom> iter = other_polynom.iteretor();
		while (iter.hasNext()) {
			Monom m = iter.next();
			this.add(new Monom(m));
		}
	}

	/**
	 * Polynom
	 * A constructor that receive array list and defines it as polynom array list.
	 * @param arr
	 */
	private Polynom(ArrayList<Monom> arr) {
		this.polynom_array_list = arr;
	}

	/**
	 * f 
	 * Calculation y=f(x).
	 * @param x - the x value for him we want to calculate the function value
	 * @return - f(x) value
	 */
	public double f(double x) {

		double answer = 0;

		Iterator<Monom> iterator = this.iteretor();
		while (iterator.hasNext()) {
			Monom current_monom = iterator.next();
			answer += current_monom.f(x);
		}
		return answer;
	}

	/**
	 * add 
	 * Add m1 to this Polynom.
	 * @param m1 - added monom
	 */
	public void add(Monom m1) {

		boolean operation_done = false;

		Iterator<Monom> iterator = this.iteretor();
		while (iterator.hasNext() && !operation_done) {
			Monom current_monom = iterator.next();

			// If there is a monoms with the same power in the polynom, we will add them
			if (current_monom.get_power() == m1.get_power()) {
				current_monom.add(m1);
				operation_done = true;
			}
		}

		// if the while stoped because there are no more monoms in the polynom but the
		// operation still not done - its mean that there are no monom with the same
		// power in the polynom so add m1 as a new monom to the polynom.
		if (!iterator.hasNext() && !operation_done) {
			polynom_array_list.add(m1);
		}
		remove_zero_monoms(this);
	}

	/**
	 * add 
	 * Add p1 to this Polynom.
	 * @param p1 - added polynom
	 */
	public void add(Polynom_able p1) {

		Iterator<Monom> iterator = p1.iteretor();
		while (iterator.hasNext()) {
			Monom current_monom = iterator.next();
			this.add(current_monom);
		}
	}

	/**
	 * substract 
	 * Subtract p1 from this Polynom.
	 * @param p1 - subtracted Polynom
	 */
	public void substract(Polynom_able p1) {

		Iterator<Monom> iterator = p1.iteretor();
		while (iterator.hasNext()) {
			Monom current_monom = iterator.next();
			this.substract_monom(current_monom);
		}
		remove_zero_monoms(this);
	}

	/**
	 * multiply 
	 * Multiply this Polynom by p1.
	 * @param p1 - multiplication Polynom
	 */
	public void multiply(Polynom_able p1) {

		ArrayList<Monom> arr = new ArrayList<Monom>();

		// mult every monom in every polynom with all the monoms in the secound polynom
		Iterator<Monom> p1_iterator = p1.iteretor();
		while (p1_iterator.hasNext()) {
			Monom current_monom_of_p1 = p1_iterator.next();
			Polynom Cpolynom = (Polynom) this.copy();
			
			Iterator<Monom> current_iterator = Cpolynom.iteretor();
			while (current_iterator.hasNext()) {
				Monom current_monom = current_iterator.next();

				current_monom.multiply(current_monom_of_p1);
				arr.add(current_monom);
			}
		}

		// cerate a new polynom with the array list who have the multiply results
		Polynom updateP = new Polynom(arr);

		// clear this polynom
		Iterator<Monom> current_iterator0 = this.iteretor();
		while (current_iterator0.hasNext()) {
			Monom current_monom = current_iterator0.next();
			current_iterator0.remove();
		}

		// copy the update polynom to this polynom
		Iterator<Monom> current_iterator1 = updateP.iteretor();
		while (current_iterator1.hasNext()) {
			Monom current_monom = current_iterator1.next();
			this.add(current_monom);
		}
	}

	/**
	 * equals 
	 * Test if this Polynom is logically equals to p1.
	 * @param p1 - tested polynom
	 * @return - true if they are equals, , otherwise false
	 */
	public boolean equals(Polynom_able p1) {

		boolean answer = true;

		// sort both of the polynoms on order to make comparison between them
		this.sort_array();
		((Polynom) p1).sort_array();

		// if the sizes are different we already know that they are not equals
		if (!(this.size() == ((Polynom) p1).size())) {
			return false;
		}

		Iterator<Monom> iterator1 = this.iteretor();
		Iterator<Monom> iterator2 = p1.iteretor();

		// its not important whice iterator we use to this hasnext because there are in
		// the same size.
		while (iterator1.hasNext()) {
			Monom current_monom1 = iterator1.next();
			Monom current_monom2 = iterator2.next();

			if (!(current_monom1.equals(current_monom2))) {
				return false;
			}
		}
		return answer;
	}

	/**
	 * isZero 
	 * Test if this is the Zero Polynom.
	 * @return - true if zero, otherwise false
	 */
	public boolean isZero() {

		boolean answer = true;

		// if the polynom size is 0
		if (polynom_array_list.size() == 0) {
			return answer;

		// if all the monoms in the polynom are 0
		} else {
			Iterator<Monom> iterator = this.iteretor();
			while (iterator.hasNext()) {
				Monom current_monom = iterator.next();
				if (!(current_monom.get_coefficient() == 0)) {
					return false;
				}
			}
		}
		return answer;
	}

	/**
	 * root
	 * Compute a value x' (x0<=x'<=x1) for with |f(x')| < eps assuming
	 * (f(x0)*f(x1)<=0, returns f(x2) such that: (i) x0<=x2<=x2 && (ii) f(x2)<eps
	 * @param x0 - starting point
	 * @param x1 - end point       
	 * @param eps - step (positive) value
	 * @return - root point
	 */
	public double root(double x0, double x1, double eps) {

		double startPoint = 0;
		double endPoint = 0;
		double midPoint = 0;
		double deltaX = 0;
		double y0 = this.f(x0);
		double y1 = this.f(x1);

		// if there is no root an error should be thrown
		if (y0 * y1 > 0) {
			throw new RuntimeException("");
		}

		// Set the start and end of the domain where the point is being sought
		if (x1 > x0) {
			startPoint = x0;
			endPoint = x1;
		} else if (x0 > x1) {
			startPoint = x1;
			endPoint = x0;
		}

		deltaX = Math.abs(endPoint - startPoint);

		// distribution method until deltaX will be bigger than eps
		while (deltaX >= eps) {

			midPoint = (startPoint + endPoint) / 2;
			deltaX = Math.abs(endPoint - startPoint);
			
			if (this.f(midPoint) == 0) {
				return midPoint;
			}

			// if the root is in the left side set the middle as the end point
			if (this.f(startPoint) * this.f(midPoint) < 0) {
				endPoint = midPoint;
				
			// if the root is in the right side set the middle as the start point
			} else {
				startPoint = midPoint;
			}
		}
		return midPoint;
	}

	/**
	 * copy 
	 * Create a deep copy of this Polynum.
	 * @return the copied polynom
	 */
	public Polynom_able copy() {

		Polynom Cpolynom = new Polynom();

		Iterator<Monom> iterator = this.iteretor();
		while (iterator.hasNext()) {
			Monom current_monom = iterator.next();
			Cpolynom.add(new Monom(current_monom));
		}
		return Cpolynom;
	}

	/**
	 * derivative 
	 * Compute a new Polynom which is the derivative of this Polynom.
	 * @return - derivative of this Polynom
	 */
	public Polynom_able derivative() {

		Polynom Dpolynom = new Polynom();

		Iterator<Monom> iterator = this.iteretor();
		while (iterator.hasNext()) {
			Monom current_monom = iterator.next();
			current_monom = current_monom.derivative();
			if (current_monom.get_coefficient() != 0) {
				Dpolynom.add(current_monom);
			}
		}
		return Dpolynom;
	}

	/**
	 * area 
	 * Compute Riemann's Integral over this Polynom starting from x0, till x1using eps size steps.
	 * @param x0 - start point
	 * @param x1 - end point
	 * @param eps - Permissible deviation
	 * @return - the area above the X axis and under the function between the [x0,x1] range
	 */
	public double area(double x0, double x1, double eps) {

		double arearesult = 0;
		double startPoint = 0;
		double endPoint = 0;

		// set the start and end of the domain for which the area is calculated.
		if (x1 > x0) {
			startPoint = x0;
			endPoint = x1;
		} else if (x0 > x1) {
			startPoint = x1;
			endPoint = x0;

			// if x0=x1 the area is zero
		} else {
			return 0;
		}

		// run from the start point to the end point and each iteration moves to the
		// next rectangle (according to the width of the rectangle)
		for (double i = startPoint; i < endPoint; i += eps) {

			// count only the rectangle areas above the x-axis
			if (this.f(i) > 0) {
				arearesult += eps * this.f(i);
			}
		}
		return arearesult;
	}

	/**
	 * iteretor
	 * @return an Iterator (of Monoms) over this Polynom
	 */
	public Iterator<Monom> iteretor() {
		return this.polynom_array_list.iterator();
	}
	
	/**
	 * toString
	 * @return - this monom as a string
	 */
	public String toString() {

		this.sort_array();

		String answer = "";
		boolean first = true;

		Iterator<Monom> iterator = this.iteretor();
		while (iterator.hasNext()) {
			Monom current_monom = iterator.next();

			// if it's the first monom in the polynom
			if (first) {
				answer += current_monom.toString();
				first = false;
			}

			// if is not the first monom in the polynom and the monom coefficient are positive add '+' before him
			else if (current_monom.get_coefficient() > 0 && (!(first))) {
				answer += "+" + current_monom.toString();
			}

			//if the monom coefficient is not zero (negative)
			else if (!(current_monom.get_coefficient() == 0)) {
				answer += current_monom.toString();
			}
		}
		if (answer == "") {
			return "0";
		}
		return answer;
	}
	
	/**
	 * area_under_x_axis
	 * Calculates the area under the X axis and above the function (Riemann's Integral).
	 * @param x0 - start point
	 * @param x1 - end point
	 * @param eps - Permissible deviation
	 * @return - the area under the X axis and above the function between the [x0,x1] range
	 */
	public double area_under_x_axis(double x0, double x1, double eps) {
		
		double arearesult = 0;
		double startPoint = 0;
		double endPoint = 0;

		//set the start and end of the domain for which the area is calculated.
		if (x1 > x0) {
			startPoint = x0;
			endPoint = x1;
		} else if (x0 > x1) {
			startPoint = x1;
			endPoint = x0;

		//if x0=x1 the area is zero
		} else {
			return 0;
		}

		//run from the start point to the end point and each iteration moves to the
		//next rectangle (according to the width of the rectangle)
		for (double i = startPoint; i < endPoint; i += eps) {

			//count only the rectangle areas under the x-axis
			if (this.f(i) < 0) {
				arearesult += eps * this.f(i);
			}
		}
		if (arearesult < 0) return arearesult*-1;
		return arearesult;
	}

	/**
	 * from_chararray_to_monoms
	 * create monoms objects from input chat array.
	 * @param char_array1 - char array
	 */
	private void from_chararray_to_monoms(char[] char_array1) {

		int point1 = 0;
		int point2 = 0;

		for (int i = 0; i <= char_array1.length; i++) {

			// the last monom in the array
			if (i == char_array1.length) {

				// call 'create monom' function with sub char array
				create_monom(create_sub_char_array(char_array1, point1, point2));
				point1 = point2;
				point2++;
			}

			// first or some middle monom in the array
			else if ((char_array1[i] == '+' || char_array1[i] == '-') && !(i == 0)) {

				// call 'create monom' function with sub char array
				create_monom(create_sub_char_array(char_array1, point1, point2));
				point1 = point2;
				point2++;
			}
			else {
				point2++;
			}
		}
	}

	/**
	 * create_sub_char_array
	 * Create sub char array from the main array.
	 * @param char_array - the main char array (which include all the input string)
	 * @param point1 - first index
	 * @param point2 - last index
	 * @return - sub char array from first to last index
	 */
	private char[] create_sub_char_array(char[] char_array, int point1, int point2) {

		char[] sub_char_array = new char[point2 - point1];

		int t = 0;
		for (int l = point1; l < point2; l++) {
			sub_char_array[t] = char_array[l];
			t++;
		}
		return sub_char_array;
	}

	/**
	 * create_monom
	 * Create monom object according to the data in the input array.
	 * @param sub_char_array - char array
	 */
	private void create_monom(char[] sub_char_array) {

		String coefficient1 = "";
		String power1 = "";
		boolean bcoefficient = false;
		double coefficient = 0;
		int power = 0;

		for (int i = 0; i < sub_char_array.length; i++) {

			// if there is 'x' we done with the monom coefficient
			if (sub_char_array[i] == 'x') {
				bcoefficient = true;
			}

			// if there is part of the monom coefficient
			else if ((!(bcoefficient)) && (!(sub_char_array[i] == '+'))) {
				coefficient1 += Character.toString(sub_char_array[i]);
			}

			// if there is part of the monom power
			else if (bcoefficient && !(sub_char_array[i] == 'x' || sub_char_array[i] == '^')) {
				power1 += Character.toString(sub_char_array[i]);
			}
		}

		// if there is no coefficient we set is as '1' (x^2 = 1x^2)
		if (coefficient1 == "") {
			coefficient = 1;
			
		// if the coefficient is '-' we set is as '-1' (-x^2 = -1x^2
		} else if (coefficient1.equals("-")) {
			coefficient = -1;
			
		//monom coefficient
		} else {
			coefficient = Double.parseDouble(coefficient1);
		}

		// if there is no coefficient and power we set the power as '0' (it is a number like '6')
		if (power1 == "" && bcoefficient == false) {
			power = 0;
		}

		// if there is coefficient but no power we set the power as '1' (2x = 2x^1)
		else if (power1 == "" && bcoefficient == true) {
			power = 1;
		}

		// monom power
		else {
			power = Integer.parseInt(power1);
		}

		Monom m = new Monom(coefficient, power);
		polynom_array_list.add(m);
	}

	/**
	 * substract_monom
	 * Substract monom from this polynom
	 * @param m1 - substracted monom
	 */
	private void substract_monom(Monom m1) {

		boolean operation_done = false;

		Iterator<Monom> iterator = this.iteretor();

		while (iterator.hasNext() && !operation_done) {
			Monom current_monom = iterator.next();
			if (current_monom.get_power() == m1.get_power()) {
				current_monom.subtraction(m1);
				operation_done = true;
			}
		}

		// if the while stoped because there are no more monoms but the operation still not done
		// (its mean that there are no monom with the same power in the polinom)
		// so we add m1 as a new monom to the polynom.
		if (!iterator.hasNext() && !operation_done) {
			Monom other = new Monom(-1, 0);
			m1.multiply(other);
			polynom_array_list.add(m1);
		}
	}

	/**
	 * multiply_monom
	 * Multiply this polynom by the input monom.
	 * @param m1 - multiply monom
	 */
	private void multiply_monom(Monom m1) {

		Iterator<Monom> iterator = this.iteretor();
		while (iterator.hasNext()) {
			Monom current_monom = iterator.next();
			current_monom.multiply(m1);
		}
	}

	/**
	 * sort_array
	 * Sort the array using comperator.
	 */
	private void sort_array() {
		Monom_Comperator comper = new Monom_Comperator();
		polynom_array_list.sort(comper);
	}

	/**
	 * size
	 * @return - polynom array list size
	 */
	private int size() {
		return this.polynom_array_list.size();
	}

	/**
	 * stringValid
	 * Validate if the input string is valid as polynom.
	 * @param char_array - char array
	 * @return - true if valid, otherwise false
	 */
	private boolean stringValid(char[] char_array) {

		boolean xExists = false;

		for (int i = 0; i < char_array.length; i++) {

			xExists = false;

			// if this char is any from these chars it is invalid input
			if (!(Character.isDigit(char_array[i]))) {
				if (!(char_array[i] == '+')) {
					if (!(char_array[i] == '-')) {
						if (!(char_array[i] == '.')) {
							if (!(char_array[i] == '^')) {
								if (!(char_array[i] == 'x')) {
									throw new RuntimeException("Invalid input");
								}
							}
						}
					}
				}
			}

			if (char_array[i] == '^' || char_array[i] == 'x') {

				// set xExists as true so we will know if another 'x' will appear in the same monom
				if (char_array[i] == 'x') {
					xExists = true;
				}

				// search for another 'x' in the same monom
				for (int t = i + 1; t < char_array.length; t++) {

					if (char_array[t] == '+' || char_array[t] == '-') {
						break;
					}

					if (char_array[t] == 'x') {
						throw new RuntimeException("Invalid input");
					}
				}
			}

			if (char_array[i] == '^') {

				// if there is '^' but there is no power number
				if (i == char_array.length - 1) {
					throw new RuntimeException("Invalid input");
				}

				// if the monom power is negative
				else if (char_array[i + 1] == '-') {
					throw new RuntimeException("Invalid input - the monom power should be a non-negative integer");
				}
			}
			
			if (char_array[i] == '+' || char_array[i] == '-') {
				is_continuous_signs(i, char_array);
			}
		}
		return true;
	}

	/**
	 * is_continuous_signs
	 * Checks if there are consecutive signs in an abnormal manner (++, --, +-, -+, +^, -^)
	 * @param index - current index
	 * @param char_array - char array
	 */
	private void is_continuous_signs(int index, char[] char_array) {

		if (index != 0) {
			if (char_array[index - 1] == '+' || char_array[index - 1] == '-') {
				throw new RuntimeException("Invalid input - there are two consecutive signs (+/-)");
			}
		}
		if (char_array[index + 1] == '^') {
			throw new RuntimeException("Invalid input - After add or subtraction signs should appear monoam");
		}
	}
	
	/**
	 * remove_zero_monoms
	 * Checks if there are monoms whose coefficient is zero and delete them.
	 * @param p - the tested polynom
	 */
	private void remove_zero_monoms(Polynom p) {
		Iterator<Monom> iterator = p.iteretor();
		while (iterator.hasNext()) {
			Monom current_monom = iterator.next();
			if (current_monom.get_coefficient() == 0) {
				iterator.remove();
			}
		}
	}
}
