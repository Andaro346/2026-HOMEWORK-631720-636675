package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {
	
	private Borsa borsaTest;
	private Attrezzo spadaTest_1;
	private Attrezzo spadaTest_2;

	@Before
	public void setUp() {
		borsaTest = new Borsa();
		spadaTest_1 = new Attrezzo("spada 1", 3);
		spadaTest_2 = new Attrezzo("spada 2", 0);
	}
	
	@Test
	public void testAggiungoUnAttrezzoAdUnaBorsaVuota() {
		assertTrue(borsaTest.addAttrezzo(spadaTest_1));
	}

	@Test
	public void testAggiungoUnAttrezzoAdUnaBorsaSuperandoIlPesoMax() {
		for(int i = 0; i<3; i++) {
			borsaTest.addAttrezzo(spadaTest_1);
		}
		assertFalse(borsaTest.addAttrezzo(spadaTest_1));
	}
	
	@Test
	public void testAggiungoUnAttrezzoAdUnaBorsaConNumeroMassimoDiItemRaggiunti() {
		for(int i = 0; i<10; i++) {
			borsaTest.addAttrezzo(spadaTest_2);
		}
		assertFalse(borsaTest.addAttrezzo(spadaTest_2));
	}
	
	@Test
	public void testOttengoUnAttrezzoPresente() {
		borsaTest.addAttrezzo(spadaTest_1);
		assertEquals(spadaTest_1, borsaTest.getAttrezzo("spada 1"));
	}
	
	@Test
	public void testOttengoUnAttrezzoNonPresente() {
		assertEquals(null, borsaTest.getAttrezzo("spada 1"));
	}
	
	@Test
	public void testVerificoCheIlPesoAttualeSiaCorrestto() {
		for(int i = 0; i<3; i++) {
			borsaTest.addAttrezzo(spadaTest_1);
		}
		assertEquals(9, borsaTest.getPeso());
	}
	
	@Test
	public void testCercoUnAttrezzoInUnaBorsaVuota() {
		assertFalse(borsaTest.hasAttrezzo("spada 1"));
	}
	
	@Test
	public void testCercoUnAttrezzoInUnaBorsaConAltriAttrezziMaSenzaQuelloCercato() {
		for(int i = 0; i<4; i++) {
			borsaTest.addAttrezzo(spadaTest_2);
		}
		assertFalse(borsaTest.hasAttrezzo("spada 1"));
	}
	
	@Test
	public void testCercoUnAttrezzoInUnaBorsaConAltriAttrezziTraCuiQuelloCercato() {
		for(int i = 0; i<4; i++) {
			borsaTest.addAttrezzo(spadaTest_2);
		}
		borsaTest.addAttrezzo(spadaTest_1);
		assertTrue(borsaTest.hasAttrezzo("spada 1"));
	}
	
	@Test
	public void testRimuovoUnAttrezzoDaUnaBorsaVuota() {
		assertEquals(null, borsaTest.removeAttrezzo("spada 1"));
	}
	
	@Test
	public void testRimuovoUnAttrezzoDaUnaBorsaNonVuotaMaSenzaAttrezzoCercato() {
		for(int i = 0; i<4; i++) {
			borsaTest.addAttrezzo(spadaTest_2);
		}
		assertEquals(null, borsaTest.removeAttrezzo("spada 1"));
	}
	
	@Test
	public void testRimuovoUnAttrezzoDaUnaBorsaNonVuotaMaConAttrezzoCercato() {
		borsaTest.addAttrezzo(spadaTest_1);
		for(int i = 0; i<4; i++) {
			borsaTest.addAttrezzo(spadaTest_2);
		}
		assertEquals(spadaTest_1, borsaTest.removeAttrezzo("spada 1"));
	}
	
	@Test
	public void testRimuovoUnAttrezzoDaUnaBorsaCompletamentePienaConAttrezzoCercato() {
		borsaTest.addAttrezzo(spadaTest_1);
		for(int i = 0; i<9; i++) {
			borsaTest.addAttrezzo(spadaTest_2);
		}
		assertEquals(spadaTest_1, borsaTest.removeAttrezzo("spada 1"));
	}
	
}
