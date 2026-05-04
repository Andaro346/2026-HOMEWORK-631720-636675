package it.uniroma3.diadia.comandi;
import org.junit.*;
import static org.junit.Assert.*;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;


public class ComandoPrendiTest {

	private Partita partitaTest;
	private ComandoPrendi comando;
	private Stanza stanza1;
	private Attrezzo Telefono = new Attrezzo("Telefono", 5);
	
	@Before
	public void setUp() {
		partitaTest = new Partita();
		stanza1 = new Stanza("Prima");
		stanza1.addAttrezzo(Telefono);
		partitaTest.setStanzaCorrente(stanza1);
		comando = new ComandoPrendi();
	}
	
	@Test
	public void testPrendoETrovoInBorsa() {
		comando.setParametro("Telefono");
		comando.esegui(partitaTest);
		assertEquals(Telefono, partitaTest.getGiocatore().getBorsa().getAttrezzo("Telefono"));
	}
	
	@Test
	public void testPrendoENonTrovoPiuInStanza() {
		comando.setParametro("Telefono");
		comando.esegui(partitaTest);
		assertNull(stanza1.getAttrezzo("Telefono"));
	}
	
}
