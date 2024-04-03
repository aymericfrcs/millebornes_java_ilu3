package jeu;

import java.util.List;

import cartes.Borne;
import cartes.Carte;
import main.MainAsListe;

public class Joueur {
	private String nom;
	private ZoneDeJeu zoneJeu;
	private MainAsListe main;
	
	public Joueur(String nom) {
		this.nom = nom;
		
	}
	
	public void donner(Carte c) {
		main.prendre(c);
	}
	
	public Carte prendreCarte(List<Carte> sabot) {
		if (sabot.size()==0) {
			return null;
		}
		Carte c = sabot.get(0);
		sabot.remove(0);
		this.donner(c);
		return c;
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


