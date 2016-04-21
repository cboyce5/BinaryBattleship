package BattleshipGame;

public class Ship {
	private int startRow, startColumn;
	private Direction shipDirection;
	private int shipLength;
	public Ship(int startRow, int startColumn, Direction shipDirection, int shipLength) {
		super();
		this.startRow = startRow;
		this.startColumn = startColumn;
		this.shipDirection = shipDirection;
		this.shipLength = shipLength;
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
