package disciplina3;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JOptionPane;

public class AcessoBD {

	// alt para cima subir a linha
	static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	static String usuario = "curso_java";
	static String senha = "schema";

	static Connection conexao; // Connection que faz a conexão com o banco de
								// dados

	public static void conectar() throws SQLException {
		conexao = DriverManager.getConnection(url, usuario, senha);
		conexao.setAutoCommit(false);
	}

	// Fazer uma consulta no metodo cliente
	public static void consultarCliente() throws SQLException {
		String consulta = "SELECT * FROM cliente";

		Statement statement = conexao.createStatement();
		ResultSet rs = statement.executeQuery(consulta);

		while (rs.next()) {
			JOptionPane.showMessageDialog(null,
					"CPF: " + rs.getString(1) + "\nnome:  " + rs.getString(2) + "\nEmail:  " + rs.getString(3));
		}
	}
	
	public static void consultarCurso() throws SQLException {
		String consulta = "SELECT * FROM curso";

		Statement statement = conexao.createStatement();
		ResultSet rs = statement.executeQuery(consulta);

		while (rs.next()) {
			JOptionPane.showMessageDialog(null,
					"IDCurso: " + rs.getString(1) + "\nNome:  " + rs.getString(2) + "\nValor:  " + rs.getFloat(3)
					+ "\nurl: " + rs.getString(4));
		}
	}

	/*
	 * Utilizar a interface DataBaseMetaData para obter o nome do fabricante do
	 * BD e a sua versao utilizada
	 */
	public static void mostrarMetaInfoBD() throws SQLException {
		DatabaseMetaData meta = conexao.getMetaData();
		String fabricanteBD = meta.getDatabaseProductName();
		String versaoBD = meta.getDatabaseProductVersion();

		JOptionPane.showMessageDialog(null, fabricanteBD + " <===> " + versaoBD);
	}

	public static void main(String[] args) {
		try {
			conectar();
			mostrarMetaInfoBD();
			consultarCliente();
			consultarCurso();
			conexao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
