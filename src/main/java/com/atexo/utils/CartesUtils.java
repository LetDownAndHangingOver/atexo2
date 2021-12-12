package com.atexo.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;

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
		List<String> listeValeur = listeValeurAleatoire;
		List<Carte> listeCarte = new ArrayList<Carte>();
		
		for (String string : listeValeur) {
			listeCarte.add(new Carte(couleur, string))
		}
		
		return listeValeur;
	}

	public

}
