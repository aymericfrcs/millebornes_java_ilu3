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
			nomCarte = "R�parations";
			break;
	
		default:
			throw new IllegalArgumentException("Unexpected value: " + type );
			
		}
		return "Parade: " + nomCarte;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj.getClass() == getClass()) {
			Carte c = (Carte)obj;
			return toString().equals(c.toString()); //pas sur pour celle la
		}
		return false;
			
	}
}
