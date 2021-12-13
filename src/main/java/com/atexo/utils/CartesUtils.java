package com.atexo.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.atexo.model.COULEUR;
import com.atexo.model.Carte;
import com.atexo.model.VALEURS;

public final class CartesUtils {

	public static List<VALEURS> listeValeurAleatoire;

	public static List<COULEUR> listeCouleurAleatoire;

	public static List<COULEUR> couleurAleatoire() {
		List<COULEUR> listeCouleur = Arrays.asList(COULEUR.values());
		Collections.shuffle(listeCouleur);
		listeCouleurAleatoire = listeCouleur;
		return listeCouleur;
	}

	public static List<VALEURS> valeursAleatoire() {
		List<VALEURS> listeValeurs = Arrays.asList(VALEURS.values());
		Collections.shuffle(listeValeurs);
		System.out.println(listeValeurs);
		listeValeurAleatoire = listeValeurs;
		return listeValeurs;
	}

	public static List<Carte> dixCartesAleatoire() {
		List<Carte> listeDixCartes = new ArrayList<Carte>();
		Carte c = null;
		while (listeDixCartes.size() < 10) {
			c = new Carte(COULEUR.values()[(int) (3 * Math.random())], VALEURS.values()[(int) (12 * Math.random())]);
			if (listeDixCartes.contains(c)) {
			} else {
				listeDixCartes.add(c);
			}
		}
		return listeDixCartes;
	}

	public static List<Carte> triDeCartes(List<Carte> listeNonTriee) {
		
		if (listeCouleurAleatoire == null || listeValeurAleatoire == null) {
			throw new RuntimeException("Il faut choisir l'ordre de couleurs et de valeurs");
		}	

		List<Carte> listeTriee = listeNonTriee.stream().sorted(new Comparator<Carte>() {
			@Override
			public int compare(Carte carte1, Carte carte2) {
				COULEUR couleur1 = carte1.getCouleur();
				COULEUR couleur2 = carte2.getCouleur();
				
				if(listeCouleurAleatoire.indexOf(couleur1) < listeCouleurAleatoire.indexOf(couleur2)) {
					return -1;
				} else if(listeCouleurAleatoire.indexOf(couleur1) > listeCouleurAleatoire.indexOf(couleur2)) {
					return 1;
				}
				VALEURS valeur1 = carte1.getValeur();
				VALEURS valeur2 = carte2.getValeur();
				if(listeValeurAleatoire.indexOf(valeur1) < listeValeurAleatoire.indexOf(valeur2)) {
					return -1;
				}
				return 1;
			}	
		}).collect(Collectors.toList());
		
		return listeTriee;
	}

}
