package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;



public class StanzaBloccataTest {

	private Stanza stanzaTest;
	private Stanza stanzaAdiacenteTest;
	private Attrezzo piedeDiPorco;
	
	@Before
	public void setUp() {
		stanzaTest = new StanzaBloccata("aula", "nord", "piede di porco");
		stanzaAdiacenteTest = new Stanza("aula adiacente");
		stanzaTest.impostaStanzaAdiacente("nord", stanzaAdiacenteTest);
		piedeDiPorco = new Attrezzo("piede di porco", 4);
	}
	
	@Test
	public void testTentoDiAndareNordSenzaAttrezzo() {
		assertEquals(this.stanzaTest, stanzaTest.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testTentoDiAndareNordConAttrezzo() {
		stanzaTest.addAttrezzo(piedeDiPorco);
		assertEquals(this.stanzaAdiacenteTest, stanzaTest.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testTentoDiAndareNordConMettoLevoAttrezzo() {
		stanzaTest.addAttrezzo(piedeDiPorco);
		stanzaTest.removeAttrezzo(piedeDiPorco);
		assertEquals(this.stanzaTest, stanzaTest.getStanzaAdiacente("nord"));
	}

}
