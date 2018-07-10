package PersistindoValoresEmMaisDeUmaTabelaDev;

import java.sql.Connection;
import java.sql.ResultSet;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class PessoaDAO {

	public void inserirPessoa(PessoaTo pessoaTO) {
		Integer idEndereco = inserirEndereco(pessoaTO.getEnderecoTO());
		try {
			Connection conexao = Conexao.getConexao();

			String sql = "INSERT INTO pessoa (nome,endereco,cod_endereco) VALUES (?,?,?)";

			// RETURN_GENERATED_KEYS retorna o id do endereço que foi gerado
			PreparedStatement statement = (PreparedStatement) conexao.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, pessoaTO.getNome());
			statement.setString(2, pessoaTO.getEndereco());
			statement.setInt(3, idEndereco);

			statement.execute();/* para executar o insert */
			conexao.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Integer inserirEndereco(EnderecoTo enderecoTO) {
		Integer resultado = null;
		try {
			Connection conexao = Conexao.getConexao();

			String sql = "INSERT INTO endereco (descricao,numero) VALUES (?,?)";

			// RETURN_GENERATED_KEYS retorna o id do endereço que foi gerado
			PreparedStatement statement = (PreparedStatement) conexao.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, enderecoTO.getDescricao());
			statement.setInt(2, enderecoTO.getNumero());

			statement.execute();/* para executar o insert */

			ResultSet keys = statement.getGeneratedKeys();
			// resultset irá retornar o valor da chave
			if (keys.next()) {
				resultado = keys.getInt(1);
			}
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}
}
