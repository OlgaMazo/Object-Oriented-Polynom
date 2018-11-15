package myMath;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

class PolynomTest {

	@Test
	void test_default_constructor() {
		Polynom p1 = new Polynom();
		assertEquals("0", p1.toString());
	}
	
	@Test
	void test_string_constructor() {
		
		Polynom p1 = new Polynom("");
		assertEquals("0", p1.toString());
		
		Polynom p2 = new Polynom("4-3-4+0+0+0");
		assertEquals("4.0-3.0-4.0", p2.toString());
		
		Polynom p3 = new Polynom("3x^2");
		assertEquals("3.0x^2", p3.toString());
		
		Polynom p4 = new Polynom("-3.0x^2");
		assertEquals("-3.0x^2", p4.toString());
		
		Polynom p5 = new Polynom("3.0x^2");
		assertEquals("3.0x^2", p5.toString());
		
		Polynom p6 = new Polynom("-1x^2");
		assertEquals("-x^2", p6.toString());
		
		Polynom p7 = new Polynom("1x^2");
		assertEquals("x^2", p7.toString());
		
		Polynom p8 = new Polynom("x^2");
		assertEquals("x^2", p8.toString());
		
		Polynom p9 = new Polynom("3x^1");
		assertEquals("3.0x", p9.toString());
		
		Polynom p10 = new Polynom("-3x");
		assertEquals("-3.0x", p10.toString());
		
		Polynom p11 = new Polynom("3x");
		assertEquals("3.0x", p11.toString());
		
		Polynom p12 = new Polynom("0x^2");
		assertEquals("0", p12.toString());
		
		Polynom p13 = new Polynom("0");
		assertEquals("0.0", p13.toString());
		
		Polynom p14 = new Polynom("3x^0");
		assertEquals("3.0", p14.toString());
		
		Polynom p15 = new Polynom("-3x^0");
		assertEquals("-3.0", p15.toString());
		
		Polynom p16 = new Polynom("3");
		assertEquals("3.0", p16.toString());
		
		Polynom p17 = new Polynom("+3");
		assertEquals("3.0", p17.toString());
		
		Polynom p18 = new Polynom("- 3");
		assertEquals("-3.0", p18.toString());
		
		Polynom p19 = new Polynom("1x^1");
		assertEquals("x", p19.toString());
		
		Polynom p20 = new Polynom("-1x^1");
		assertEquals("-x", p20.toString());
		
		Polynom p21 = new Polynom("x");
		assertEquals("x", p21.toString());
		
		Polynom p22 = new Polynom("4X^2");
		assertEquals("4.0x^2", p22.toString());
		
		Polynom p23 = new Polynom("425X^2");
		assertEquals("425.0x^2", p23.toString());
		
		Polynom p24 = new Polynom("-4.123123X^2");
		assertEquals("-4.123123x^2", p24.toString());
		
		Polynom p25 = new Polynom("4X^123");
		assertEquals("4.0x^123", p25.toString());
		
		Polynom p26 = new Polynom("123X^123");
		assertEquals("123.0x^123", p26.toString());
		
		Polynom p27 = new Polynom("123.0X^123");
		assertEquals("123.0x^123", p27.toString());
		
		Polynom p28 = new Polynom("3x^2 + 4x^3 -6");
		assertEquals("-6.0+3.0x^2+4.0x^3", p28.toString());
		
		Polynom p29 = new Polynom("-6 + 3x^2 + 4x^3");
		assertEquals("-6.0+3.0x^2+4.0x^3", p29.toString());
		
		Polynom p30 = new Polynom("3x^2 -6 + 4x^3");
		assertEquals("-6.0+3.0x^2+4.0x^3", p30.toString());
		
		Polynom p31 = new Polynom("3x^2+4x^3-60");
		assertEquals("-60.0+3.0x^2+4.0x^3", p31.toString());
		
		Polynom p32 = new Polynom("3X^2 + 4X^3 -6");
		assertEquals("-6.0+3.0x^2+4.0x^3", p32.toString());
		
		Polynom p33 = new Polynom("10 - 2x + x^2 -10x^3");
		assertEquals("10.0-2.0x+x^2-10.0x^3", p33.toString());
		
		Polynom p34 = new Polynom("x^2 -10 x ^ 3 -2x +10");
		assertEquals("10.0-2.0x+x^2-10.0x^3", p34.toString());
		
		Polynom p35 = new Polynom("2*x^3");
		assertEquals("2.0x^3", p35.toString());
		
		Polynom p36 = new Polynom("-x^3");
		assertEquals("-x^3", p36.toString());
		
		Polynom p37 = new Polynom("3*X^2 + 4 * X^3 -6");
		assertEquals("-6.0+3.0x^2+4.0x^3", p37.toString());
	}
	
