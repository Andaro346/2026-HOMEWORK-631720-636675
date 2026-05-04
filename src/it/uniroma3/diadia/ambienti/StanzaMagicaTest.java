package it.uniroma3.diadia.ambienti;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaTest {
	
	private StanzaMagica stanzaTest;
	private Attrezzo spadaTest;
	
	@Before
	public void setUp() {
		stanzaTest = new StanzaMagica("aula", 1);	
		spadaTest = new Attrezzo("spada", 4);
	}
	

	@Test
	public void testSuperoNumeroMassimoPosare() {
		stanzaTest.addAttrezzo(spadaTest);
		stanzaTest.removeAttrezzo(spadaTest);
		stanzaTest.addAttrezzo(spadaTest);
		assertEquals("adaps", stanzaTest.getAttrezzo("adaps").getNome());
	}
	
	@Test
	public void testNonSuperoNumeroMassimoPosare() {
		stanzaTest.addAttrezzo(spadaTest);
		assertNull(stanzaTest.getAttrezzo("adaps"));
	}
}
