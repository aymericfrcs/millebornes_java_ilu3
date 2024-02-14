package cartes;


public class Botte extends Probleme {

	public Botte(int nombre, Type t) {
		super(nombre, t);

	}
	
	@Override
	public String toString() {
		String nomCarte;
		Type type = getType();
		
		switch (type) {
		case FEU :
			nomCarte = "Véhicule Prioritaire";
			break;
			
		case ESSENCE :
			nomCarte = "Citerne d'essence";
			break;
		
		case CREVAISON :
			nomCarte = "Increvable";
			break;
			
		case ACCIDENT :
			nomCarte = "As du volant";
			break;
	
		default:
			throw new IllegalArgumentException("Unexpected value: " + type );
			
		}
		return "Botte: " + nomCarte;
	}

}
