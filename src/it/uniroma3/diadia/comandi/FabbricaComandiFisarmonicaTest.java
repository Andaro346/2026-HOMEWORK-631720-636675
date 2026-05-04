package it.uniroma3.diadia.comandi;

import org.junit.*;
import static org.junit.Assert.*;

public class FabbricaComandiFisarmonicaTest {
	FabbricaComandiFisarmonica fab;
	Comando comando;
	
	@Before
	public void setUp() {
		fab = new FabbricaComandiFisarmonica();
	}
	
	@Test
	public void testComandoVai() {
	    comando = fab.costruisciComando("vai sud");
	    assertEquals("vai", comando.getNome());
	    assertEquals("sud", comando.getParametro());
	}
	
	@Test
	public void testComandoAiuto() {
	    comando = fab.costruisciComando("aiuto");
	    assertEquals("aiuto", comando.getNome());
	    assertNull(comando.getParametro());
	}

	@Test
	public void testComandoFine() {
	    comando = fab.costruisciComando("fine");
	    assertEquals("fine", comando.getNome());
	    assertNull(comando.getParametro());
	}

	@Test
	public void testComandoGuarda() {
	    comando = fab.costruisciComando("guarda");
	    assertEquals("guarda", comando.getNome());
	    assertNull(comando.getParametro());
	}

	@Test
	public void testComandoPosa() {
	    comando = fab.costruisciComando("posa lanterna");
	    assertEquals("posa", comando.getNome());
	    assertEquals("lanterna", comando.getParametro());
	}

	@Test
	public void testComandoPrendi() {
	    comando = fab.costruisciComando("prendi osso");
	    assertEquals("prendi", comando.getNome());
	    assertEquals("osso", comando.getParametro());
	}
	
	@Test
	public void testComandoNonValido() {
	    comando = fab.costruisciComando("aaaa aaaa");
	    assertEquals("non valido", comando.getNome());
	    assertNull(comando.getParametro());
	}
}
