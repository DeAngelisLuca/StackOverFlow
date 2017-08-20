package it.uniroma3.comparatori;
import java.util.Comparator;

import it.uniroma3.model.*;
  
public class ComparatoreDipendente implements Comparator<Dipendente> {

	@Override
	public int compare(Dipendente d1, Dipendente d2) {
		int cmp = d1.getCognome().compareTo(d2.getCognome());
		if(cmp==0)
			cmp = d1.getNome().compareTo(d2.getNome());
		if(cmp==0)
			cmp = d1.getCid()-d2.getCid();
		if(cmp==0)
			cmp = d1.getId().intValue()-d2.getId().intValue();
		return cmp;
	}
	

}
