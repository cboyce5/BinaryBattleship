package BattleshipGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameBoard extends JPanel {
	boolean isHuman;
	private int numRows, numColumns;
	public GameCell[][] board;
	public ArrayList<Ship> ships;
	private JLabel label;
	private boolean turn = false;
	private int lastRow;
	private int lastCol;
	private boolean correctAnswer = false;

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
		if(!isHuman){
			initializeShipsComputer();
			this.turn = false;
		}
		else {
			this.turn = true;
		}
	
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(int i = 0; i < numRows; i++){
			for(int j = 0; j < numColumns; j++){
				board[i][j].draw(g);
				if(isHuman){
					board[i][j].humanDraw(g);
					Font myFont = new Font("Serif", Font.BOLD, 18);
					g.setFont(myFont);
					g.setColor(Color.black);
					g.drawString("Human Board", 0, GameCell.cellSize * numRows + 20);
				}
				else{
					board[i][j].computerDraw(g);
					Font myFont = new Font("Serif", Font.BOLD, 18);
					g.setFont(myFont);
					g.setColor(Color.black);
					g.drawString("Computer Board", 0, GameCell.cellSize * numRows + 20);
				}
			}
		}
	}
	public boolean isCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(boolean correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	
	public int getLastRow() {
		return lastRow;
	}
	public void setLastRow(int lastRow) {
		this.lastRow = lastRow;
	}
	public int getLastCol() {
		return lastCol;
	}
	public void setLastCol(int lastCol) {
		this.lastCol = lastCol;
	}
	public void initializeShipsComputer(){
		ships.add(new Ship(0, 0, Direction.RIGHT, 3));
		ships.add(new Ship(3, 1, Direction.DOWN, 4));
		ships.add(new Ship(5, 6, Direction.UP, 5));
		ships.add(new Ship(4, 4, Direction.LEFT, 2));
		setShips();
	}
	public boolean handleMove(int row, int column){
		lastRow = row;
		lastCol = column;
		switch (board[row][column].getCellState()) {
		case NONE:
			if(board[row][column].containsShip()){
				board[row][column].setCellState(CellState.HIT);
				checkShipSunk();
			}
			else{
				board[row][column].setCellState(CellState.MISS);
			}
			repaint();
			return true;
		case HIT:
			return false;
		case MISS:
			return false;
		default:
			return false;	
		}
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
	public boolean isTurn() {
		return turn;
	}
	public void setTurn(boolean turn) {
		this.turn = turn;
	}
	public boolean checkAllSunk(){
		for(Ship s: ships){
			if(!s.isSunk()){
				return false;
			}
		}
		return true;
	}
	public void checkShipSunk() {
		for(Ship s : ships){
			if(s.getShipDirection() == Direction.UP){
				int count = 0;
				for(int i = 0; i < s.getShipLength(); i++){
					if (board[s.getStartRow()-i][s.getStartColumn()].getCellState() == CellState.HIT) {
						count++;
					}
				}
				if (count == s.getShipLength()) {
					if(!isHuman){
						BinaryQuestionDialog dialog = new BinaryQuestionDialog(this);
						dialog.setModal(true);
						dialog.setVisible(true);
					}
					if (correctAnswer || isHuman) {
						s.setSunk(true);
						for(int i = 0; i < s.getShipLength(); i++){
							board[s.getStartRow()-i][s.getStartColumn()].setCellState(CellState.SUNK);
						}
					}
					correctAnswer = false;
					
				}
			}
			else if(s.getShipDirection() == Direction.RIGHT){
				int count = 0;
				for(int i = 0; i < s.getShipLength(); i++){
					if (board[s.getStartRow()][s.getStartColumn()+i].getCellState() == CellState.HIT) {
						count++;
					}
				}
				if (count == s.getShipLength()) {
					if(!isHuman){
						BinaryQuestionDialog dialog = new BinaryQuestionDialog(this);
						dialog.setModal(true);
						dialog.setVisible(true);
					}
					if (correctAnswer || isHuman) {
						s.setSunk(true);
						for(int i = 0; i < s.getShipLength(); i++){
							board[s.getStartRow()][s.getStartColumn()+i].setCellState(CellState.SUNK);
						}
					}
					correctAnswer = false;
				}
			}
			else if(s.getShipDirection() == Direction.DOWN){
				int count = 0;
				for(int i = 0; i < s.getShipLength(); i++){
					if (board[s.getStartRow()+i][s.getStartColumn()].getCellState() == CellState.HIT) {
						count++;
					}
				}
				if (count == s.getShipLength()) {
					if(!isHuman){
						BinaryQuestionDialog dialog = new BinaryQuestionDialog(this);
						dialog.setModal(true);
						dialog.setVisible(true);
					}
					if (correctAnswer || isHuman) {
						s.setSunk(true);
						for(int i = 0; i < s.getShipLength(); i++){
							board[s.getStartRow()+i][s.getStartColumn()].setCellState(CellState.SUNK);
						}
					}
					correctAnswer = false;
				}
			}
			else if(s.getShipDirection() == Direction.LEFT){
				int count = 0;
				for(int i = 0; i < s.getShipLength(); i++){
					if (board[s.getStartRow()][s.getStartColumn()-i].getCellState() == CellState.HIT) {
						count++;
					}
				}
				if (count == s.getShipLength()) {
					if(!isHuman){
						BinaryQuestionDialog dialog = new BinaryQuestionDialog(this);
						dialog.setModal(true);
						dialog.setVisible(true);
					}
					if (correctAnswer || isHuman) {
						s.setSunk(true);
						for(int i = 0; i < s.getShipLength(); i++){
							board[s.getStartRow()][s.getStartColumn()-i].setCellState(CellState.SUNK);
						}
					}
					correctAnswer = false;
				}
			}
		}
	}
}
