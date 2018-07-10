package JDBC_Alura;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.spi.DirStateFactory.Result;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class TesteInsercao_Commit_Rollback {
	public static void main(String[] args) throws SQLException {

			
		Connection connection = new Database().getConnection();
			// Autocomite = false caso houver 2 inserts os 2 devem ser executados,
			// caso contrario não será inserindo 2 ou mais inserts;
			connection.setAutoCommit(false);
			String sql = "INSERT INTO loja2 (nome,descricao) values (?,?)";
			try (PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS)){
				
				adiciona("TV LED", "32 pol",statement);
				connection.commit();
				adiciona("TV plasma", "4k",statement);
				connection.commit();
				System.out.println("Commit efetuado");
			} catch (Exception ex) {
				ex.printStackTrace();
				connection.rollback();
				System.out.println("Rollback efetuado");
			}
		
	}

	private static void adiciona(String nome, String descricao, PreparedStatement statement) throws SQLException {

		if(nome.equals("Blueray")) {
			throw new IllegalArgumentException("Problema ocorrido");
		}
		statement.setString(1,nome);
		statement.setString(2, descricao);
		
		boolean resultado = statement.execute();
		System.out.println(resultado);
		
		ResultSet resultSet = statement.getGeneratedKeys();
		while (resultSet.next()) {
			String id = resultSet.getString("id");
			System.out.println(id + " gerado");
		}
		
	}

}
