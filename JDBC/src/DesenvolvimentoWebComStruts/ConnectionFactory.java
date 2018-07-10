package DesenvolvimentoWebComStruts;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class ConnectionFactory {

	public static Connection createConnection() {
		
		String stringDeConexao = "jdbc:mysql://localhost:3306/livraria2";
		String nome = "root";
		String senha = "";
		
		Connection conexao = null;
		
		try {
			conexao = (Connection) DriverManager.getConnection(stringDeConexao,nome, senha);
		
		} catch (Exception e) {
			//printStackTrace dignosticar uma excessão. Ele informa o que aconteceu e aonde no codigo isso ocorreu.
			e.printStackTrace();
		}
		return conexao;
		
	}
}
