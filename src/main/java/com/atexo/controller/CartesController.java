package com.atexo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atexo.model.Carte;
import com.atexo.model.TenRandomCardsResponse;
import com.atexo.service.CarteService;

@RestController
@RequestMapping(value = "/cards")
public class CartesController {
	
	@Autowired
	private CarteService carteService; 
	
	@GetMapping(value="/generate")
	public TenRandomCardsResponse dixCartesAleatoires(){
		Map<String, List<Carte>> mapCartes = new HashMap<>();
		
		List<Carte> listeNonTriee = carteService.dixCartesAleatoire();
		mapCartes.put("unsorted", listeNonTriee);
		List<Carte> listeTriee = carteService.triDeCartes(listeNonTriee);
		mapCartes.put("sorted", listeTriee);
		return  new TenRandomCardsResponse(mapCartes, CarteService.listeCouleurAleatoire, CarteService.listeValeurAleatoire);
		
	}
}
