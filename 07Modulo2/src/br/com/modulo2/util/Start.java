package br.com.modulo2.util;

import java.util.List;

import br.com.modulo2.bean.Pessoa;
import br.com.modulo2.dao.PessoaDao;
import br.com.modulo2.view.CadastroPessoa;

public class Start {
public static void main(String[] args) {
	
CadastroPessoa cp = new CadastroPessoa();
cp.setVisible(true);
	/*
	Pessoa p = new Pessoa();
	p.setNome("Mariloana");
	p.setCpf("12323455");
	p.setDdd("011");
	p.setFone("1234456");
	p.setEmail("mari@gmail.com");
	
	PessoaDao pd = new PessoaDao();
	/*INSERT*/
	//pd.insert(p);
	
	/*SELECT
	List<Pessoa> pessoas = pd.select();
	
	for (Pessoa listapessoa : pessoas) {
		System.out.println(listapessoa.getNome()  );
	}
	
	
	Pessoa pes  = (Pessoa) pd.select(2);
	System.out.println(p.getNome());
	*/
}
}
