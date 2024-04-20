package testsFonctionnels;

import cartes.Attaque;
import cartes.Botte;
import cartes.Parade;
import cartes.Probleme.Type;
import jeu.Joueur;

public class TestZoneDeJeu {

	public static void testEstBloque() {
		Joueur j = new Joueur("j");
		//System.out.println(j.estBloque());
		
		j.deposer(new Attaque(1, Type.FEU));
		System.out.println(j.estBloque());
		
		j.deposer(new Botte(1, Type.FEU));
		System.out.println(j.estBloque());
		
		j.deposer(new Attaque(1, Type.ACCIDENT));
		System.out.println(j.estBloque());
		
		j.deposer(new Botte(1, Type.ACCIDENT));
		System.out.println(j.estBloque());
		
		j.deposer(new Attaque(1, Type.ESSENCE));
		System.out.println(j.estBloque());
		
		j.deposer(new Botte(0, Type.ESSENCE));
		System.out.println(j.estBloque());
		
		Joueur j2 = new Joueur("j2");
		
		j2.deposer(new Attaque(0, Type.FEU));
		System.out.println(j2.estBloque());
		
		j2.deposer(new Parade(1, Type.FEU));
		System.out.println(j2.estBloque());
	}
}
