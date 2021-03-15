package org.karim.tondeuse.domain;

import org.karim.tondeuse.constants.Instruction;

/**
 * execute instructions   
 */
public class Tondeuse {

	ConfigurationTondeuse configurationTondeuse;
	PositionTondeuse positionCourante;

	
	public void start(Pelouse pelouse) {

		for (Instruction instruction : configurationTondeuse.getInstructions()) {
			executerInstruction(instruction, pelouse);
		}

	}

	public void executerInstruction(Instruction instruction,	Pelouse pelouse) {
		PositionTondeuse newPositionTondeuse = positionCourante.clone();
		
		if (Instruction.AVANT.equals(instruction)) {
			newPositionTondeuse.forward();
			if (!pelouse.isCoordonneesOutSide(newPositionTondeuse.getCoordonnee())) {
				positionCourante.setCoordonnee(newPositionTondeuse.getCoordonnee());
			}
		} else if (Instruction.GAUCHE.equals(instruction)) {
			positionCourante.turnLeft();
		} else if (Instruction.DROITE.equals(instruction)) {
			positionCourante.turnRight();
		}
	}
	
	public Tondeuse(ConfigurationTondeuse configurationTondeuse) {
		super();
		this.configurationTondeuse = configurationTondeuse;
		this.positionCourante = configurationTondeuse.getPositionInitiale().clone();
	}

	public ConfigurationTondeuse getConTondeuse() {
		return configurationTondeuse;
	}

	public void setConTondeuse(ConfigurationTondeuse conTondeuse) {
		this.configurationTondeuse = conTondeuse;
	}

	public PositionTondeuse getPositionCourante() {
		return positionCourante;
	}

	public void setPositionCourante(PositionTondeuse positionCourante) {
		this.positionCourante = positionCourante;
	}

}
