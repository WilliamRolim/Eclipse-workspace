package bean;

public class Pessoa {
private String nome;
private String cpf;
private String fone;
private String ddd;
private String email;

//metodos acessores gets and sets representa a tabela do banco
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getCpf() {
	return cpf;
}
public void setCpf(String cpf) {
	this.cpf = cpf;
}
public String getFone() {
	return fone;
}
public void setFone(String fone) {
	this.fone = fone;
}
public String getDdd() {
	return ddd;
}
public void setDdd(String ddd) {
	this.ddd = ddd;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

}
