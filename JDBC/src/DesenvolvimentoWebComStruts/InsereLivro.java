package DesenvolvimentoWebComStruts;
import java.sql.DriverManager;
import java.util.Scanner;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class InsereLivro {
public static void main(String[] args) {
	String stringDeConexao = "jdbc:mysql://localhost:3306/livraria2";
	String usuario = "root";
	String senha = "";
	
	Scanner captura  = new Scanner(System.in);
	try {
		System.out.println("Abrindo conexão... ");
		//DriverManager classe responsável pela criação de uma conexão JDBC do pacote java.sql
		//Getconnection metodo estatico que cria uma conexão com a JDBC (passamos a string de conexão, etc)
		Connection conexao = (Connection) DriverManager.getConnection(stringDeConexao, usuario, senha);

	
		System.out.println("Digite o nome do livro..:" );
		String nome = captura.nextLine();
		System.out.println("Digite o preco livro..:" );
		float preco = captura.nextFloat();
		System.out.println("Digite o ID da editora..:" );
		int id = captura.nextInt();

		String sql = "INSERT INTO livro(titulo_livro,preco,editora_id)" + "VALUES('" + nome + "', " + preco + " + " + id + ")";

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
