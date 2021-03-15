package org.karim.tondeuse.domain;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PelouseTest {

	@Test
	public void Should_Return_True_When_Run_isCoordonneesOutSide() {
		Coordonnees maxCoordonnee = new Coordonnees(5, 5);
		Coordonnees c2 = new Coordonnees(6, 6);
		Pelouse p = new Pelouse(maxCoordonnee);
		assertTrue("Coordonne is outside", p.isCoordonneesOutSide(c2));

	}

}
