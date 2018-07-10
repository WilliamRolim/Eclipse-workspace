package br.ce.wcaquino.suite;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.servicos.Calculadora;
import br.ce.wcaquino.servicos.CalculadoraTest;
import br.ce.wcaquino.servicos.CalculoValorLocacaoTeste;
import br.ce.wcaquino.servicos.LocacaoServiceTest4;

@RunWith(Suite.class) //RunWhit declarar que a excecucssão será diferente
@SuiteClasses({//declarar todos os testes que quero ser executado por essa suite
	CalculadoraTest.class,
	CalculoValorLocacaoTeste.class,
	LocacaoServiceTest4.class
	
})

public class SuiteExecucao {
//remova se puder SuiteExecucao
	

}


