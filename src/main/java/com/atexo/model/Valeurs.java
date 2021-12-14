package com.atexo.model;

/**
 * une carte a 13 valeurs
 * @author Mohammed BENALI
 *
 */
public enum Valeurs {
	UN("As"),
	DEUX("2"),
	TROIS("3"),
	QUATRE("4"),
	CINQ("5"),
	SIX("6"),
	SEPT("7"),
	HUIT("8"),
	NEUF("9"),
	DIX("10"),
	ONZE("Valet"),
	DOUZE("Dame"),
	TREIZE("Roi");
	
	/**
	 * valeur des elements
	 */
	private final String valeur;

	/**
	 * 
	 * @param valeur
	 */
	private Valeurs(String valeur) {
		this.valeur = valeur;
	}

	/**
	 * 
	 * @return valeur
	 */
	public String getValeur() {
		return valeur;
	}

	/**
	 * pour afficher la valeur String de VALEUR
	 */
	@Override
	public String toString() {
		return this.valeur;
	}
}
