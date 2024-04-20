package jeu;

import cartes.Carte;

public class Coup {
	private Carte carte;
	private Joueur cible; // si cible=null, carte remise dans sabot
	
	public Coup(Carte carte, Joueur cible) {
		this.carte = carte;
		this.cible = cible;
	}

	public Carte getCarte() {
		return carte;
	}

	public Joueur getCible() {
		return cible;
	}
	
	
	
	
}
