package com.atexo.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Comparator;
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
	
	@Test()
	public void triDeCartesCouleurNullValid() {
		CartesUtils.listeCouleurAleatoire = null;
		CartesUtils.valeursAleatoire();
		List<Carte> listeNonTriee = CartesUtils.dixCartesAleatoire();
		assertThatExceptionOfType(RuntimeException.class).isThrownBy(() ->
			CartesUtils.triDeCartes(listeNonTriee)
			)
		.withMessage("Il faut choisir l'ordre de couleurs et de valeurs");
	}
	
	@Test()
	public void triDeCartesValeursNullValid() {
		CartesUtils.listeValeurAleatoire = null;
		CartesUtils.couleurAleatoire();
		List<Carte> listeNonTriee = CartesUtils.dixCartesAleatoire();
		assertThatExceptionOfType(RuntimeException.class).isThrownBy(() ->
			CartesUtils.triDeCartes(listeNonTriee)
			)
		.withMessage("Il faut choisir l'ordre de couleurs et de valeurs");
	}
	
	@Test()
	public void triDeCartesCouleurEtValeurNullValid() {
		CartesUtils.listeCouleurAleatoire = null;
		CartesUtils.listeValeurAleatoire = null;
		List<Carte> listeNonTriee = CartesUtils.dixCartesAleatoire();
		assertThatExceptionOfType(RuntimeException.class).isThrownBy(() ->
			CartesUtils.triDeCartes(listeNonTriee)
			)
		.withMessage("Il faut choisir l'ordre de couleurs et de valeurs");
	}
	
	@Test()
	public void triDeCartesValid() {
		CartesUtils.couleurAleatoire();
		CartesUtils.valeursAleatoire();
		List<Carte> listeNonTriee = CartesUtils.dixCartesAleatoire();
		
		List<Carte> listeTriee = CartesUtils.triDeCartes(listeNonTriee);
		
		assertThat(listeTriee).isNotNull();
		
		assertThat(listeTriee.size()).isEqualTo(10);
		
		assertThat(listeTriee).doesNotHaveDuplicates();
		
		assertThat(listeTriee).isSortedAccordingTo(new Comparator<Carte>() {
		@Override
		public int compare(Carte carte1, Carte carte2) {
			COULEUR couleur1 = carte1.getCouleur();
			COULEUR couleur2 = carte2.getCouleur();
			
			if(CartesUtils.listeCouleurAleatoire.indexOf(couleur1) < CartesUtils.listeCouleurAleatoire.indexOf(couleur2)) {
				return -1;
			} else if(CartesUtils.listeCouleurAleatoire.indexOf(couleur1) > CartesUtils.listeCouleurAleatoire.indexOf(couleur2)) {
				return 1;
			}
			VALEURS valeur1 = carte1.getValeur();
			VALEURS valeur2 = carte2.getValeur();
			if(CartesUtils.listeValeurAleatoire.indexOf(valeur1) < CartesUtils.listeValeurAleatoire.indexOf(valeur2)) {
				return -1;
			}
			return 1;
		}	
	});
	}
}
