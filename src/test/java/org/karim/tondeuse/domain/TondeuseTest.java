package org.karim.tondeuse.domain;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.karim.tondeuse.constants.Instruction;
import org.karim.tondeuse.constants.Orientation;

public class TondeuseTest {

	@Test
	public void Should_Return_5_1_E_When_Run_start() {
		Coordonnees coordonneeMax = new Coordonnees(5, 5);

		Coordonnees coordonnee = new Coordonnees(3, 3);

		Pelouse pelouse = new Pelouse(coordonneeMax);

		PositionTondeuse position = new PositionTondeuse(Orientation.E, coordonnee);
		
		

		String resulString = "5 1 E";

		List<Instruction> instructions = new ArrayList<Instruction>();

		instructions.add(Instruction.AVANT);
		instructions.add(Instruction.AVANT);
		instructions.add(Instruction.DROITE);
		instructions.add(Instruction.AVANT);
		instructions.add(Instruction.AVANT);
		instructions.add(Instruction.DROITE);
		instructions.add(Instruction.AVANT);
		instructions.add(Instruction.DROITE);
		instructions.add(Instruction.DROITE);
		instructions.add(Instruction.AVANT);

		ConfigurationTondeuse configurationTondeuse = new ConfigurationTondeuse(position, instructions);
		Tondeuse tondeuse = new Tondeuse(configurationTondeuse);
		tondeuse.start(pelouse);
		assertEquals(tondeuse.getPositionCourante().toString(), resulString);

	}
}
