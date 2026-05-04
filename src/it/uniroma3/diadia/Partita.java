package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	private Labirinto mappa;
	private Giocatore studente;
	private Stanza stanzaCorrente;
	private boolean finita;
	
	public Partita(){
		mappa = new Labirinto();
		studente = new Giocatore();
		this.finita = false;
		stanzaCorrente = mappa.getStanzaIniziale();
	}

	public Giocatore getGiocatore() {
		return studente;
	}
	
	public Stanza getStanzaVincente() {
		return mappa.getStanzaVincente();
	}
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return getStanzaCorrente() == mappa.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (studente.getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}

	public int getCfu() {
		return studente.getCfu();
	}

	public void setCfu(int cfu) {
		studente.setCfu(cfu);;		
	}	
	
	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}
	 
	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
}
