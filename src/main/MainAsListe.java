package main;

import java.util.ArrayList;
import java.util.List;

import cartes.Carte;

public class MainAsListe implements IMain {
	
	List<Carte> main;
	
	
	

	public MainAsListe() {
		main = new ArrayList<Carte>();
	}

	
	public int nbElem() {
		return main.size();
	}
	
	@Override
	public void prendre(Carte carte) {
		main.add(carte);
		
	}

	@Override
	public void jouer(Carte carte) {
		assert(main.contains(carte));
		main.remove(carte);
	}
	
	@Override
	public String toString() {
		String str = "";
		for (Carte carte : main) {
			str = str + carte.toString() + " | ";
		}
		return str;
	}

}
