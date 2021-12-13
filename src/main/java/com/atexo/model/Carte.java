package com.atexo.model;

public class Carte {

	private final COULEUR couleur;
	private final VALEURS valeur;

	public Carte(COULEUR couleur, VALEURS valeur) {
			this.valeur = valeur;
			this.couleur = couleur;
	}

	public COULEUR getCouleur() {
		return couleur;
	}

	public VALEURS getValeur() {
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
