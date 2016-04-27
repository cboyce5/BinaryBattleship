package BattleshipGame;

import java.awt.Color;
import java.awt.Graphics;

public class GameCell {
	private int row, column;
	public static final int cellSize = 40;
	private CellState cellState;
	private boolean containsShip;
	public GameCell(int row, int column) {
		super();
		this.row = row;
		this.column = column;
		this.cellState = CellState.NONE;
		this.containsShip = containsShip;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	public CellState getCellState() {
		return cellState;
	}
	public void setCellState(CellState cellState) {
		this.cellState = cellState;
	}
	public boolean isContainsShip() {
		return containsShip;
	}
	public void setContainsShip(boolean containsShip) {
		this.containsShip = containsShip;
	}
	public void draw(Graphics g){
		g.setColor(Color.blue);
		g.fillRect(column * cellSize, row * cellSize, cellSize, cellSize);
		g.setColor(Color.black);
		g.drawRect(column * cellSize, row * cellSize, cellSize, cellSize);
		//TODO Add portion which will displays hits and misses.
		
	}
	public void humanDraw(Graphics g){
		if(containsShip){
			g.setColor(Color.gray);
			g.fillRect(column * cellSize, row * cellSize, cellSize, cellSize);
		}
		switch(cellState){
		case NONE:
			break;
		case MISS:
			g.setColor(Color.white);
			g.drawOval(column * cellSize, row * cellSize, cellSize, cellSize);
			break;
		case SUNK:
			g.setColor(Color.red);
			g.drawOval(column * cellSize, row * cellSize, cellSize, cellSize);
			break;
		case HIT:
			g.setColor(Color.yellow);
			g.drawOval(column * cellSize, row * cellSize, cellSize, cellSize);
			break;
		}
	}
	public void computerDraw(Graphics g){
		if(containsShip){
			g.setColor(Color.gray);
			g.fillRect(column * cellSize, row * cellSize, cellSize, cellSize);
		}
		switch(cellState){
		case NONE:
			break;
		case MISS:
			g.setColor(Color.white);
			g.drawOval(column * cellSize, row * cellSize, cellSize, cellSize);
			break;
		case SUNK:
			g.setColor(Color.red);
			g.drawOval(column * cellSize, row * cellSize, cellSize, cellSize);
			break;
		case HIT:
			g.setColor(Color.yellow);
			g.drawOval(column * cellSize, row * cellSize, cellSize, cellSize);
			break;
		}
	}
}
