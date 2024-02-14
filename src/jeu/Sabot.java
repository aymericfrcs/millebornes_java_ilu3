package jeu;

import java.util.Iterator;

import cartes.*;

public class Sabot {
	private Carte tabSabot[];
	private int nbCartes = 0;
	private int maxNbCartes;
	
	
	public Sabot(int maxNbCartes) {
		this.maxNbCartes = maxNbCartes;
		tabSabot = new Carte[maxNbCartes];
	}
	
	public Boolean estVide() {
		return nbCartes == 0;
	}
	
	private void ajouterCarte(Carte c) throws IllegalStateException {
		if (nbCartes == maxNbCartes) {
			throw new IllegalStateException("La sabot est plein");
		} else {
			tabSabot[nbCartes] = c;
			nbCartes++;
		}
	}
	
	public void ajouterFamilleCarte(Carte c) {
		for (int i = 0; i < c.getNombre(); i++) {
			ajouterCarte(c);
		}
	}
	
	public void ajouterFamilleCartes(Carte...cartes ) {
		for (int i = 0; i < cartes.length; i++) {
			ajouterFamilleCarte(cartes[i]);
		}
	}

}
