package org.karim.tondeuse.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.karim.tondeuse.constants.Instruction;
import org.karim.tondeuse.domain.Coordonnees;
import org.karim.tondeuse.domain.Pelouse;
import org.karim.tondeuse.exception.ExceptionTondeuse;

public class ParserTest {
	String coinSuperieureDroit = "5 5";
	String positionInitial = "1 2 N";
	Coordonnees coordonneesMax = new Coordonnees(5, 5);
	Pelouse pelouse = new Pelouse(coordonneesMax);

	@Test
	public void Should_Return_5_5_When_Run_LoadPelouse() throws ExceptionTondeuse {
		assertEquals(coinSuperieureDroit, Parser.extractCoinSuperieurDroit(coinSuperieureDroit).toString());

	}

	@Test
	public void Should_Return_True_When_Run_LoadPositions() throws ExceptionTondeuse {
		assertEquals(positionInitial, Parser.extractPosition(positionInitial, pelouse).toString());

	}

	@Test
	public void Should_Return_True_When_Run_ListInstructions() {

		List<Instruction> tondeuseInstructionList = new ArrayList<Instruction>();

		String instructionsStr = "GAGAGAGAA";

		Arrays.stream(instructionsStr.trim().split(""))
				.forEach(a -> tondeuseInstructionList.add(Instruction.getInstructionFromLettre(a).get()));

		assertTrue(Parser.extractInstructions(instructionsStr).toString().equals(tondeuseInstructionList.toString()));
	}

}
