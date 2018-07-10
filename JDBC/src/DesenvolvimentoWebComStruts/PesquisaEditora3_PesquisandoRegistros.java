package DesenvolvimentoWebComStruts;

import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class PesquisaEditora3_PesquisandoRegistros {
	public static void main(String[] args) {
		Scanner leitura = new Scanner(System.in);

		System.out.println("Digite o id da editora");
		int id = leitura.nextInt();

		try {

			System.out.println("Abrindo conexão\n");
			Connection conexao = ConnectionFactory.createConnection();

			String sql = "SELECT * FROM editora WHERE id_livro = ?";

			PreparedStatement comando = (PreparedStatement) conexao.prepareStatement(sql);
			comando.setInt(1, id);

			System.out.println("Execundo comando\n");
			ResultSet resultado = comando.executeQuery();

			while (resultado.next()) {
				System.out.printf("%d : %s - %s\n", resultado.getInt("id_livro"), resultado.getString("nome"),
						resultado.getString("email"));
			}
			
			System.out.println("\nConexão Fechada");
			conexao.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
