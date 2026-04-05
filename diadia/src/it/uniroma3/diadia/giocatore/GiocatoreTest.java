package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GiocatoreTest {

	private Giocatore playerTest;
	
	@Before
	public void setUp() {
		playerTest = new Giocatore();
	}
	
	@Test
	public void testControlloCFUadInizioGioco() {
		assertEquals(20, playerTest.getCfu());
	}
	
	@Test
	public void testControlloChiCFUvenganoAggiornati() {
		playerTest.setCfu(7);
		assertEquals(7, playerTest.getCfu());
	}
}
