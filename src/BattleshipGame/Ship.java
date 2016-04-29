package BattleshipGame;

public class Ship {
	private int startRow, startColumn;
	private Direction shipDirection;
	private int shipLength;
	private boolean sunk;
	public Ship(int startRow, int startColumn, Direction shipDirection, int shipLength) {
		super();
		this.startRow = startRow;
		this.startColumn = startColumn;
		this.shipDirection = shipDirection;
		this.shipLength = shipLength;
		sunk = false;
	}
	public boolean isSunk() {
		return sunk;
	}
	public void setSunk(boolean sunk) {
		this.sunk = sunk;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getStartColumn() {
		return startColumn;
	}
	public void setStartColumn(int startColumn) {
		this.startColumn = startColumn;
	}
	public Direction getShipDirection() {
		return shipDirection;
	}
	public void setShipDirection(Direction shipDirection) {
		this.shipDirection = shipDirection;
	}
	public int getShipLength() {
		return shipLength;
	}
	public void setShipLength(int shipLength) {
		this.shipLength = shipLength;
	}
	
}
