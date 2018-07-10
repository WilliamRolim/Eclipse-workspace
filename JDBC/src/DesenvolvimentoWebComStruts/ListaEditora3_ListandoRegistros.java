package DesenvolvimentoWebComStruts;

import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ListaEditora3_ListandoRegistros {
	public static void main(String[] args) {


		try {
			System.out.println("Abrindo conex�o");
			
			Connection conexao = ConnectionFactory.createConnection();
			String sql = "SELECT * FROM editora";

			PreparedStatement comando = (PreparedStatement) conexao.prepareStatement(sql);

			System.out.println("Resultados encontrados \n");

			// Resultset responsavel por armazenar dados da consulta
			// executeQuery() executar comando de consulta
			ResultSet resultado = comando.executeQuery();

			while (resultado.next()) {
				System.out.printf("%d : %s - %s\n", resultado.getInt("id_livro"), resultado.getString("nome"),
						resultado.getString("email"));
			}
			
			System.out.println("Fechando conex�o");
			conexao.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
