package it.uniroma3.diadia;

public class IOSimulator implements IO{

	private String[] test;
	private String[] messaggi;
	private int messaggioCorrente = 0;
	private int istruzioneCorrente = 0;
	
	public IOSimulator(String[] comandi) {
		this.test = comandi;
		this.messaggi = new String[500];
	}
	
	@Override
	public void mostraMessaggio(String messaggio) {
		this.messaggi[messaggioCorrente++] = messaggio; 
	}

	@Override
	public String leggiRiga() {
		return test[istruzioneCorrente++];
	}
	
	public String[] getMessaggi() {
		return this.messaggi;
	}

}
