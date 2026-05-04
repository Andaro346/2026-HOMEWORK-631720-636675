package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.attrezzi.Attrezzo;


import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class StanzaBuiaTest {

	private Stanza stanzaTest;
	private Attrezzo lanterna;
	
	@Before
	public void setUp() {
		stanzaTest = new StanzaBuia("aula", "lanterna");	
		lanterna = new Attrezzo("lanterna", 4);
	}
	
	@Test
	public void testChiedoLaDescrizioneSenzaLanterna() {
		assertTrue(stanzaTest.getDescrizione().equals("qui c'è un buio pesto"));
	}
	
	@Test
	public void testChiedoLaDescrizioneConLanterna() {
		stanzaTest.addAttrezzo(lanterna);
		assertFalse(stanzaTest.getDescrizione().equals("qui c'è un buio pesto"));
	}

	@Test
	public void testChiedoLaDescrizioneMettoLevoLaLanterna() {
		stanzaTest.addAttrezzo(lanterna);
		stanzaTest.removeAttrezzo(lanterna);
		assertTrue(stanzaTest.getDescrizione().equals("qui c'è un buio pesto"));
	}
	
}
