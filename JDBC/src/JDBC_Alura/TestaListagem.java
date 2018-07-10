package JDBC_Alura;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public class TestaListagem {
	
	public static void main(String[] args) throws SQLException {
		Connection connection = new Database().getConnection();
		Statement statement = connection.createStatement();
		boolean resultado = statement.execute("select * from loja2");
		ResultSet resultSet = statement.getResultSet();
		
		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String nome = resultSet.getString("nome");
			String descricao = resultSet.getString("descricao");
			System.out.println("id=" + id + ", nome=" + nome + ", descricao=" + descricao);
		}
		
		resultSet.close();
		statement.close();
		connection.close();
	}


}
