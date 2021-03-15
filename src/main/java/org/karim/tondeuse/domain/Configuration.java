package org.karim.tondeuse.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Classe qui represente le fichier d'entree (la pelouse a tondre avec les
 * tondeuses a programmer et leurs instructions respectives)
 *
 */
public class Configuration {

	private Coordonnees coinSuperieurDroit;
	private List<ConfigurationTondeuse> configurationsTondeuses;

	public Coordonnees getCoinSuperieurDroit() {
		return coinSuperieurDroit;
	}

	public void setCoinSuperieurDroit(Coordonnees coinSuperieurDroit) {
		this.coinSuperieurDroit = coinSuperieurDroit;
	}

	public List<ConfigurationTondeuse> getConfigurationsTondeuses() {
		if (configurationsTondeuses == null) {
			configurationsTondeuses = new ArrayList<ConfigurationTondeuse>();
		}
		return configurationsTondeuses;
	}

	public void setConfigurationsTondeuses(List<ConfigurationTondeuse> configurationsTondeuses) {
		this.configurationsTondeuses = configurationsTondeuses;
	}

}
