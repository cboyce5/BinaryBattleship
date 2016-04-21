package BattleshipGame;

import java.util.ArrayList;

public class GameBoard {
	private int numRows, numColumns;
	public GameCell[][] board;
	public ArrayList<Ship> ships;
	public GameBoard(int numRows, int numColumns, GameCell[][] board) {
		super();
		this.numRows = numRows;
		this.numColumns = numColumns;
		this.ships = new ArrayList<Ship>();
	}
	public void initialize(){
		board = new GameCell[numRows][numColumns];
		for(int i = 0; i < numRows; i++){
			for(int j = 0; j < numColumns; j++){
				board[numRows][numColumns] = new GameCell(i, j);
			}
		}
	}
	
}
