package com.atexo.model;

import java.util.List;
import java.util.Map;


public class TenRandomCardsResponse {
	
	private Map<String, List<Carte>> cards; 
	private List<Couleur> suitOrder; 
	private List<Valeurs> numberOrder;
	
	
	
	public TenRandomCardsResponse(Map<String, List<Carte>> cards, List<Couleur> suitOrder, List<Valeurs> numberOrder) {
		super();
		this.cards = cards;
		this.suitOrder = suitOrder;
		this.numberOrder = numberOrder;
	}
	public Map<String, List<Carte>> getCards() {
		return cards;
	}
	public void setCards(Map<String, List<Carte>> cards) {
		this.cards = cards;
	}
	public List<Couleur> getSuitOrder() {
		return suitOrder;
	}
	public void setSuitOrder(List<Couleur> suitOrder) {
		this.suitOrder = suitOrder;
	}
	public List<Valeurs> getNumberOrder() {
		return numberOrder;
	}
	public void setNumberOrder(List<Valeurs> numberOrder) {
		this.numberOrder = numberOrder;
	}
	
	

}
