package it.uniroma3.diadia.comandi;

import java.util.Scanner;

public class FabbricaComandiFisarmonica {
	String nome = null;
	String parametro = null;
	Comando comando = null;
	
	public Comando costruisciComando(String istruzione) {

		Scanner scannerDiParole = new Scanner(istruzione);
		
		// prima parola: nome del comando
		if (scannerDiParole.hasNext())
			nome = scannerDiParole.next(); 

		// seconda parola: eventuale parametro
		if (scannerDiParole.hasNext())
			parametro = scannerDiParole.next();

		if (nome == null) {
			comando = new ComandoNonValido();
		} else if ("fine".equals(nome)) {
			comando = new ComandoFine(); 
		} else if ("vai".equals(nome)) {
			comando = new ComandoVai();
		}else if ("aiuto".equals(nome)) {
			comando = new ComandoAiuto();
		} else if ("prendi".equals(nome)) {
			comando = new ComandoPrendi();
		} else if ("posa".equals(nome)) {
			comando = new ComandoPosa();
		} else if ("guarda".equals(nome)) {
			comando = new ComandoGuarda();
		}else {
			comando = new ComandoNonValido();
		}
		comando.setParametro(parametro);
		return comando;
	}
}
