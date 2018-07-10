package br.ce.wcaquino.servicos;

import static br.ce.waquinho.builders.FilmeBuilder.umFilme;
import static br.ce.waquinho.builders.UsuarioBuilder.umUsuario;
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
import buildermaster.BuilderMaster;

public class LocacaoServiceTest5 {
	private LocacaoService ls;

	@Rule
	public ErrorCollector error = new ErrorCollector();

	@Rule
	public ExpectedException exception = ExpectedException.none();

	// impressão de um par de before e after para cada teste
	@Before
	public void antes() {
		System.out.println("Before");
		ls = new LocacaoService();// Demais testes irao pegar o serviço global, não repetindo a instancia
		// dos objetos - cada metodo irá executar o before
	}

	@Test
	public void deveAlugarFilme() throws Exception {// o nome não importa
		Assume.assumeFalse(DataUtils.verificarDiaSemana(new Date(), Calendar.SATURDAY));
		// cenario
		Usuario u = umUsuario().agora();
		List<Filme> f = Arrays.asList(umFilme().comValor(6.0).agora());

		// ação
		Locacao locacao = ls.alugarFilme(u, f);
		// verificação
		error.checkThat(locacao.getValor(), is(equalTo(6.00))); // verifique que o valor da locação é 6
		error.checkThat(locacao.getDataLocacao(), MathersProprios.ehHoje());
		// É A MESMA DATA DO NEW DATE NEW DATE QUANDO ESTANCIADO VAI DAR A DATA ATUAL
		error.checkThat(isMesmaData(locacao.getDataRetorno(), obterDataComDiferencaDias(1)), is(true));

	}

	@Test(expected = FilmeSemEstoqueException.class) // elegante -> funciona bem quando -
	// somente a excesão importa para vc, garatir o motivo porque a excessão for
	// lançada
	public void naoDeveAlugarFilmeSemEstoque() throws Exception {
		// cenario: aonde as variáveis são inicializadas.

		Usuario u = umUsuario().agora();
		List<Filme> f = Arrays.asList(umFilme().umFilmeSemEstoque().agora());

		// ação: invocar o método que queremos testar
		ls.alugarFilme(u, f);
		System.out.println("Forma Elegante");
	}

	// recomendado usar a robusta
	@Test // forma robusta -> a forma que terei mais poder sobre a execução => se precisar
			// da msg forma robsta ou nova
	public void naoDeveAlugarFilmeSemUsuario() throws FilmeSemEstoqueException {
		// cenario

		List<Filme> f = Arrays.asList(umFilme().agora());

		// ação

		try {
			ls.alugarFilme(null, f);
			Assert.fail();
		} catch (LocadoraException e) {
			assertThat(e.getMessage(), is("Usario vazio"));
		}

	}

	@Test // forma nova
	public void naoDeveAlugarFilmeSemFilme() throws FilmeSemEstoqueException, LocadoraException {
		// cenario

		Usuario u = umUsuario().agora();

		// ação

		exception.expect(LocadoraException.class);
		exception.expectMessage("Filme Vazio");

		ls.alugarFilme(u, null);

		System.out.println("Forma Nova");
	}

	// @ignore notação para ignorar o teste - não recomendada

	@Test
	public void deveDevolverNaSegundaAoAlugarNoSabado() throws FilmeSemEstoqueException, LocadoraException {
		// Assume verificar qual teste deve executar ou não
		Assume.assumeTrue(DataUtils.verificarDiaSemana(new Date(), Calendar.SATURDAY));
		// cenario
		Usuario u = umUsuario().agora();
		List<Filme> f = Arrays.asList(umFilme().agora());
		// acao
		Locacao retorno = ls.alugarFilme(u, f);
		// verificacao
		// Assert.assertThat(retorno.getDataRetorno(), new
		// DiaSemanaMather(Calendar.MONDAY));
		Assert.assertThat(retorno.getDataRetorno(), caiEm(Calendar.SUNDAY));
		Assert.assertThat(retorno.getDataRetorno(), caiNumaSegunda());
	}
	/*
	public static void main(String[] args) {
		new BuilderMaster().gerarCodigoClasse(Locacao.class);
	}*/

}
