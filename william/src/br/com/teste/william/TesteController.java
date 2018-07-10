package br.com.teste.william;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("teste")
public class TesteController {

	@GET	
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response testaJson(){
		System.out.println("Entrou");
		return Response.ok().entity("Meu retorno vai aqui").header("Access-Control-Allow-Origin", "*").build();
	}
}
