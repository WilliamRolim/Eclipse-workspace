package controller;

public class Pessoa {
 private String nome;
 private Integer idade;
 private String cpf;
 
 public Pessoa() {
	// TODO Auto-generated constructor stub
}
 
 
public Pessoa(String nome, Integer idade, String cpf) {
	this.nome = nome;
	this.idade = idade;
	this.cpf = cpf;
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
public String getCpf() {
	return cpf;
}
public void setCpf(String cpf) {
	this.cpf = cpf;
}

@Override
	public int hashCode() {//se o equals for igual o hashcode deve ser igual tbém
		Integer i = Integer.parseInt(cpf);		
		return i*7;
	}


@Override
public String toString() {
	return "Pessoa [nome=" + nome + ", idade=" + idade + ", cpf=" + cpf + "]" + "  Hashcode..: " + this.hashCode();
}


@Override
	public boolean equals(Object obj) {
	//instanceof está verificando se o objeto é uma instancia de pessoa
		if (obj instanceof Pessoa ) {
			Pessoa p = (Pessoa) obj;//transformando o objeto em pessoa
			if (this.cpf.equals(p.getCpf())) {
				return true;
			}else {
				return false;
			}
		}else {
		return false;
		}
	}
 
}
