package BattleshipGame;

public class BattleshipGame {
	public GameBoard computerBoard;
	public GameBoard humanBoard;
	

	public BattleshipGame() {
		super();
	}
	
	public int convertToDecimal(String binNumb){
		
		int decNumb = 0;
		int power = binNumb.length() - 1;
		
		for (int i = 0; i < binNumb.length(); ++i) {
			if (((Character)binNumb.charAt(i)).equals('1')) {
				decNumb += (int)Math.pow(2.0, power);
			}
			power = power - 1;
		}
		
		return decNumb;
	}
	public String convertToBinary(int decNumb, int numbBits){
		
		String binNum = "";
		if (decNumb < 8 && numbBits > 3) {binNum += '0';}
		if (decNumb > 7 && numbBits > 3) {binNum += '1'; decNumb -= 8;}
		int bitValue = 4;
		for (int i = 0; i < 3; ++i) { // Only need 3 more bits to calculate
			if (decNumb / bitValue > 0) {binNum += '1'; decNumb -= bitValue;}
			else {binNum += '0';}
			bitValue /= 2;
		}
		return binNum;
	}
	public boolean handleMove(GameCell selectedCell){
		
		return false;
	}
	public void playGame(){
		
		
	}
	
	public static void main(String[] args) {
		//Insert main code//
	}

	
}
