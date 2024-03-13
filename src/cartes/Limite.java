package cartes;

public abstract class Limite extends Carte {

	protected Limite(int nombre) {
		super(nombre);
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
