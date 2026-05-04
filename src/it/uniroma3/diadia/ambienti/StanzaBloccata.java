package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {

	private String direzioneBloccata;
	private String attrezzoNecessario;
	
	public StanzaBloccata(String nome, String direzione, String attrezzo) {
		super(nome);
		this.attrezzoNecessario = attrezzo;
		this.direzioneBloccata = direzione;
	}
	
	@Override
	public String getDescrizione() {
		String parteClassica = super.getDescrizione();
		StringBuilder risultato = new StringBuilder();
		risultato.append(parteClassica);
		risultato.append("\nDirezione bloccata: " + direzioneBloccata);
		risultato.append("\nAttrezzo per aprire: " + attrezzoNecessario);
		return risultato.toString();
	}
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(direzione.equals(direzioneBloccata) && !hasAttrezzo(attrezzoNecessario)) {
			return this;
		}
		return super.getStanzaAdiacente(direzione);
	}
	
}
