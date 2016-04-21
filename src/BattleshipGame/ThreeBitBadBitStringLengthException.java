package BattleshipGame;

@SuppressWarnings("serial")
public class ThreeBitBadBitStringLengthException extends Exception {
	
	public ThreeBitBadBitStringLengthException() {
		super("Incorrect Bit String Length");
	}
	
	public ThreeBitBadBitStringLengthException(int length) {
		super("Bit string length entered: " + length + '\n' + "Enter a bit string of length 3");
	}
}
