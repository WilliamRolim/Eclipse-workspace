package controle;

public class Start {
	public static void main(String[] args) {
//calculador � uma inferface  
		//qualquer classe que implementa interface calculadora o c poder� assumir
		Calculador c = new Soma();
		Calculador c1 = new Multiplicacao();
		
		Calculador c2 = new Divisao();
		
		System.out.println(c.calcular(2.2, 3.3));
		System.out.println(c1.calcular(2.2, 3.3));
		System.out.println(c2.calcular(10, 5));
		
		//Aplica��o de projetos STRATEGY
		//N�o vou ter aquele monte de if e else edentado
		//Facilita a manuten��o
		
		//Desvantagem do strategy ele gera muitas classes
		
	}
}
