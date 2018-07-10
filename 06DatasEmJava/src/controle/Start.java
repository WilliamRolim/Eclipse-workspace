package controle;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Start {
public static void main(String[] args) {
	Date d = new Date();
	
	Locale local = new Locale("pt", "BR");
	//Locale local = new Locale("e");
	
	//tranformar uma data  // MM Maiusculo significia mes, mm minuto
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy E" ,local);
	/*
	try {
		d = sdf.parse("20/08/1986 Domingo");
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	*/
	
	//apresenta a data no formato JVM
	System.out.println(d);
	
	//formata no padrão que definir no simpleDateFormat
	System.out.println(sdf.format(d));
}
}
