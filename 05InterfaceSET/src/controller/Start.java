package controller;

import java.util.LinkedHashSet;
import java.util.Set;

public class Start {
public static void main(String[] args) {
	//interface set apela para exclusividade
	//coleção de set não pode ter elementos repetidos
	Set<Pessoa>pessoas = new LinkedHashSet<Pessoa>();
	
	Pessoa p1 = new Pessoa("Joana", 19, "11111");
	Pessoa p2 = new Pessoa("Marilia", 39, "11111");
	Pessoa p3 = new Pessoa("Pedroso", 59, "11211");
	Pessoa p4 = new Pessoa("Astrogildo", 39, "11411");
	Pessoa p5 = new Pessoa("Kleiton", 27, "12111");
	
	pessoas.add(p1);
	pessoas.add(p2);
	pessoas.add(p3);
	pessoas.add(p4);
	pessoas.add(p5);
	
	//só lista quem tem o hashcode cpf diferente
	for (Pessoa listapessoa: pessoas) {
		System.out.println(listapessoa);
	}
}
} 
