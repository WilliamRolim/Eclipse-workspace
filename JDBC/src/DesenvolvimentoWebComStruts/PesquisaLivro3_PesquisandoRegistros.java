package DesenvolvimentoWebComStruts;

import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class PesquisaLivro3_PesquisandoRegistros {
	public static void main(String[] args) {
		try {
			Scanner entrada = new Scanner(System.in);
			
			System.out.println("Pesquise pelo número da id..: ");
			int id = entrada.nextInt();
			
			System.out.println("Abrindo conexão");
			
			Connection conexao = ConnectionFactory.createConnection();
			
			String sql = "SELECT * FROM livro WHERE id_livro = ?";
			
			PreparedStatement comando = (PreparedStatement) conexao.prepareStatement(sql);
			comando.setInt(1, id);
			
			System.out.println("Executando comando");
			
			ResultSet resultado = comando.executeQuery();
			
			while (resultado.next()) {
				System . out . printf ("%d : %s - %s\n",
						resultado.getInt("id_livro"),
						resultado.getString("titulo_livro"),
						resultado.getFloat("preco"),
						resultado.getInt("editora_id"));
			}
			
			System.out.println("Fechando conexão");
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
