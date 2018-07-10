package br.ce.waquinho.builders;

import br.ce.wcaquino.entidades.Filme;

public class FilmeBuilder {

	private Filme filme;

	private FilmeBuilder() {
	}

	public static FilmeBuilder umFilme() {//1 metodo de entrada
		FilmeBuilder builderF = new FilmeBuilder();
		builderF.filme = new Filme();
		builderF.filme.setEstoque(1);
		builderF.filme.setNome("Filme 1");
		builderF.filme.setPrecoLocacao(4.0);
		return builderF;
	}
	
	public static FilmeBuilder umFilmeSemEstoque() {//2 metodo de entrada
		FilmeBuilder builderF = new FilmeBuilder();
		builderF.filme = new Filme();
		builderF.filme.setEstoque(0);
		builderF.filme.setNome("Filme 1");
		builderF.filme.setPrecoLocacao(4.0);
		return builderF;
	}

	public FilmeBuilder semEstoque() {
		filme.setEstoque(0);
		return this;// Retorno a instancia do builder
	}
	
	public FilmeBuilder comValor(Double valor) {
		filme.setPrecoLocacao(valor);
		return this;
	}

	public Filme agora() {
		return filme;

	}
}
