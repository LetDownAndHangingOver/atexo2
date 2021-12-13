package com.atexo.model;

public enum VALEURS {
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
	
	private final String valeur;

	private VALEURS(String valeur) {
		this.valeur = valeur;
	}

	public String getValeur() {
		return valeur;
	}

	@Override
	public String toString() {
		return this.valeur;
	}
	
	

}
