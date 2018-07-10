package com.abctreinamentos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ClienteDAO {
	// alt para cima subir a linha
	static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	static String usuario = "curso_java";
	static String senha = "schema";

	static Connection conexao; // Connection que faz a conexão com o banco de
	// dados

	public static void conectar() throws SQLException {
		conexao = DriverManager.getConnection(url, usuario, senha);
		DatabaseMetaData meta = conexao.getMetaData();// Para dizer o banco que
														// estou conectado
		conexao.setAutoCommit(false);
		System.out.println(">>>>>>Conectando Ao Banco de Dados:  " + meta.getDatabaseProductVersion());
	}

	public static void desconectar() throws SQLException {
		conexao.close();
	}

	// Inserindo o objeto Cliente via parametro
	public static void inserir(Cliente cliente) throws SQLException {
		// Instruções sql ao qual vou colocar um registro no banco de dados
		String sql = "INSERT INTO cliente (cpf,nome,email) VALUES(" + cliente.getCpf() + ",'" + cliente.getNome()
				+ "', '" + cliente.getEmail() + "' )";
		Statement statement = conexao.createStatement();
		statement.execute(sql);
		conexao.commit();// confirmo a transação com o commit
	}

	// Inserindo o objeto Cliente via parametro
	public static void inserirPS(Cliente cliente) throws SQLException {
		// Instruções sql ao qual vou colocar um registro no banco de dados
		String sql = "INSERT INTO cliente (cpf,nome,email) VALUES(?,?,?)";
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setLong(1, cliente.getCpf());
		statement.setString(2, cliente.getNome());
		statement.setString(3, cliente.getEmail());
		statement.executeUpdate();
		conexao.commit();// confirmo a transação com o commit
	}

	// Inserindo o objeto Cliente via parametro
	private static void inserirSP(Cliente cliente) throws SQLException {
		String sql = "{call sp_inserircliente(?,?,?)}";
		CallableStatement cstmt = conexao.prepareCall(sql);
		cstmt.setLong(1, cliente.getCpf());
		cstmt.setString(2, cliente.getNome());
		cstmt.setString(3, cliente.getEmail());
		cstmt.execute();
		conexao.commit();

	}

	// passar a chave primaria cpf que eu quero consultar (parametro)
	public static Cliente consultar(long cpf) throws SQLException {
		String sql = "SELECT * FROM cliente WHERE cpf=" + cpf + "";
		Statement statement = conexao.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		Cliente cliente = null;
		while (rs.next()) {
			cliente = new Cliente(rs.getLong(1), rs.getString(2), rs.getString(3));
		}
		return cliente;
	}

	// consultar todos os registros da tabela
	// Quero saber quantos registros tem
	// Consutar todos atraves do padrão de projetos VO
	public static List<Cliente> consultarTodos() throws SQLException {
		String sql = "SELECT * FROM cliente";
		Statement statement = conexao.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		// Criando uma lista de cliente
		List<Cliente> clientes = new LinkedList<>();

		while (rs.next()) {
			// Obtendo cada cliente - cada cliente eu vou guardando no objeto
			// cliente
			Cliente cliente = new Cliente(rs.getLong(1), rs.getString(2), rs.getString(3));
			clientes.add(cliente);
		}
		return clientes;
	}

	// consultar todos os registros da tabela
	public static void alterar(Cliente cliente) throws SQLException {
		// Obs: chaves primarias não são colocadas no update
		String sql = "UPDATE cliente SET nome = '" + cliente.nome + "',email='" + cliente.email + "' WHERE cpf = "
				+ cliente.cpf;
		Statement statement = conexao.createStatement();
		statement.executeUpdate(sql);
		conexao.commit();// confirmo a transação com o commit
	}

	public static void excluir(long cpf) throws SQLException {
		String sql = "DELETE cliente WHERE cpf=" + cpf;
		Statement statement = conexao.createStatement();
		statement.executeUpdate(sql);
		conexao.commit();// confirmo a transação com o commit
		// se eu tirar o commit ele não atualiza no banco (controle de
		// transação)
	}

	public static void main(String[] args) throws SQLException {
		try {
			// primeira coisa que eu tenho que fazer é conectar no banco
			conectar();

			// Criar um menu com opções de tarefas ao qual o usuario quer
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
					List<Cliente> clientes = ClienteDAO.consultarTodos();
					clientes.forEach(System.out::println);
					// clientes.size() só ver o tamanho da lista
					System.out.println("Número de clientes >>>" + clientes.size() + "\n");

					break;
				case 2:// Consultar
					System.out.println("[2] Consultar");
					System.out.println("Favor Informar o CPF..:  ");
					cpf = entrada.nextLong();
					Cliente cliente = ClienteDAO.consultar(cpf);
					System.out.println(cliente);
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
					// inserir(cpf, nome, email);
					// inserirPS(cpf, nome, email);
					Cliente cliente1 = new Cliente(cpf, nome, email);
					ClienteDAO.inserirSP(cliente1);
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
					Cliente cliente2 = new Cliente(cpf, nome, email);
					ClienteDAO.alterar(cliente2);
					break;
				case 5:// Excluir
					System.out.println("[5] Excluir");
					System.out.println("Favor Informar o CPF.:  ");
					cpf = entrada.nextLong();
					ClienteDAO.excluir(cpf);
					break;
				case 6:
					System.out.println("[6] Encerrando o Sistema");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();// printStackTrace() Imprime a pilha de erros
		}

	}

}
