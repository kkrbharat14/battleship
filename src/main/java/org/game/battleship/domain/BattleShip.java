package org.game.battleship.domain;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.game.battleship.parser.LocationParser;

public class BattleShip {
	private ShipType shipType;
	private String location;
	private Dimension dimension;
	private List<Cell> shipCells;
	private int shipHealth;

	public BattleShip(ShipType shipType, Dimension dimension, String location) {
		this.shipType = shipType;
		this.dimension = dimension;
		this.location = location;
		initializeShipCells();
		shipHealth = this.shipCells.size() * this.shipType.getCellHitThreshold();
	}

	public ShipType getShipType() {
		return shipType;
	}

	public void setShipType(ShipType shipType) {
		this.shipType = shipType;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Dimension getDimension() {
		return dimension;
	}

	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}

	public int getShipHealth() {
		return shipHealth;
	}

	public void setShipHealth(int shipHealth) {
		this.shipHealth = shipHealth;
	}

	public List<Cell> getShipCells() {
		return shipCells;
	}

	public void setShipCells(List<Cell> shipCells) {
		this.shipCells = shipCells;
	}

	private void initializeShipCells() {
		shipCells = new ArrayList<>();
		Point startPoint = null;
		if (this.location != null) {
			startPoint = LocationParser.parseLocation(this.location);
		}

		if (null != startPoint && null != dimension) {
			int width = (int) dimension.getWidth();
			int height = (int) dimension.getHeight();

			for (int xOffset = 0; xOffset < width; xOffset++) {
				for (int yOffset = 0; yOffset < height; yOffset++) {
					int startPointX = (int) startPoint.getX();
					int startPointY = (int) startPoint.getY();

					shipCells.add(new Cell(new Point(startPointX + xOffset, startPointY + yOffset), true));
				}
			}
		}
	}

}
