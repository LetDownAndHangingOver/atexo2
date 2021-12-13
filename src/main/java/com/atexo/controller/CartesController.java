package com.atexo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atexo.model.COULEUR;
import com.atexo.model.Carte;
import com.atexo.model.VALEURS;
import com.atexo.utils.CartesUtils;

@RestController
public class CartesController {
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value="/couleursAleatoires", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<COULEUR> couleurAleatoire(){
		return CartesUtils.couleurAleatoire();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value="/dixCartesAleatoires")
	public Map<String,List<Carte>> dixCartesAleatoires(){
		Map<String, List<Carte>> mapCartes = new HashMap<String, List<Carte>>();
		List<Carte> listeNonTriee = CartesUtils.dixCartesAleatoire();
		mapCartes.put("unsorted", listeNonTriee);
		List<Carte> listeTriee = CartesUtils.triDeCartes(listeNonTriee);
		mapCartes.put("sorted", listeTriee);
		return mapCartes;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value="/valeursAleatoires")
	public List<VALEURS> valeursAleatoires(){
		return CartesUtils.valeursAleatoire();
	}

}
