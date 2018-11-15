package myMath;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MonomTest {
	
	@Test
	void test_constructor() {
		Monom m1 = new Monom(2.5, 4);
		assertEquals(2.5, m1.get_coefficient());
		assertEquals(4, m1.get_power());
	}
	
	@Test
	void test_copy_constructor() {
		Monom m1 = new Monom(2.5, 4);
		Monom m2 = new Monom(m1);
		assertEquals(2.5, m2.get_coefficient());
		assertEquals(4, m2.get_power());
	}
	
	@Test
	void test_f() {
		Monom m1 = new Monom(0, 12);
		assertEquals(0, m1.f(-2.568));
		
		Monom m2 = new Monom(-3, 3);
		assertEquals(0, m2.f(0));
		
		Monom m3 = new Monom(-3, 3);
		assertEquals(-3, m3.f(1));
		
		Monom m4 = new Monom(3, 5);
		assertEquals(-96, m4.f(-2));
		
		Monom m5 = new Monom(2.0, 3);
		assertEquals(16, m5.f(2));
		
		Monom m6 = new Monom(-10.25, 11);
		assertEquals(-20992, m6.f(2));
		
		Monom m7 = new Monom(0.025, 8);
		assertEquals(10749542.4, m7.f(12));
		
		Monom m8 = new Monom(3.1, 2);
		assertEquals(12.4, m8.f(2));
		
		Monom m9 = new Monom(-3, 2);
		assertEquals(-12, m9.f(-2));
		
		Monom m10 = new Monom(-3.1, 2);
		assertEquals(-12.4, m10.f(-2));
		
		Monom m11 = new Monom(1, 2);
		assertEquals(4, m11.f(2));
	}
	
	@Test
	void test_add() {
		Monom m1 = new Monom(3,2);
		Monom m2 = new Monom(10,2);
		m1.add(m2);
		assertEquals(13, m1.get_coefficient());
		assertEquals(2, m1.get_power());
		
		Monom m3 = new Monom(-10,2);
		m3.add(m2);
		assertEquals(0, m3.get_coefficient());
		assertEquals(2, m3.get_power());
		
		Monom m4 = new Monom(-12.25,2);
		m4.add(m2);
		assertEquals(-2.25, m4.get_coefficient());
		assertEquals(2, m4.get_power());
	}
	
	@Test
	void test_multiply() { 
		Monom m1 = new Monom(-3,2);
		Monom m2 = new Monom(10.5,6);
		m1.multiply(m2);
		assertEquals(-31.5, m1.get_coefficient());
		assertEquals(8, m1.get_power());
		
		Monom m3 = new Monom(0, 2);
		Monom m4 = new Monom(3,6);
		m4.multiply(m3);
		assertEquals(0, m4.get_coefficient());
		assertEquals(0, m4.get_power());
		
		Monom m5 = new Monom(1, 1);
		Monom m6 = new Monom(1,0);
		m5.multiply(m6);
		assertEquals(1, m5.get_coefficient());
		assertEquals(1, m5.get_power());
		
		Monom m7 = new Monom(-2.5, 1);
		Monom m8 = new Monom(-2,0);
		m7.multiply(m8);
		assertEquals(5, m7.get_coefficient());
		assertEquals(1, m7.get_power());
		
		Monom m9 = new Monom(-2.5, 0);
		Monom m10 = new Monom(2,0);
		m9.multiply(m10);
		assertEquals(-5, m9.get_coefficient());
		assertEquals(0, m9.get_power());
	}
	
	@Test
	void test_derivative() {
		Monom m1 = new Monom(-3,2);
		assertEquals(-6, m1.derivative().get_coefficient());
		assertEquals(1, m1.derivative().get_power());
		
		Monom m2 = new Monom(0,0);
		assertEquals(0, m2.derivative().get_coefficient());
		assertEquals(0, m2.derivative().get_power());
		
		Monom m3 = new Monom(2,0);
		assertEquals(0, m3.derivative().get_coefficient());
		assertEquals(0, m3.derivative().get_power());
		
		Monom m4 = new Monom(2, 3);
		assertEquals(6, m4.derivative().get_coefficient());
		assertEquals(2, m4.derivative().get_power());
		
		Monom m5 = new Monom(-2, 3);
		assertEquals(-6, m5.derivative().get_coefficient());
		assertEquals(2, m5.derivative().get_power());
		
		Monom m6 = new Monom(2.1, 3);
		assertEquals(6.300000000000001, m6.derivative().get_coefficient());
		assertEquals(2, m6.derivative().get_power());
		
		Monom m7 = new Monom(2, 2);
		assertEquals(4, m7.derivative().get_coefficient());
		assertEquals(1, m7.derivative().get_power());
		
		Monom m8 = new Monom(2, 1);
		assertEquals(2, m8.derivative().get_coefficient());
		assertEquals(0, m8.derivative().get_power());
	}
	
	@Test
	void test_equals() {
		Monom m1 = new Monom(0, 0);
		Monom m2 = new Monom(2, 0);
		Monom m3 = new Monom(2, 3);
		Monom m4 = new Monom(2, 3);
		assertFalse(m1.equals(m2));
		assertFalse(m2.equals(m3));
		assertTrue(m3.equals(m4));
		assertTrue(m4.equals(m3));
	}
	
	@Test
	void test_toString() {
		Monom m1 = new Monom(2, 3);
		assertEquals("2.0x^3", m1.toString());
		
		Monom m2 = new Monom(-2, 10);
		assertEquals("-2.0x^10", m2.toString());
		
		Monom m3 = new Monom(2.5, 2);
		assertEquals("2.5x^2", m3.toString());
		
		Monom m4 = new Monom(-6.01, 16);
		assertEquals("-6.01x^16", m4.toString());
		
		Monom m5 = new Monom(1, 2);
		assertEquals("x^2", m5.toString());
		
		Monom m6 = new Monom(-1, 2);
		assertEquals("-x^2", m6.toString());
		
		Monom m7 = new Monom(1, 1);
		assertEquals("x", m7.toString());
		
		Monom m8 = new Monom(-1, 1);
		assertEquals("-x", m8.toString());
		
		Monom m9 = new Monom(61, 1);
		assertEquals("61.0x", m9.toString());
		
		Monom m10 = new Monom(-61, 1);
		assertEquals("-61.0x", m10.toString());
		
		Monom m11 = new Monom(0, 0);
		assertEquals("0.0", m11.toString());
		
		Monom m12 = new Monom(3, 0);
		assertEquals("3.0", m12.toString());
		
		Monom m13 = new Monom(-3.6, 0);
		assertEquals("-3.6", m13.toString());
	}
	
	@Test
	void test_Subtraction() {
		Monom m1 = new Monom(6, 2);
		Monom m2 = new Monom(4, 2);
		m1.subtraction(m2);
		assertEquals(2, m1.get_coefficient());
		assertEquals(2, m1.get_power());
		
		Monom m3 = new Monom(3, 2);
		Monom m4 = new Monom(1, 2);
		m3.subtraction(m4);
		assertEquals(2, m3.get_coefficient());
		assertEquals(2, m3.get_power());
		
		Monom m5 = new Monom(6, 10);
		Monom m6 = new Monom(-2, 10);
		m5.subtraction(m6);
		assertEquals(8, m5.get_coefficient());
		assertEquals(10, m5.get_power());
		
		Monom m7 = new Monom(-2, 2);
		Monom m8 = new Monom(-3, 2);
		m7.subtraction(m8);
		assertEquals(1, m7.get_coefficient());
		assertEquals(2, m7.get_power());
		
		Monom m9 = new Monom(6, 6);
		Monom m10 = new Monom(8, 6);
		m9.subtraction(m10);
		assertEquals(-2, m9.get_coefficient());
		assertEquals(6, m9.get_power());
		
		Monom m11 = new Monom(-2, 2);
		Monom m12 = new Monom(2, 2);
		m11.subtraction(m12);
		assertEquals(-4, m11.get_coefficient());
		assertEquals(2, m11.get_power());
		
		Monom m13 = new Monom(1, 2);
		Monom m14 = new Monom(1, 2);
		m13.subtraction(m14);
		assertEquals(0, m13.get_coefficient());
		assertEquals(2, m13.get_power());
		
		Monom m15 = new Monom(3, 0);
		Monom m16 = new Monom(1, 0);
		m15.subtraction(m16);
		assertEquals(2, m15.get_coefficient());
		assertEquals(0, m15.get_power());
		
		Monom m17 = new Monom(6, 1);
		Monom m18 = new Monom(3, 1);
		m17.subtraction(m18);
		assertEquals(3, m17.get_coefficient());
		assertEquals(1, m17.get_power());
		
		Monom m19 = new Monom(8, 3);
		Monom m20 = new Monom(0, 3);
		m19.subtraction(m20);
		assertEquals(8, m19.get_coefficient());
		assertEquals(3, m19.get_power());
		
		Monom m21 = new Monom(2, 1);
		Monom m22 = new Monom(8, 1);
		m21.subtraction(m22);
		assertEquals(-6, m21.get_coefficient());
		assertEquals(1, m21.get_power());
		
		Monom m23 = new Monom(-6, 0);
		Monom m24 = new Monom(-3, 0);
		m23.subtraction(m24);
		assertEquals(-3, m23.get_coefficient());
		assertEquals(0, m23.get_power());
	}
	
	@Test
	void test_invalid_add() {

		boolean exception = false;

		try {
			Monom m1 = new Monom(3, 2);
			Monom m2 = new Monom(3, 1);
			m1.add(m2);

		} catch (Exception e) {
			exception = true;
		}
		assertTrue(exception);
	}
	
	@Test
	void test_invalid_constructor() {

		boolean exception = false;

		try {
			Monom m1 = new Monom(3, -2);
			
		} catch (Exception e) {
			exception = true;
		}
		assertTrue(exception);
	}
}
