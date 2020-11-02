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
		playerTwoBattleArea.placeShips(setup.getPlayerTwoBattleShips());

		playerOne.setBattleArea(playerOneBattleArea);
		playerTwo.setBattleArea(playerTwoBattleArea);

		playerOne.setMissileCoordinatess(setup.getPlayerOneMissiles());
		playerTwo.setMissileCoordinatess(setup.getPlayerTwoMissiles());

		boolean gameEnded = false;
		int playerOneMissileIndex = 0;
		int playerTwoMissileIndex = 0;
		boolean playerOneActive = true;

		while (!gameEnded) {
			if (playerOneActive && playerOneMissileIndex < playerOne.getMissileCoordinatess().length) {
				String targetLocation = playerOne.getMissileCoordinatess()[playerOneMissileIndex];
				boolean hitStatus = playerTwoBattleArea.handleAttack(playerOne.getName(), targetLocation);
				playerOneMissileIndex++;
				gameEnded = playerTwoBattleArea.getBattleAreahealth() == 0;
				playerOneActive = !hitStatus;
			} else if (playerTwoMissileIndex < playerTwo.getMissileCoordinatess().length) {
				String targetLocation = playerTwo.getMissileCoordinatess()[playerTwoMissileIndex];
				boolean hitStatus = playerOneBattleArea.handleAttack(playerTwo.getName(), targetLocation);
				playerTwoMissileIndex++;
				gameEnded = playerOneBattleArea.getBattleAreahealth() == 0;
				playerOneActive = !hitStatus;
			} else {
				gameEnded = true;
			}
		}

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
