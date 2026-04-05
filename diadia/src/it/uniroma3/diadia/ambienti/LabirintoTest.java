package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LabirintoTest {
	
	private Labirinto mappaTest;
	private Stanza stanzaTest;
	
	@Before
	public void setUp() {
		mappaTest = new Labirinto();
		stanzaTest = new Stanza("aula");
	}
	
	@Test
	public void testRichiedoLaStanzaVincente() {
		assertEquals("Biblioteca", mappaTest.getStanzaVincente().getNome());
	}
	
	@Test
	public void testRichiedoStanzaCorrente() {
		assertEquals("Atrio", mappaTest.getStanzaCorrente().getNome());
	}
	
	@Test
	public void testRichiedoStanzaCorrenteDopoAverlaCambiata() {
		mappaTest.setStanzaCorrente(stanzaTest);
		assertEquals("aula", mappaTest.getStanzaCorrente().getNome());
	}

}
