package cartes;

public class DebutLimite extends Limite {

	public DebutLimite(int nombre) {
		super(nombre);
	}

	@Override
	public String toString() {
		return "D�but de limite de vitesse � " + getNombre() + " km/h";
	}

}
