package br.com.pacote;

public abstract class Gerente extends Pessoa {
	//abstrata só vai servir para ser extendida
	//gerente é uma EXPECIALIZAÇÃO DE Pessoa
	
	private double salario;

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	
}
