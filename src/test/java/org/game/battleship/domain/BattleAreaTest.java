package org.game.battleship.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class BattleAreaTest {

	@Test
	public void shouldCreateBattleAreaAndInitializeCells() {
		BattleArea battleArea = new BattleArea(new Dimension(5, 5));

		assertNotNull(battleArea.getAllCells());
		assertEquals(25, battleArea.getAllCells().size());
		assertEquals(0, battleArea.getBattleAreahealth());
	}

	@Test
	public void shouldPlaceShipsAndMarkCellOccupied() {
		BattleArea battleArea = new BattleArea(new Dimension(5, 5));
		BattleShip battleShip = new BattleShip(ShipType.FRIGATE, new Dimension(1, 1), "A1");
		List<BattleShip> battleShips = new ArrayList<>();
		battleShips.add(battleShip);

		battleArea.placeShips(battleShips);

		Cell cell = battleArea.getAllCells().stream().filter((c) -> c.equals(new Cell(new Point(1, 1)))).findFirst()
				.orElse(null);

		assertNotNull(cell);
		assertEquals(true, cell.isOccupied());
		assertEquals(0, cell.getMissilesHit());
		assertEquals(2, cell.getMissilesHitThreshold());
		assertEquals(2, battleArea.getBattleAreahealth());
	}
	
	@Test
	public void shouldNotAffectBattleAreaHealth() {
		BattleArea battleArea = new BattleArea(new Dimension(5, 5));
		BattleShip battleShip = new BattleShip(ShipType.FRIGATE, new Dimension(1, 1), "A1");
		List<BattleShip> battleShips = new ArrayList<>();
		battleShips.add(battleShip);

		battleArea.placeShips(battleShips);
		battleArea.handleAttack("player","A2");
		battleArea.handleAttack("player","B3");
		battleArea.handleAttack("player","C3");
		
		assertEquals(2, battleArea.getBattleAreahealth());
	}
	
	@Test
	public void shouldAffectBattleAreaHealth() {
		BattleArea battleArea = new BattleArea(new Dimension(5, 5));
		BattleShip battleShip = new BattleShip(ShipType.FRIGATE, new Dimension(1, 1), "A1");
		List<BattleShip> battleShips = new ArrayList<>();
		battleShips.add(battleShip);

		battleArea.placeShips(battleShips);
		battleArea.handleAttack("player","A2");
		battleArea.handleAttack("player","A1");
		battleArea.handleAttack("player","C3");
		battleArea.handleAttack("player","A5");
		battleArea.handleAttack("player","A2");
		battleArea.handleAttack("player","A1");
		
		assertEquals(0, battleArea.getBattleAreahealth());
	}
	
	
	
}
