package org.game.battleship.exceptions;

public class AreaAlreadyOccupiedException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public AreaAlreadyOccupiedException(String message) {
		super(message);
	}

}
