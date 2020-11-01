package org.game.battleship.domain;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.hasItems;
import java.awt.Dimension;
import java.awt.Point;

import org.junit.Test;

public class BattleShipTest {
	@Test
	public void shouldInitializeSubMarineBattleShipCellsAndSetBattleShipHealth() {
		BattleShip battleShip = new BattleShip(ShipType.SUBMARINE, new Dimension(2, 3), "B2");

		assertThat(battleShip.getShipCells(),
				hasItems(new Cell(new Point(2, 2)), new Cell(new Point(3, 2)), new Cell(new Point(2, 3)),
						new Cell(new Point(3, 3)), new Cell(new Point(2, 4)), new Cell(new Point(3, 4))));
		assertEquals(6, battleShip.getShipHealth());
	}

	@Test
	public void shouldInitializeFrigateBattleShipCellsAndSetBattleShipHealth() {
		BattleShip battleShip = new BattleShip(ShipType.FRIGATE, new Dimension(2, 1), "B2");

		assertThat(battleShip.getShipCells(), hasItems(new Cell(new Point(2, 2)), new Cell(new Point(3, 2))));
		assertEquals(4, battleShip.getShipHealth());
	}
}
