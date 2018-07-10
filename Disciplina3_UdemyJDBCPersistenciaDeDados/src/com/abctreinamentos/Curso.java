package com.abctreinamentos;

public class Curso {
	private int cdcurso;
	private String nomecurso;
	private float valor;
	private String url;
	
	public Curso() {
		
	}

	public Curso(int cdcurso, String nomecurso, float valor, String url) {
		super();
		this.cdcurso = cdcurso;
		this.nomecurso = nomecurso;
		this.valor = valor;
		this.url = url;
	}

	public int getCdcurso() {
		return cdcurso;
	}

	public void setCdcurso(int cdcurso) {
		this.cdcurso = cdcurso;
	}

	public String getNomecurso() {
		return nomecurso;
	}

	public void setNomecurso(String nomecurso) {
		this.nomecurso = nomecurso;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Curso [cdcurso=" + cdcurso + ", nomecurso=" + nomecurso + ", valor=" + valor + ", url=" + url + "]";
	}
	
	
	
	
}
