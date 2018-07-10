package JDBC_Alura;

import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.DatabaseMetaData;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class TestaInsercao {
public static void main(String[] args) throws SQLException {
		Scanner leitura = new Scanner(System.in);

		Connection connection = new Database().getConnection();

		System.out.println("Digite o nome do produto..:");
		String nome = leitura.nextLine();

		System.out.println("Digite a descricao do produto");
		String descricao = leitura.nextLine();

		String sql = "INSERT INTO loja2 (nome, descricao) VALUES (?,?)";

		PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql,
				Statement.RETURN_GENERATED_KEYS);

		statement.setString(1, nome);
		statement.setString(2, descricao);

		boolean resultado = statement.execute();
		System.out.println(resultado);

		ResultSet resultSet = statement.getGeneratedKeys();

		while (resultSet.next()) {
			String id = resultSet.getString("id");
			System.out.println(id + "gerado");
		}
		resultSet.close();
		statement.close();
		connection.close();
}
}
