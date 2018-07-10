package br.ce.wcaquino.servicos;

import static br.ce.wcaquino.utils.DataUtils.isMesmaData;
import static br.ce.wcaquino.utils.DataUtils.obterDataComDiferencaDias;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.exceptions.FilmeSemEstoqueException;
import br.ce.wcaquino.exceptions.LocadoraException;
//Deixar as classes de teste no mesmo pacote de serviço
public class LocacaoServiceTest2 {
	//Com notação rule consigo fazer todas as assertivas mesmo que o erro pare no caminho
	@Rule
	public ErrorCollector error = new ErrorCollector();
	
	@Rule //Tratamento da exessão do metodo semEstoque3
	public ExpectedException exception = ExpectedException.none();
	
	@Before
	public void antes() {
		System.out.println("Before");
	}
	
	@After
	public void depois() {
		System.out.println("antes");
	}
	
		@Test
		 public void testeLocacao() throws Exception {// o nome não importa
//cenario
			LocacaoService ls = new LocacaoService();//INSTANCIA DA CLASSE QUE QUERO TESTAR
			Usuario u = new Usuario("William");
			List<Filme> f = Arrays.asList(new Filme("Maquina Mortifera", 4, 6.00));
			
			System.out.println("teste");
//ação
			Locacao locacao = ls.alugarFilme(u, f);
//verificação
	        error.checkThat(locacao.getValor(), is(equalTo(6.00))); //verifique que o valor da locação é 6
	        //error.checkThat(locacao.getValor(), CoreMatchers.not(5.00));//verifique que o valor da locação NÃO é 5
	        error.checkThat(isMesmaData(locacao.getDataLocacao(), new Date()), is(true));//CHECAR QUE A DATA DE LOCAÇÃO 
	        //É A MESMA DATA DO NEW DATE NEW DATE QUANDO ESTANCIADO VAI DAR A DATA ATUAL 
	        error.checkThat(isMesmaData(locacao.getDataRetorno(), obterDataComDiferencaDias(1)), is(true));
 
		}
		
		@Test(expected=FilmeSemEstoqueException.class)//elegante -> funciona bem quando -
		//somente a excesão importa para vc, garatir o motivo porque a excessão for lançada
		public void testeLocacao_filmeSemEstoque() throws Exception { 
//cenario: aonde as variáveis são inicializadas.
			
			LocacaoService ls = new LocacaoService();//INSTANCIA DA CLASSE QUE QUERO TESTAR
			Usuario u = new Usuario("William");
			List<Filme> f = Arrays.asList(new Filme("Maquina Mortifera", 0, 6.00));


			//ação: invocar o método que queremos testar
	        ls.alugarFilme(u, f);
	        System.out.println("Forma Elegante");
		}
		
		/*
		
		@Test//robusta pq permite uma controle maior sobre a execução do teste que a elegante não me da
		public void testeLocacao_filmeSemEstoque2() {
		//cenario: aonde as variáveis são inicializadas.
		
		LocacaoService ls = new LocacaoService();//INSTANCIA DA CLASSE QUE QUERO TESTAR
		Usuario u = new Usuario("William");
		Filme f = new Filme("Maquina Mortifera", 1, 6.00);


		//ação: invocar o método que queremos testar
        try {
			ls.alugarFilme(u, f);
			fail("Deveria lançar uma excessão");//caso nenhuma excessão seja lançada, irá cair na linha seguinte já pega o assert fail
		} catch (Exception e) {
			// TODO Auto-generated catch block
			assertThat(e.getMessage(), is("Filme Sem Estoque"));
		}
		}
		
		@Test 
		public void testeLocacao_filmeSemEstoque3() throws Exception { 
//cenario: aonde as variáveis são inicializadas.
			
			LocacaoService ls = new LocacaoService();//INSTANCIA DA CLASSE QUE QUERO TESTAR
			Usuario u = new Usuario("William");
			Filme f = new Filme("Maquina Mortifera", 0, 6.00);
			
			exception.expect(Exception.class);
			exception.expectMessage("Filme Sem Estoque");


			//ação: invocar o método que queremos testar
	        ls.alugarFilme(u, f);
		}
		*/
		//recomendado usar a robusta
		@Test //forma robusta -> a forma que terei mais poder sobre a execução => se precisar da msg forma robsta ou nova
		public void locadoraService_UsuarioVazio( ) throws FilmeSemEstoqueException {
			//cenario
			LocacaoService ls = new LocacaoService();//INSTANCIA DA CLASSE QUE QUERO TESTAR
			List<Filme> f = Arrays.asList(new Filme("Maquina Mortifera", 0, 6.00));

			//ação
			
			try {
				ls.alugarFilme(null, f);
				Assert.fail();
			} catch (LocadoraException e) {
				assertThat(e.getMessage(), is("Usario vazio"));
			}
			System.out.println("Forma Robusta");
		}
		
		@Test //forma nova
		public void locadoraService_FilmeVazio( ) throws FilmeSemEstoqueException, LocadoraException {
			//cenario
			LocacaoService ls = new LocacaoService();//INSTANCIA DA CLASSE QUE QUERO TESTAR
			Usuario u = new Usuario("William");

			//ação

				exception.expect(LocadoraException.class);
				exception.expectMessage("Filme Vazio");
				
				ls.alugarFilme(u, null);
				
				
				System.out.println("Forma Nova");
		}
		
	}
		

