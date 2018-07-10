package br.ce.wcaquino.servicos;


import static br.ce.waquinho.mathers.MathersProprios.caiEm;
import static br.ce.waquinho.mathers.MathersProprios.caiNumaSegunda;
import static br.ce.wcaquino.utils.DataUtils.isMesmaData;
import static br.ce.wcaquino.utils.DataUtils.obterDataComDiferencaDias;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;

import br.ce.waquinho.mathers.MathersProprios;
import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.exceptions.FilmeSemEstoqueException;
import br.ce.wcaquino.exceptions.LocadoraException;
import br.ce.wcaquino.utils.DataUtils;

public class LocacaoServiceTest4 {

	private LocacaoService ls;

    
	@Rule
	public ErrorCollector error = new ErrorCollector();
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	//impress�o de um par de before e after para cada teste
	@Before
	public void antes() {
		System.out.println("Before");
		ls = new LocacaoService();//Demais testes irao pegar o servi�o global, n�o repetindo a instancia
		//dos objetos - cada metodo ir� executar o before
	}

	
		@Test
		 public void deveAlugarFilme() throws Exception {// o nome n�o importa
			Assume.assumeFalse(DataUtils.verificarDiaSemana(new Date(), Calendar.SATURDAY));
//cenario
			Usuario u = new Usuario("William");
			List<Filme> f = Arrays.asList(new Filme("Maquina Mortifera", 5, 6.00));

		
//a��o
	        Locacao locacao = ls.alugarFilme(u, f);
//verifica��o
	        error.checkThat(locacao.getValor(), is(equalTo(6.00))); //verifique que o valor da loca��o � 6
	        //error.checkThat(locacao.getValor(), CoreMatchers.not(5.00));//verifique que o valor da loca��o N�O � 5
	       // error.checkThat(isMesmaData(locacao.getDataLocacao(), new Date()), is(true));//CHECAR QUE A DATA DE LOCA��O 
	        error.checkThat(locacao.getDataLocacao(),MathersProprios.ehHoje());
	        //� A MESMA DATA DO NEW DATE NEW DATE QUANDO ESTANCIADO VAI DAR A DATA ATUAL 
	        error.checkThat(isMesmaData(locacao.getDataRetorno(), obterDataComDiferencaDias(1)), is(true));
 
		}

		@Test(expected=FilmeSemEstoqueException.class)//elegante -> funciona bem quando -
		//somente a exces�o importa para vc, garatir o motivo porque a excess�o for lan�ada
		public void naoDeveAlugarFilmeSemEstoque( ) throws Exception { 
//cenario: aonde as vari�veis s�o inicializadas.
			
	
			Usuario u = new Usuario("William");
			List<Filme> f = Arrays.asList(new Filme("Maquina Mortifera", 0, 7.00));


			//a��o: invocar o m�todo que queremos testar
	        ls.alugarFilme(u, f);
	        System.out.println("Forma Elegante");
		}

		//recomendado usar a robusta
		@Test //forma robusta -> a forma que terei mais poder sobre a execu��o => se precisar da msg forma robsta ou nova
		public void naoDeveAlugarFilmeSemUsuario() throws FilmeSemEstoqueException {
			//cenario
			
			List<Filme> f = Arrays.asList(new Filme("Maquina Mortifera", 1, 4.00));
			

			//a��o
			
			try {
				ls.alugarFilme(null, f);
				Assert.fail();
			} catch (LocadoraException e) {
				assertThat(e.getMessage(), is("Usario vazio"));
			}
	
		}
		
		@Test //forma nova
		public void naoDeveAlugarFilmeSemFilme()  throws FilmeSemEstoqueException, LocadoraException {
			//cenario
			
			Usuario u = new Usuario("William");

			//a��o

				exception.expect(LocadoraException.class);
				exception.expectMessage("Filme Vazio");
				
				ls.alugarFilme(u, null);

				System.out.println("Forma Nova");
		}
		
		@Test
		public void devePagar25PctNo3Filme() throws FilmeSemEstoqueException, LocadoraException {
			
			//cenario
			Usuario usuario = new Usuario("William");
			List<Filme> filmes = Arrays.asList(new Filme("Gunes", 4, 4.00), new Filme("Matrix", 4, 4.00), new Filme("Maquina Mortifera", 6, 4.00));
			
			//acao
			Locacao resultado = ls.alugarFilme(usuario, filmes);
			
			//verificacao
			Assert.assertThat(resultado.getValor(), is(11.0));
			
		}
		
		@Test
		public void devePagar50PctNo4Filme() throws FilmeSemEstoqueException, LocadoraException {
			
			//cenario
			Usuario usuario = new Usuario("William");
			List<Filme> filmes = Arrays.asList(new Filme("Gunes", 4, 4.0), new Filme("Matrix", 4, 4.0), new Filme("Maquina Mortifera", 6, 4.0),new Filme("Mae", 6, 4.0));
			
			//acao
			Locacao resultado = ls.alugarFilme(usuario, filmes);
			//4 + 4 + 3 + 2
			//verificacao
			Assert.assertThat(resultado.getValor(), is(13.0));
			
		}
		
		@Test
		public void devePagar75PctNo5Filme() throws FilmeSemEstoqueException, LocadoraException {
			
			//cenario
			Usuario usuario = new Usuario("William");
			List<Filme> filmes = Arrays.asList(new Filme("Gunes", 4, 4.0), new Filme("Matrix", 4, 4.0), new Filme("Maquina Mortifera", 6, 4.0),new Filme("Mae", 6, 4.0),new Filme("Et", 5, 4.0));
			
			//acao
			Locacao resultado = ls.alugarFilme(usuario, filmes);
			//4 + 4 + 3 + 2 + 1
			//verificacao
			Assert.assertThat(resultado.getValor(), is(14.0));
			
		}
		
		@Test
		public void devePagar100PctNo6Filme() throws FilmeSemEstoqueException, LocadoraException {
			
			//cenario
			Usuario usuario = new Usuario("William");
			List<Filme> filmes = Arrays.asList(new Filme("Gunes", 4, 4.0), new Filme("Matrix", 4, 4.0), new Filme("Maquina Mortifera", 6, 4.0),new Filme("Mae", 6, 4.0),new Filme("Et", 5, 4.0),new Filme("Et2", 5, 4.0));
			
			//acao
			Locacao resultado = ls.alugarFilme(usuario, filmes);
			//4 + 4 + 3 + 2 + 1 + 0
			//verificacao
			Assert.assertThat(resultado.getValor(), is(14.0));
			
		}
		//@ignore nota��o para ignorar o teste - n�o recomendada
		
		@Test
		public void deveDevolverNaSegundaAoAlugarNoSabado() throws FilmeSemEstoqueException, LocadoraException {
			//Assume verificar qual teste deve executar ou n�o
			Assume.assumeTrue(DataUtils.verificarDiaSemana(new Date(), Calendar.SATURDAY));
			//cenario
			Usuario usuario = new Usuario ("William");
			List<Filme> filmes = Arrays.asList(new Filme("ET", 2, 4.00));
			//acao
			Locacao retorno = ls.alugarFilme(usuario, filmes);
			//verificacao
			//Assert.assertThat(retorno.getDataRetorno(), new DiaSemanaMather(Calendar.MONDAY));
			Assert.assertThat(retorno.getDataRetorno(), caiEm(Calendar.SUNDAY));
			Assert.assertThat(retorno.getDataRetorno(), caiNumaSegunda());
		}
		

		
		
	}
		

