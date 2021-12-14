package com.atexo.model;
/**
 * la classe represente une carte avec une couleur unique et une valeur unique
 * @author Mohammed BENALI
 *
 */
public class Carte {

	/**
	 * la couleur de la carte doit etre unique
	 */
	private final Couleur couleur;
	/**
	 * la valeur de la carte doit etre unique
	 */
	private final Valeurs valeur;
	
	/**
	 * constructeur de la carte
	 * @param couleur
	 * @param valeur
	 */
	public Carte(Couleur couleur, Valeurs valeur) {
			this.valeur = valeur;
			this.couleur = couleur;
	}

	/**
	 * 
	 * @return couleur
	 */
	public Couleur getCouleur() {
		return couleur;
	}

	/**
	 * 
	 * @return valeur
	 */
	public Valeurs getValeur() {
		return valeur;
	}

	/**
	 * equals retourne true si les deux cartes ont la meme couleur et la meme 
	 * valeur
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Carte) {
			Carte c = (Carte) obj;
			if(this.couleur.equals(c.couleur) && this.valeur.equals(c.valeur))
				return true;
		}
		return false;
	}

	/**
	 * @return la couleur et la valeur d'une carte
	 */
	@Override
	public String toString() {
		return "Couleur : "+ this.couleur + ", Valeur : " + this.valeur;
	}
	
	
}
