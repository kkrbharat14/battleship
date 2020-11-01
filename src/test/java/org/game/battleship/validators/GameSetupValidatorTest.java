package org.game.battleship.validators;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import org.game.battleship.common.ErrorConstants;
import org.game.battleship.domain.BattleShip;
import org.game.battleship.domain.ShipType;
import org.game.battleship.exceptions.InvalidGameSetupException;
import org.game.battleship.setup.GameSetup;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class GameSetupValidatorTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void testInvalidGameSetupExceptionIfPlayerOneBattleShipIsNull() {
		exception.expect(InvalidGameSetupException.class);
		exception.expectMessage(ErrorConstants.ERROR_PLAYER_ONE_BATTLESHIPS_NULL_OR_EMPTY);
		GameSetup gameSetup = new GameSetup();
		gameSetup.setPlayerOneBattleShips(null);

		GameSetupValidator.validate(gameSetup);
	}
	
	@Test
	public void testInvalidGameSetupExceptionIfPlayerTwoBattleShipsAreEmpty() {
		exception.expect(InvalidGameSetupException.class);
		exception.expectMessage(ErrorConstants.ERROR_PLAYER_TWO_BATTLESHIPS_NULL_OR_EMPTY);
		BattleShip battleShip = new BattleShip(ShipType.FRIGATE, new Dimension(2,2), "A1");
		List<BattleShip> battleShips = new ArrayList<>();
		battleShips.add(battleShip);
		GameSetup gameSetup = new GameSetup();
		gameSetup.setPlayerOneBattleShips(battleShips);
		gameSetup.setPlayerTwoBattleShips(null);

		GameSetupValidator.validate(gameSetup);
	}
	
	@Test
	public void testInvalidGameSetupExceptionIfPlayerOneMissilesAreEmpty() {
		exception.expect(InvalidGameSetupException.class);
		exception.expectMessage(ErrorConstants.ERROR_PLAYER_ONE_MISILLES_NULL_OR_EMPTY);
		BattleShip battleShip = new BattleShip(ShipType.FRIGATE, new Dimension(2,2), "A1");
		List<BattleShip> battleShips = new ArrayList<>();
		battleShips.add(battleShip);
		GameSetup gameSetup = new GameSetup();
		gameSetup.setPlayerOneBattleShips(battleShips);
		gameSetup.setPlayerTwoBattleShips(battleShips);
		gameSetup.setPlayerOneMissiles(null);

		GameSetupValidator.validate(gameSetup);
	}
	
	@Test
	public void testInvalidGameSetupExceptionIfPlayerTwoMissilesAreEmpty() {
		exception.expect(InvalidGameSetupException.class);
		exception.expectMessage(ErrorConstants.ERROR_PLAYER_TWO_MISILLES_NULL_OR_EMPTY);
		BattleShip battleShip = new BattleShip(ShipType.FRIGATE, new Dimension(2,2), "A1");
		List<BattleShip> battleShips = new ArrayList<>();
		battleShips.add(battleShip);
		GameSetup gameSetup = new GameSetup();
		gameSetup.setPlayerOneBattleShips(battleShips);
		gameSetup.setPlayerTwoBattleShips(battleShips);
		gameSetup.setPlayerOneMissiles(new String[] {"A1","A2"});

		GameSetupValidator.validate(gameSetup);
	}
	
}
