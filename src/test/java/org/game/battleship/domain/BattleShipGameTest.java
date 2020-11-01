package org.game.battleship.domain;

import static org.junit.Assert.assertEquals;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import org.game.battleship.setup.GameSetup;
import org.junit.Before;
import org.junit.Test;

public class BattleShipGameTest {

	private GameSetup gameSetup;

	@Before
	public void init() {
		List<BattleShip> playerOneBattleShips = new ArrayList<>();
		playerOneBattleShips.add(new BattleShip(ShipType.SUBMARINE, new Dimension(2, 2), "A1"));
		List<BattleShip> playerTwoBattleShips = new ArrayList<>();
		playerTwoBattleShips.add(new BattleShip(ShipType.SUBMARINE, new Dimension(2, 2), "B2"));
		String[] playerOneMissiles = new String[] { "A1", "C2" };
		String[] playerTwoMissiles = new String[] { "A1", "C1", "A2", "B1", "B2" };

		gameSetup = new GameSetup();
		gameSetup.setBattleAreaDimension(new Dimension(3, 3));
		gameSetup.setNoOfShips(1);
		gameSetup.setPlayerOneBattleShips(playerOneBattleShips);
		gameSetup.setPlayerTwoBattleShips(playerTwoBattleShips);
		gameSetup.setPlayerOneMissiles(playerOneMissiles);
		gameSetup.setPlayerTwoMissiles(playerTwoMissiles);
	}

	@Test
	public void shouldStartGameAndSetWinner() {
		Player playerOne = new Player("P1");
		Player playerTwo = new Player("P2");
		BattleShipGame battleShipGame = new BattleShipGame();
		battleShipGame.setPlayerOne(playerOne);
		battleShipGame.setPlayerTwo(playerTwo);

		Result result = battleShipGame.startPlay(gameSetup);
		assertEquals(result.getWinner(), playerTwo);

	}
}
