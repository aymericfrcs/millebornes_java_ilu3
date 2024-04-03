package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class Utils {

	
	public static <T> T extraire(List<T> liste) {
		if (liste.isEmpty()) {
			return null;
		}
		
		Random r = new Random();
		int numElt = r.nextInt(liste.size());
		
		T element = liste.remove(numElt);
		
		return element;
	}
	
	public static <T> T extraireWIterator(List<T> liste) {
		if (liste.isEmpty()) {
			return null;
		}
		
		Random r = new Random();
		int numElt = r.nextInt(liste.size());
		T element = liste.get(0);		
		ListIterator<T> it = liste.listIterator();
		
		for (int i=0; i<numElt; i++) {
			element = it.next();
		}
		it.remove();
		
		return element;
	}
	
	public static <T> List<T> melanger(List<T> liste) {
		List<T> lResult = new ArrayList<>();
		while (!liste.isEmpty()) {
			T elt = extraire(liste);
			lResult.add(elt);
		}
		
		return lResult;
	}
	
	public static <T> boolean verifierMelange(List<T> l1, List<T> l2) {
		for (T t : l1) {
			if (Collections.frequency(l1, t) != Collections.frequency(l2, t)) {
				System.out.println(Collections.frequency(l1, t));
				System.out.println(Collections.frequency(l2, t));
				return false;
			}
		}
		return true;
	}
	
	
	
	public static <T> List<T> rassembler(List<T> liste) {
		List<T> lResult = new ArrayList<>();
		List<T> lCopie = new ArrayList<>();
		for (T t : liste) {
			lCopie.add(t);
		}
		
		while (!lCopie.isEmpty()) {
			T elem = lCopie.get(0);
			while (lCopie.indexOf(elem) != -1) {
				lResult.add(elem);
				lCopie.remove(elem);
			}
		}
		
		return lResult;
	}
	
	public static <T> boolean verifierRassemblement(List<T> liste) {
		ListIterator<T> it = liste.listIterator();
		T elem = it.next();
		while (it.hasNext()) {
			T elemPrev = elem;
			elem = it.next();
			
			if (!elem.equals(elemPrev)) {
				ListIterator<T> it2 = liste.listIterator(it.nextIndex());
				
				while (it2.hasNext()) {
					if (it2.next().equals(elemPrev)) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	
	
	
	
	
	
	
	
	
}
