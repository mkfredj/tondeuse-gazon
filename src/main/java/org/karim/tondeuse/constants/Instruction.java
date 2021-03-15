package org.karim.tondeuse.constants;

import java.util.Arrays;
import java.util.Optional;

public enum Instruction {
	AVANT("A"), DROITE("D"), GAUCHE("G");

	private String instructionLettre;

	Instruction(String instructionLettre) {
		this.instructionLettre = instructionLettre;
	}

	public String getInstructionLettre() {
		return instructionLettre;
	}

	public static Optional<Instruction> getInstructionFromLettre(final String letter) {
		return Arrays.stream(values()).filter(instruction -> instruction.getInstructionLettre().equals(letter))
				.findFirst();
	}

}
