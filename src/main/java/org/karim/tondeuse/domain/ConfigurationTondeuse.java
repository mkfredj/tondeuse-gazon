package org.karim.tondeuse.domain;

import java.util.List;

import org.karim.tondeuse.constants.Instruction;

/**
 * Classe qui represente une tondeuse et ses instructions a executer 
 */

public class ConfigurationTondeuse {

	private PositionTondeuse positionInitiale;
	private List<Instruction> instructions;

	public ConfigurationTondeuse(PositionTondeuse positionInitiale, List<Instruction> instructions) {
		super();
		this.positionInitiale = positionInitiale;
		this.instructions = instructions;
	}

	public ConfigurationTondeuse(ConfigurationTondeuse configurationTondeuse) {
		super();
		this.positionInitiale = new PositionTondeuse(configurationTondeuse.getPositionInitiale().getOrientation(),
				configurationTondeuse.getPositionInitiale().getCoordonnee());
		this.instructions = configurationTondeuse.getInstructions();
	}

	public PositionTondeuse getPositionInitiale() {
		return positionInitiale;
	}

	public void setPositionInitiale(PositionTondeuse positionInitiale) {
		this.positionInitiale = positionInitiale;
	}

	public List<Instruction> getInstructions() {
		return instructions;
	}

	public void setInstructions(List<Instruction> instructions) {
		this.instructions = instructions;
	}

}
