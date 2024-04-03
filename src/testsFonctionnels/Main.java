package testsFonctionnels;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

import cartes.*;
import cartes.Probleme.Type;
import jeu.Sabot;
import utils.Utils;

public class Main {
	

	/*public static void main_test_tp1(String[] argv) {
		System.out.println("Creation Sabot");
		Sabot sab = new Sabot(50);
		
		Carte accident = new Attaque(3, Type.ACCIDENT);
		Carte reparation = new Parade(3, Type.ACCIDENT);
		Carte asDuVolant = new Botte(1, Type.ACCIDENT);
		
		
		sab.ajouterFamilleCartes(accident, reparation, asDuVolant);
		System.out.println("Cartes ajoutees");
		
		/* (2.a) while (sab.getNbCartes() > 0) {
			sab.piocher();
		}*/
		
		//Iterator<Carte> it = sab.iterator();
		
		 /*(2.b) while(sab.getNbCartes() > 0) {
			Carte c = it.next();
			System.out.println("Je pioche " + c);
			it.remove();
		}*/
		
		/*while(sab.getNbCartes() > 0) {
			Carte c = it.next();
			System.out.println("Je pioche " + c);
			it.remove();
			sab.piocher();
			sab.ajouterFamilleCarte(asDuVolant);
		}
	}*/
		
		public static void main_test_tp1_2(String[] argv) {
			//test methode equals
			Sabot sab = new Sabot(50);
			Carte accident = new Attaque(2, Type.ACCIDENT);
			Carte reparation = new Parade(1, Type.ACCIDENT);
			Carte asDuVolant = new Botte(1, Type.ACCIDENT);
			
			sab.ajouterFamilleCartes(accident, reparation, asDuVolant);
			System.out.println("Cartes ajoutees");
			
			Carte c1 = sab.piocher();
			Carte c2 = sab.piocher();
			sab.piocher();
			Carte c3 = sab.piocher();
			
			
			System.out.println("C1: " + c1.toString() + " = C2: " + c2.toString() + " ? " + c1.equals(c2));
			System.out.println("C1: " + c1.toString() + " = C3: " + c3.toString() + " ? " + c1.equals(c3));
			
			Carte limite50 = new DebutLimite(1);
			Carte finLimite50 = new FinLimite(1);
			
			sab.ajouterFamilleCartes(limite50, finLimite50);
			
			Carte c4 = sab.piocher();
			Carte c5 = sab.piocher();
			
			System.out.println("C4: " + c4.toString() + " = C5: " + c5.toString() + " ? " + c4.equals(c5));
			
		}
		
		/*public static void main(String[] args) {
			JeuDeCartes jeu = new JeuDeCartes();
			List<Carte> lCartes = jeu.getListeCartes();
			
			for (Carte carte : lCartes) {
				//System.out.println(carte.toString());
			}
			
			System.out.println(jeu.checkCount()); //true
			
			Iterator<Carte> iter = lCartes.iterator();
			iter.next();
			iter.remove(); //on enlève la deuxième carte de lCartes

			
			System.out.println(jeu.checkCount()); //false
			
			//System.out.println(Utils.extraire(lCartes));
			
			ArrayList<Carte> lCartesMelangee = (ArrayList<Carte>) Utils.melanger(lCartes);
			
			for (Carte carte : lCartesMelangee) { //affichage de la liste melangee
				System.out.println(carte.toString());
			}
			
			System.out.println(Utils.verifierMelange(lCartes, lCartesMelangee));
			
		}*/
		
		public static void main(String[] args) {
			List<Integer> l1 = new ArrayList<>();
			List<Integer> l2 = new ArrayList<>();
			l1.add(1);
			l1.add(2);
			l1.add(3);
			l1.add(4);
			Utils.extraire(l1);
			System.out.println(l1);
			l2 = Utils.melanger(l1);
			System.out.println(l2);
			
			
			
			
			JeuDeCartes jeu = new JeuDeCartes();
			List<Carte> listeCarteNonMelangee = jeu.getListeCartes();
			List<Carte> listeCartes = new ArrayList<>(listeCarteNonMelangee);
			System.out.println(listeCartes);
			listeCartes = Utils.melanger(listeCartes);
			System.out.println(listeCartes);
			System.out.println("liste mélangée sans erreur ? "
			+ Utils.verifierMelange(listeCarteNonMelangee, listeCartes));
			listeCartes = Utils.rassembler(listeCartes);
			System.out.println(listeCartes);
			System.out.println("liste rassemblée sans erreur ? " + Utils.verifierRassemblement(listeCartes));

		}
	
	

}
