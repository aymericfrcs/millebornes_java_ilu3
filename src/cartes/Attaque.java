package cartes;

public class Attaque extends Bataille {

	public Attaque(int nombre, Type t) {
		super(nombre, t);
	}

	@Override
	public String toString() {
		String nomCarte;
		Type type = getType();
		
		switch (type) {
		case FEU :
			nomCarte = "Feu rouge";
			break;
			
		case ESSENCE :
			nomCarte = "Panne d'essence";
			break;
		
		case CREVAISON :
			nomCarte = "Crevaison";
			break;
			
		case ACCIDENT :
			nomCarte = "Accident";
			break;
	
		default:
			throw new IllegalArgumentException("Unexpected value: " + type );
			
		}
		return "Attaque: " + nomCarte;
	}

}
