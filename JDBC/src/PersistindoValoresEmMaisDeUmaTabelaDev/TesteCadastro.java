package PersistindoValoresEmMaisDeUmaTabelaDev;

public class TesteCadastro {
public static void main(String[] args) {
	EnderecoTo enderecoTO = new EnderecoTo();
	enderecoTO.setNumero(123);
	enderecoTO.setDescricao("ABCD");
	
	PessoaTo pessoaTO = new PessoaTo();
	pessoaTO.setNome("Joana");
	pessoaTO.setEndereco("Tobias");
	pessoaTO.setEnderecoTO(enderecoTO);
	
	PessoaDAO dao = new PessoaDAO();
	dao.inserirPessoa(pessoaTO);
}
}
