package org.game.battleship.domain;

import java.awt.Point;

public class Cell {
	private Point point;
	private boolean occupied;
	private int missilesHit;
	private int missilesHitThreshold;

	public Cell(Point point) {
		super();
		this.point = point;
	}

	public Cell(Point point, boolean occupied) {
		super();
		this.point = point;
		this.occupied = occupied;
	}

	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	public int getMissilesHit() {
		return missilesHit;
	}

	public void setMissilesHit(int missilesHit) {
		this.missilesHit = missilesHit;
	}

	public int getMissilesHitThreshold() {
		return missilesHitThreshold;
	}

	public void setMissilesHitThreshold(int missilesHitThreshold) {
		this.missilesHitThreshold = missilesHitThreshold;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((point == null) ? 0 : point.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cell other = (Cell) obj;
		if (point == null) {
			if (other.point != null)
				return false;
		} else if (!point.equals(other.point))
			return false;
		return true;
	}

}
