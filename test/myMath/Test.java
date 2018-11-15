package myMath;

public class Test {
	
	public static void main (String[] args) {
	
		monom_valid_monom();
		monom_copy_constructor();
		monom_copy_constructor();
		monom_f_function_test();
		monom_add_and_substract();
		monom_multiply_tests();
		monom_derivative_tests();
		monom_equals_tests();
		polynom_default_constructor_test();
		polynom_string_constructor_tests();
		polynom_copy_constructor();
		polynom_f_function_tests();
		polynom_add_monom_to_polymon_tets();
		polynom_add_polynom_to_polynom_tests();
		polynom_substract_tests();
		polynom_multiply_tets();
		polynom_equals_tests();
		polynom_isZero_test();
		polynom_copy_test();
		polynom_derivative_test();
		polynom_root_test();
		polynom_area_test();
		
		//These are an invalid tests - should throw an error so you have to run it separately.
		//monom_invalid_add();
		//monom_invalid_monoms();
		//polynom_invalid_input_tests();
	}
	

	/**
	 * monom_invalid_monoms
	 * Create an invalid monom - should throw an error so you have to run it separately.
	 */
	private static void monom_invalid_monoms () {
		Monom m1_1 = new Monom(3, -2);
	}
	
	/**
	 * monom_valid_monom
	 * Create a few valid monoms
	 */
	private static void monom_valid_monom () {
		
		Monom m2_1 = new Monom(3, 2);
		System.out.println("3.0x^2 --> "  + m2_1.toString());
		
		Monom m2_2 = new Monom(3.1, 2);
		System.out.println("3.1x^2 --> "  + m2_2.toString());
		
		Monom m2_3 = new Monom(-3, 2);
		System.out.println("-3.0x^2 --> "  + m2_3.toString());
		
		Monom m2_4 = new Monom(-3.1, 2);
		System.out.println("-3.1x^2 --> "  + m2_4.toString());
		
		Monom m2_5 = new Monom(3, 1);
		System.out.println("3.0x --> "  + m2_5.toString());
		
		Monom m2_6 = new Monom(1, 1);
		System.out.println("x --> "  + m2_6.toString());
		
		Monom m2_7 = new Monom(3, 0);
		System.out.println("3.0 --> "  + m2_7.toString());
		
		Monom m2_8 = new Monom(0, 2);
		System.out.println("0 --> "  + m2_8.toString());
		
		Monom m2_9 = new Monom(1, 2);
		System.out.println("x^2 --> "  + m2_9.toString());
		
		Monom m2_10 = new Monom(0, 0);
		System.out.println("0 --> "  + m2_10.toString());
	}

	/**
	 * monom_copy_constructor
	 */
	private static void monom_copy_constructor () {
		
		Monom m2_1 = new Monom(3, 2);
		Monom m2_10_2 = new Monom(m2_1);
		System.out.println("3.0x^2 --> "  + m2_10_2.toString());
	}
	
	/**
	 * monom_f_function_test
	 */
	private static void monom_f_function_test () {
		
		Monom m2_1 = new Monom(3, 2);
		System.out.println("12.0 -->" + m2_1.f(2));
		
		Monom m2_2 = new Monom(3.1, 2);
		System.out.println("12.4 -->" + m2_2.f(2));
		
		Monom m2_3 = new Monom(-3, 2);
		System.out.println("-12 -->" + m2_3.f(-2));
		
		Monom m2_4 = new Monom(-3.1, 2);
		System.out.println("-12.4 -->" + m2_4.f(-2));
		
		Monom m2_5 = new Monom(3, 1);
		System.out.println("-6.3 -->" + m2_5.f(-2.1));
		
		Monom m2_6 = new Monom(1, 1);
		System.out.println("-2.1 -->" + m2_6.f(-2.1));
		
		Monom m2_7 = new Monom(3, 0);
		System.out.println("3 -->" + m2_7.f(2.1));
		
		Monom m2_8 = new Monom(0, 2);
		System.out.println("0 -->" + m2_8.f(1));
		
		Monom m2_9 = new Monom(1, 2);
		System.out.println("4 -->" + m2_9.f(2));
		
		System.out.println("0 -->" + m2_9.f(0));
	}
	
