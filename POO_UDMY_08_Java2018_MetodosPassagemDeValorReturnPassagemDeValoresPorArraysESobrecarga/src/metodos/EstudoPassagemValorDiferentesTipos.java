package metodos;

public class EstudoPassagemValorDiferentesTipos {
public static void main(String[] args) {
	MensagemIdade("William", 30, "Touro", 1.69, 69);
}

public static void MensagemIdade(String nome, int idade, String signo, double altura, float peso){
	System.out.println("Nome..: " + nome + "\nIdade..: " + idade + "\nSigno: " + signo +
			"\nAltura: " + altura + "\nPeso: " + peso);
}
}
