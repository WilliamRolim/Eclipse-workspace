package arraymultidimensional;

public class ProjetoArrayMultiDimensional {
public static void main(String[] args) {
	String contatos[][] = 
		{
				{"Mariana","Silva", "1234-3234"},
				{"Juliana", "Tamura", "2345-0956"},
				{"Manoel","Antonio","9346-09646"},
				{"Jucelio","Almeida","29387-4872"},
				{"Sandra","Albuquerque", "3004-3982"}
				
		};
	System.out.println(contatos[2][2]);
	System.out.println(contatos.length + " Contatos");
}
}
