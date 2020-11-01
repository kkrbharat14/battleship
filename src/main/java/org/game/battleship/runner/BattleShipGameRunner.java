package org.game.battleship.runner;

import java.util.logging.Logger;

import org.game.battleship.domain.BattleShipGame;
import org.game.battleship.domain.Player;
import org.game.battleship.domain.Result;
import org.game.battleship.setup.GameSetup;
import org.game.battleship.validators.GameSetupValidator;

public class BattleShipGameRunner {

	private static final Logger LOGGER = Logger.getLogger(BattleShipGameRunner.class.getName());

	public static void main(String[] args) {
		String inputFilePath = args[0];

		BattleShipGame battleShipGame = new BattleShipGame();
		battleShipGame.setPlayerOne(new Player("playerOne"));
		battleShipGame.setPlayerTwo(new Player("playerTwo"));

		GameSetup setup = new GameSetup(inputFilePath);
		GameSetupValidator.validate(setup);
		Result result = battleShipGame.startPlay(setup);

		if (result.getWinner() != null) {
			LOGGER.info(result.getWinner().getName() + " won the game");
		} else {
			LOGGER.info("Game ended in Draw");
		}

	}
}
