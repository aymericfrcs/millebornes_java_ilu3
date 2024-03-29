package cartes;

public abstract class Probleme extends Carte {
	
	public enum Type {FEU, ESSENCE, CREVAISON, ACCIDENT}
	private Type type;
	
	protected Probleme(int nombre, Type t) {
		super(nombre);
		this.type = t;
	}

	public Type getType() {
		return type;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj.getClass() == getClass()) {
			Carte c = (Carte)obj;
			return toString().equals(c.toString()); 
		}
		return false;
			
	}

}
