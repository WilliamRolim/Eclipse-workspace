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

	// impress�o de um par de before e after para cada teste
	@Before
	public void antes() {
		System.out.println("Before");
		ls = new LocacaoService();// Demais testes irao pegar o servi�o global, n�o repetindo a instancia
		// dos objetos - cada metodo ir� executar o before
	}

	@Test
	public void deveAlugarFilme() throws Exception {// o nome n�o importa
		Assume.assumeFalse(DataUtils.verificarDiaSemana(new Date(), Calendar.SATURDAY));
		// cenario
		Usuario u = umUsuario().agora();
		List<Filme> f = Arrays.asList(umFilme().comValor(6.0).agora());

		// a��o
		Locacao locacao = ls.alugarFilme(u, f);
		// verifica��o
		error.checkThat(locacao.getValor(), is(equalTo(6.00))); // verifique que o valor da loca��o � 6
		error.checkThat(locacao.getDataLocacao(), MathersProprios.ehHoje());
		// � A MESMA DATA DO NEW DATE NEW DATE QUANDO ESTANCIADO VAI DAR A DATA ATUAL
		error.checkThat(isMesmaData(locacao.getDataRetorno(), obterDataComDiferencaDias(1)), is(true));

	}

	@Test(expected = FilmeSemEstoqueException.class) // elegante -> funciona bem quando -
	// somente a exces�o importa para vc, garatir o motivo porque a excess�o for
	// lan�ada
	public void naoDeveAlugarFilmeSemEstoque() throws Exception {
		// cenario: aonde as vari�veis s�o inicializadas.

		Usuario u = umUsuario().agora();
		List<Filme> f = Arrays.asList(umFilme().umFilmeSemEstoque().agora());

		// a��o: invocar o m�todo que queremos testar
		ls.alugarFilme(u, f);
		System.out.println("Forma Elegante");
	}

	// recomendado usar a robusta
	@Test // forma robusta -> a forma que terei mais poder sobre a execu��o => se precisar
			// da msg forma robsta ou nova
	public void naoDeveAlugarFilmeSemUsuario() throws FilmeSemEstoqueException {
		// cenario

		List<Filme> f = Arrays.asList(umFilme().agora());

		// a��o

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

		// a��o

		exception.expect(LocadoraException.class);
		exception.expectMessage("Filme Vazio");

		ls.alugarFilme(u, null);

		System.out.println("Forma Nova");
	}

	// @ignore nota��o para ignorar o teste - n�o recomendada

	@Test
	public void deveDevolverNaSegundaAoAlugarNoSabado() throws FilmeSemEstoqueException, LocadoraException {
		// Assume verificar qual teste deve executar ou n�o
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
