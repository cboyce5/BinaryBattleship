package BattleshipGame;

import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
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
		setSize(800,430);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(1,2));
		add(computerBoard);
		add(humanBoard);
	
	}
	
	public static int convertToDecimal(String binNumb){
		
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
	public static boolean handleMove(GameCell selectedCell){
		switch (selectedCell.getCellState()) {
		case NONE:
			
			return true;
		case HIT:
			
			return false;
		case MISS:
			
			return false;
		default:
			return false;	
		}
	}
	public void playGame(){
		while (this.isVisible()) {
			if (humanBoard.isTurn()) {
				CoordinateDialog dialog = new CoordinateDialog(this.computerBoard);
				dialog.setModal(true);
				dialog.setVisible(true);
				humanBoard.setTurn(false);
				if(computerBoard.checkAllSunk()){
					JOptionPane.showMessageDialog(null,"Congratulations!! You have won the binary battleship!");
					
					break;
				}
			}
			else {
				try {
				    Thread.sleep(1500);                 //1000 milliseconds is one second.
				} catch(InterruptedException ex) {
				    Thread.currentThread().interrupt();
				}
				
				Random rn = new Random();
				int row;
				int col;
				do {
					row = rn.nextInt(8);
					col = rn.nextInt(8);
				}
				while(!humanBoard.handleMove(row, col));
				try {
				    Thread.sleep(1500);                 //1000 milliseconds is one second.
				} catch(InterruptedException ex) {
				    Thread.currentThread().interrupt();
				}
				if(humanBoard.checkAllSunk()){
					JOptionPane.showMessageDialog(null,"Uh oh!, the computer beat you!  GET WRECKED");
					break;
				}
				humanBoard.setTurn(true);
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null,"Welcome to BattleShip!\nPlease enter your ship placements in the next screen.");
		BattleshipGame game = new BattleshipGame();
		game.setDefaultCloseOperation(EXIT_ON_CLOSE);
		game.setVisible(true);
		HumanShipSetUp jd = new HumanShipSetUp(game.humanBoard);
		jd.setModal(true);
		jd.setVisible(true);
		game.humanBoard.ships = jd.getShips();
		game.humanBoard.setShips();
		game.humanBoard.repaint();
		if (game.humanBoard.ships.isEmpty()) {
			game.setVisible(false);
		}
		game.playGame();
		game.setVisible(false);
	}
	
}
