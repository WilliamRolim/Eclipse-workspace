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
			System.out.println("Abrindo conexão... ");
			//DriverManager classe responsável pela criação de uma conexão JDBC do pacote java.sql
			//Getconnection metodo estatico que cria uma conexão com a JDBC (passamos a string de conexão, etc)
			Connection conexao = (Connection) DriverManager.getConnection(stringDeConexao, usuario, senha);

			System.out.println("Digite o nome da editora..:");
			String nome = entrada.nextLine();
			System.out.println("Digite o email da editora..:");
			String email = entrada.nextLine();

			String sql = "INSERT INTO Editora(nome,email)" + "VALUES('" + nome + "', '" + email + "')";
			
			//PreparedStatement Esse método criará um objeto que representa a operação que será executada
			PreparedStatement comando = (PreparedStatement) conexao.prepareStatement(sql);

			System.out.println("Executando comando...");
			comando.execute();

			System.out.println("Fechando conexão....");
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
