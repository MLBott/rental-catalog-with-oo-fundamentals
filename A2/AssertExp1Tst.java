package hw2;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AssertExp1Tst extends AssertExp1 {
	

	@Test
	public void testMinValue() {
		assertTrue(-7 == minValue(new double[] {-7}));
		assertTrue(-13 == minValue(new double[] {-13, -4, -5, 7, 8, 11}));
		assertTrue(-7 == minValue(new double[] {1, -4,-7, 7, 8, 11}));
		assertTrue(-9 == minValue(new double[] {1, -4, -7, -6, 8, 11, -9}));

	}
	
	@Test
	public void testMinPosition() {
		assertTrue(0 == minPosition(new double[] { -2 }));
		assertTrue(2 == minPosition(new double[] { 1, -4, -7, 7, 8, 11 }));
		assertTrue(6 == minPosition(new double[] { 1, -4, -7, 7, 8, 11, -9 }));
		assertTrue(1 == minPosition(new double[] { -4, -13, -7, 7, 8, 11 }));
	}
	
	@Test
	public void testNumUnique() {
		assertTrue(0 == numUnique(new double[] { }));
		assertTrue(1 == numUnique(new double[] { 6 }));
		assertTrue(1 == numUnique(new double[] { 11, 11, 11, 11 }));
		assertTrue(8 == numUnique(new double[] { 11, 11, 11, 11, 22, 33, 44, 44, 44, 44, 44, 55, 55, 66, 77, 88, 88 }));
		assertTrue(8 == numUnique(new double[] { 11, 22, 33, 44, 44, 44, 44, 44, 55, 55, 66, 77, 88 }));
	}
	
	@Test
	public void testRemoveDuplicates() {

	}
}
