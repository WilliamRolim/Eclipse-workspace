package br.ce.wcaquino.servicos;

import br.ce.wcaquino.exceptions.SemDivisaoPorZero;

public class Calculadora {

	public int somar (int a, int b) {
		int result = a + b;
		return result;
	}

	public int subtrair(int a, int b) {
		int result = a - b;
		return result;
		
	}

	public int multiplicar(int a, int b) {
		int result = a * b;
		return result;
	}
	
	public int dividir(int a, int b) throws SemDivisaoPorZero {

		if (b == 0) {
			throw new SemDivisaoPorZero();
		}
		int result = a / b;
		return result;
	}
}
