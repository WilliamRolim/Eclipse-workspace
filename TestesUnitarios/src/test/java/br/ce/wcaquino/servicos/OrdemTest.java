package br.ce.wcaquino.servicos;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)   //anotação que permite que execute os testes em ordem alfabetica dos nomes
//Na duvida obedeça o FIRST e deixe seus metodos independentes
public class OrdemTest {
	public static int contador = 0;
@Test
public void inicia() {
	contador = 1;
}

@Test
public void verifica() {
	Assert.assertEquals(1, contador);
}

//Garantido a ordem dos metodos
/*
@Test
public void testeGeral() {//metodo erroneo , pois cado algum metodo estiver com falhas ou erros não 
	//conseguerei visualizar, irei perder no erro rastreabilidade, irá dar que o metodo inteiro erro
	//e terei que descobrir o err
	inicia ();
	verifica();
	}
	*/

}
