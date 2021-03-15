package org.karim.tondeuse.constants;

public enum Orientation {
	N(0), W(90), S(180), E(270);

	private int degre;

	Orientation(int degre) {
		this.degre = degre;
	}

	public int getDegre() {
		return degre;
	}

	public Orientation turnRight() {
		Orientation result = null;
		switch (degre) {
		case 0:
			result = Orientation.E;
			break;
		case 90:
			result = Orientation.N;
			break;
		case 180:
			result = Orientation.W;
			break;
		case 270:
			result = Orientation.S;
			break;
		}
		return result;
	}

	public Orientation turnLeft() {
		Orientation result = null;
		switch (degre) {
		case 0:
			result = Orientation.W;
			break;
		case 90:
			result = Orientation.S;
			break;
		case 180:
			result = Orientation.E;
			break;
		case 270:
			result = Orientation.N;
			break;
		}
		return result;
	}
}
