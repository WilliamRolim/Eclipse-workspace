package br.com.modulo2.bean;

import java.util.List;

import br.com.modulo2.dao.PessoaDao;

public class PessoaBC {

	public void insert(Pessoa p) {
		PessoaDao pd = new PessoaDao();
		pd.insert(p);
	}
	
	public void update(Pessoa p) {
		PessoaDao pd = new PessoaDao();
		pd.update(p);
	}
	
	public void delete(Pessoa p) {
		PessoaDao pd = new PessoaDao();
		pd.delete(p);
	}
	
	public Pessoa select (int i) {
		PessoaDao pd = new PessoaDao();
		Pessoa ps2 = (Pessoa) pd.select(i);
		return null;
	}
	
	public List<Pessoa> select(){
		PessoaDao pd = new PessoaDao();
		List<Pessoa> p2 = pd.select();
		return p2;
	}


}
