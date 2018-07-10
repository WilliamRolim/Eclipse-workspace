package br.ce.wcaquino.servicos;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.ce.wcaquino.exceptions.SemDivisaoPorZero;



public class CalculadoraTest {

	private Calculadora calc;
	
	@Before
	public void global() {
		calc = new Calculadora();
	}
@Test
public void somar() {
	

//cenario
int a = 5;
int b = 8;

//a��o
int resultado = calc.somar(a, b);

//verifica��o
 Assert.assertEquals(13,resultado);
}

@Test
public void subtracao() {
	
	//cenario
	int a = 9;
	int b = 7;
	
	//a��o;
	int resultado = calc.subtrair(a,b);
	
	//verifica��o
	Assert.assertEquals(2, resultado);
}

@Test
public void multiplicacao() {
	//cenario
	int a = 9;
	int b = 7;
	
	//a��o;
	int resultado = calc.multiplicar(a,b);
	
	//verifica��o
	Assert.assertEquals(63, resultado);
}

@Test
public void divisao() throws SemDivisaoPorZero {
	//cenario
	int a = 100;
	int b = 10;
	Calculadora calc = new Calculadora();	
	//a��o;
	int resultado = calc.dividir(a,b);
	
	//verifica��o
	Assert.assertEquals(10, resultado);
}


@Test (expected = SemDivisaoPorZero.class)
public void divisaoSemDividirPorZero() throws SemDivisaoPorZero {
	//cenario
	int a = 10;
	int b = 0;
	
	
	//a��o;
	calc.dividir(a,b);
	

}



}