package it.uniroma3.diadia;


import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai", "prendi", "posa", "aiuto", "fine"};

	private Partita partita;
	private IOConsole io = new IOConsole();
	
	public DiaDia() {
		this.partita = new Partita();
	}

	public void gioca() {
		String istruzione; 

		io.mostraMessaggio(MESSAGGIO_BENVENUTO);	
		do
			istruzione = io.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);

		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine();
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else if (comandoDaEseguire.getNome().equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("posa"))
			this.posa(comandoDaEseguire.getParametro());
		else
			io.mostraMessaggio("Comando sconosciuto");
		if (this.partita.vinta()) {
			io.mostraMessaggio("Hai vinto!");
			return true;
		} else if(partita.isFinita()){
			io.mostraMessaggio("Hai perso :(");
			return true;
		} else
			return false;
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i = 0; i < elencoComandi.length; i++) 
			io.mostraMessaggio(elencoComandi[i]+" ");
		io.mostraMessaggio("");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione == null) // senza dare direzione
			io.mostraMessaggio("Dove vuoi andare?");
		Stanza prossimaStanza = null; //ottiene la prossima stanza
		prossimaStanza = this.partita.getMappa().getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			io.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.getMappa().setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getCfu();
			cfu--;
			this.partita.setCfu(cfu); // errore perché prima da i cfu e poi li decrementa
			io.mostraMessaggio("cfu = " + this.partita.getCfu());
		}
		io.mostraMessaggio(partita.getMappa().getStanzaCorrente().getDescrizione());
	}
	
	/**
	 * prende un attrezzo da una stanza e lo ripone
	 * nella borsa del giocatore
	 */
	private void prendi(String nomeAttrezzo) {
		boolean borsaLibera;
		if(this.partita.getGiocatore().getBorsa().getPeso() <= this.partita.getGiocatore().getBorsa().getPesoMax()) {
			if(this.partita.getMappa().getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {
				Attrezzo a = this.partita.getMappa().getStanzaCorrente().getAttrezzo(nomeAttrezzo);
				this.partita.getMappa().getStanzaCorrente().removeAttrezzo(a);
				borsaLibera = this.partita.getGiocatore().getBorsa().addAttrezzo(a);
				if(borsaLibera)
					io.mostraMessaggio(nomeAttrezzo + " messa in borsa");
				else
					io.mostraMessaggio("La borsa è già piena");
			}	
			else
				io.mostraMessaggio(nomeAttrezzo + " non trovato in " + this.partita.getMappa().getStanzaCorrente());
		}
		else
			io.mostraMessaggio("La borsa è troppo pesante!");
	}
	
	/**
	 * prende un attrezzo dalla borse del giovatore
	 *  e lo ripone nella stanza
	 */
	private void posa(String nomeAttrezzo) {
		boolean stanzaLibera;
		if(this.partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
			Attrezzo a = this.partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
			this.partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
			stanzaLibera = this.partita.getMappa().getStanzaCorrente().addAttrezzo(a);
			if(stanzaLibera)
				io.mostraMessaggio(nomeAttrezzo + " posato in " + this.partita.getMappa().getStanzaCorrente());
			else
				io.mostraMessaggio("Non c'è posto in questa stanza");
		}
		else
			io.mostraMessaggio(nomeAttrezzo + " non presente nella borsa");
	}
	
	/**
	 * Comando "Fine".
	 */
	private void fine() {
		io.mostraMessaggio("Grazie di aver giocato!");
	}

	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
}