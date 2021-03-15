package org.karim.tondeuse.domain;

public class Coordonnees {

	private Integer x;
	private Integer y;

	public void forwardX() {
		x = x + 1;
	}

	public void forwardY() {
		y = y + 1;
	}

	public void stepBackX() {
		x = x - 1;
	}

	public void stepBackY() {
		y = y - 1;
	}

	public Coordonnees(Integer x, Integer y) {
		this.x = x;
		this.y = y;
	}

	public static Coordonnees clone(Coordonnees coordonnee) {
		return new Coordonnees(coordonnee.getX(), coordonnee.getY());
	}

	public Integer getX() {
		return x;
	}

	public Integer getY() {
		return y;
	}

	@Override
	public String toString() {
		return x + " " + y;
	}

}
