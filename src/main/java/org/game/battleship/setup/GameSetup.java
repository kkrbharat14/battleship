package org.game.battleship.setup;

import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.game.battleship.domain.BattleShip;
import org.game.battleship.domain.ShipType;
import org.game.battleship.exceptions.InputFileNotFoundException;

public class GameSetup {
	private Dimension battleAreaDimension;
	private int noOfShips;
	private List<BattleShip> playerOneBattleShips;
	private List<BattleShip> playerTwoBattleShips;
	private String[] playerOneMissiles;
	private String[] playerTwoMissiles;

	public GameSetup() {
	}

	public GameSetup(String filePath) {
		init(filePath);
	}

	public Dimension getBattleAreaDimension() {
		return battleAreaDimension;
	}

	public void setBattleAreaDimension(Dimension battleAreaDimension) {
		this.battleAreaDimension = battleAreaDimension;
	}

	public List<BattleShip> getPlayerOneBattleShips() {
		return playerOneBattleShips;
	}

	public void setPlayerOneBattleShips(List<BattleShip> playerOneBattleShips) {
		this.playerOneBattleShips = playerOneBattleShips;
	}

	public List<BattleShip> getPlayerTwoBattleShips() {
		return playerTwoBattleShips;
	}

	public void setPlayerTwoBattleShips(List<BattleShip> playerTwoBattleShips) {
		this.playerTwoBattleShips = playerTwoBattleShips;
	}

	public String[] getPlayerOneMissiles() {
		return playerOneMissiles;
	}

	public void setPlayerOneMissiles(String[] playerOneMissiles) {
		this.playerOneMissiles = playerOneMissiles;
	}

	public String[] getPlayerTwoMissiles() {
		return playerTwoMissiles;
	}

	public void setPlayerTwoMissiles(String[] playerTwoMissiles) {
		this.playerTwoMissiles = playerTwoMissiles;
	}

	public int getNoOfShips() {
		return noOfShips;
	}

	public void setNoOfShips(int noOfShips) {
		this.noOfShips = noOfShips;
	}

	private void init(String filePath) {
		File file = new File(filePath);
		try (Scanner reader = new Scanner(file)) {
			int lineNumber = 0;

			while (reader.hasNextLine()) {
				String data = reader.nextLine();
				lineNumber++;
				if (lineNumber == 1) {
					setBattleAreaDimension(data);
				} else if (lineNumber == 2) {
					setNumberOfShips(data);
				} else if (lineNumber <= noOfShips + 2) {
					setBattleShips(data);
				} else if (lineNumber == noOfShips + 3) {
					setPlayerOneMissiles(data);
				} else if (lineNumber == noOfShips + 4) {
					setPlayerTwoMissiles(data);
				}
			}

		} catch (FileNotFoundException e) {
			throw new InputFileNotFoundException("Input File Not Found" + e.getMessage());
		}
	}

	private void setBattleAreaDimension(String widthByHeight) {
		boolean isWidthByHeightPattern = Pattern.matches("^[1-9]{1}\\s[A-Z]{1}$", widthByHeight);
		if (!isWidthByHeightPattern) {
			throw new IllegalArgumentException("Battle Area Dimension is Invalid, "
					+ "It should contain width[1-9] and height[A-Z] separated by space");
		}
		String[] splitted = widthByHeight.split("\\s+");
		int width = Integer.parseInt(splitted[0]);
		int height = String.valueOf(splitted[1]).hashCode() - 64;

		battleAreaDimension = new Dimension(width, height);
	}

	private void setNumberOfShips(String noOfShips) {
		try {
			this.noOfShips = Integer.parseInt(noOfShips);
			if (this.noOfShips <= 0) {
				throw new IllegalArgumentException("Number of ships should be greater than zero");
			}
		} catch (NumberFormatException ex) {
			throw new IllegalArgumentException("Number of Ships is Invalid, It should be a number");
		}
	}

	private void setBattleShips(String data) {
		String[] splitted = data.split("\\s+");

		ShipType shipType = getShipType(splitted[0]);
		int width = 0;
		int height = 0;
		try {
			width = Integer.parseInt(splitted[1]);
			height = Integer.parseInt(splitted[2]);
		} catch (NumberFormatException ex) {
			throw new IllegalArgumentException("Ship width/height is Invalid");
		}
		Dimension dimension = new Dimension(width, height);
		createPlayerOneShips(shipType, dimension, splitted[3]);
		createPlayerTwoShips(shipType, dimension, splitted[4]);
	}

	private ShipType getShipType(String shipTypeData) {
		ShipType shipType;
		switch (shipTypeData) {
		case "P":
			shipType = ShipType.SUBMARINE;
			break;
		case "Q":
			shipType = ShipType.FRIGATE;
			break;
		default:
			throw new IllegalArgumentException("ShipType must be One of P or Q");
		}
		return shipType;
	}

	private void createPlayerOneShips(ShipType shipType, Dimension dimension, String location) {
		if (null == this.playerOneBattleShips) {
			playerOneBattleShips = new ArrayList<>();
		}
		playerOneBattleShips.add(new BattleShip(shipType, dimension, location));
	}

	private void createPlayerTwoShips(ShipType shipType, Dimension dimension, String location) {
		if (null == this.playerTwoBattleShips) {
			playerTwoBattleShips = new ArrayList<>();
		}
		playerTwoBattleShips.add(new BattleShip(shipType, dimension, location));
	}

	private void setPlayerOneMissiles(String data) {
		this.playerOneMissiles = data.split("\\s+");
	}

	private void setPlayerTwoMissiles(String data) {
		this.playerTwoMissiles = data.split("\\s+");
	}
}
