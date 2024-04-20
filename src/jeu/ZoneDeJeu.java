package jeu;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import cartes.Attaque;
import cartes.Bataille;
import cartes.Borne;
import cartes.Botte;
import cartes.Carte;
import cartes.Cartes;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.Limite;
import cartes.Parade;
import cartes.Probleme.Type;

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
		
		if (!pileBataille.isEmpty() ) {
			Bataille sommetBataille = (Bataille) pileBataille.get(pileBataille.size()-1);
			
			if (sommetBataille.getClass()==Parade.class) {
				if (sommetBataille.getType()==Type.FEU || prioritaire) {
					return false; //Cas 2 & 3
				}
			}
			
			if (sommetBataille.getClass()==Attaque.class && prioritaire) {
				if (sommetBataille.getType()==Type.FEU) {
					return false; //Cas 4
				}
				
				Type typeAttaque = sommetBataille.getType();
				for (Carte carte : ensembleBottes) {
					if (((Botte)carte).getType() == typeAttaque) {
						return false; //Cas 5
					}
				}
			}
		} 
		else {
			if (prioritaire) { 
				return false; //Cas 1
			}
		}
		
		return true;
		
	}
	
	public boolean estDepotAutorise(Carte carte) {
		Class<? extends Carte> classe = carte.getClass();
		
		if (classe == Botte.class) {
			return true; //Cas b
		}
		
		if (classe == Borne.class && !estBloque() && donnerKmParcourus()<1000) {
			return true; //Cas a
		}
		
		if (classe == DebutLimite.class || classe == FinLimite.class) {
			return estDeposLimiteAutorise((Limite)carte); //Cas c et d
		}
		
		if (classe == Bataille.class) {
			return estDepotBatailleAutorise((Bataille)carte);
		}
		
	}
	
	
	private boolean estDeposLimiteAutorise(Limite carte) {
		boolean prio = ensembleBottes.contains(Cartes.PRIORITAIRE);
		boolean estLimite = !pileLimites.isEmpty() && pileLimites.get(pileLimites.size()-1).getClass()==DebutLimite.class;
		if (carte.getClass() == DebutLimite.class) {
			if (prio) {
				return false;
			}
			if (estLimite) {
				return false;
			}
			return true;
		} else {
			if (prio || estLimite) {
				return false;
			}
			return true;
		}
	}
	
	private boolean estDepotBatailleAutorise(Bataille carte) {
		if 
	}
	
}
