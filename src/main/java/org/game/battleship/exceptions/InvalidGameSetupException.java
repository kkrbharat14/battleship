package org.game.battleship.exceptions;

public class InvalidGameSetupException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidGameSetupException(String message) {
		super(message);
	}
}
