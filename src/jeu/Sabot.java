package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.*;

public class Sabot implements Iterable<Carte>{
	private Carte[] tabSabot;
	private int nbCartes = 0;
	private int maxNbCartes;
	private int nbOperations = 0;
	
	
	public Sabot(int maxNbCartes) {
		this.maxNbCartes = maxNbCartes;
		tabSabot = new Carte[maxNbCartes];
	}
	
	public Boolean estVide() {
		return nbCartes == 0;
	}
	
	private void ajouterCarte(Carte c) throws IllegalStateException {
		if (nbCartes == maxNbCartes) {
			throw new IllegalStateException("Le sabot est plein");
		} else {
			tabSabot[nbCartes] = c;
			nbCartes++;
		}
		nbOperations++;
	}
	
	public void ajouterFamilleCarte(Carte c) {
		for (int i = 0; i < c.getNombre(); i++) {
			ajouterCarte(c);
		}
	}
	
	public void ajouterFamilleCartes(Carte...cartes ) {
		for (int i = 0; i < cartes.length; i++) {
			ajouterFamilleCarte(cartes[i]);
		}
	}
	
	public Carte piocher() {
		Iterateur it = new Iterateur();
		Carte c = it.next();
		System.out.println("Carte piochee: " + c);
		it.remove();
		return c;
	}

	public int getNbCartes() {
		return nbCartes;
	}

	public int getMaxNbCartes() {
		return maxNbCartes;
	}

	@Override
	public Iterator<Carte> iterator() {
		return new Iterateur();
	}
	
	private class Iterateur implements Iterator<Carte> {
		private int indiceIterateur = 0;
		private boolean nextEffectue = false;
		private int nbOperationsReference = nbOperations;
		
		
		@Override
		public boolean hasNext( ) {
			return indiceIterateur < nbCartes;
		}

		@Override
		public Carte next() throws NoSuchElementException {
			verificationConcurrence();
			if(hasNext()) {
				Carte c = tabSabot[indiceIterateur];
				indiceIterateur++;
				nextEffectue = true;
				return c;
			} else {
				throw new NoSuchElementException();
			}
		}
		
		@Override
		public void remove() throws IllegalStateException {
			verificationConcurrence();
			if (nbCartes < 1 || !nextEffectue) {
				throw new IllegalStateException();
			}
			for (int i = indiceIterateur-1; i<nbCartes-1; i++) {
				tabSabot[i] = tabSabot[i+1];
			}
			nextEffectue = false;
			indiceIterateur--;
			nbCartes--;
			nbOperations++;
			nbOperationsReference++;
		}
		
		private void verificationConcurrence() throws ConcurrentModificationException {
			if (nbOperations != nbOperationsReference) {
				throw new ConcurrentModificationException();
			}
		}
		
		
		
		
	}

}




