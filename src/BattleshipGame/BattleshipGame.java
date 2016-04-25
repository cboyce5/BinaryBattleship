package BattleshipGame;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class BattleshipGame extends JFrame{
	public GameBoard computerBoard;
	public GameBoard humanBoard;
	

	public BattleshipGame() {
		super();
		setUp();
	}
	
	
	public void setUp() {
		computerBoard = new GameBoard(8,8, false);
		humanBoard = new GameBoard(8,8, true);
		setTitle("Binary Battleship");
		setSize(800,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(1,2));
		add(computerBoard);
		add(humanBoard);
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
		BattleshipGame game = new BattleshipGame();
		game.setVisible(true);
	}

	
}
