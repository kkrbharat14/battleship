package org.game.battleship.domain;

import org.game.battleship.setup.GameSetup;

public class BattleShipGame {
	private Player playerOne;
	private Player playerTwo;
	private Result result;

	public Result startPlay(GameSetup setup) {
		BattleArea playerOneBattleArea = new BattleArea(setup.getBattleAreaDimension());
		BattleArea playerTwoBattleArea = new BattleArea(setup.getBattleAreaDimension());

		playerOneBattleArea.placeShips(setup.getPlayerOneBattleShips());
		playerTwoBattleArea.placeShips(setup.getPlayerOneBattleShips());

		playerOne.setBattleArea(playerOneBattleArea);
		playerTwo.setBattleArea(playerTwoBattleArea);

		playerOneBattleArea.handleAttacks(setup.getPlayerTwoMissiles());
		playerTwoBattleArea.handleAttacks(setup.getPlayerOneMissiles());

		result = new Result();

		if (playerOneBattleArea.getBattleAreahealth() == 0) {
			result.setWinner(playerTwo);
		} else if (playerTwoBattleArea.getBattleAreahealth() == 0) {
			result.setWinner(playerOne);
		}

		return result;

	}

	public Player getPlayerOne() {
		return playerOne;
	}

	public void setPlayerOne(Player playerOne) {
		this.playerOne = playerOne;
	}

	public Player getPlayerTwo() {
		return playerTwo;
	}

	public void setPlayerTwo(Player playerTwo) {
		this.playerTwo = playerTwo;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

}
