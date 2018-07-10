package br.ce.waquinho.builders;

import br.ce.wcaquino.entidades.Usuario;

public class UsuarioBuilder {

	private Usuario usuario;
	
	private UsuarioBuilder() {}//O construtor do metodo ficou privado para que ninguem possa criar instancia do bealder
	//externamente ao proprio bealder
	
	public static UsuarioBuilder umUsuario() {// publico static para uqe ele possa ser acessado externamente
		//sem a necessidade de instancia. Esse metodo será a porta de entrada para criação do usuario
		// garantido a fluencia da leitura , é chamado de usuario
		
		UsuarioBuilder builder = new UsuarioBuilder();//Criar uma instancia de usuario builder
		builder.usuario = new Usuario();//inicializando a construção do usuario
		builder.usuario.setNome("William");//povoando o usuario com um dado qualquer
		return builder; //retornar a instancia do usuario builder chaining method - //
		//a partir dai posso chamar outras instancia do proprio builder
	}
	
	public Usuario agora() {//retorna o usuario construido pela builder
		return usuario;
	}
	
}
