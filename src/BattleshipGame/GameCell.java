package BattleshipGame;

import java.awt.Color;
import java.awt.Graphics;

public class GameCell {
	private int row, column;
	public static final int cellSize = 40;
	private CellState cellState;
	private boolean containsShip;
	Assets assets = new Assets();
	public GameCell(int row, int column) {
		super();
		this.row = row;
		this.column = column;
		this.cellState = CellState.NONE;
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
	public boolean containsShip() {
		return containsShip;
	}
	public void setContainsShip(boolean containsShip) {
		this.containsShip = containsShip;
	}
	
	public void drawBackground(Graphics g) {
		g.drawImage(Assets.getPlanks(), column * cellSize * 3, row * cellSize * 3, cellSize * 3, cellSize * 3, null);
	}
	
	public void draw(Graphics g){
		//g.setColor(Color.blue);
		//g.fillRect(column * cellSize, row * cellSize, cellSize, cellSize);
		g.drawImage(Assets.getPuddle(), column * cellSize, row * cellSize, cellSize, cellSize, null);
		g.setColor(Color.black);
		g.drawRect(column * cellSize, row * cellSize, cellSize, cellSize);
	}
	public void humanDraw(Graphics g){
		if(containsShip){
			//g.setColor(Color.gray);
			//g.fillRect(column * cellSize, row * cellSize, cellSize, cellSize);
			g.drawImage(Assets.getShip(), column * cellSize, row * cellSize, cellSize, cellSize, null);
		}
		switch(cellState){
		case NONE:
			break;
		case MISS:
			//g.setColor(Color.white);
			//g.fillOval(column * cellSize, row * cellSize, cellSize, cellSize);
			g.drawImage(Assets.getMiss(), column * cellSize, row * cellSize, cellSize, cellSize, null);
			break;
		case SUNK:
			//g.setColor(Color.red);
			//g.fillOval(column * cellSize, row * cellSize, cellSize, cellSize);
			g.drawImage(Assets.getSunk(), column * cellSize, row * cellSize, cellSize, cellSize, null);
			break;
		case HIT:
			//g.setColor(Color.yellow);
			//g.fillOval(column * cellSize, row * cellSize, cellSize, cellSize);
			g.drawImage(Assets.getHit(), column * cellSize, row * cellSize, cellSize, cellSize, null);
			break;
		}
	}
	public void computerDraw(Graphics g){
		
		switch(cellState){
		case NONE:
			break;
		case MISS:
			//g.setColor(Color.white);
			//g.fillOval(column * cellSize, row * cellSize, cellSize, cellSize);
			g.drawImage(Assets.getMiss(), column * cellSize, row * cellSize, cellSize, cellSize, null);
			break;
		case SUNK:
			//g.setColor(Color.red);
			//g.fillOval(column * cellSize, row * cellSize, cellSize, cellSize);
			g.drawImage(Assets.getSunk(), column * cellSize, row * cellSize, cellSize, cellSize, null);
			break;
		case HIT:
			//g.setColor(Color.yellow);
			//g.fillOval(column * cellSize, row * cellSize, cellSize, cellSize);
			g.drawImage(Assets.getHitC(), column * cellSize, row * cellSize, cellSize, cellSize, null);
			break;
		}
	}
}
