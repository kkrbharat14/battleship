package org.game.battleship.exceptions;

public class InputFileNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InputFileNotFoundException(String message) {
		super(message);
	}
}
