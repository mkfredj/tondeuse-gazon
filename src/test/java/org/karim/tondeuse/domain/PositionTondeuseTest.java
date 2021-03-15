package org.karim.tondeuse.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.karim.tondeuse.constants.Orientation;

public class PositionTondeuseTest {

	@Test
	public void Should_Return_2_1_When_Run_calculateNextCoordonnees() {
		Coordonnees coordonnee = new Coordonnees(1, 1);
		PositionTondeuse position = new PositionTondeuse(Orientation.E, coordonnee);
		String resulString = "2 1";

		Coordonnees nextCoordonnees = position.calculateNextCoordonnees();
		assertEquals(nextCoordonnees.toString(), resulString);

	}

}
