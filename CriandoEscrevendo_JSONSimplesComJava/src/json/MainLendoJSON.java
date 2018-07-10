package json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class MainLendoJSON {

	public static void main(String[] args) throws org.json.simple.parser.ParseException {
		JSONObject jsonObject;

		JSONParser parser = new JSONParser();

		Pessoa pessoa = new Pessoa();

		try {
			jsonObject = (JSONObject) parser.parse(new FileReader(
					"C:\\Users\\willi\\Documents\\Eclipse-workspace\\CriandoEscrevendo_JSONSimplesComJava\\arquivoJSON_Gerado\\Dados_Importantes.json"));
			pessoa.setNome((String) jsonObject.get("nome"));
			pessoa.setSobrenome((String) jsonObject.get("sobrenome"));
			pessoa.setCpf((String) jsonObject.get("cpf"));

			System.out.println("Arquivo do JSON = " + pessoa.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
