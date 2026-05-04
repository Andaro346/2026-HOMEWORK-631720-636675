package it.uniroma3.diadia.comandi;
import org.junit.*;
import static org.junit.Assert.*;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;


public class ComandoPosaTest {

	private Partita partitaTest;
	private ComandoPosa comando;
	private Stanza stanza1;
	private Attrezzo Telefono = new Attrezzo("Telefono", 5);
	
	@Before
	public void setUp() {
		partitaTest = new Partita();
		stanza1 = new Stanza("Prima");
		partitaTest.getGiocatore().getBorsa().addAttrezzo(Telefono);
		partitaTest.setStanzaCorrente(stanza1);
		comando = new ComandoPosa();
	}
	
	
	@Test
	public void testPosoAttrezzoNellaStanza() {
		comando.setParametro("Telefono");
		comando.esegui(partitaTest);
		assertTrue(stanza1.hasAttrezzo("Telefono"));
	}
	
	@Test
	public void testSePosoAttrezzoNonCeNellaBorsa() {
		comando.setParametro("Telefono");
		comando.esegui(partitaTest);
		assertNull(partitaTest.getGiocatore().getBorsa().getAttrezzo("Telefono"));
	}
}
