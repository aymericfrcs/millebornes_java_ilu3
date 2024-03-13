package cartes;

public class Borne extends Carte {
	
	private int km;

	public Borne(int nombre, int km) {
		super(nombre);
		this.km = km;
	}

	@Override
	public String toString() {
		return "Borne de " + km + " km";
	}

	public int getKm() {
		return km;
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
