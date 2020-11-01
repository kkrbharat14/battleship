package org.game.battleship.validators;

import org.game.battleship.common.ErrorConstants;
import org.game.battleship.exceptions.InvalidGameSetupException;
import org.game.battleship.setup.GameSetup;

public class GameSetupValidator {
	private GameSetupValidator() {

	}

	public static void validate(GameSetup gameSetup) {
		if (gameSetup.getPlayerOneBattleShips() == null || gameSetup.getPlayerOneBattleShips().isEmpty()) {
			throw new InvalidGameSetupException(ErrorConstants.ERROR_PLAYER_ONE_BATTLESHIPS_NULL_OR_EMPTY);
		} else if (gameSetup.getPlayerTwoBattleShips() == null || gameSetup.getPlayerTwoBattleShips().isEmpty()) {
			throw new InvalidGameSetupException(ErrorConstants.ERROR_PLAYER_TWO_BATTLESHIPS_NULL_OR_EMPTY);
		} else if (gameSetup.getPlayerOneMissiles() == null || gameSetup.getPlayerOneMissiles().length == 0) {
			throw new InvalidGameSetupException(ErrorConstants.ERROR_PLAYER_ONE_MISILLES_NULL_OR_EMPTY);
		} else if (gameSetup.getPlayerTwoMissiles() == null || gameSetup.getPlayerTwoMissiles().length == 0) {
			throw new InvalidGameSetupException(ErrorConstants.ERROR_PLAYER_TWO_MISILLES_NULL_OR_EMPTY);
		}
	}
}
