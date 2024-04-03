package jeu;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


import cartes.Borne;
import cartes.Carte;
import cartes.Limite;

public class ZoneDeJeu {
	private List<Limite> pileLimites = new LinkedList<>();
	private List<Carte> pileBataille = new LinkedList<>();
	private List<Borne> bornes = new LinkedList<>();
	private Set<Carte> ensembleBottes= new HashSet<>();
	
	public void deposer(Borne borne) {
		bornes.add(borne);
	}
	
	public int donnerKmParcourus() {
		int acc=0;
		Iterator<Borne> it = bornes.listIterator();
		while(it.hasNext()) {
			acc += it.next().getKm();
		}
		return acc;
		
		
	}
	
	
	
	
}
