package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza{
	
	private String attrezzoNecessario;
	
	public StanzaBuia(String nome, String attrezzo) {
		super(nome);
		this.attrezzoNecessario = attrezzo; 
	}
	
	@Override
	public String getDescrizione() {
		String buio = "qui c'è un buio pesto";
		if(this.hasAttrezzo(attrezzoNecessario)) {
			return super.getDescrizione();
		}
		else
			return buio;
	}
}
