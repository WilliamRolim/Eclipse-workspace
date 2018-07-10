package leitorjson.entidade;

import java.util.ArrayList;
import java.util.List;

public class Cidade {

	private String nome;
	private List<Posicao>posicoesOnibus;//Medir todas as posiçoes feitas durante o dia
	
	public Cidade() {
		this.posicoesOnibus = new ArrayList<Posicao>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Posicao> getPosicoesOnibus() {
		return posicoesOnibus;
	}

	public void setPosicoesOnibus(List<Posicao> posicoesOnibus) {
		this.posicoesOnibus = posicoesOnibus;
	}

	@Override
	public String toString() {
		return "Cidade [nome=" + nome + ", posicoesOnibus=" + posicoesOnibus + "]";
	}
	
}
