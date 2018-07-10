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
//Deixar as classes de teste no mesmo pacote de serviço
public class LocacaoServiceTest {
	//@Teste notação que o Junit reconhece como teste
		@Test
		 public void teste() throws Exception {// o nome não importa
		//public static void main(String[] args) {
			//cenario: aonde as variáveis são inicializadas. --> ENTRADA
			
			LocacaoService ls = new LocacaoService();//INSTANCIA DA CLASSE QUE QUERO TESTAR
			Usuario u = new Usuario("William");
			List<Filme> f = Arrays.asList(new Filme("Maquina Mortifera", 4, 6.00));

			//ação: invocar o método que queremos testar
	        Locacao locacao = ls.alugarFilme(u, f);
	        //Verificação --> SAIDA
			//verificação:coletar os resultados da ação com o cenário especificado e podemos avaliar que o resultado está como esperado.
	       /* System.out.println(locacao.getValor());
	        System.out.println(locacao.getDataLocacao());
	        System.out.println(locacao.getDataRetorno());
	        */
	        
	        /*
	        System.out.println(locacao.getValor() == 6.00);
	        System.out.println(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));//CHECAR QUE A DATA DE LOCAÇÃO 
	        //É A MESMA DATA DO NEW DATE NEW DATE QUANDO ESTANCIADO VAI DAR A DATA ATUAL 
	        System.out.println(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
	        */
	        
	        //Usando assertivas
	        //Ctrl + F1
	        //Assert.assertTrue((locacao.getValor() == 6.00));
	        /*Assert.assertEquals(locacao.getValor(),6.00,0.01);
	        Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));//CHECAR QUE A DATA DE LOCAÇÃO 
	        //É A MESMA DATA DO NEW DATE NEW DATE QUANDO ESTANCIADO VAI DAR A DATA ATUAL 
	        Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));*/
	        
	    	//assertthat = verifique que
	        
	       // Assert.assertThat(locacao.getValor(),CoreMatchers.is(6.00));//Primeiro valor é o atual o segundo é o matcher(valor esperado)
	        //Dando maior fluidez na leitura usando o import estatico -> botão direito - source add import
	        
	       // assertThat(locacao.getValor(),is(6.00)); //verifique que o valor da locação é 5
	        
	        assertThat(locacao.getValor(), is(equalTo(6.00))); //verifique que o valor da locação é 5
	        assertThat(locacao.getValor(), CoreMatchers.not(5.00));//verifique que o valor da locação NÃO é 5
	        assertThat(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()), is(true));//CHECAR QUE A DATA DE LOCAÇÃO 
	        //É A MESMA DATA DO NEW DATE NEW DATE QUANDO ESTANCIADO VAI DAR A DATA ATUAL 
	        assertThat(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)), is(true));
	        
	        
	        
	        
		}
}
