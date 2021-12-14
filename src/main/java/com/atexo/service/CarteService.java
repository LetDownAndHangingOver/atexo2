package com.atexo.service;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.atexo.model.Carte;
import com.atexo.model.Couleur;
import com.atexo.model.Valeurs;

/**
 * Cette classe nous permet de creer une liste de 13 valeurs de cartes
 * aleatoires, une liste de 4 couleurs de cartes aleatoires, une liste de 10
 * cartes aleatoires et de trier des cartes selon les ordres definis des valeurs
 * et des couleurs
 * 
 * elle affiche aussi en console l'ordre de tri des couleurs et de valeurs
 * 
 * @author Mohammed BENALI
 *
 */
@Service
public class CarteService {
	/**
	 * logger de slf4j
	 */
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().getClass().getSimpleName());

	/**
	 * Cette valeur est utilisee pour stocker l'ordre des valeurs
	 */
	public static List<Valeurs> listeValeurAleatoire;

	/**
	 * Cette valeur est utilisee pour stocker l'ordre des couleurs
	 */
	public static List<Couleur> listeCouleurAleatoire;

	/**
	 * Utilisee pour generer un tri par couleur et les stocker dans
	 * ListeCouleurAleatoire ainsi que d'afficher l'ordre de tri des couleurs
	 * 
	 * @return Une liste de couleur unique triee de facon aleatoire
	 */
	public static List<Couleur> couleurAleatoire() {
		List<Couleur> listeCouleur = Arrays.asList(Couleur.values());
		Collections.shuffle(listeCouleur);
		//affecter la liste aleatoire de couleur a la variable static listeCouleurAleatoire
		listeCouleurAleatoire = listeCouleur;

		logger.info("La liste de couleurs aleatoires est : " + listeCouleurAleatoire);
		return listeCouleur;
	}

	/**
	 * Utilisee pour generer un tri par valeur et les stocker dans
	 * ListeValeurAleatoire ainsi que d'afficher l'ordre de tri des valeurs
	 * 
	 * @return une liste de valeur unique triee de facon aleatoire
	 */
	public static List<Valeurs> valeursAleatoire() {
		List<Valeurs> listeValeurs = Arrays.asList(Valeurs.values());
		// on tri d'une facon aleatoire
		Collections.shuffle(listeValeurs);
		// affecter la liste de valeur aleatoire a la variable static listeValeurAleatoire
		listeValeurAleatoire = listeValeurs;

		logger.info("La liste de valeurs aleatoires est : " + listeValeurAleatoire);
		return listeValeurs;
	}

	/**
	 * Utilisee pour generer dix cartes aleatoires
	 * 
	 * @return une liste de dix cartes unique de facon aleatoire
	 */
	public List<Carte> dixCartesAleatoire() {
		List<Carte> listeDixCartes = new ArrayList<>();
		// on cree 10 cartes uniques
		while (listeDixCartes.size() < 10) {
			Carte c = new Carte(Couleur.values()[(int) (4 * Math.random())],
					Valeurs.values()[(int) (13 * Math.random())]);
			// si la carte n'existe pas dans la liste, on l'ajoute
			if (!listeDixCartes.contains(c)) {
				listeDixCartes.add(c);
			}
		}

		logger.info("la liste des cartes aleatoires est : " + listeDixCartes);
		return listeDixCartes;
	}

	/**
	 * Utilisee pour trier des cartes de facon a respecter les ordres stockes dans
	 * ListeCouleurAleatoire et ListeValeurAleatoire si l'ordre n'est pas defini, on
	 * fait appel aux methodes de tri de couleurs et de valeurs
	 * 
	 * @param listeNonTriee est une liste de dix cartes unique de facon aleatoire
	 * @return Une liste triee selon l'ordre defini des couleurs et des valeurs
	 */
	public List<Carte> triDeCartes(List<Carte> listeNonTriee) {
		// si l'ordre des couleurs n'a pas ete defini, on le defini
		if (listeCouleurAleatoire == null) {
			couleurAleatoire();
		}
		// si l'ordre des valeurs n'a pas ete defini, on le defini
		if (listeValeurAleatoire == null) {
			valeursAleatoire();
		}
		// on tri la liste des cartes en implementant la methode compare de Comparator
		List<Carte> listeTriee = listeNonTriee.stream().sorted(new Comparator<Carte>() {
			@Override
			public int compare(Carte carte1, Carte carte2) {
				Couleur couleur1 = carte1.getCouleur();
				Couleur couleur2 = carte2.getCouleur();

				// on commence par l'ordre des couleurs
				if (listeCouleurAleatoire.indexOf(couleur1) < listeCouleurAleatoire.indexOf(couleur2)) {
					return -1;
				} else if (listeCouleurAleatoire.indexOf(couleur1) > listeCouleurAleatoire.indexOf(couleur2)) {
					return 1;
				}
				Valeurs valeur1 = carte1.getValeur();
				Valeurs valeur2 = carte2.getValeur();
				// si l'ordre des couleurs est identique, on tri par valeur
				if (listeValeurAleatoire.indexOf(valeur1) < listeValeurAleatoire.indexOf(valeur2)) {
					return -1;
				}
				return 1;
			}
		}).collect(Collectors.toList());

		return listeTriee;
	}

}
