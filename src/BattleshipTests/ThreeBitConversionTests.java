package BattleshipTests;

import static org.junit.Assert.*;

import org.junit.Test;

import BattleshipGame.ThreeBitBadBitException;
import BattleshipGame.ThreeBitBadBitStringLengthException;
import BattleshipGame.ThreeBitConverter;
import BattleshipGame.ThreeBitInvalidDecimalException;

public class ThreeBitConversionTests {
	
	private static String binaryString = "";
	private static int decimalNumber = -1;
	
	@SuppressWarnings("unused")
	private static String dummyString = "";
	@SuppressWarnings("unused")
	private static int dummyDecimal = -1;
	
	// ------------------
	// TEST FUNCTIONALITY
	// ------------------
	
	// Check conversions that are proper 3-bit binary strings
	@Test
	public void convertValidBiinaryStrings() {
		
		try {
			binaryString = "000";
			assertEquals(0, ThreeBitConverter.convertFromBinary(binaryString));
			
			binaryString = "001";
			assertEquals(1, ThreeBitConverter.convertFromBinary(binaryString));
			
			binaryString = "010";
			assertEquals(2, ThreeBitConverter.convertFromBinary(binaryString));
			
			binaryString = "011";
			assertEquals(3, ThreeBitConverter.convertFromBinary(binaryString));
			
			binaryString = "100";
			assertEquals(4, ThreeBitConverter.convertFromBinary(binaryString));
			
			binaryString = "101";
			assertEquals(5, ThreeBitConverter.convertFromBinary(binaryString));
			
			binaryString = "110";
			assertEquals(6, ThreeBitConverter.convertFromBinary(binaryString));
			
			binaryString = "111";
			assertEquals(7, ThreeBitConverter.convertFromBinary(binaryString));
		}
		catch(ThreeBitBadBitStringLengthException bBSLE) {
			System.out.println("convertValidBinaryStrings() threw a ThreeBitBadBitStringLengthException");
		}
		catch (ThreeBitBadBitException bBE) {
			System.out.println("convertValidBinaryStrings() threw a ThreeBitBadBitException");
		}
	}
	
	// Check conversions that are proper decimal numbers between 0 and 7, inclusive
	@Test
	public void convertValidDecimalNumbers() {
		
		try {
			decimalNumber = 0;
			assertEquals("000", ThreeBitConverter.convertFromDecimal(decimalNumber));
			
			decimalNumber = 1;
			assertEquals("001", ThreeBitConverter.convertFromDecimal(decimalNumber));
			
			decimalNumber = 2;
			assertEquals("010", ThreeBitConverter.convertFromDecimal(decimalNumber));
			
			decimalNumber = 3;
			assertEquals("011", ThreeBitConverter.convertFromDecimal(decimalNumber));
			
			decimalNumber = 4;
			assertEquals("100", ThreeBitConverter.convertFromDecimal(decimalNumber));
			
			decimalNumber = 5;
			assertEquals("101", ThreeBitConverter.convertFromDecimal(decimalNumber));
			
			decimalNumber = 6;
			assertEquals("110", ThreeBitConverter.convertFromDecimal(decimalNumber));
			
			decimalNumber = 7;
			assertEquals("111", ThreeBitConverter.convertFromDecimal(decimalNumber));
		}
		catch(ThreeBitInvalidDecimalException iDE) {
			System.out.println("convertValidDecimalNumbers() threw an ThreeBitInvalidDecimalException");
		}
	}
	
	// ---------------
	// TEST EXCEPTIONS
	// ---------------
	
	// Test BadBitStringLengthException (binaryString = "100110")
	@Test (expected = ThreeBitBadBitStringLengthException.class)
	public void testBadBitStringLengthException_WrongLength() throws ThreeBitBadBitStringLengthException {
		
		binaryString = "100110";
		try {
			dummyDecimal = ThreeBitConverter.convertFromBinary(binaryString);
		}
		catch(ThreeBitBadBitException bBE) {
			System.out.println("ThreeBitBadBitException occured for binaryString = " + binaryString);
		}
	}
		
	// Test BadBitStringLengthException (binaryString = "0204")
	@Test (expected = ThreeBitBadBitStringLengthException.class)
	public void testBadBitStringLengthException_WrongLengthAndBits() throws ThreeBitBadBitStringLengthException {
		
		binaryString = "0204";
		try {
			dummyDecimal = ThreeBitConverter.convertFromBinary(binaryString);
		}
		catch(ThreeBitBadBitException bBE) {
			System.out.println("ThreeBitBadBitException occured for binaryString = " + binaryString);
		}
	}
	
	// Test BadBitException (first bit)
	@Test (expected = ThreeBitBadBitException.class)
	public void testBadBitException_FirstBit() throws ThreeBitBadBitException {
		
		binaryString = "510";
		try {
			dummyDecimal = ThreeBitConverter.convertFromBinary(binaryString);
		}
		catch (ThreeBitBadBitStringLengthException bBSLE) {
			System.out.println("testBadBitException_FirstBit() threw a ThreeBitBadBitStringLengthException");
		}
	}
	
	// Test BadBitException (second bit)
	@Test (expected = ThreeBitBadBitException.class)
	public void testBadBitException_SecondBit() throws ThreeBitBadBitException {
		
		binaryString = "090";
		try {
			dummyDecimal = ThreeBitConverter.convertFromBinary(binaryString);
		}
		catch (ThreeBitBadBitStringLengthException bBSLE) {
			System.out.println("testBadBitException_SecondBit() threw a ThreeBitBadBitStringLengthException");
		}
	}
	
	// Test BadBitException (third bit)
	@Test (expected = ThreeBitBadBitException.class)
	public void testBadBitException_ThirdBit() throws ThreeBitBadBitException {
		
		binaryString = "116";
		try {
			dummyDecimal = ThreeBitConverter.convertFromBinary(binaryString);
		}
		catch (ThreeBitBadBitStringLengthException bBSLE) {
			System.out.println("testBadBitException_ThirdBit() threw a ThreeBitBadBitStringLengthException");
		}
	}
	
	// Test InvalidDecimalException (decimalNumber < 0)
	@Test (expected = ThreeBitInvalidDecimalException.class)
	public void testInvalidDecimalException_LessThanZero() throws ThreeBitInvalidDecimalException {
		
		decimalNumber = -1;
		dummyString = ThreeBitConverter.convertFromDecimal(decimalNumber);
	}
	
	// Test InvalidDecimalException (decimalNumber > 7)
	@Test (expected = ThreeBitInvalidDecimalException.class)
	public void testInvalidDecimalException_GreaterThanSeven() throws ThreeBitInvalidDecimalException {
		
		decimalNumber = 8;
		dummyString = ThreeBitConverter.convertFromDecimal(decimalNumber);
	}
}
