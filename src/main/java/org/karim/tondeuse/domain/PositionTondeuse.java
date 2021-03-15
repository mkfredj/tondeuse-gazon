package org.karim.tondeuse.domain;

import org.karim.tondeuse.constants.Orientation;

public class PositionTondeuse {

	private Coordonnees coordonnee;
	private Orientation orientation;

	public PositionTondeuse(Orientation orientation, Coordonnees coordonnee) {
		this.orientation = orientation;
		this.coordonnee = coordonnee;
	}

	public PositionTondeuse() {
	}

	@Override
	public PositionTondeuse clone() {
		return new PositionTondeuse(this.orientation, Coordonnees.clone(coordonnee));
	}

	public void turnLeft() {
		orientation = getOrientation().turnLeft();
	}

	public void turnRight() {
		orientation = getOrientation().turnRight();
	}

	public void forward() {
		coordonnee = calculateNextCoordonnees();
	}

	public Coordonnees calculateNextCoordonnees() {
		Coordonnees newCoordonnee = Coordonnees.clone(coordonnee);
		if (Orientation.E.equals(orientation)) {
			newCoordonnee.forwardX();
		} else if (Orientation.N.equals(orientation)) {
			newCoordonnee.forwardY();
		} else if (Orientation.W.equals(orientation)) {
			newCoordonnee.stepBackX();
		} else if (Orientation.S.equals(orientation)) {
			newCoordonnee.stepBackY();
		}
		return newCoordonnee;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	public Coordonnees getCoordonnee() {
		return coordonnee;
	}

	public void setCoordonnee(Coordonnees coordonnee) {
		this.coordonnee = coordonnee;
	}

	@Override
	public String toString() {
		return coordonnee + " " + orientation;
	}

}
