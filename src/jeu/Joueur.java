package jeu;

import java.util.List;

import cartes.Bataille;
import cartes.Borne;
import cartes.Botte;
import cartes.Carte;
import cartes.Limite;
import main.MainAsListe;

public class Joueur {
	private String nom;
	private ZoneDeJeu zoneJeu;
	private MainAsListe main;
	
	public Joueur(String nom) {
		this.nom = nom;
		zoneJeu = new ZoneDeJeu();
		main = new MainAsListe();
	}
	
	public String montrerMain() {
		return "Nombre de cartes: " + String.valueOf(main.nbElem())
		+ ":\n| " + main.toString() + "\n";
	}
	
	public void donner(Carte c) {
		main.prendre(c);
	}
	
	public Carte prendreCarte(Sabot sabot) {
		if (sabot.estVide()) {
			return null;
		}
		Carte c = sabot.piocher();
		this.donner(c);
		return c;
	}
	
	public boolean deposer(Borne borne) {
		return zoneJeu.deposer(borne);
	}
	
	public boolean deposer(Limite l) {
		return zoneJeu.deposer(l);
	}
	
	public boolean deposer(Bataille b) {
		return zoneJeu.deposer(b);
	}
	
	public boolean deposer(Botte b) {
		return zoneJeu.deposer(b);
	}
	
	public int donnerKmParcourus() {
		return zoneJeu.donnerKmParcourus();
	}
	
	public int donnerLimitationVitesse() {
		return zoneJeu.donnerLimitationVitesse();
	}
	
	public boolean estBloque() {
		return zoneJeu.estBloque();
	}
	
	
	
	
	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj.getClass() == getClass()) {
			Joueur j = (Joueur)obj;
			return this.getNom() == j.getNom();
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Joueur :" + nom;
	}
	
	public String getNom() {
		return nom;
	}
	
	public MainAsListe getMain() {
		return main;
	}
}


