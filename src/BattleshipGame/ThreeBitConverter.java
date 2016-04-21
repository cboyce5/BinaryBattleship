package BattleshipGame;

public class ThreeBitConverter {
	
	public ThreeBitConverter() {
		
	}
	
	public static int convertFromBinary(String binaryString) throws ThreeBitBadBitStringLengthException, ThreeBitBadBitException {
		
		// Check length of the binary string
		if (binaryString.length() != 3) {throw new ThreeBitBadBitStringLengthException(binaryString.length());}
		
		// Check that the binary string has only 0s and 1s
		for (int i = 0; i < binaryString.length(); ++i) {
			if (!((Character)binaryString.charAt(i)).equals('0') && !((Character)binaryString.charAt(i)).equals('1')) {
				throw new ThreeBitBadBitException();
			}
		}
		
		// Calculate decimal value of the bit string
		int sum = 0;
		if ( ( (Character)binaryString.charAt(0) ).equals('1')) {sum += 4;}
		if ( ( (Character)binaryString.charAt(1) ).equals('1')) {sum += 2;}
		if ( ( (Character)binaryString.charAt(2) ).equals('1')) {sum += 1;}
		
		return sum;
	}
	
	public static String convertFromDecimal(int decimal) throws ThreeBitInvalidDecimalException {
		
		// Check if the decimal is valid for 3-bit binary strings
		if (decimal < 0 || decimal > 7) {throw new ThreeBitInvalidDecimalException();}
		
		// Calculate bit string of the decimal
		String binaryString = "";
		if (decimal / 4 > 0) {binaryString += '1'; decimal -= 4;} else {binaryString += '0';}
		if (decimal / 2 > 0) {binaryString += '1'; decimal -= 2;} else {binaryString += '0';}
		if (decimal / 1 > 0) {binaryString += '1'; decimal -= 1;} else {binaryString += '0';}
		
		return binaryString;
	}
}