	/**
	 * monom_invalid_add
	 * Invalid add operation - should throw an error so you have to run it separately.
	 */
	private static void monom_invalid_add () {
		
		Monom m2_1 = new Monom(3, 2);
		Monom m2_5 = new Monom(3, 1);
		m2_1.add(m2_5);
	}
	
	/**
	 * monom_add_and_substract
	 * add and substract functions tests
	 */
	private static void monom_add_and_substract () {
		
		Monom m2_1 = new Monom(3, 2);
		Monom sub1 = new Monom(m2_1);
		m2_1.add(m2_1);
		System.out.println("6.0x^2 --> " + m2_1.toString());
		m2_1.subtraction(sub1);
		System.out.println("3.0x^2 --> " + m2_1.toString());
	}
	
	/**
	 * monom_multiply_tests
	 * multiply function tests
	 */
	private static void monom_multiply_tests () {
		
		Monom m5_1 = new Monom(2, 3);
		Monom m5_2 = new Monom(-10, 2);
		m5_1.multiply(m5_2);
		System.out.println("-20x^5 -->" + m5_1.toString());
		System.out.println("-10x^2 -->" + m5_2.toString());
		
		Monom m5_3 = new Monom(0, 2);
		m5_1.multiply(m5_3);
		System.out.println("0.0 -->" + m5_1.toString() + '\n');
	}
	
	/**
	 * monom_derivative_tests
	 * derivative function tests
	 */
	private static void monom_derivative_tests () {
		
		Monom m6_1 = new Monom(0, 0);
		System.out.println("0.0 --> " + m6_1.derivative());
		
		Monom m6_2 = new Monom(2, 0);
		System.out.println("0.0 --> " + m6_2.derivative());
		
		Monom m6_3 = new Monom(2, 3);
		System.out.println("6.0x^2 --> " + m6_3.derivative());
		
		Monom m6_4 = new Monom(-2, 3);
		System.out.println("-6.0x^2 --> " + m6_4.derivative());
		
		Monom m6_5 = new Monom(2.1, 3);
		System.out.println("6.3x^2 --> " + m6_5.derivative());
		
		Monom m6_6 = new Monom(2, 2);
		System.out.println("4.0x --> " + m6_6.derivative());
		
		Monom m6_7 = new Monom(2, 1);
		System.out.println("2.0 --> " + m6_7.derivative());
	}
	
	/**
	 * monom_equals_tests
	 * equals function tests
	 */
	private static void monom_equals_tests () {
		
		Monom m7_1 = new Monom(0, 0);
		Monom m7_2 = new Monom(2, 0);
		Monom m7_3 = new Monom(2, 3);
		Monom m7_4 = new Monom(2, 3);
		
		System.out.println("false --> " + m7_1.equals(m7_2));
		System.out.println("false --> " + m7_2.equals(m7_3));
		System.out.println("true --> " + m7_3.equals(m7_4));
		System.out.println("true --> " + m7_4.equals(m7_3));
	}
	
	/**
	 * polynom_default_constructor_test
	 */
	private static void polynom_default_constructor_test () {
		
		Polynom p1 = new Polynom();
		System.out.println("should print only this" + p1.toString());
	}
	
