package controle;

public class Start {
public static void main(String[] args) {
	
	//Polimorfismo varias formas
	Animal a = new Baleia();
	
	Voar v = new Morcego();
	Voar v1 = new Ave();
	
	Morcego m = new Morcego();
	Baleia b = new Baleia();
	Pessoa p = new Pessoa();
	
	Veterinario ve = new Veterinario();
	ve.desempenhoNaAgua(b);
	ve.medeTamanhoDaAsa(m);
	ve.verificaSaudeMamifero(m);
}
}
