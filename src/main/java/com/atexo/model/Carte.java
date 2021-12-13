package com.atexo.model;

public class Carte {

	private final Couleur couleur;
	private final Valeurs valeur;

	public Carte(Couleur couleur, Valeurs valeur) {
			this.valeur = valeur;
			this.couleur = couleur;
	}

	public Couleur getCouleur() {
		return couleur;
	}

	public Valeurs getValeur() {
		return valeur;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Carte) {
			Carte c = (Carte) obj;
			if(this.couleur.equals(c.couleur) && this.valeur.equals(c.valeur))
				return true;
		}
		return false;
	}
}
