package it.uniroma3.diadia;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class PartitaTest {
	
	private Partita partitaTest;
	private Stanza stanzaTest;
	private Attrezzo spadaTest;
	
	@Before
	public void setUp() {
		partitaTest = new Partita();
		stanzaTest = new Stanza("aula");
		spadaTest = new Attrezzo("spada", 1);

	}

	@Test
	public void testRichiedoStanzaVincente() {
		assertEquals("Biblioteca", partitaTest.getStanzaVincente().getNome());
	}
	
	@Test
	public void testRichiedoStanzaCorrente() {
		assertEquals("Atrio", partitaTest.getStanzaCorrente().getNome());
	}
	
	@Test
	public void testRichiedoStanzaCorrenteDopoAverlaCambiata() {
		partitaTest.setStanzaCorrente(stanzaTest);
		assertEquals("aula", partitaTest.getStanzaCorrente().getNome());
	}

	@Test
	public void testVerificoSeHoVintoLaPartitaSenzaStareNellaStanzaVincente() {
		partitaTest.setStanzaCorrente(stanzaTest);
		assertFalse(partitaTest.vinta());
	}
	
	@Test
	public void testVerificoSeHoVintoLaPartitaStandoNellaStanzaVincente() {
		partitaTest.setStanzaCorrente(partitaTest.getStanzaVincente());
		assertTrue(partitaTest.vinta());
	}
	
	@Test
	public void testControlloSeFinitaDuranteLaPartita() {
		assertFalse(partitaTest.isFinita());
	}
	
	@Test
	public void testControlloSeFinitaCon0CFU() {
		partitaTest.setCfu(0);
		assertTrue(partitaTest.isFinita());
	}

	@Test
	public void testControlloSeFinitaQuandoHoVinto() {
		partitaTest.setStanzaCorrente(partitaTest.getStanzaVincente());
		assertTrue(partitaTest.isFinita());
	}
	
	@Test
	public void testRimuovoUnAttrezzoDaUnaStanzaCompletamentePienaConAttrezzoCercato() {
		stanzaTest.addAttrezzo(spadaTest);
		for(int i = 0; i<9; i++) {
			stanzaTest.addAttrezzo(spadaTest);
		}
		assertTrue(stanzaTest.removeAttrezzo(spadaTest));
	}
}
