package org.game.battleship.setup;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.awt.Dimension;

import org.junit.Test;

public class GameSetupTest {

	@Test
	public void shouldInitializeGame() {
		GameSetup gameSetup = new GameSetup("src/test/resources/sample-input.txt");

		assertEquals(new Dimension(5, 5), gameSetup.getBattleAreaDimension());
		assertEquals(2, gameSetup.getNoOfShips());
		assertEquals(2, gameSetup.getPlayerOneBattleShips().size());
		assertEquals(2, gameSetup.getPlayerTwoBattleShips().size());
		assertNotNull(gameSetup.getPlayerOneMissiles());
		assertNotNull(gameSetup.getPlayerTwoMissiles());
	}
}
