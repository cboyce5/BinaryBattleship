package BattleshipGame;

@SuppressWarnings("serial")
public class ThreeBitInvalidDecimalException extends Exception {
	
	public ThreeBitInvalidDecimalException() {
		super("Number input was not between 0 and 7 (inclusive)");
	}
}