	/**
	 * polynom_string_constructor_tests
	 */
	private static void polynom_string_constructor_tests () {
		
		Polynom p2_25 = new Polynom("");
		System.out.println("should print only this" + p2_25.toString());
		
		Polynom p2_1_1 = new Polynom("4-3-4+0+0+0");
		System.out.println("4-3-4+0+0+0 --> " + p2_1_1.toString());
		
		Polynom p2_1 = new Polynom("3x^2");
		System.out.println("3.0x^2 --> " + p2_1.toString());
		
		Polynom p2_2 = new Polynom("-3.0x^2");
		System.out.println("-3.0x^2 --> " + p2_2.toString());
		
		Polynom p2_32 = new Polynom("3.0x^2");
		System.out.println("3.0x^2 --> " + p2_32.toString());
		
		Polynom p2_3 = new Polynom("-1x^2");
		System.out.println("-x^2 --> " + p2_3.toString());
		
		Polynom p2_31 = new Polynom("1x^2");
		System.out.println("x^2 --> " + p2_31.toString());
		
		Polynom p2_4 = new Polynom("x^2");
		System.out.println("x^2 --> " + p2_4.toString());
		
		Polynom p2_5 = new Polynom("3x^1");
		System.out.println("3.0x --> " + p2_5.toString());
		
		Polynom p2_6 = new Polynom("-3x");
		System.out.println("-3.0x --> " + p2_6.toString());
		
		Polynom p2_19 = new Polynom("3x");
		System.out.println("3.0x --> " + p2_19.toString());
		
		Polynom p2_7 = new Polynom("0x^2");
		System.out.println("0 --> " + p2_7.toString());
		
		Polynom p2_8 = new Polynom("0");
		System.out.println("0 --> " + p2_8.toString());
		
		Polynom p2_9 = new Polynom("3x^0");
		System.out.println("3.0 --> " + p2_9.toString());
		
		Polynom p2_33 = new Polynom("-3x^0");
		System.out.println("-3.0 --> " + p2_33.toString());
		
		Polynom p2_10 = new Polynom("3");
		System.out.println("3.0 --> " + p2_10.toString());
		
		Polynom p2_37 = new Polynom("+3");
		System.out.println("3.0 --> " + p2_37.toString());
		
		Polynom p2_36 = new Polynom("- 3");
		System.out.println("-3.0 --> " + p2_36.toString());
		
		Polynom p2_11 = new Polynom("1x^1");
		System.out.println("x --> " + p2_11.toString());
		
		Polynom p2_35 = new Polynom("-1x^1");
		System.out.println("-x --> " + p2_35.toString());
		
		Polynom p2_12 = new Polynom("x");
		System.out.println("x --> " + p2_12.toString());
		
		Polynom p2_34 = new Polynom("x");
		System.out.println("x --> " + p2_34.toString());
		
		Polynom p2_13 = new Polynom("4X^2");
		System.out.println("4.0x^2 --> " + p2_13.toString());
		
		Polynom p2_40 = new Polynom("425X^2");
		System.out.println("425.0x^2 --> " + p2_40.toString());
		
		Polynom p2_41 = new Polynom("-4.123123X^2");
		System.out.println("-4.123123x^2 --> " + p2_41.toString());
		
		Polynom p2_42 = new Polynom("4X^123");
		System.out.println("4.0x^123 --> " + p2_42.toString());
		
		Polynom p2_43 = new Polynom("123X^123");
		System.out.println("123.0x^123 --> " + p2_43.toString());
		
		Polynom p2_44 = new Polynom("123.0X^123");
		System.out.println("123.0x^123 --> " + p2_44.toString());
		
		Polynom p2_14 = new Polynom("3x^2 + 4x^3 -6");
		System.out.println("-6.0+3.0x^2+4.0x^3 --> " + p2_14.toString());
		
		Polynom p2_46 = new Polynom("-6 + 3x^2 + 4x^3");
		System.out.println("-6.0+3.0x^2+4.0x^3 --> " + p2_46.toString());
		
		Polynom p2_47 = new Polynom("3x^2 -6 + 4x^3");
		System.out.println("-6.0+3.0x^2+4.0x^3 --> " + p2_47.toString());
		
		Polynom p2_15 = new Polynom("3x^2+4x^3-60");
		System.out.println("-60.0+3.0x^2+4.0x^3 --> " + p2_15.toString());
		
		Polynom p2_16 = new Polynom("3X^2 + 4X^3 -6");
		System.out.println("-6.0+3.0x^2+4.0x^3 --> " + p2_16.toString());
		
		Polynom p2_17 = new Polynom("10 - 2x + x^2 -10x^3");
		System.out.println("10.0-2.0x+x^2-10.0x^3 --> " + p2_17.toString());
		
		Polynom p2_18 = new Polynom("x^2 -10 x ^ 3 -2x +10");
		System.out.println("10.0-2.0x+x^2-10.0x^3 --> " + p2_18.toString());
		
		Polynom p2_48 = new Polynom("2*x^3");
		System.out.println("2.0x^3 --> " + p2_48.toString());
		
		Polynom p2_49 = new Polynom("-x^3");
	    System.out.println("-x^3 --> " + p2_49.toString());
	}
	
