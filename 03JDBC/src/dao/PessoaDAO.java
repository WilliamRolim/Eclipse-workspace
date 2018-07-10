package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;



import bean.Pessoa;

public class PessoaDAO {

	public void salvar(Pessoa p) {
		String sql = "INSERT INTO pessoa (nome,email,cpf,ddd,fone) values (?,?,?,?,?)";
		
		try {
			//pegar a conexão pelo metodo getConexao sempre mantendo uma conexão aberta
			//passando sql como argumento
			PreparedStatement ps = Connector.getConexao().prepareStatement(sql);
			ps.setString(1, p.getNome());
			ps.setString(2, p.getEmail());
			ps.setString(3, p.getCpf());
			ps.setString(4, p.getDdd());
			ps.setString(5, p.getFone());
			
			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
