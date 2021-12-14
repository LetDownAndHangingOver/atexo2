package com.atexo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.atexo.model.Couleur;
import com.atexo.model.Carte;
import com.atexo.model.Valeurs;
import com.atexo.service.CarteService;

@SpringBootTest
public class CarteServiceTest {
	
	@Autowired
	private CarteService carteService; 

	@Test
	public void couleurAleatoireValid() {
		List<Couleur> listeCouleur = CarteService.couleurAleatoire();

		assertThat(listeCouleur).isNotNull();
		assertThat(listeCouleur.size()).isEqualTo(4);

		for (int i = 0; i < listeCouleur.size(); i++) {
			assertThat(listeCouleur.get(i)).isNotNull();
		}

		assertThat(listeCouleur).doesNotHaveDuplicates();
	}

	@Test
	public void valeurAleatoireValid() {
		List<Valeurs> listeValeur = CarteService.valeursAleatoire();
		
		assertThat(listeValeur).isNotNull();
		assertThat(listeValeur.size()).isEqualTo(13);
		assertThat(listeValeur).doesNotHaveDuplicates();
		
		for (int i = 0; i < listeValeur.size(); i++) {
			assertThat(listeValeur.get(i)).isNotNull();
		}
	}
	
	@Test
	public void dixCartesAleatoireValid() {
		List<Carte> listeCartes = carteService.dixCartesAleatoire();
		
		assertThat(listeCartes).isNotNull();
		assertThat(listeCartes.size()).isEqualTo(10);
		assertThat(listeCartes).doesNotHaveDuplicates();
		
		for (int i = 0; i < listeCartes.size(); i++) {
			assertThat(listeCartes.get(i)).isNotNull();
		}
	}	
	
	@Test()
	public void triDeCartesValid() {
		List<Carte> listeNonTriee = carteService.dixCartesAleatoire();
		
		List<Carte> listeTriee = carteService.triDeCartes(listeNonTriee);
		
		assertThat(listeTriee).isNotNull();
		
		assertThat(listeTriee.size()).isEqualTo(10);
		
		assertThat(listeTriee).doesNotHaveDuplicates();
		
	}
}
