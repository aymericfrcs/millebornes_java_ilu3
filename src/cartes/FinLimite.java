package cartes;

public class FinLimite extends Limite {

	
	public FinLimite(int nombre) {
		super(nombre);

	}
	
	@Override
	public String toString() {
		return "Fin de limite de vitesse à " + getNombre() + " km/h";
	}


}
