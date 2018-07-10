package br.com.pacote;

public class Vendedor implements Gratificacao {
private double vendas;



public double getVendas() {
	return vendas;
}



public void setVendas(double vendas) {
	this.vendas = vendas;
}



@Override
public double calculaGratificacao() {
	double gratificacao = this.vendas/30;
	return gratificacao;
}
}
