package it.uniroma3.diadia.comandi;
import org.junit.*;
import static org.junit.Assert.*;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;


public class ComandoVaiTest {

	private Partita partitaTest;
	private ComandoVai comando;
	private Stanza stanza1;
	private Stanza stanza2;
	
	@Before
	public void setUp() {
		partitaTest = new Partita();
		stanza1 = new Stanza("Prima");
		stanza2 = new Stanza("Seconda");
		stanza1.impostaStanzaAdiacente("sud", stanza2);
		stanza2.impostaStanzaAdiacente("nord", stanza1);
		partitaTest.setStanzaCorrente(stanza1);
		comando = new ComandoVai();
		comando.setIO(new IOConsole());
	}
	
	
	@Test
	public void testCambiamentoNulloRimaneNellaStessaStanza() {
		comando.setParametro(null);
		comando.esegui(partitaTest);
		assertEquals(stanza1, partitaTest.getStanzaCorrente());
	}
	
	@Test 
	public void testCambioStanza() {
		comando.setParametro("sud");
		comando.esegui(partitaTest);
		assertEquals(stanza2, partitaTest.getStanzaCorrente());
	}
	
	@Test
	public void testCambioERicambioStanza() {
		comando.setParametro("sud");
		comando.esegui(partitaTest);
		comando.setParametro("nord");
		comando.esegui(partitaTest);
		assertEquals(stanza1, partitaTest.getStanzaCorrente());
	}
	
	@Test
	public void testDirezioneInesistente() {
		comando.setParametro("ovest");
		comando.esegui(partitaTest);
		assertEquals(stanza1, partitaTest.getStanzaCorrente());
	}
}
