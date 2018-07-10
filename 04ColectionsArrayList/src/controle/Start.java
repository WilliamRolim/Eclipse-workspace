package controle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Start {
	public static void main(String[] args) {
		/*
		String[] frutas = new String[4]; //Criado array de 4 posiçoes
		frutas[0] = "Laranja";
		frutas[1] = "Morango";
		frutas[2] = "Manga";
		frutas[3] = "Ameixa";
		
		for (String string : frutas) {
			System.out.println(string);
		}
		*/
		/*ArrayList<String> list = new ArrayList<String>();*/
		/*sempre programar voltado para interface*/
		List<String> list = new ArrayList<String>();
		list.add("Laranja");
		list.add("Morango");
		list.add("Abacate");
		list.add("Banana");
		list.add("Acerola");
		list.add("Pessego");
		
		//Collection.sort ordenar por ordem alfabetica STRINGS
		Collections.sort(list);
		
		for (String frutas : list) {
			System.out.println(frutas);
		}
		
		List<Pessoa> pessoas = new ArrayList<>();
		Pessoa p1 = new Pessoa("William", 30);
		Pessoa p2 = new Pessoa("Rodrigo", 27);
		Pessoa p3 = new Pessoa("Maria",98);
		Pessoa p4 = new Pessoa("Barnabe", 14);
		Pessoa p5 = new Pessoa("Mariana", 25);
		
		pessoas.add(p1);
		pessoas.add(p2);
		pessoas.add(p3);
		pessoas.add(p4);
		pessoas.add(p5);
		
		Collections.sort(pessoas);
		for (Pessoa listandopessoa : pessoas) {
			System.out.println(listandopessoa);
		}
		
	}
}
