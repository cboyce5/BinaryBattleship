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
	
}
