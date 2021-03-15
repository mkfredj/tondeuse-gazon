package org.karim.tondeuse.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.karim.tondeuse.constants.Instruction;
import org.karim.tondeuse.constants.Orientation;
import org.karim.tondeuse.domain.Configuration;
import org.karim.tondeuse.domain.ConfigurationTondeuse;
import org.karim.tondeuse.domain.Coordonnees;
import org.karim.tondeuse.domain.Pelouse;
import org.karim.tondeuse.domain.PositionTondeuse;
import org.karim.tondeuse.exception.ExceptionTondeuse;

public class Parser {

	public static Configuration loadConfiguration(String configurationPath) throws ExceptionTondeuse {
		Configuration configuration = new Configuration();

		try (BufferedReader br = new BufferedReader(new FileReader(configurationPath))) {

			// lecture coin superieur droit
			String line = br.readLine();
			Pelouse pelouse;
			if (!checkPelouse(line)) {
				throw new ExceptionTondeuse("pelouse invalide");
			} else {

				Coordonnees coinSuperieurDroit = extractCoinSuperieurDroit(line);
				pelouse = new Pelouse(coinSuperieurDroit);
				configuration.setCoinSuperieurDroit(coinSuperieurDroit);
			}

			for (line = br.readLine(); line != null; line = br.readLine()) {
				PositionTondeuse positionTondeuse;

				// lecture position initiale
				String positionInitiale = line;

				if (!checkPosition(positionInitiale)) {
					throw new ExceptionTondeuse("postion tondeuse invalide");
				} else {
					positionTondeuse = extractPosition(positionInitiale, pelouse);
				}

				// lecture instructions

				String instructions = br.readLine();
				if (!checkListInstructions(instructions)) {
					throw new ExceptionTondeuse("liste des instructions invalide");
				} else {
					List<Instruction> listeInstructions = extractInstructions(instructions);

					ConfigurationTondeuse configurationTondeuse = new ConfigurationTondeuse(positionTondeuse, listeInstructions);
					configuration.getConfigurationsTondeuses().add(configurationTondeuse);
				}

			}

		} catch (

		IOException e) {
			e.printStackTrace();
		}

		return configuration;
	}

	/**
	 * 
	 * Lecture du coin superiieur droit
	 */
	public static Coordonnees extractCoinSuperieurDroit(String line) throws ExceptionTondeuse {
		String[] result = line.split("\\s+");

		Coordonnees coinSuperieurDroit = new Coordonnees(Integer.parseInt(result[0]), Integer.parseInt(result[1]));
		return coinSuperieurDroit;
	}

	/**
	 * Lecture de la position
	 */
	public static PositionTondeuse extractPosition(String line, Pelouse pelouse) throws ExceptionTondeuse {
		PositionTondeuse position = new PositionTondeuse();

		String[] result = line.split("\\s+");
		if (!pelouse.isCoordonneesOutSide(new Coordonnees(Integer.parseInt(result[0]), Integer.parseInt(result[1])))) {
			position.setOrientation(Orientation.valueOf(result[2]));
			position.setCoordonnee(new Coordonnees(Integer.parseInt(result[0]), Integer.parseInt(result[1])));
			return position;
		} else
			throw new ExceptionTondeuse("La tondeuse est hosrs pelouse");

	}

	/**
	 * Lecture des instructions
	 */

	public static List<Instruction> extractInstructions(String line) {
		List<Instruction> tondeuseInstructionList = new ArrayList<>();

		Arrays.stream(line.trim().split(""))
				.forEach(a -> tondeuseInstructionList.add(Instruction.getInstructionFromLettre(a).get()));

		return tondeuseInstructionList;

	}


	/**
	 * vérifier que la position de la tondeuse et son orientation sont fournies sous
	 * la forme de 2 chiffres et une lettre, séparés par un espace
	 */
	public static boolean checkPosition(String tondeuse) {
		StringBuilder stringBuilder = new StringBuilder("");
		stringBuilder.append(Orientation.N).append("|").append(Orientation.S).append("|").append(Orientation.E)
				.append("|").append(Orientation.W);
		return tondeuse.matches("(\\d+) (\\d+) (" + stringBuilder.toString() + ")");
	}

	/**
	 * vérifier que les instructions sont une suite de caractères(G, D, A) sans
	 * espaces
	 */
	public static boolean checkListInstructions(String instructions) {
		StringBuilder stringBuilder = new StringBuilder("");
		stringBuilder.append("(").append(Instruction.AVANT.getInstructionLettre()).append("|")
				.append(Instruction.DROITE.getInstructionLettre()).append("|")
				.append(Instruction.GAUCHE.getInstructionLettre()).append(")+");
		return instructions.matches(stringBuilder.toString());
	}

	/**
	 * verifier que la position de la pelouse est sous la forme de 2 chiffres
	 * séparés par un espace
	 */
	public static boolean checkPelouse(String pelouse) {
		return pelouse.matches("(\\d+) (\\d+)");

	}

}
