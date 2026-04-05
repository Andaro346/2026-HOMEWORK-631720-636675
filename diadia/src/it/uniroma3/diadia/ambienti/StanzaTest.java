package it.uniroma3.diadia.ambienti;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {
	
	private Stanza stanzaTest;
	private Stanza stanzaAdiacenteTest;
	private Attrezzo spadaTest;
	
	@Before
	public void setUp() {
		stanzaTest = new Stanza("aula");
		stanzaAdiacenteTest = new Stanza("aula adiacente");	
		spadaTest = new Attrezzo("spada", 4);
	}
	

	@Test
	public void testImpostoUnaStanzaAdiacenteAdUNaStanzaConTutteLeDirezioniOccupate() {
		for(int i = 0; i<4; i++) {
			stanzaTest.impostaStanzaAdiacente("direzione" + i, stanzaAdiacenteTest);
		}
		stanzaTest.impostaStanzaAdiacente("direzione extra", stanzaAdiacenteTest);
		assertNull(stanzaTest.getStanzaAdiacente("direzione extra"));
	}
	
	@Test
	public void testRichiedoUnaStanzaAdiacenteEsistente() {
		stanzaTest.impostaStanzaAdiacente("nord", stanzaAdiacenteTest);
		assertEquals(stanzaAdiacenteTest, stanzaTest.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testRichiedoUnaStanzaAdiacenteNonEsistente() {
		assertNull(stanzaTest.getStanzaAdiacente("sud"));
	}
	
	@Test
	public void testRichiedoUnaStanzaInUnaDirezioneNonEsistente() {
		assertNull(stanzaTest.getStanzaAdiacente("Palermo"));
	}
	
	@Test
	public void testCercoUnAttrezzoPresente() {
		stanzaTest.addAttrezzo(spadaTest);
		assertTrue(stanzaTest.hasAttrezzo("spada"));
	}
	
	@Test
	public void testCercoUnAttrezzoNonPresente() {
		assertFalse(stanzaTest.hasAttrezzo("spada"));
	}
	
	@Test
	public void testRichiedoUnAttrezzo() {
		stanzaTest.addAttrezzo(spadaTest);
		assertEquals(spadaTest, stanzaTest.getAttrezzo("spada"));
	}
	
	@Test
	public void testRimuovoUnAttrezzoPresente() {
		stanzaTest.addAttrezzo(spadaTest);
		assertTrue(stanzaTest.removeAttrezzo(spadaTest));
	}
	
	@Test
	public void testRimuovoUnAttrezzoNonPresente() {
		assertFalse(stanzaTest.removeAttrezzo(spadaTest));
	}
	
	@Test
	public void testAggiungoUnAttrezzoAdUnaStanzaVuota() {
		assertTrue(stanzaTest.addAttrezzo(spadaTest));
	}
	
	@Test
	public void testAggiungoUnAttrezzoAdUnaStanzaConUnAttrezzo() {
		stanzaTest.addAttrezzo(spadaTest);
		assertTrue(stanzaTest.addAttrezzo(spadaTest));
	}
	
	@Test
	public void testAggiungoUnAttrezzoAdUnaStanzaConNumeroMassimoDiItemRaggiunti() {
		for(int i = 0; i<10; i++) {
			stanzaTest.addAttrezzo(spadaTest);
		}
		assertFalse(stanzaTest.addAttrezzo(spadaTest));
	}
	@Test
	public void testRichiedoIlNome() {
		assertEquals("aula", stanzaTest.getNome());
	}	
	
	@Test
	public void testRichiedoNomeStanzaAdiacente() {
		stanzaTest.impostaStanzaAdiacente("sud", stanzaAdiacenteTest);
		assertEquals("aula adiacente", stanzaTest.getStanzaAdiacente("sud").getNome());
	}
	
}
