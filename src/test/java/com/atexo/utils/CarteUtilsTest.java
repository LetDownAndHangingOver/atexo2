package com.atexo.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.atexo.model.COULEUR;
import com.atexo.model.Carte;
import com.atexo.model.VALEURS;

@SpringBootTest
public class CarteUtilsTest {

	@Test
	public void couleurAleatoireValid() {
		List<COULEUR> listeCouleur = CartesUtils.couleurAleatoire();

		assertThat(listeCouleur).isNotNull();
		assertThat(listeCouleur.size()).isEqualTo(4);

		for (int i = 0; i < listeCouleur.size(); i++) {
			assertThat(listeCouleur.get(i)).isNotNull();
		}

		assertThat(listeCouleur).doesNotHaveDuplicates();
	}

	@Test
	public void valeurAleatoireValid() {
		List<VALEURS> listeValeur = CartesUtils.valeursAleatoire();
		
		assertThat(listeValeur).isNotNull();
		assertThat(listeValeur.size()).isEqualTo(13);
		assertThat(listeValeur).doesNotHaveDuplicates();
		
		for (int i = 0; i < listeValeur.size(); i++) {
			assertThat(listeValeur.get(i)).isNotNull();
		}
	}
	
	@Test
	public void dixCartesAleatoireValid() {
		List<Carte> listeCartes = CartesUtils.dixCartesAleatoire();
		
		assertThat(listeCartes).isNotNull();
		assertThat(listeCartes.size()).isEqualTo(10);
		assertThat(listeCartes).doesNotHaveDuplicates();
		
		for (int i = 0; i < listeCartes.size(); i++) {
			assertThat(listeCartes.get(i)).isNotNull();
		}
	}
}
