package org.game.battleship.domain;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Stream;

import org.game.battleship.common.ErrorConstants;
import org.game.battleship.exceptions.AreaAlreadyOccupiedException;
import org.game.battleship.parser.LocationParser;

public class BattleArea {
	private Dimension dimension;
	private List<Cell> allCells;
	private int battleAreahealth;

	private static final Logger LOGGER = Logger.getLogger(BattleArea.class.getName());

	/**
	 * @param Dimension Creates Battle area with specified Dimension Initializes
	 *                  cells with points
	 */
	public BattleArea(Dimension dimension) {
		this.dimension = dimension;
		intializeCells();
	}

	/**
	 * @param battleShips These are ships to be placed in battle area.
	 * @throws IllegalArgumentException     If Battleship position is outside battle
	 *                                      area.
	 * @throws AreaAlreadyOccupiedException If cell is already occupied
	 */
	public void placeShips(List<BattleShip> battleShips) {
		battleShips.forEach(bs -> {
			placeShip(bs);
			battleAreahealth = bs.getShipHealth() + battleAreahealth;
		});
	}

	/**
	 * @param targetLocations These are targets to attack,reduces battle area health
	 *                        if hit is successful.
	 */
	public void handleAttacks(String[] targetLocations) {
		Stream.of(targetLocations).forEach(this::handleAttack);
	}

	public int getBattleAreahealth() {
		return battleAreahealth;
	}

	public void setBattleAreahealth(int battleAreahealth) {
		this.battleAreahealth = battleAreahealth;
	}

	public List<Cell> getAllCells() {
		return allCells;
	}

	public void setAllCells(List<Cell> allCells) {
		this.allCells = allCells;
	}

	private void handleAttack(String targetLocation) {
		Point targetPoint = LocationParser.parseLocation(targetLocation);
		Cell targetCell = allCells.stream().filter(c -> new Cell(targetPoint).equals(c) && c.isOccupied()).findFirst()
				.orElse(null);

		if (targetCell == null) {
			LOGGER.info("Missed: No Damage caused");
		} else if (targetCell.getMissilesHit() < targetCell.getMissilesHitThreshold()) {
			targetCell.setMissilesHit(targetCell.getMissilesHit() + 1);
			battleAreahealth = battleAreahealth - 1;
			LOGGER.info("Successful Hit: BattleArea Health Reduced");
		} else {
			LOGGER.info("Target location Already Destroyed");
		}

	}

	private List<Cell> intializeCells() {
		allCells = new ArrayList<>();
		for (int xOffset = 1; xOffset <= dimension.width; xOffset++) {
			for (int yOffset = 1; yOffset <= dimension.height; yOffset++) {
				allCells.add(new Cell(new Point(xOffset, yOffset)));
			}
		}
		return allCells;
	}

	private void placeShip(BattleShip battleShip) {
		for (Cell shipcell : battleShip.getShipCells()) {
			int index = allCells.indexOf(shipcell);

			if (index == -1) {
				throw new IllegalArgumentException(ErrorConstants.ERROR_SHIP_OUTSIDE_BATTLE_AREA);
			}

			boolean occupied = allCells.get(index).isOccupied();

			if (occupied) {
				throw new AreaAlreadyOccupiedException(ErrorConstants.ERROR_AREA_ALREADY_OCCUPIED);
			}

			allCells.get(index).setOccupied(true);
			allCells.get(index).setMissilesHitThreshold(battleShip.getShipType().getCellHitThreshold());
		}
	}

}
