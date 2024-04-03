package cartes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import cartes.Probleme.Type;
import utils.Utils;

public class JeuDeCartes {
	private Carte[] typesDeCartes = new Carte[19]; 
	{
	typesDeCartes[0] = new Botte(1, Type.FEU);
	typesDeCartes[1] = new Botte(1, Type.ESSENCE);
	typesDeCartes[2] = new Botte(1, Type.CREVAISON);
	typesDeCartes[3] = new Botte(1, Type.ACCIDENT);
	
	typesDeCartes[4] = new Attaque(5, Type.FEU);
	typesDeCartes[5] = new DebutLimite(4);
	typesDeCartes[6] = new Attaque(3, Type.ESSENCE);
	typesDeCartes[7] = new Attaque(3, Type.CREVAISON);
	typesDeCartes[8] = new Attaque(3, Type.ACCIDENT);
	
	typesDeCartes[9] = new Parade(14, Type.FEU);
	typesDeCartes[10] = new FinLimite(6);
	typesDeCartes[11] = new Parade(6, Type.ESSENCE);
	typesDeCartes[12] = new Parade(6, Type.CREVAISON);
	typesDeCartes[13] = new Parade(6, Type.ACCIDENT);
	
	typesDeCartes[14] = new Borne(10, 25);
	typesDeCartes[15] = new Borne(10, 50);
	typesDeCartes[16] = new Borne(10, 75);
	typesDeCartes[17] = new Borne(12, 100); 
	typesDeCartes[18] = new Borne(4, 200); }
	
	private List<Carte> listeCartes;

	public JeuDeCartes() {
		listeCartes = new ArrayList<>();
		
		for (int i=0; i<19; i++) {
			for (int j=0; j<typesDeCartes[i].getNombre(); j++) {
				listeCartes.add(typesDeCartes[i]);
			}
		}
		listeCartes = Utils.melanger(listeCartes);
		if (!this.checkCount()) {
			System.out.println("Il manque des cartes!!");
		}
	}

	public List<Carte> getListeCartes() {
		return listeCartes;
	}
	
	public boolean checkCount() {
		Iterator<Carte> it = listeCartes.iterator();
		for (int i=0; i<19; i++ ) {
			if (Collections.frequency(listeCartes, typesDeCartes[i]) != typesDeCartes[i].getNombre()) {
				return false;
			}
		}
				
		
		return true;
	}

}
