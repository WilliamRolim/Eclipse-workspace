package controle;

import bean.Pessoa;
import dao.PessoaDAO;

public class Start {
  public static void main(String[] args) {
	Pessoa p = new Pessoa();
	p.setNome("Thiago");
	p.setCpf("12378911");
	p.setEmail("thiago@gmail.com");
	p.setDdd("011");
	p.setFone("1234-6567");
	
	Pessoa p2 = new Pessoa();
	p2.setNome("Ivanira");
	p2.setCpf("98765432");
	p2.setEmail("ivanira@gmail.com");
	p2.setDdd("011");
	p2.setFone("2234-7557");
	
	
	PessoaDAO pd = new PessoaDAO();
	pd.salvar(p);
	pd.salvar(p2);
}
}
