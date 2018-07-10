package model;

import java.util.Date;

public class Cliente {
 private int codigo;
 private String nome;
 private String email;
 private Date data;
 private Object dependentes;
 
public Object getDependentes() {
	return dependentes;
}
public void setDependentes(Object dependentes) {
	this.dependentes = dependentes;
}
public int getCodigo() {
	return codigo;
}
public void setCodigo(int codigo) {
	this.codigo = codigo;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Date getData() {
	return data;
}
public void setData(Date data) {
	this.data = data;
}
@Override
public String toString() {
	return "Cliente [codigo=" + codigo + ", nome=" + nome + ", email=" + email + ", data=" + data + ", dependentes="
			+ dependentes + "]";
}

 
}
