package org.game.battleship.domain;

public class Player {

	private String name;
	private BattleArea battleArea;
	private String[] missileCoordinatess;

	public Player(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BattleArea getBattleArea() {
		return battleArea;
	}

	public void setBattleArea(BattleArea battleArea) {
		this.battleArea = battleArea;
	}

	public String[] getMissileCoordinatess() {
		return missileCoordinatess;
	}

	public void setMissileCoordinatess(String[] missileCoordinatess) {
		this.missileCoordinatess = missileCoordinatess;
	}

}
