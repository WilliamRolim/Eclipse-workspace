package br.ce.wcaquino.servicos;




	import static br.ce.waquinho.builders.FilmeBuilder.umFilme;
import static br.ce.waquinho.builders.UsuarioBuilder.umUsuario;
	import static org.hamcrest.CoreMatchers.is;
	import static org.junit.Assert.assertThat;

	import java.util.Arrays;
	import java.util.Collection;
	import java.util.List;

	import org.junit.Before;
	import org.junit.Test;
	import org.junit.runner.RunWith;
	import org.junit.runners.Parameterized;
	import org.junit.runners.Parameterized.Parameter;
	import org.junit.runners.Parameterized.Parameters;
import org.mockito.Mockito;

import br.ce.wcaquinho.dados.LocacaoDAO;
import br.ce.wcaquinho.dados.LocacaoDAOFake;
import br.ce.wcaquino.entidades.Filme;
	import br.ce.wcaquino.entidades.Locacao;
	import br.ce.wcaquino.entidades.Usuario;
	import br.ce.wcaquino.exceptions.FilmeSemEstoqueException;
	import br.ce.wcaquino.exceptions.LocadoraException;


	@RunWith(Parameterized.class)
	public class CalculoValorLocacaoTeste2 {
		
		private LocacaoService service;
		//inicial ->0
		
		@Parameter
		public List<Filme> filmes;
		
		//irá executar apos a lista de filme
		
		@Parameter (value=1)
		public Double valorLocacao;
		
		@Parameter (value=2)
		public String cenario;
		
		@Before
		public void setup() {
			service = new LocacaoService();
			LocacaoDAO dao = Mockito.mock(LocacaoDAO.class);
			service.setLocacaoDAO(dao);
		}
		
		private static Filme filme1 = umFilme().agora();
		private static Filme filme2 = umFilme().agora();
		private static Filme filme3 = umFilme().agora();
		private static Filme filme4 = umFilme().agora();
		private static Filme filme5 = umFilme().agora();
		private static Filme filme6 = umFilme().agora();
		private static Filme filme7 = umFilme().agora();
		
		@Parameters(name="{2}")
		public static Collection<Object[]> getParametros(){//retornar uma coleção de array de objetos
			return Arrays.asList(new Object[][]{
				{Arrays.asList(filme1,filme2), 8.0,"2 Filmes SEM de desconto"},
				{Arrays.asList(filme1,filme2,filme3), 11.0,"3 Filmes 25% de desconto"},
				{Arrays.asList(filme1,filme2,filme3,filme4), 13.0,"4 Filmes 50% de desconto"},
				{Arrays.asList(filme1,filme2,filme3,filme4,filme5), 14.0,"5 Filmes 75% de desconto"},
				{Arrays.asList(filme1,filme2,filme3,filme4,filme5,filme6), 14.0,"6 Filmes 100% de desconto"},
				{Arrays.asList(filme1,filme2,filme3,filme4,filme5,filme6, filme7), 18.0,"6 Filmes SEM de desconto"}
			});
		}
		
		
		@Test
		public void deveCalcularValorDaLocacaoConsiderandoDescontos() throws FilmeSemEstoqueException, LocadoraException {
			
			//cenario
			Usuario u = umUsuario().agora();
		
			
			//acao
			Locacao resultado = service.alugarFilme(u, filmes);
			
			//verificacao
			assertThat(resultado.getValor(), is(valorLocacao));

			
		}

	}


