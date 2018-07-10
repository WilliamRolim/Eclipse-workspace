package metodos;

public class EstudoReturn {
public static void main(String[] args) {
	System.out.println("M�todo Retorna Inteiro..:  " + RetornaInteiro());
	System.out.println("M�todo Retorna Soma..:  " + RetornaSoma());
	System.out.println("M�todo Retorna Variavel..:  " + RetornaVariavel());
	System.out.println("M�todo Retorna String..:  " + RetornaString());
	System.out.println("M�todo Retorna String Concatenada..:  " + RetornaStringConcatenada("William", "Santana"));
}

//Retorna int
public static int RetornaInteiro(){
	return 10;
}

//Retorna Soma
public static double RetornaSoma(){
	return 10 + 30;
}

//Retorna variavel

public static int RetornaVariavel(){
	int a = 10;
	return a;
}

//Retorna String
public static String RetornaString(){
	return "William Rolim";
}

public static String RetornaStringConcatenada(String nome, String sobrenome){
	return nome + " " + sobrenome;
}
}
