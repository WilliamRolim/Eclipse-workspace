package metodos;

public class EstudoMetodos {
public static void main(String[] args) {
	Mensagem();
	int valor = PassagemValor();
	//System.out.println(PassagemValor());
	System.out.println(valor);
}

//Criando metodo void que n�o retorna valores
static void Mensagem(){
	System.out.println("Estamos executando o m�todo Mensagem");
}

//Criando metodo int que  retornara valor inteiro sem passagem de parametros
static int PassagemValor(){
	int a = 7, b = 13, c = a + b;
	return c;
	
}
}
