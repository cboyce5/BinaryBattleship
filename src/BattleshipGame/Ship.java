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
	
}
