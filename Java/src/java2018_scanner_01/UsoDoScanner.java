package java2018_scanner_01;


import java.util.Calendar;
import java.util.Scanner;

public class UsoDoScanner {
//main e espa�o
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		Calendar calendario = Calendar.getInstance();
		
		System.out.println("----------------------------");
		System.out.println(" -- Digite sua idade: ");
		
		int idade = entrada.nextInt();
		int anoAtual = calendario.get(Calendar.YEAR);
		int anoNascimento = anoAtual - idade;
		
		System.out.println("Voc� nasceu em: " + anoNascimento);
	}
}