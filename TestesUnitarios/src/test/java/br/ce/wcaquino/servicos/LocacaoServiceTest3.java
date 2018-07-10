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
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.exceptions.FilmeSemEstoqueException;
import br.ce.wcaquino.exceptions.LocadoraException;

public class LocacaoServiceTest3 {

	private LocacaoService ls;
    private static int contador = 0;//static deixou de estar no escopo da instancia de teste
    //como ela static ela passou para o escopo da classe, esse tipo de variavel o junit não ira reinicializar
    //private int contador = 0;
    
	@Rule
	public ErrorCollector error = new ErrorCollector();
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	//impressão de um par de before e after para cada teste
	@Before
	public void antes() {
		System.out.println("Before");
		ls = new LocacaoService();//Demais testes irao pegar o serviço global, não repetindo a instancia
		//dos objetos - cada metodo irá executar o before
		contador++;
		System.out.println("contador..: " + contador);


	}
	
	@After
	public void depois() {
		System.out.println("After");
	}
	
	@BeforeClass
	public static void antesDaClasse() { //antes da classe ser inicializada ps - devo colocar o static
		System.out.println("BeforeClass");
		
	}
	
	@AfterClass 
	public static void depoisDaClasse(){// depois da classe ser destruida - ps devo colocar o static
		System.out.println("AfterClass");
	}
	
		@Test
		 public void testeLocacao() throws Exception {// o nome não importa
//cenario
			Usuario u = new Usuario("William");
			List<Filme> f = Arrays.asList(new Filme("Maquina Mortifera", 4, 6.00));
			System.out.println("Teste!");
			
		
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
			
	
			Usuario u = new Usuario("William");
			List<Filme> f = Arrays.asList(new Filme("Maquina Mortifera", 4, 6.00));


			//ação: invocar o método que queremos testar
	        ls.alugarFilme(u, f);
	        System.out.println("Forma Elegante");
		}

		//recomendado usar a robusta
		@Test //forma robusta -> a forma que terei mais poder sobre a execução => se precisar da msg forma robsta ou nova
		public void locadoraService_UsuarioVazio( ) throws FilmeSemEstoqueException {
			//cenario
			
			List<Filme> f = Arrays.asList(new Filme("Maquina Mortifera", 4, 6.00));

			//ação
			
			try {
				ls.alugarFilme(null, f);
				Assert.fail();
			} catch (LocadoraException e) {
				assertThat(e.getMessage(), is("Usario vazio"));
			}
	
		}
		
		@Test //forma nova
		public void locadoraService_FilmeVazio( ) throws FilmeSemEstoqueException, LocadoraException {
			//cenario
			
			Usuario u = new Usuario("William");

			//ação

				exception.expect(LocadoraException.class);
				exception.expectMessage("Filme Vazio");
				
				ls.alugarFilme(u, null);
				
				
				System.out.println("Forma Nova");
		}

		
		
	}
		