	/**
	 * polynom_invalid_input_tests
	 * invalid string input tests - should throw an error so you have to run it separately.
	 */
	private static void polynom_invalid_input_tests () {
		Polynom p2_20 = new Polynom("-x^-2");
		Polynom p2_21 = new Polynom("1a.2x");
		Polynom p2_22 = new Polynom("-4.5x^");
		Polynom p2_23 = new Polynom("2xx");
		Polynom p2_24 = new Polynom("xx");
		Polynom p2_26 = new Polynom("2.5x^10x");
		Polynom p2_27 = new Polynom("11^2x");
	}
	
	/**
	 * polynom_copy_constructor
	 */
	private static void polynom_copy_constructor () {
		
		Polynom p3_1 = new Polynom("-10x^2");
		Polynom p3_2 = new Polynom(p3_1);
		System.out.println("-10.0x^2 --> " + p3_2.toString());
		
		Polynom p3_3 = new Polynom("-10x^2-8x");
		Polynom p3_4 = new Polynom(p3_3);
		System.out.println("-8x-10.0x^2 --> " + p3_4.toString());
	}
	
	/**
	 * polynom_f_function_tests
	 */
	private static void polynom_f_function_tests () {
		
		Polynom p4_1 = new Polynom("3x^2");
		System.out.println("3.0 --> " + p4_1.f(1));
		
		Polynom p4_4 = new Polynom("3x^2");
		System.out.println("0 --> " + p4_4.f(0));
		
		Polynom p4_5 = new Polynom("3x^2");
		System.out.println("12.0 --> " + p4_5.f(2));
		
		Polynom p4_2 = new Polynom("3x^2 -6 + 4x^3");
		System.out.println("38.0 --> " + p4_2.f(2));
		
		Polynom p4_3 = new Polynom("x^2 -10 x ^ 3 -2x +10");
		System.out.println("-257.0 --> " + p4_3.f(3));
	}
	
	/**
	 * polynom_add_monom_to_polymon_tets
	 */
	private static void polynom_add_monom_to_polymon_tets () {
		
		Monom m1 = new Monom(2, 2);
		Monom m2 = new Monom(8, 2);
		Polynom p5_1 = new Polynom("3x^2");
		Polynom p5_2 = new Polynom("-6+2x^3");
		Polynom p5_3 = new Polynom("1-x-2x^2+3x^3");
		Polynom p5_4 = new Polynom("1-x-2x^2+3x^3");
		p5_1.add(m1);
		System.out.println("5.0x^2 --> " + p5_1.toString());
		p5_3.add(m1);
		System.out.println("1.0-x+3.0x^3 --> " + p5_3.toString());
		p5_4.add(m2);
		System.out.println("1.0-x+6.0x^2+3.0x^3 --> " + p5_4.toString());
		p5_2.add(m1);
		System.out.println("-6.0+2.0x^2+2.0x^3 -- > " + p5_2.toString());
	}
	
	/**
	 * polynom_add_polynom_to_polynom_tests
	 */
	private static void polynom_add_polynom_to_polynom_tests () {
		
		Polynom p5_1 = new Polynom("3x^2+10");
		Polynom p5_2 = new Polynom("-6+2x^3+x^2");

		p5_1.add(p5_2);
		System.out.println("4.0+4.0x^2+2.0x^3 --> " + p5_1.toString());
	}
	