	@Test
	void test_copy_constructor() {
		Polynom p1 = new Polynom("-10x^2");
		Polynom p2 = new Polynom(p1);
		assertEquals("-10.0x^2", p2.toString());
		
		Polynom p3 = new Polynom("-10x^2-8x + 6x^0");
		Polynom p4 = new Polynom(p3);
		assertEquals("6.0-8.0x-10.0x^2", p4.toString());
	}
	
	@Test
	void test_f() {
		Polynom p1 = new Polynom("3x^2");
		assertEquals(3.0, p1.f(1));
		
		Polynom p2 = new Polynom("3x^2");
		assertEquals(0.0, p2.f(0));
		
		Polynom p3 = new Polynom("3x^2");
		assertEquals(12.0, p3.f(2));
		
		Polynom p4 = new Polynom("3x^2 -6 + 4x^3");
		assertEquals(38.0, p4.f(2));
		
		Polynom p5 = new Polynom("x^2 -10 x ^ 3 -2x +10");
		assertEquals(-257.0, p5.f(3));
	}
	
	@Test
	void test_add_monom_to_polymon() {
		
		Monom m1 = new Monom(2, 2);
		Monom m2 = new Monom(8, 2);
		
		Polynom p1 = new Polynom("3x^2");
		p1.add(m1);
		assertEquals("5.0x^2", p1.toString());
		
		Polynom p2 = new Polynom("-6+2x^3");
		p2.add(m1);
		assertEquals("-6.0+2.0x^2+2.0x^3", p2.toString());

		Polynom p3 = new Polynom("1-x-2x^2+3x^3");
		p3.add(m1);
		assertEquals("1.0-x+3.0x^3", p3.toString());
		
		Polynom p4 = new Polynom("1-x-2x^2+3x^3");
		p4.add(m2);
		assertEquals("1.0-x+6.0x^2+3.0x^3", p4.toString());
	}
	
	@Test
	void test_add_polymon_to_polymon() {
		Polynom p1 = new Polynom("3x^2+10");
		Polynom p2 = new Polynom("-6+2x^3+x^2");
		p1.add(p2);
		assertEquals("4.0+4.0x^2+2.0x^3", p1.toString());
		
		Polynom p3 = new Polynom("-6x+8x^0-2x^6");
		Polynom p4 = new Polynom("-X+x^3+x^6");
		p3.add(p4);
		assertEquals("8.0-7.0x+x^3-x^6", p3.toString());
	}
	
	@Test
	void test_substract() {
		Polynom p1 = new Polynom("3x^2+10");
		Polynom p2 = new Polynom("-6+2x^3+x^2");
		p2.substract(p1);
		assertEquals("-16.0-2.0x^2+2.0x^3", p2.toString());
		
		Polynom p3 = new Polynom("-6x+8x^0-2x^6");
		Polynom p4 = new Polynom("-X+x^3+x^6");
		p3.substract(p4);
		assertEquals("8.0-5.0x-x^3-3.0x^6", p3.toString());
	}
	
	@Test
	void test_multiply() {
		Polynom p1 = new Polynom("3x^2+10");
		Polynom p2 = new Polynom("-6+2x^3+x^2");
		p1.multiply(p2);
		assertEquals("-60.0-8.0x^2+20.0x^3+3.0x^4+6.0x^5", p1.toString());
		
		Polynom p3 = new Polynom("-6x+8x^0-2x^6");
		Polynom p4 = new Polynom("-X+x^3+x^6");
		p3.multiply(p4);
		assertEquals("-8.0x+6.0x^2+8.0x^3-6.0x^4+8.0x^6-4.0x^7-2.0x^9-2.0x^12", p3.toString());
		
		Polynom p5 = new Polynom("-0.25x^8");
		Polynom p6 = new Polynom("10x^2");
		p5.multiply(p6);
		assertEquals("-2.5x^10", p5.toString());
	}
	
	@Test
	void test_equals() {
		Polynom p1 = new Polynom("3x^2+10");
		Polynom p2 = new Polynom("-6+2x^3+x^2");
		Polynom p3 = new Polynom("10+3x^2");
		assertFalse(p1.equals(p2));
		assertFalse(p2.equals(p3));
		assertTrue(p1.equals(p3));
	}
	
	@Test
	void test_isZero() {
		Polynom p1 = new Polynom("3x^2+10");
		assertFalse(p1.isZero());
		
		Polynom p2 = new Polynom("-6+2x^3+x^2");
		assertFalse(p2.isZero());
		
		Polynom p3 = new Polynom("");
		assertTrue(p3.isZero());
		
		Polynom p4 = new Polynom();
		assertTrue(p4.isZero());
		
		Polynom p5 = new Polynom("0+0x^3+0x^2");
		assertTrue(p5.isZero());
	}
	
