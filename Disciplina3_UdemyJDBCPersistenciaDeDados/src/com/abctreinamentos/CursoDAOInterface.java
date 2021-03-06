package com.abctreinamentos;

import java.sql.SQLException;
import java.util.List;

public interface CursoDAOInterface {
	public void conectar() throws SQLException;
	
	public void desconectar() throws SQLException;
	
	void inserirCurso(Curso curso) throws SQLException;

	void inserirCursoPS(Curso curso) throws SQLException;
	
	void inserirCursoSP(Curso curso) throws SQLException;
	
	public Curso consultar(int cdcurso) throws SQLException;

	public List<Curso> consultarTodosCursos() throws SQLException;

	void alterar(Curso curso) throws SQLException;

	void excluir(int cdcurso) throws SQLException;

	
}
