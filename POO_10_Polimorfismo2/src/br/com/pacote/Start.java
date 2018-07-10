package br.com.pacote;

public class Start {
public static void main(String[] args) {
	GerenteGeral gg = new GerenteGeral();
	gg.setSalario(30000);
	
	GerenteVendas gv = new GerenteVendas();
	gv.setSalario(2400);
	
	Vendedor v = new Vendedor();
	//tanto o gerente geral quanto gerente de vendas implementam a gratificação
	
	Rh rh = new Rh();
	rh.calculaPagamento(gg);
	rh.calculaPagamento(gv);
	rh.calculaPagamento(v);
}

}
