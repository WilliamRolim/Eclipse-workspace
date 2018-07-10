package br.com.pacote;

public class GerenteVendas extends Gerente implements Gratificacao {

	@Override
	public double calculaGratificacao() {
		double gratificacao =  50.00;
		return gratificacao;
	}
	//todos herdam os metodos do gerente
}
