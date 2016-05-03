package BattleshipTests;

import static org.junit.Assert.*;

import org.junit.Test;

import BattleshipGame.BattleshipGame;

public class ConversionTests {

	private static BattleshipGame bs = new BattleshipGame();
	
	//Tests for converting from base ten decimal to binary
	@Test
	public void testConvertingToBinary() {

		// 4 bits
		assertEquals("0000", bs.convertToBinary(0, 4));
		assertEquals("0001", bs.convertToBinary(1, 4));
		assertEquals("0010", bs.convertToBinary(2, 4));
		assertEquals("0011", bs.convertToBinary(3, 4));
		assertEquals("0100", bs.convertToBinary(4, 4));
		assertEquals("0101", bs.convertToBinary(5, 4));
		assertEquals("0110", bs.convertToBinary(6, 4));
		assertEquals("0111", bs.convertToBinary(7, 4));
		assertEquals("1000", bs.convertToBinary(8, 4));
		assertEquals("1001", bs.convertToBinary(9, 4));
		assertEquals("1010", bs.convertToBinary(10, 4));
		assertEquals("1011", bs.convertToBinary(11, 4));
		assertEquals("1100", bs.convertToBinary(12, 4));
		assertEquals("1101", bs.convertToBinary(13, 4));
		assertEquals("1110", bs.convertToBinary(14, 4));
		assertEquals("1111", bs.convertToBinary(15, 4));

		//Tests for converting from base ten decimal to binary (3 bits).
		assertEquals("000", bs.convertToBinary(0, 3));
		assertEquals("001", bs.convertToBinary(1, 3));
		assertEquals("010", bs.convertToBinary(2, 3));
		assertEquals("011", bs.convertToBinary(3, 3));
		assertEquals("100", bs.convertToBinary(4, 3));
		assertEquals("101", bs.convertToBinary(5, 3));
		assertEquals("110", bs.convertToBinary(6, 3));
		assertEquals("111", bs.convertToBinary(7, 3));
	}

	// Tests for converting from binary back to base 10 decimal
	@Test 
	public void testConvertingToDecimal() {

		// 4-bit
		assertEquals(0, BattleshipGame.convertToDecimal("0000"));
		assertEquals(1, BattleshipGame.convertToDecimal("0001"));
		assertEquals(2, BattleshipGame.convertToDecimal("0010"));
		assertEquals(3, BattleshipGame.convertToDecimal("0011"));
		assertEquals(4, BattleshipGame.convertToDecimal("0100"));
		assertEquals(5, BattleshipGame.convertToDecimal("0101"));
		assertEquals(6, BattleshipGame.convertToDecimal("0110"));
		assertEquals(7, BattleshipGame.convertToDecimal("0111"));
		assertEquals(8, BattleshipGame.convertToDecimal("1000"));
		assertEquals(9, BattleshipGame.convertToDecimal("1001"));
		assertEquals(10, BattleshipGame.convertToDecimal("1010"));
		assertEquals(11, BattleshipGame.convertToDecimal("1011"));
		assertEquals(12, BattleshipGame.convertToDecimal("1100"));
		assertEquals(13, BattleshipGame.convertToDecimal("1101"));
		assertEquals(14, BattleshipGame.convertToDecimal("1110"));
		assertEquals(15, BattleshipGame.convertToDecimal("1111"));

		// 3-bit
		assertEquals(0, BattleshipGame.convertToDecimal("000"));
		assertEquals(1, BattleshipGame.convertToDecimal("001"));
		assertEquals(2, BattleshipGame.convertToDecimal("010"));
		assertEquals(3, BattleshipGame.convertToDecimal("011"));
		assertEquals(4, BattleshipGame.convertToDecimal("100"));
		assertEquals(5, BattleshipGame.convertToDecimal("101"));
		assertEquals(6, BattleshipGame.convertToDecimal("110"));
		assertEquals(7, BattleshipGame.convertToDecimal("111"));
	}

}
