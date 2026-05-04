package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Test;

public class IOSimulatorTest {

	private IOSimulator IO;
	private DiaDia gioco;
	
	@Test
	public void testVinco() {
		String[] comandi = {"vai nord"};
		IO = new IOSimulator(comandi);
		gioco = new DiaDia(IO);
		gioco.gioca();
		int i = 0;
		for(String messaggi : IO.getMessaggi()) {
			if(messaggi != null) {
				i++;
			}
		}
		assertTrue(IO.getMessaggi()[i - 1].equals("Hai vinto!"));
	}
	
	@Test
	public void tesFiniscoCFU() {
		String[] comandi = {
			    "vai sud",
			    "vai est",
			    "vai est",
			    "vai ovest",
			    "vai ovest",
			    "vai sud",
			    "vai est",
			    "vai ovest",
			    "vai est",
			    "vai ovest",
			    "vai est",
			    "vai ovest",
			    "vai est",
			    "vai ovest",
			    "vai est",
			    "vai ovest",
			    "vai est",
			    "vai ovest",
			    "vai est",
			    "vai ovest"
			};
		IO = new IOSimulator(comandi);
		gioco = new DiaDia(IO);
		gioco.gioca();
		int i = 0;
		for(String messaggi : IO.getMessaggi()) {
			if(messaggi != null) {
				i++;
			}
		}
		assertTrue(IO.getMessaggi()[i - 1].equals("Hai perso :("));
	}

}
