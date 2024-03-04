package testsFonctionnels;

import java.util.Iterator;

import cartes.*;
import cartes.Probleme.Type;
import jeu.Sabot;

public class Main {
	

	public static void main(String[] argv) {
		System.out.println("Création Sabot");
		Sabot sab = new Sabot(50);
		
		Carte accident = new Attaque(3, Type.ACCIDENT);
		Carte reparation = new Parade(3, Type.ACCIDENT);
		Carte asDuVolant = new Botte(1, Type.ACCIDENT);
		
		
		sab.ajouterFamilleCartes(accident, reparation, asDuVolant);
		System.out.println("Cartes ajoutées");
		
		/* (2.a) while (sab.getNbCartes() > 0) {
			sab.piocher();
		}*/
		
		Iterator<Carte> it = sab.iterator();
		
		/* (2.b) while(sab.getNbCartes() > 0) {
			Carte c = it.next();
			System.out.println("Je pioche " + c);
			it.remove();
		}*/
		
		while(sab.getNbCartes() > 0) {
			Carte c = it.next();
			System.out.println("Je pioche " + c);
			it.remove();
			sab.piocher();
			sab.ajouterFamilleCarte(asDuVolant);
		}
		
	
	}

}
