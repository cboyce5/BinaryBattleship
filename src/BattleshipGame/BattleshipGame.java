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
		
		return -1;//decNumb;
	}
	public String convertToBinary(int decNumb, int numbBits){
		
		return " ";
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
