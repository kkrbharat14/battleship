package org.game.battleship.common;

public class ErrorConstants {
	private ErrorConstants() {
	}

	public static final String ERROR_PLAYER_ONE_BATTLESHIPS_NULL_OR_EMPTY = "Player One BattleShips cannot be null or empty";
	public static final String ERROR_PLAYER_TWO_BATTLESHIPS_NULL_OR_EMPTY = "Player Two BattleShips cannot be null or empty";
	public static final String ERROR_PLAYER_ONE_MISILLES_NULL_OR_EMPTY = "Player One Missiles Cannot be null or empty";
	public static final String ERROR_PLAYER_TWO_MISILLES_NULL_OR_EMPTY = "Player Two Missiles Cannot be null or empty";
	public static final String ERROR_INVALID_SHIP_OR_MISSILE_LOCATION = "Ship Location/ Missile Target Location is Invalid, It should contain height[A-Z]and width[1-9] without spaces";
	public static final String ERROR_SHIP_OUTSIDE_BATTLE_AREA = "Ship Cannot be Placed Outside Battle Area";
	public static final String ERROR_AREA_ALREADY_OCCUPIED = "Cannot place ship, area is already occupied";
}
