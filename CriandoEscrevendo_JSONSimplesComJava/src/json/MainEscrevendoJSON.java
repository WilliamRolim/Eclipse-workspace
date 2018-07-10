package json;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.JSONObject;

public class MainEscrevendoJSON {
	
public static void main(String[] args) {
	
	//filewriter escrever arquivo com o json
	FileWriter writerFile = null;
	
	JSONObject objetoJson = new JSONObject();
	
	objetoJson.put("nome", "Jurandir");
	objetoJson.put("sobrenome", "Malaquias");
	objetoJson.put("cpf", "123.456.789-10");
	objetoJson.put("signo", "Touro");
	
	//escrevendo em arquivo fisico no nosso computador
	try {
		writerFile = new FileWriter("C:\\Users\\willi\\Documents\\Eclipse-workspace\\CriandoEscrevendo_JSONSimplesComJava\\arquivoJSON_Gerado\\Dados_Importantes.json");
		
		//popular o arquivo com o json
		writerFile.write(objetoJson.toJSONString());
		writerFile.close();
	} catch (IOException ex) {
		Logger.getLogger(MainEscrevendoJSON.class.getName()).log(Level.SEVERE, null, ex);
	}
	System.out.println(objetoJson.toJSONString());
}
}