	@Test
	void test_root() {
		Polynom p1 = new Polynom("x");
		assertEquals(0, p1.root(-2, 10, 0.01), 0.01);
		
		Polynom p2 = new Polynom("x^2-x-2");
		assertEquals(2, p2.root(1, 6, 0.01), 0.01);
		
		Polynom p3 = new Polynom("x^2-x-2");
		assertEquals(-1, p3.root(-8, -0.5, 0.01), 0.01);
	}
	
	@Test
	void test_copy() {
		Polynom p1 = new Polynom("3x^2+10");
		Polynom p2 = (Polynom) p1.copy();
		assertTrue(p1.equals(p2));
	}
	
	@Test
	void test_derivative() {
		Polynom p1 = new Polynom("3x^2+10");
		assertEquals("6.0x", p1.derivative().toString());
		
		Polynom p2 = new Polynom("-6+2x^3+x^2");
		assertEquals("2.0x+6.0x^2", p2.derivative().toString());
		
		Polynom p3 = new Polynom("-6x+8x^0-2x^6");
		assertEquals("-6.0-12.0x^5", p3.derivative().toString());
		
		Polynom p4 = new Polynom("-X+x^3+x^6");
		assertEquals("-1.0+3.0x^2+6.0x^5", p4.derivative().toString());
		
		Polynom p5 = new Polynom("x^3-0x^2+6x-3.2");
		assertEquals("6.0+3.0x^2", p5.derivative().toString());
		
		Polynom p6 = new Polynom("-2.1x^5+x^2-x");
		assertEquals("-1.0+2.0x-10.5x^4", p6.derivative().toString());
		
		Polynom p7 = new Polynom("6.2");
		assertEquals("0", p7.derivative().toString());
	}
	
	@Test
	void test_area() {
		Polynom p1 = new Polynom("x");
		assertEquals(50, p1.area(0, 10, 0.01), 0.1);
		
		Polynom p2 = new Polynom("x^2");
		assertEquals(41.66, p2.area(0, 5, 0.01), 0.5);
		
		Polynom p3 = new Polynom("4x^3+3x^2-6");
		assertEquals(10250, p3.area(5, 10, 0.01), 7);
		
		Polynom p4 = new Polynom("8x^2+3x-2");
		assertEquals(21.16, p4.area(2, 1, 0.01), 0.5);
	}
	
	@Test
	void test_iteretor() {
		
		Monom m1 = new Monom (2, 2);
		Monom m2 = new Monom (1, 1);
		Monom m3 = new Monom (6, 0);
		Monom[] arr = {m1, m2, m3};
		Polynom p = new Polynom("2x^2+x+6");
		
		Iterator<Monom> iterator = p.iteretor();
		int i=0;
		while (iterator.hasNext()) {
			Monom current_monom = iterator.next();
			assertEquals(arr[i].toString(), current_monom.toString());
			i++;
		}
	}
	
	@Test
	void test_toString() {
		Polynom p1 = new Polynom("6x^2+x-10");
		String test = p1.toString();
		Polynom p2 = new Polynom(test);
		assertTrue(p2.equals(p1));
		
		Polynom p3 = new Polynom("6x^2-8x^3");
		Polynom p4 = new Polynom("-8x^3+6x^2");
		assertEquals(p3.toString(), p4.toString());
	}
	
	@Test
	void test_area_under_x_axis() {
		Polynom p1 = new Polynom("0.2x^4-1.5x^3+3.0x^2-x-5");
		assertEquals(25.183633821940276, p1.area_under_x_axis(-2, 6, 0.01));
		
		Polynom p2 = new Polynom("x^2");
		assertEquals(0.0, p2.area_under_x_axis(-2, 6, 0.01));
	}
	
	@Test
	void test_invalid_string_constructor() {

		boolean exception = false;

		try {
			Polynom p1 = new Polynom("-x^-2");
		} catch (Exception e) {
			exception = true;
		}
		assertTrue(exception);
		exception = false;

		try {
			Polynom p2 = new Polynom("1a.2x");
		} catch (Exception e) {
			exception = true;
		}
		assertTrue(exception);
		exception = false;

		try {
			Polynom p3 = new Polynom("-4.5x^");
		} catch (Exception e) {
			exception = true;
		}
		assertTrue(exception);
		exception = false;

		try {
			Polynom p4 = new Polynom("2xx");
		} catch (Exception e) {
			exception = true;
		}
		assertTrue(exception);
		exception = false;

		try {
			Polynom p5 = new Polynom("xx");
		} catch (Exception e) {
			exception = true;
		}
		assertTrue(exception);
		exception = false;
		
		try {
			Polynom p6 = new Polynom("2.5x^10x");
		} catch (Exception e) {
			exception = true;
		}
		assertTrue(exception);
		exception = false;
		
		try {
			Polynom p7 = new Polynom("11^2x");
		} catch (Exception e) {
			exception = true;
		}
		assertTrue(exception);
		exception = false;
	}
}
