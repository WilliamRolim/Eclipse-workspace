package disciplina3;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class ClienteApp {

	// alt para cima subir a linha
	static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	static String usuario = "curso_java";
	static String senha = "schema";

	static Connection conexao; // Connection que faz a conex�o com o banco de
	// dados

	public static void conectar() throws SQLException {
		conexao = DriverManager.getConnection(url, usuario, senha);
		conexao.setAutoCommit(false);
	}

	public static void desconectar() throws SQLException {
		conexao.close();
	}

	// Quais as propriedades que preciso inserir (parametros)
	public static void inserir(long cpf, String nome, String email) throws SQLException {
		// Instru��es sql ao qual vou colocar um registro no banco de dados
		String sql = "INSERT INTO cliente (cpf,nome,email) VALUES(" + cpf + ",'" + nome + "', '" + email + "' )";
		Statement statement = conexao.createStatement();
		statement.execute(sql);
		conexao.commit();// confirmo a transa��o com o commit
	}
	
	public static void inserirPS(long cpf, String nome, String email) throws SQLException {
		// Instru��es sql ao qual vou colocar um registro no banco de dados
		String sql = "INSERT INTO cliente (cpf,nome,email) VALUES(?,?,?)";
		PreparedStatement statement = conexao.prepareStatement(sql);
		//STATEMENT O objeto usado para executar uma instru��o SQL est�tica e retornar os resultados que ela produz.
		statement.setLong(1, cpf);
		statement.setString(2, nome);
		statement.setString(3, email);
		statement.executeUpdate();
		conexao.commit();// confirmo a transa��o com o commit
	}
	
	private static void inserirSP(long cpf, String nome, String email) throws SQLException {
		String sql = "{call sp_inserircliente(?,?,?)}";
		CallableStatement cstmt = conexao.prepareCall(sql);
		cstmt.setLong(1,cpf);
		cstmt.setString(2, nome);
		cstmt.setString(3, email);
		cstmt.execute();
		conexao.commit();
		
	}

	// passar a chave primaria cpf que eu quero consultar (parametro)
	public static void consultar(long cpf) throws SQLException {
		String sql = "SELECT * FROM cliente WHERE cpf=" + cpf + "";
		Statement statement = conexao.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			System.out.println(
					"CPF: " + rs.getString(1) + "\nnome:  " + rs.getString(2) + "\nEmail:  " + rs.getString(3));
		}
	}

	// consultar todos os registros da tabela
	// Quero saber quantos registros tem
	public static void consultarTodos() throws SQLException {
		String sql = "SELECT * FROM cliente";
		Statement statement = conexao.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		// int contador = rs.getFetchSize();// Contar as linhas
		int contador = 0;
		while (rs.next()) {
			System.out.println(
					"CPF: " + rs.getString(1) + "\nnome:  " + rs.getString(2) + "\nEmail:  " + rs.getString(3));
			System.out.println("********************************************************");
			contador++;
		}
		System.out.println("Total de clientes listados:   " + contador + "\n");
	}

	// alterar os registros da tabela
	public static void alterar(long cpf, String nome, String email) throws SQLException {
		// Obs: chaves primarias n�o s�o colocadas no update
		String sql = "UPDATE cliente SET nome = '" + nome + "',email='" + email + "' WHERE cpf = " + cpf;
		Statement statement = conexao.createStatement();
		statement.executeUpdate(sql);
		conexao.commit();// confirmo a transa��o com o commit
	}

	public static void excluir(long cpf) throws SQLException {
		String sql = "DELETE cliente WHERE cpf=" + cpf;
		Statement statement = conexao.createStatement();
		statement.executeUpdate(sql);
		conexao.commit();// confirmo a transa��o com o commit
		//se eu tirar o commit ele n�o atualiza no banco (controle de transa��o)
	}

	public static void main(String[] args) throws SQLException {
		try {
			// primeira coisa que eu tenho que fazer � conectar no banco
			conectar();

			// Criar um menu com op��es de tarefas ao qual o usuario quer
			// realizar
			// System.in para ler do teclado
			Scanner entrada = new Scanner(System.in);
			int opcao = 0;
			long cpf;
			String nome;
			String email;
			while (opcao != 6) {
				System.out.println("Sistema de gerenciamento de Clientes");
				System.out.println("===================================");
				System.out.println("Digite [1] Para Consultar todos os clientes");
				System.out.println("Digite [2] Para Consultar Um Cliente Especifico");
				System.out.println("Digite [3] Para Cadastrar um Novo Cliente ");
				System.out.println("Digite [4] Para Alterar um Cliente ");
				System.out.println("Digite [5] Para Excluir um Cliente ");
				System.out.println("Digite [6] Para Sair");
				System.out.println("===================================");

				opcao = entrada.nextInt();

				switch (opcao) {
				case 1:// Consultando Todos
					System.out.println("[1] Consultar Todos");
					consultarTodos();

					break;
				case 2:// Consultar
					System.out.println("[2] Consultar");
					System.out.println("Favor Informar o CPF..:  ");
					cpf = entrada.nextLong();
					consultar(cpf);
					break;
				case 3:// Cadastrar
					System.out.println("[3] Inserir");
					System.out.println("Favor Informar o CPF.:  ");
					cpf = entrada.nextLong();
					entrada.nextLine();// Esvaziar o Buffer do teclado
					System.out.println("Favor Informar o Nome.:  ");
					nome = entrada.nextLine();
					System.out.println("Favor Informar o Email.:  ");
					email = entrada.nextLine();
					//inserir(cpf, nome, email);
					//inserirPS(cpf, nome, email);
					inserirSP(cpf, nome, email);
					break;
				case 4:// Alterar
					System.out.println("[4] Alterar");
					System.out.println("Favor Informar o CPF.:  ");
					cpf = entrada.nextLong();
					entrada.nextLine();// Esvaziar o Buffer do teclado
					System.out.println("Favor Informar o Nome.:  ");
					nome = entrada.nextLine();
					System.out.println("Favor Informar o Email.:  ");
					email = entrada.nextLine();
					alterar(cpf, nome, email);
					break;
				case 5:// Excluir
					System.out.println("[5] Excluir");
					System.out.println("Favor Informar o CPF.:  ");
					cpf = entrada.nextLong();
					excluir(cpf);
					break;
				case 6:
					System.out.println("[6] Encerrando o Sistema");
				}
			}
			entrada.close();
			desconectar();
		} catch (Exception e) {
			e.printStackTrace();// printStackTrace() Imprime a pilha de erros
		}

	}



}
