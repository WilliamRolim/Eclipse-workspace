package br.com.pacote;

public abstract class Gerente extends Pessoa {
	//abstrata s� vai servir para ser extendida
	//gerente � uma EXPECIALIZA��O DE Pessoa
	
	private double salario;

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	
}
