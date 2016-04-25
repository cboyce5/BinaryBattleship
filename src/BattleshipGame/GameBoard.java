package BattleshipGame;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JPanel;

public class GameBoard extends JPanel{
	boolean isHuman;
	private int numRows, numColumns;
	public GameCell[][] board;
	public ArrayList<Ship> ships;
	public GameBoard(int numRows, int numColumns, boolean isHuman) {
		super();
		this.numRows = numRows;
		this.numColumns = numColumns;
		this.ships = new ArrayList<Ship>();
		this.isHuman = isHuman;
		initialize();
		//Add other initialize calls here.
	}
	public void initialize(){
		board = new GameCell[numRows][numColumns];
		for(int i = 0; i < numRows; i++){
			for(int j = 0; j < numColumns; j++){
				board[i][j] = new GameCell(i, j);
			}
		}
		if(isHuman){
			HumanShipSetUp jd = new HumanShipSetUp();
			jd.setVisible(true);
		}
		else{
			initializeShipsComputer();
		}
	}
	public void paintComponent(Graphics g) {
		for(int i = 0; i < numRows; i++){
			for(int j = 0; j < numColumns; j++){
				board[i][j].draw(g);
				if(isHuman){
					board[i][j].humanDraw(g);
				}
				else{
					board[i][j].computerDraw(g);
				}
			}
		}
	}
	public void initializeShipsComputer(){
		ships.add(new Ship(0, 0, Direction.RIGHT, 3));
		ships.add(new Ship(3, 1, Direction.DOWN, 4));
		ships.add(new Ship(5, 6, Direction.UP, 5));
		ships.add(new Ship(4, 4, Direction.LEFT, 2));
		setShips();
	}

	public void setShips(){
		for(Ship s : ships){
			if(s.getShipDirection() == Direction.UP){
				for(int i = 0; i < s.getShipLength(); i++){
					board[s.getStartRow() - i][s.getStartColumn()].setContainsShip(true);
				}
			}
			else if(s.getShipDirection() == Direction.RIGHT){
				for(int i = 0; i < s.getShipLength(); i++){
					board[s.getStartRow()][s.getStartColumn() + i].setContainsShip(true);
				}
			}
			else if(s.getShipDirection() == Direction.DOWN){
				for(int i = 0; i < s.getShipLength(); i++){
					board[s.getStartRow() + i][s.getStartColumn()].setContainsShip(true);
				}
			}
			else if(s.getShipDirection() == Direction.LEFT){
				for(int i = 0; i < s.getShipLength(); i++){
					board[s.getStartRow()][s.getStartColumn() - i].setContainsShip(true);
				}
			}
		}
	}
}
