package PersistindoValoresEmMaisDeUmaTabelaDev;

public class PessoaTo {
private String nome;
private String endereco;
private EnderecoTo enderecoTO;/*FOREIGN KEY uma pessoa tem um endereço*/

public EnderecoTo getEnderecoTO() {
	return enderecoTO;
}
public void setEnderecoTO(EnderecoTo enderecoTO) {
	this.enderecoTO = enderecoTO;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getEndereco() {
	return endereco;
}
public void setEndereco(String endereco) {
	this.endereco = endereco;
}
}
