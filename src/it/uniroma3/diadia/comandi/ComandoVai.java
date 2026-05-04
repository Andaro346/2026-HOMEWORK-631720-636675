package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando{

	private IO io;
	private String direzione;
	
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza prossimaStanza = null;
		if (this.direzione==null) {
			io.mostraMessaggio("Dove vuoi andare? Devi specificare una direzione valida");
			return;
		}
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);
		if (prossimaStanza==null) {
			io.mostraMessaggio("Direzione inesistente");
			return;
		}
		partita.setStanzaCorrente(prossimaStanza);
		partita.setCfu(partita.getCfu() - 1);
		io.mostraMessaggio("cfu = " + partita.getCfu());
        io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}
	
	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;
	}
	
	public String getNome() {
		return "vai";
	}
	
	public String getParametro() {
		return this.direzione;
	}
	
	public void setIO(IO io) {
		this.io = io;
	}
}
