package construindo_servlets_Funcionario;

import java.util.Date;

public class Funcionario {
private String nome;
private Date nascimento;
private Double salario;
private Character sexo;
private Boolean temporario;

public Funcionario() {
	
}

public Funcionario(String nome, Date nascimento, Double salario, Character sexo, Boolean temporario) {
	super();
	this.nome = nome;
	this.nascimento = nascimento;
	this.salario = salario;
	this.sexo = sexo;
	this.temporario = temporario;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public Date getNascimento() {
	return nascimento;
}

public void setNascimento(Date nascimento) {
	this.nascimento = nascimento;
}

public Double getSalario() {
	return salario;
}

public void setSalario(Double salario) {
	this.salario = salario;
}

public Character getSexo() {
	return sexo;
}

public void setSexo(Character sexo) {
	this.sexo = sexo;
}

public Boolean getTemporario() {
	return temporario;
}

public void setTemporario(Boolean temporario) {
	this.temporario = temporario;
}



}
