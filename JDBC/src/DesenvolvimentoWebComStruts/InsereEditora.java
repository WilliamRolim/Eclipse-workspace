package DesenvolvimentoWebComStruts;
import java.sql.DriverManager;
import java.util.Scanner;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class InsereEditora {

	public static void main(String[] args) {

		String stringDeConexao = "jdbc:mysql://localhost:3306/livraria2";
		String usuario = "root";
		String senha = "";

		Scanner entrada = new Scanner(System.in);

		try {
			System.out.println("Abrindo conex�o... ");
			//DriverManager classe respons�vel pela cria��o de uma conex�o JDBC do pacote java.sql
			//Getconnection metodo estatico que cria uma conex�o com a JDBC (passamos a string de conex�o, etc)
			Connection conexao = (Connection) DriverManager.getConnection(stringDeConexao, usuario, senha);

			System.out.println("Digite o nome da editora..:");
			String nome = entrada.nextLine();
			System.out.println("Digite o email da editora..:");
			String email = entrada.nextLine();

			String sql = "INSERT INTO Editora(nome,email)" + "VALUES('" + nome + "', '" + email + "')";
			
			//PreparedStatement Esse m�todo criar� um objeto que representa a opera��o que ser� executada
			PreparedStatement comando = (PreparedStatement) conexao.prepareStatement(sql);

			System.out.println("Executando comando...");
			comando.execute();

			System.out.println("Fechando conex�o....");
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
