package org.game.battleship.domain;

public enum ShipType {
	SUBMARINE(1), FRIGATE(2);

	private int cellHitThreshold;

	ShipType(int cellHitThreshold) {
		this.cellHitThreshold = cellHitThreshold;
	}

	public int getCellHitThreshold() {
		return cellHitThreshold;
	}
}
