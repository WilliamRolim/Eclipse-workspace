package br.ce.wcaquino.servicos;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.utils.DataUtils;
//Deixar as classes de teste no mesmo pacote de servi�o
public class LocacaoServiceTest {
	//@Teste nota��o que o Junit reconhece como teste
		@Test
		 public void teste() throws Exception {// o nome n�o importa
		//public static void main(String[] args) {
			//cenario: aonde as vari�veis s�o inicializadas. --> ENTRADA
			
			LocacaoService ls = new LocacaoService();//INSTANCIA DA CLASSE QUE QUERO TESTAR
			Usuario u = new Usuario("William");
			List<Filme> f = Arrays.asList(new Filme("Maquina Mortifera", 4, 6.00));

			//a��o: invocar o m�todo que queremos testar
	        Locacao locacao = ls.alugarFilme(u, f);
	        //Verifica��o --> SAIDA
			//verifica��o:coletar os resultados da a��o com o cen�rio especificado e podemos avaliar que o resultado est� como esperado.
	       /* System.out.println(locacao.getValor());
	        System.out.println(locacao.getDataLocacao());
	        System.out.println(locacao.getDataRetorno());
	        */
	        
	        /*
	        System.out.println(locacao.getValor() == 6.00);
	        System.out.println(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));//CHECAR QUE A DATA DE LOCA��O 
	        //� A MESMA DATA DO NEW DATE NEW DATE QUANDO ESTANCIADO VAI DAR A DATA ATUAL 
	        System.out.println(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
	        */
	        
	        //Usando assertivas
	        //Ctrl + F1
	        //Assert.assertTrue((locacao.getValor() == 6.00));
	        /*Assert.assertEquals(locacao.getValor(),6.00,0.01);
	        Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));//CHECAR QUE A DATA DE LOCA��O 
	        //� A MESMA DATA DO NEW DATE NEW DATE QUANDO ESTANCIADO VAI DAR A DATA ATUAL 
	        Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));*/
	        
	    	//assertthat = verifique que
	        
	       // Assert.assertThat(locacao.getValor(),CoreMatchers.is(6.00));//Primeiro valor � o atual o segundo � o matcher(valor esperado)
	        //Dando maior fluidez na leitura usando o import estatico -> bot�o direito - source add import
	        
	       // assertThat(locacao.getValor(),is(6.00)); //verifique que o valor da loca��o � 5
	        
	        assertThat(locacao.getValor(), is(equalTo(6.00))); //verifique que o valor da loca��o � 5
	        assertThat(locacao.getValor(), CoreMatchers.not(5.00));//verifique que o valor da loca��o N�O � 5
	        assertThat(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()), is(true));//CHECAR QUE A DATA DE LOCA��O 
	        //� A MESMA DATA DO NEW DATE NEW DATE QUANDO ESTANCIADO VAI DAR A DATA ATUAL 
	        assertThat(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)), is(true));
	        
	        
	        
	        
		}
}
