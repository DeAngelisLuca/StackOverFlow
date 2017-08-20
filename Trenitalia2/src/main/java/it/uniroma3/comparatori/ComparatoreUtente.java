package it.uniroma3.comparatori;

import java.util.Comparator;

import it.uniroma3.model.Utente;

public class ComparatoreUtente implements Comparator<Utente> {

	@Override
	public int compare(Utente u1, Utente u2) {
		int cmp = u1.getNome().compareTo(u2.getNome());
		if(cmp==0)
			cmp = u1.getEmail().compareTo(u2.getEmail());
		if(cmp==0)
			cmp = u1.getId().intValue()-u2.getId().intValue();
		return cmp;
	}

}
