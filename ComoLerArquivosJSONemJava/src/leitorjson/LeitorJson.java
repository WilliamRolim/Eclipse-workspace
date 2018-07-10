package leitorjson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import leitorjson.entidade.Cidade;
import leitorjson.entidade.Posicao;

public class LeitorJson {
	public static void main(String[] args) {
		
		Cidade cidade = new Cidade();
		try {
			 Posicao posicao = null;
			//classe file pode representar arquivos ou diretorios
			File diretorio = new File("/opt/posicoes");//optposicoes representa diretorio dentro do sistema op
			if (diretorio.isDirectory()) {//verificando se realmente é um diretorios -- Esse metodo retorna true ou false
				//listar todos os arquivos dentro do diretorio
				//teremos todos os arquivos JSON disponiveis capturados da API
				//UTLIZANDO o metodo listFiles ele irá retornar um array de arquivos
				File arquivos[] = diretorio.listFiles();
				//for para percorrer todos os arquivos
				for (File arquivo : arquivos) {
					//Ler o arquivo no conteudo no formato json
					Gson gson = new Gson();
					//Jsonreader recebe como parametro um objeto filereeader e o file reader le o arquivo que estamos interando no nosso for
					//Jsonreader criamos um objeto capaz de ler json
					JsonReader reader = new JsonReader(new FileReader(arquivo));
	                
					posicao = gson.fromJson(reader, Posicao.class);
					//adicionando a lista de onibus cada posição capturada
	                cidade.getPosicoesOnibus().add(posicao);
				}
			}
		} catch (FileNotFoundException ex) {
			Logger.getLogger(LeitorJson.class.getName()).log(Level.SEVERE, null, ex);
		}
		System.out.println(cidade.getPosicoesOnibus().size());
	}
}
