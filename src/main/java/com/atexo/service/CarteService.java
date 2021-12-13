package com.atexo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.atexo.model.Couleur;
import com.atexo.model.Carte;
import com.atexo.model.Valeurs;

@Service
public class CarteService {

	public static List<Valeurs> listeValeurAleatoire;

	public static List<Couleur> listeCouleurAleatoire;

	public static List<Couleur> couleurAleatoire() {
		List<Couleur> listeCouleur = Arrays.asList(Couleur.values());
		Collections.shuffle(listeCouleur);
		listeCouleurAleatoire = listeCouleur;
		return listeCouleur;
	}

	public static List<Valeurs> valeursAleatoire() {
		List<Valeurs> listeValeurs = Arrays.asList(Valeurs.values());
		Collections.shuffle(listeValeurs);
		listeValeurAleatoire = listeValeurs;
		return listeValeurs;
	}

	public List<Carte> dixCartesAleatoire() {
		List<Carte> listeDixCartes = new ArrayList<>();
		
		while (listeDixCartes.size() < 10) {
			Carte c = new Carte(Couleur.values()[(int) (4 * Math.random())], Valeurs.values()[(int) (13 * Math.random())]);
			if (!listeDixCartes.contains(c)){
				listeDixCartes.add(c);
			}
		}
		return listeDixCartes;
	}

	public List<Carte> triDeCartes(List<Carte> listeNonTriee) {
		
		if (listeCouleurAleatoire == null) {
			couleurAleatoire();
		}	
		if(listeValeurAleatoire == null) {
			valeursAleatoire();
		}
		List<Carte> listeTriee = listeNonTriee.stream().sorted(new Comparator<Carte>() {
			@Override
			public int compare(Carte carte1, Carte carte2) {
				Couleur couleur1 = carte1.getCouleur();
				Couleur couleur2 = carte2.getCouleur();
				
				if(listeCouleurAleatoire.indexOf(couleur1) < listeCouleurAleatoire.indexOf(couleur2)) {
					return -1;
				} else if(listeCouleurAleatoire.indexOf(couleur1) > listeCouleurAleatoire.indexOf(couleur2)) {
					return 1;
				}
				Valeurs valeur1 = carte1.getValeur();
				Valeurs valeur2 = carte2.getValeur();
				if(listeValeurAleatoire.indexOf(valeur1) < listeValeurAleatoire.indexOf(valeur2)) {
					return -1;
				}
				return 1;
			}	
		}).collect(Collectors.toList());
		
		return listeTriee;
	}

}
