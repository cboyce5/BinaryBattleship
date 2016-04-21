package BattleshipGame;

@SuppressWarnings("serial")
public class ThreeBitBadBitException extends Exception {
	
	public ThreeBitBadBitException() {
		super("Invalid bit detected; a bit can only be 0 or 1");
	}
}
