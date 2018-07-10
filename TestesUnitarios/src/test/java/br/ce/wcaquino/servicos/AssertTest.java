package br.ce.wcaquino.servicos;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.entidades.Usuario;





public class AssertTest {
	@Test
public void Teste(){
	Assert.assertTrue(true);//Verificar se o valor for verdadeiro
	Assert.assertTrue(!false);//Verificar se o valor for falso - n�o recomendado
	Assert.assertFalse(false);//Verificar se o valor for falso
	
	Assert.assertEquals(1, 1);
	Assert.assertEquals(0.51, 0.51, 0.01);//0.01 = delta: margem de erro de compara��o
	Assert.assertEquals(Math.PI, 3.14, 0.01);//Preciso de uma margem de erro -
	//- pois pi � infinito 0.01 = delta: margem de erro de compara��o
	
	//todo tipo primitivo possui uma representa��o em forma de objeto 
	//Conhecido como classe Wrappers
	int i = 5; //tipo primitivo
	Integer  j = 5;//tb�m posso representalo utilizando o objeto *Integer
	
	Assert.assertEquals(Integer.valueOf(i), j);//Passando o tipo primitivo para objeto
	Assert.assertEquals(i, j.intValue());//Passando o objeto para tipo primitivo
	
	//Assert.assertEquals("Erro de comparacao","XOXA","XUXA");
	Assert.assertEquals("bola","bola");
	Assert.assertEquals("bola","bola");//primeiro parametro (bola) esperado , segundo parametro atual
	Assert.assertNotEquals("bola","bola2");//verificar se strings s�o diferentes
	Assert.assertTrue("bola".equalsIgnoreCase("Bola"));//N�o considerar o B maiusculo na compara��o
	Assert.assertTrue("bola".startsWith("bo"));//Comparar radicais iguais
	
	//A igualdade dos objetos ser� verificada atraves do metodo equals do proprio objeto
	//pq ninguem melhor que o proprio objeto para dizer que ele � igual ou n�o a outro
	
	Usuario u1 = new Usuario("usuario");
	Usuario u2 = new Usuario("usuario");
	
	//Assert.assertEquals(u1, u2);N�o est� considerando que os objetos s�o iguais
	//procurar o metodo equals daquele objeto, o usuario n�o tem o metodo equals implementado
	//O java vai procurar nas superclasses , at� procurar o metodo equals
	//como esse metodo n�o tem nenhuma super classe declarada
	//ficou claro que ele est� estendendo o object que � a superclasse de todas as classes
	//nesse caso a compara��o � para ver que um objeto � igual ao outro
	
	Assert.assertEquals(u1, u1);
	Assert.assertEquals(u1, u2);
	
	Assert.assertNotSame(u1, u2);//apesar de serem iguais ele s�o de instancias diferentes
	
	Usuario u3 = null;
	
	//Compara��o a nivel de instancia, quero garantir que seja da mesma intancia
	//Assert.assertSame(u1, u2); erro pois s�o instancias diferentes
	
	Assert.assertNull(u3);//Verificar se o objeto � igual a null
	Assert.assertNotNull(u1);//Verificar se o objeto n�o est� vazio (null)
	

	
	
	}
}
