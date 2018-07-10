package br.com.modulo2.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import br.com.arquitetura.dao.Dao;
import br.com.modulo2.bean.Pessoa;
import br.com.modulo2.util.Connector;

public class PessoaDao implements Dao{

	@Override
	public void delete(Object arg0) {
		//recebo o argumento generico
		Pessoa p = (Pessoa) arg0; //casting garanto q vc irá tranformar em pessoa
		String sql = "DELETE FROM pessoa WHERE id = ?";
		
		try {
			PreparedStatement ps;
			ps = Connector.getConexao().prepareStatement(sql);
			ps.setInt(1, p.getId());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void insert(Object arg0) {
		//recebo o argumento generico
				Pessoa p = (Pessoa) arg0; //casting garanto q vc irá tranformar em pessoa
				String sql = "INSERT INTO pessoa (nome,cpf, fone, ddd,email) values (?,?,?,?,?)";
				
				try {
					PreparedStatement ps;
					ps = Connector.getConexao().prepareStatement(sql);
					 ps.setString(1,p.getNome());
					 ps.setString(2,p.getCpf());
					 ps.setString(3,p.getFone());
					 ps.setString(4,p.getDdd());
					 ps.setString(5,p.getEmail());
		
					ps.execute();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}

	@Override
	public List select() {

		
		String sql = "SELECT * FROM pessoa";
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		try {
			PreparedStatement ps;
			ps = Connector.getConexao().prepareStatement(sql);
			 //resultset encapsula todos os resultados que v ierem do banco
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				 Pessoa p = new Pessoa();
				 p.setNome(rs.getString("nome"));
				 p.setCpf(rs.getString("cpf"));
				 p.setDdd(rs.getString("ddd"));
				 p.setFone(rs.getString("fone"));
				 p.setEmail(rs.getString("email"));
				 
				 pessoas.add(p);
			}
			ps.executeQuery();//Execute query retorna objeto resultset
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pessoas;
	}

	@Override
	public Object select(int arg0) {
		String sql = "SELECT * FROM pessoa WHERE id = ?";
		 Pessoa p = new Pessoa();
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		try {
			PreparedStatement ps;
			ps = Connector.getConexao().prepareStatement(sql);
			ps.setInt(1, arg0);
			 //resultset encapsula todos os resultados que v ierem do banco
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {

				 p.setNome(rs.getString("nome"));
				 p.setCpf(rs.getString("cpf"));
				 p.setDdd(rs.getString("ddd"));
				 p.setFone(rs.getString("fone"));
				 p.setEmail(rs.getString("email"));
				 
				 pessoas.add(p);
			}
			ps.executeQuery();//Execute query retorna objeto resultset
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public void update(Object arg0) {
		//recebo o argumento generico
		Pessoa p = (Pessoa) arg0; //casting garanto q vc irá tranformar em pessoa
		String sql = "UPDATE pessoa SET(nome = ?,cpf = ?, fone = ?, ddd = ?,email = ? WHERE id = ?)";
		
		try {
			PreparedStatement ps;
			ps = Connector.getConexao().prepareStatement(sql);
			 ps.setString(1,p.getNome());
			 ps.setString(2,p.getCpf());
			 ps.setString(3,p.getFone());
			 ps.setString(4,p.getDdd());
			 ps.setString(5,p.getEmail());
			 ps.setInt(6, p.getId());
			 
	
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
