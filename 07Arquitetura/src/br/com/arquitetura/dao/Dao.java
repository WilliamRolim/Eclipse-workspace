package br.com.arquitetura.dao;

import java.util.List;

public interface Dao {

	public void insert (Object o);//Se eu recebo um objeto isso poliformicamente pode ser qualquer coisa pois tudo extende de objeto
	public void update (Object o);
	public void delete(Object o);
	public Object select (int id);//Passo o id desse cara e ele retorna o objeto
	public List select();//sobrecarga de metodo dois metodos com mesmo nome
}

