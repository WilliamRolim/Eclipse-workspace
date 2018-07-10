package arryunidimensional;

public class ProjetoArrayUnidimensional {
public static void main(String[] args) {
	//Array unidimensional
	//declarar array
	//meses do ano
	
	String[] meses = new String [12];
	meses[0] = "Janeiro";
	meses[1] = "Fevereiro";
	meses[2] = "Março";
	meses[3] = "Abril";
	meses[4] = "Maio";
	meses[5] = "Junho";
	meses[6] = "Julho";
	meses[7] = "Agosto";
	meses[8] = "Setembro";
	meses[9] = "Outubro";
	meses[10] = "Novembro";
	meses[11] = "Dezembro";
	
	System.out.println(meses[4]);
	System.out.println("O total de meses do ano é ..:  " + meses.length);
}
}
