package cartes;


public class Parade extends Bataille {

	public Parade(int nombre, Type t) {
		super(nombre, t);
	}

	@Override
	public String toString() {
		String nomCarte;
		Type type = getType();
		
		switch (type) {
		case FEU :
			nomCarte = "Feu vert";
			break;
			
		case ESSENCE :
			nomCarte = "Essence";
			break;
		
		case CREVAISON :
			nomCarte = "Roue de secours";
			break;
			
		case ACCIDENT :
			nomCarte = "Réparations";
			break;
	
		default:
			throw new IllegalArgumentException("Unexpected value: " + type );
			
		}
		return "Parade: " + nomCarte;
	}
}
