package com.atexo.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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

}
