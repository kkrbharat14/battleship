package org.game.battleship.parser;

import java.awt.Point;
import java.util.regex.Pattern;

import org.game.battleship.common.ErrorConstants;

public class LocationParser {
	private LocationParser() {
	}

	public static Point parseLocation(String heightByWidth) {
		boolean isHeightByWidthPattern = Pattern.matches("^[A-Z]{1}[1-9]{1}$", heightByWidth);

		if (!isHeightByWidthPattern) {
			throw new IllegalArgumentException(ErrorConstants.ERROR_INVALID_SHIP_OR_MISSILE_LOCATION);
		}

		int x = Character.getNumericValue(heightByWidth.charAt(1));
		int y = Character.valueOf(heightByWidth.charAt(0)).hashCode() - 64;

		return new Point(x, y);
	}
}
