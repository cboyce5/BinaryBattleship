package BattleshipTests;

import static org.junit.Assert.*;

import org.junit.Test;

import BattleshipGame.BattleshipGame;

public class ConversionTests {

	@Test
	public void test() {
		BattleshipGame bs = new BattleshipGame();
		
		//Tests for converting from base ten decimal to binary.
		assertEquals("0000", bs.convertToBinary(0));
		assertEquals("0001", bs.convertToBinary(1));
		assertEquals("0010", bs.convertToBinary(2));
		assertEquals("0011", bs.convertToBinary(3));
		assertEquals("0100", bs.convertToBinary(4));
		assertEquals("0101", bs.convertToBinary(5));
		assertEquals("0110", bs.convertToBinary(6));
		assertEquals("0111", bs.convertToBinary(7));
		assertEquals("1000", bs.convertToBinary(8));
		
		
		//Tests for converting from binary back to base 10 decimal.
		
		assertEquals(0, bs.convertToDecimal("0000"));
		assertEquals(1, bs.convertToDecimal("0001"));
		assertEquals(2, bs.convertToDecimal("0010"));
		assertEquals(3, bs.convertToDecimal("0011"));
		assertEquals(4, bs.convertToDecimal("0100"));
		assertEquals(5, bs.convertToDecimal("0101"));
		assertEquals(6, bs.convertToDecimal("0110"));
		assertEquals(7, bs.convertToDecimal("0111"));
		assertEquals(8, bs.convertToDecimal("1000"));

		
	}

}
