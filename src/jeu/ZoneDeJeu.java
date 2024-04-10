package jeu;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import cartes.Bataille;
import cartes.Borne;
import cartes.Botte;
import cartes.Carte;
import cartes.Cartes;
import cartes.FinLimite;
import cartes.Limite;
import cartes.Parade;

public class ZoneDeJeu {
	private List<Limite> pileLimites = new LinkedList<>();
	private List<Carte> pileBataille = new LinkedList<>();
	private List<Borne> bornes = new LinkedList<>();
	private Set<Carte> ensembleBottes= new HashSet<>();
	
	public ZoneDeJeu() {
		pileLimites = new LinkedList<>();
		pileBataille = new LinkedList<>();
		bornes = new LinkedList<>();
		ensembleBottes= new HashSet<>();
	}
	
	public boolean deposer(Borne borne) {
		bornes.add(borne);
		return true;
	}
	
	public boolean deposer(Limite lim) {
		pileLimites.add(lim);
		return true;
	}
	
	public boolean deposer(Bataille b) {
		pileBataille.add(b);
		return true;
	}
	
	public boolean deposer(Botte b) {
		ensembleBottes.add(b);
		return true;
	}
	
	public int donnerKmParcourus() {
		int acc=0;
		Iterator<Borne> it = bornes.listIterator();
		while(it.hasNext()) {
			acc += it.next().getKm();
		}
		return acc;
	}
	
	
	public int donnerLimitationVitesse() {
		for (Carte carte : ensembleBottes) {
			if (carte.equals(Cartes.PRIORITAIRE)) {
				return 200;
			}
		}
		if (pileLimites.isEmpty() || 
				pileLimites.get(pileLimites.size()-1).equals(new FinLimite(6))) {
			return 200;
		}
		return 50;
	}
	
	public boolean estBloque() {
		boolean prioritaire = false;
		boolean bloque = true;
		
		for (Carte carte : ensembleBottes) {
			if (carte.equals(Cartes.PRIORITAIRE)) {
				prioritaire = true;
			}
		}
		
		Bataille sommetBataille = pileBataille.get(pileBataille.size()-1);
		
		if (sommetBataille.getClass()==Parade.class && sommetBataille.getType()==FEU)
		
	}
	
	
}
