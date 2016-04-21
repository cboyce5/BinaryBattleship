package BattleshipGame;

public class GameCell {
	private int row, column;
	private CellState cellState;
	private boolean containsShip;
	public GameCell(int row, int column, boolean containsShip) {
		super();
		this.row = row;
		this.column = column;
		this.cellState = CellState.NONE;
		this.containsShip = containsShip;
	}
	
}
