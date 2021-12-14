package com.atexo.model;

import java.util.List;
import java.util.Map;
/**
 * cette classe contient une liste d'ordre de couleur,
 * une liste d'ordre de valeurs 
 * et une map qui a comme cle un String et comme valeur une liste de Carte
 * 
 * 
 * @author Mohammed BENALI
 *
 */

public class TenRandomCardsResponse {
	
	/**
	 * map avec comme cle String et valeur Liste de carte
	 */
	private Map<String, List<Carte>> cartes; 
	/**
	 * liste de couleur
	 */
	private List<Couleur> triCouleur; 
	/**
	 * liste de valeur
	 */
	private List<Valeurs> triValeur;
	
	/**
	 * 	constructeur de TenRandomCardsResponse
	 * @param cartes contient une map avec cle String et valeur Liste de cartes
	 * @param triCouleur contient une liste d'ordre de couleur
	 * @param triValeur contient une liste d'ordre de valeur
	 */
	public TenRandomCardsResponse(Map<String, List<Carte>> cartes, List<Couleur> triCouleur, List<Valeurs> triValeur) {
		super();
		this.cartes = cartes;
		this.triCouleur = triCouleur;
		this.triValeur = triValeur;
	}
	
	/**
	 * 
	 * @return cartes
	 */
	public Map<String, List<Carte>> getCartes() {
		return cartes;
	}
	/**
	 * 
	 * @param cartes
	 */
	public void setCartes(Map<String, List<Carte>> cartes) {
		this.cartes = cartes;
	}
	/**
	 * 
	 * @return triCouleur
	 */
	public List<Couleur> getTriCouleur() {
		return triCouleur;
	}
	/**
	 * 
	 * @param triCouleur
	 */
	public void setTriCouleur(List<Couleur> triCouleur) {
		this.triCouleur = triCouleur;
	}
	/**
	 * 
	 * @return triValeur
	 */
	public List<Valeurs> getTriValeur() {
		return triValeur;
	}
	/**
	 * 
	 * @param triValeur
	 */
	public void setNumberOrder(List<Valeurs> triValeur) {
		this.triValeur = triValeur;
	}
	
	

}
