package cartes;

import cartes.Probleme.Type;

public interface Cartes {
	static Carte PRIORITAIRE = new Botte(1, Type.FEU);
	static Carte FEU_ROUGE = new Attaque(5, Type.FEU);
	static Carte FEU_VERT = new Parade(15, Type.FEU);
}
