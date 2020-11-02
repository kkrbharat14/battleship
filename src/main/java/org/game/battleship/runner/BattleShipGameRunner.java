package org.game.battleship.runner;

import org.game.battleship.domain.BattleShipGame;
import org.game.battleship.domain.Player;
import org.game.battleship.domain.Result;
import org.game.battleship.setup.GameSetup;
import org.game.battleship.validators.GameSetupValidator;

public class BattleShipGameRunner {


	public static void main(String[] args) {
		String inputFilePath = args[0];

		BattleShipGame battleShipGame = new BattleShipGame();
		battleShipGame.setPlayerOne(new Player("Player-1"));
		battleShipGame.setPlayerTwo(new Player("Player-2"));

		GameSetup setup = new GameSetup(inputFilePath);
		GameSetupValidator.validate(setup);
		Result result = battleShipGame.startPlay(setup);

		if (result.getWinner() != null) {
			System.out.println(result.getWinner().getName() + " won the battle");
		} else {
			System.out.println("Game ended in Draw");
		}

	}
}
