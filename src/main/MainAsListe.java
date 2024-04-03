package main;

import java.util.List;

import cartes.Carte;

public class MainAsListe implements IMain {
	
	List<Carte> main;
	

	@Override
	public void prendre(Carte carte) {
		main.add(carte);
		
	}

	@Override
	public void jouer(Carte carte) {
		assert(main.contains(carte));
		main.remove(carte);
	}

}
