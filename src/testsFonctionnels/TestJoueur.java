package testsFonctionnels;

import cartes.Borne;
import cartes.Botte;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.Limite;
import cartes.Probleme.Type;
import jeu.Joueur;
import jeu.Sabot;

public class TestJoueur {
	
	
	public static void testAjoutBornes() {
		Joueur j1 = new Joueur("j1");
		Sabot s = new Sabot(50);
		
		Borne b1 = new Borne(5,50);
		
		j1.donner(b1);
		System.out.println("ici");
		
		System.out.println(j1.montrerMain());
		
		
		j1.deposer(b1);
		System.out.println("Kms parcourus: " + String.valueOf(j1.donnerKmParcourus()));
		
	}
	
	public static void testGetLimite() {
		Joueur j1 = new Joueur("j1");
		Sabot s = new Sabot(50);
		
		System.out.println(j1.donnerLimitationVitesse());
		
		j1.deposer(new DebutLimite(1));	
		System.out.println(j1.donnerLimitationVitesse());
		
		j1.deposer(new FinLimite(1));	
		System.out.println(j1.donnerLimitationVitesse());
		
		j1.deposer(new DebutLimite(1));	
		System.out.println(j1.donnerLimitationVitesse());
		
		j1.deposer(new Botte(1, Type.FEU));
		System.out.println(j1.donnerLimitationVitesse());
	}
	
}
