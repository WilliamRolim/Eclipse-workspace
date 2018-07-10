package controle;

public class Pessoa implements Comparable<Pessoa> {
	private String nome;
	private Integer idade;
	
	
	public Pessoa(String nome, Integer idade) {
		this.nome = nome;
		this.idade = idade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", idade=" + idade + "]";
	}
	@Override
	public int compareTo(Pessoa o) {
		return this.nome.compareTo(o.getNome());
		//retorna um int justamente é a posição que eu quero do meu array
	}
	
	
	
	
}