	/**
	 * polynom_substract_tests
	 */
	private static void polynom_substract_tests () {
		
		Polynom p6_1 = new Polynom("3x^2+10");
		Polynom p6_2 = new Polynom("-6+2x^3+x^2");

		p6_2.substract(p6_1);
		System.out.println("-16.0-2.0x^2+2.0x^3 --> " + p6_2.toString());
	}
	
	/**
	 * polynom_multiply_tets
	 */
	private static void polynom_multiply_tets () {
		
		Polynom p7_1 = new Polynom("3x^2+10");
		Polynom p7_2 = new Polynom("-6+2x^3+x^2");
		
		p7_1.multiply(p7_2);
		System.out.println("-60.0-8.0x^2+20.0x^3+3.0x^4+6.0x^5 -- > " + p7_1.toString());
	}
	
	/**
	 * polynom_equals_tests
	 */
	private static void polynom_equals_tests () {
		
		Polynom p8_1 = new Polynom("3x^2+10");
		Polynom p8_2 = new Polynom("-6+2x^3+x^2");
		Polynom p8_3 = new Polynom("10+3x^2");
		
		System.out.println("false --> " + p8_1.equals(p8_2));
		System.out.println("false --> " + p8_2.equals(p8_3));
		System.out.println("true --> " + p8_1.equals(p8_3));
	}
	
	/**
	 * polynom_isZero_test
	 */
	private static void polynom_isZero_test () {
		
		Polynom p9_1 = new Polynom("3x^2+10");
		Polynom p9_2 = new Polynom("-6+2x^3+x^2");
		Polynom p9_3 = new Polynom("");
		Polynom p9_4 = new Polynom();
		Polynom p9_5 = new Polynom("0+0x^3+0x^2");
		
		System.out.println("false --> " + p9_1.isZero());
		System.out.println("false --> " + p9_2.isZero());
		System.out.println("true --> " + p9_3.isZero());
		System.out.println("true --> " + p9_4.isZero());
		System.out.println("true --> " + p9_5.isZero());
	}
	
	/**
	 * polynom_copy_test
	 */
	private static void polynom_copy_test () {
		
		Polynom p11_1 = new Polynom("3x^2+10");
		Polynom p11_2 = (Polynom) p11_1.copy();
		
		System.out.println("true --> " + p11_1.equals(p11_2));
	}
	
	/**
	 * polynom_derivative_test
	 */
	private static void polynom_derivative_test() {
		
		Polynom p12_1 = new Polynom("3x^2+10");
		Polynom p12_2 = new Polynom("-6+2x^3+x^2");
		
		System.out.println("6.0x --> " + p12_1.derivative().toString());
		System.out.println("6.0x^2+2.0x --> " + p12_2.derivative().toString());
	}
	
	/**
	 * polynom_root_test
	 */
	private static void polynom_root_test() {
		
		Polynom p13_1 = new Polynom("x");
		System.out.println("close to 0 --> " + p13_1.root(-2, 10, 0.01));
		
		Polynom p13_3 = new Polynom("x^2-x-2");
		System.out.println("close to 2 --> " + p13_3.root(1, 6, 0.01));
	}
	
	/**
	 * polynom_area_test
	 */
	private static void polynom_area_test() {
		
		Polynom p14_1 = new Polynom("x");
		System.out.println("close to 50 --> " + p14_1.area(0, 10, 0.01));
		
		Polynom p14_2 = new Polynom("x^2");
		System.out.println("close to 41.66 --> " + p14_2.area(0, 5, 0.01));
		
		Polynom p14_3 = new Polynom("4x^3+3x^2-6");
		System.out.println("close to 10250 --> " + p14_3.area(5, 10, 0.01));
		
		Polynom p14_4 = new Polynom("8x^2+3x-2");
		System.out.println("close to 21.16 --> " + p14_4.area(2, 1, 0.01));
	}
}
