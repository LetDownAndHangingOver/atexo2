package com.atexo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atexo.model.COULEUR;
import com.atexo.model.Carte;
import com.atexo.utils.CartesUtils;

@RestController
public class CartesController {
	
	@GetMapping(value="/couleurAleatoire", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<COULEUR> couleurAleatoire(){
		return CartesUtils.couleurAleatoire();
	}
	
	@GetMapping(value="/dixCartesAleatoires")
	public List<Carte> dixCartesAleatoires(){
		return CartesUtils.dixCartesAleatoire();
	}
	
	@GetMapping(value="/valeursAleatoires")
	public List<Carte> valeursAleatoires(){
		return CartesUtils.valeursAleatoire();
	}

}
