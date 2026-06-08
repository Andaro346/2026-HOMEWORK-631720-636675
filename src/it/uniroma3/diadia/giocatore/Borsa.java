package it.uniroma3.diadia.giocatore;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import it.uniroma3.diadia.ComparatorePesoNome;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Questa classe modella l'inventario del giocatore
 *
 * @author Federico e Andrea
 * @see Giocatore
 * @version base
 */

public class Borsa {

	public final static int DEFAULT_PESO_MAX_BORSA = 10;

	//private Attrezzo[] attrezzi;
	private List<Attrezzo> attrezzi;
	//private int numeroAttrezzi;
	private int pesoMax;

	public Borsa() {
		this.pesoMax = DEFAULT_PESO_MAX_BORSA;
		this.attrezzi = new ArrayList<>();
		//this.numeroAttrezzi = 0;
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new ArrayList<>();
		//this.numeroAttrezzi = 0;
	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		this.attrezzi.add(attrezzo);
		//QUI DA SISTEMARE
		//if (this.numeroAttrezzi == 10)
		//return false;
		//this.attrezzi[this.numeroAttrezzi] = attrezzo;
		//this.numeroAttrezzi++;
		return true;
	}

	public int getPesoMax() {
		return pesoMax;
	}

	public Attrezzo getAttrezzo(String wanted) {
		for (Attrezzo a : this.attrezzi) {
			if (a.getNome().equals(wanted)) return a;
		}
		//for (int i = 0; i < this.numeroAttrezzi; i++)
		//if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
		//a = attrezzi[i];

		return null;
	}

	public int getPeso() {
		int peso = 0;
		for (Attrezzo a : this.attrezzi)
			peso += a.getPeso();

		return peso;
	}

	public boolean isEmpty() {
		return this.attrezzi.isEmpty();
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo) != null;
	}

	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		int index = this.attrezzi.indexOf(new Attrezzo(nomeAttrezzo, 0));
		if (index != -1) {
			//trovato
			this.attrezzi.remove(index);
		}
		return null;
	}
	
	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		ComparatorePesoNome perPeso = new ComparatorePesoNome();
		final List<Attrezzo> inOrdine = new ArrayList<>(this.attrezzi);
		Collections.sort(inOrdine, perPeso); 
		return inOrdine;
	}
	
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		final SortedSet<Attrezzo> inOrdine = new TreeSet<>(this.attrezzi);
		inOrdine.addAll(this.attrezzi);
		return inOrdine;
	}
	
	public Map<Integer, Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		final Map<Integer, Set<Attrezzo>> peso2attrezzi = new HashMap<>();
		for (Attrezzo corrente : this.attrezzi) {
			if (peso2attrezzi.containsKey(corrente.getPeso())) {
				//corrente ha un peso già visto prima
				Set<Attrezzo> vecchioInsiemePerAttrezziDiPesoGiaVistoPrima = peso2attrezzi.get(corrente.getPeso());
				vecchioInsiemePerAttrezziDiPesoGiaVistoPrima.add(corrente);
			}else {
				//corrente ha un peso mai visto prima
				final Set<Attrezzo> nuovoInsiemePerAttrezziDiPesoMaiVistoPrima = new HashSet<Attrezzo>();
				nuovoInsiemePerAttrezziDiPesoMaiVistoPrima.add(corrente);
				peso2attrezzi.put(corrente.getPeso(), nuovoInsiemePerAttrezziDiPesoMaiVistoPrima);
			}
		}
		return peso2attrezzi;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa (" + this.getPeso() + "kg/" + this.getPesoMax() + "kg): ");
			Iterator<Attrezzo> it = this.attrezzi.iterator();
			while (it.hasNext())
				s.append(it.next() + " ");
		} else
			s.append("Borsa vuota");
		return s.toString();
	}
}
