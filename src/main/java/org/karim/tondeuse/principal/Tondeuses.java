package org.karim.tondeuse.principal;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.karim.tondeuse.domain.Configuration;
import org.karim.tondeuse.domain.ConfigurationTondeuse;
import org.karim.tondeuse.domain.Pelouse;
import org.karim.tondeuse.domain.PositionTondeuse;
import org.karim.tondeuse.domain.Tondeuse;
import org.karim.tondeuse.exception.ExceptionTondeuse;
import org.karim.tondeuse.utils.Parser;

public class Tondeuses {

	private static String defaultInputFile = "inputFile.txt";

	public static void main(String[] args) throws ExceptionTondeuse {

		String configurationFilePath = "";
		if (args.length < 1) {
			System.out.println("Syntax :");
			System.out.println(Tondeuses.class.getName() + " <configurationPath>");
			System.out.println("default file will be used");
			configurationFilePath = defaultInputFile;
			//System.exit(1);
		} else {
			configurationFilePath = args[0];
		}

		//vérifier la configuration
		checkConfiguration(configurationFilePath);

		// charger la configuration é partir du fichier d'entrée.
		Configuration configuration = Parser.loadConfiguration(defaultInputFile);

		//créer les tondeuses
		List<Tondeuse> tondeuses = new ArrayList<Tondeuse>();
		for (ConfigurationTondeuse configurationTondeuse : configuration.getConfigurationsTondeuses()) {
			tondeuses.add(new Tondeuse(configurationTondeuse));
		}
		
		//démarrer les tondeuses
		Pelouse pelouse = new Pelouse(configuration.getCoinSuperieurDroit());
		for (Tondeuse tondeuse : tondeuses) {
			tondeuse.start(pelouse);
		}		
		
        //afficher les résultats
		tondeuses.forEach(post -> System.out.println(post.getPositionCourante().toString()));
	}

	private static void checkConfiguration(String configurationFilePath) {

		File configurationFile = new File(configurationFilePath);
		if (!configurationFile.exists() || !configurationFile.isFile()||configurationFile.length()==0) {
			System.out.println("'" + configurationFilePath + "' not found or not a file or file is empty");
			System.exit(1);
		}

	}

}