package DesenvolvimentoWebComStruts;

import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ListaLivro3_ListandoRegistros {
	public static void main(String[] args) {
		
		try {
			System.out.println("Abrindo conexão");
			

			Connection conexao = ConnectionFactory.createConnection();
			
			String sql = "SELECT * FROM livro";
			
			PreparedStatement comando = (PreparedStatement) conexao.prepareStatement(sql);
			
			System.out.println("Executando comando");
			ResultSet resultado = comando.executeQuery();
			
			System.out.println(" Resultados encontrados : \n");
			
			while (resultado.next()) {
				System.out.printf("%d : %s - %s\n",
						resultado.getInt("id_livro"),
						resultado.getString("titulo_livro"),
						resultado.getFloat("preco"),
						resultado.getInt("editora_id"));
			}
			
			System.out.println("Fechando conexão..:");
			conexao.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
