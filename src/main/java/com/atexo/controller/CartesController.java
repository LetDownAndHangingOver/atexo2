package com.atexo.controller;

import java.lang.invoke.MethodHandles;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atexo.model.Carte;
import com.atexo.model.TenRandomCardsResponse;
import com.atexo.service.CarteService;

/**
 * la clase contient un seul endpoint qui permet d'envoyer sous format JSON
 * dix cartes non triees, ces memes cartes triees, l'ordre de tri de couleur
 * et l'ordre de tri des valeurs
 * les listes triees et non triees sont aussi affichees en console
 * 
 * @author Mohammed BENALI
 *
 */
@RestController
@RequestMapping(value = "/cartes")
public class CartesController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(MethodHandles.lookup().getClass().getSimpleName());

	/**
	 * l'objet de type CarteService est directemnt injecte a carteService
	 */
	@Autowired
	private CarteService carteService; 
	
	/**
	 * cet endpoint permet de generer la liste des valeurs aleatoires,
	 * la liste des couleurs aleatoires ainsi qu'une Map avec comme cles, unsorted et sorted
	 * et comme valeurs une liste de dix cartes non triee et une liste de dix cartes triee
	 * selon l'ordre predefini et affiche aussi cette map
	 * 
	 * @return TenRandomCardsResponse qui contient la liste des couleurs aleatoire
	 *   la liste des valeurs aleatoires et une map de la liste de cartes non triee
	 *   et de la liste de cartes triee 
	 */
	@GetMapping(value="/generate")
	public TenRandomCardsResponse dixCartesAleatoires(){
		Map<String, List<Carte>> mapCartes = new HashMap<>();
		//affecter dix cartes aleatoires a listeNonTriee
		List<Carte> listeNonTriee = carteService.dixCartesAleatoire();
		//donner la cle "unsorted" a listeNonTriee
		mapCartes.put("unsorted", listeNonTriee);
		//trier listeNonTriee et l'affecter a listeTriee
		List<Carte> listeTriee = carteService.triDeCartes(listeNonTriee);
		//donner la cle "sorted" a listeTriee
		mapCartes.put("sorted", listeTriee);
		
		//afficher les cartes triees et non triees
		logger.info(mapCartes.toString());
		return  new TenRandomCardsResponse(mapCartes, CarteService.listeCouleurAleatoire, CarteService.listeValeurAleatoire);
		
	}
}
