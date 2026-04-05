package it.uniroma3.diadia.giocatore;


/**
 * 
 * classe che tiene traccia delle statistiche del
 * giocatore e gestisce le operazioni sugli attrezzi
 * 
 * @author Federico e Andrea
 * @see Partita
 * @version base
*/

public class Giocatore {
	
	static final private int CFU_INIZIALI = 20;
	
	private Borsa borsa;
	private int cfu;
	
	public Giocatore() {
		this.cfu = CFU_INIZIALI;
		this.borsa = new Borsa();
	}
	
	public int getCfu() {
		return this.cfu;
	}
	
	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}
	
	public Borsa getBorsa() {
		return this.borsa;
	}

}
