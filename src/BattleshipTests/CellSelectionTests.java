package BattleshipTests;

import static org.junit.Assert.*;

import org.junit.Test;

import BattleshipGame.BattleshipGame;
import BattleshipGame.CellState;
import BattleshipGame.GameCell;

public class CellSelectionTests {

	@Test
	public void test() {
		BattleshipGame bg = new BattleshipGame();
		GameCell gc = new GameCell(0, 0);
		//The handle move method in the battleship Game will return a boolean depending on whether or not the move was successful.
		//In this test, the game cell should return false. 
		assertTrue(bg.handleMove(gc));
		
		//In this case, the cell has already been guessed so the handle move should return false, because the user cannot select the cell.
		gc.setContainsShip(true);
		gc.setCellState(CellState.HIT);
		assertFalse(bg.handleMove(gc));
		
		//In this case, the cell has already been guessed so the handle move should return false, because the user cannot select the cell.
		gc.setContainsShip(false);
		gc.setCellState(CellState.MISS);
		assertFalse(bg.handleMove(gc));
	}

}
