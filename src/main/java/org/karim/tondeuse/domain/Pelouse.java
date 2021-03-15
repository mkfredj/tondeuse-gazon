package org.karim.tondeuse.domain;

public class Pelouse {

	private Coordonnees maxCoordonnees;

	public boolean isCoordonneesOutSide(Coordonnees nextCoordonnees) {
		return nextCoordonnees.getX() < 0 || nextCoordonnees.getY() < 0
				|| nextCoordonnees.getX() > maxCoordonnees.getX() || nextCoordonnees.getY() > maxCoordonnees.getY();
	}

	public void setMaxCoordonnees(Coordonnees maxCoordonnees) {
		this.maxCoordonnees = maxCoordonnees;
	}

	public Coordonnees getMaxCoordonnees() {
		return maxCoordonnees;
	}

	public Pelouse() {
		super();
	}

	public Pelouse(Coordonnees maxCoordonnees) {
		super();
		this.maxCoordonnees = maxCoordonnees;
	}

	@Override
	public String toString() {
		return maxCoordonnees.toString();
	}

}
