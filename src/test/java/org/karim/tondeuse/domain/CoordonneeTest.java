package org.karim.tondeuse.domain;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CoordonneeTest {

	@Test
	public void Sould_Return_X_equal_2_When_Run_ForwardX() {

		Coordonnees c1 = new Coordonnees(1, 2);
		c1.forwardX();
		assertTrue((c1.getX() == 2));
	}

	@Test
	public void Sould_Return_Y_equal_3_When_Run_ForwardY() {
		Coordonnees c1 = new Coordonnees(1, 2);
		c1.forwardY();
		assertTrue((c1.getY() == 3));
	}

	@Test
	public void Sould_Return_X_equal_0_When_Run_StepBackX() {
		Coordonnees c1 = new Coordonnees(1, 2);
		c1.stepBackX();
		assertTrue((c1.getX() == 0));
	}

	@Test
	public void Sould_Return_Y_equal_1_When_Run_StepBackY() {
		Coordonnees c1 = new Coordonnees(1, 2);
		c1.stepBackY();
		assertTrue((c1.getY() == 1));
	}

}
