package controle;

public class Veterinario {
	//Polimorfismo temos um metodo genericos que vai receber um tipo de dado, dependendo da situação ele irá se comportar
	//como um voador ou nadador
	public void medeTamanhoDaAsa(Voar v) {
		System.out.println("Mede tamanho da Asa");
	}
	
	public void verificaSaudeMamifero(Mamifero m) {
		System.out.println("Verifica saúde mamifero");
		m.amamentar();
	}
	
	public void desempenhoNaAgua(Nadar n) {
		System.out.println("Nadando");
	}
}
