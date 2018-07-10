package controle;

public class Start {
	public static void main(String[] args) {
		
		Homem h = new Homem();
		h.setNome("William");
		h.setIdade(19);
		
		Mulher m = new Mulher();
		m.setNome("Marilia");
		m.setIdade(30);
		
		h.casar(m);
		m.casar(h);
	}
}
