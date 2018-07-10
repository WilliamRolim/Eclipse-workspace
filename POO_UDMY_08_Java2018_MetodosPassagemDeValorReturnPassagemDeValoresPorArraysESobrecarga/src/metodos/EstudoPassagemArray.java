package metodos;

public class EstudoPassagemArray {
 
	public static void main(String[] args) {
		String[] cadastro = {"Nome", "Sobrenome"};
		int[] x = {1,2,3,4,5,6,7,8,9,10};
		ExibirArray(x);
		ExibirNome(cadastro);
		ExibirSobrenome(cadastro);
	}
	
	public static void ExibirArray(int x[]){
		System.out.println(x[8]);
	}
	
	public static void ExibirNome(String nome[]){
		System.out.println(nome[0]);
	}
	
	public static void ExibirSobrenome(String sobrenome[]){
		System.out.println(sobrenome[1]);
	}
}
