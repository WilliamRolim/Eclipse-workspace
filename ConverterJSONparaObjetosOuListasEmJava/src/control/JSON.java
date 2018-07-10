package control;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import model.Cliente;
import model.Dependentes;

public class JSON {
public static void main(String[] args) {
	List<Cliente> listaClientes = new ArrayList<>();
	
	Cliente c = new Cliente();
	c.setCodigo(1);
	c.setNome("William Rolim");
	c.setEmail("williamrolim2011@hotmail.com");
	c.setData(new Timestamp(System.currentTimeMillis()));
	
	Dependentes d = new Dependentes();
	d.setCodigo(1);
	d.setNome("Jose Junior");
	c.setDependentes(d);
	listaClientes.add(c);
	
	Cliente c2 = new Cliente();
	c2.setCodigo(1);
	c2.setNome("Amanda Britto");
	c2.setEmail("amanda@gmail.com");
	c2.setData(new Timestamp(System.currentTimeMillis()));
	listaClientes.add(c2);
	
	//convertendo em carquivo
	//type do pacote reflect
	Type type = new TypeToken<List<Cliente>>(){}.getType();
	Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy HH:mm").create();
	/*toJson converte para arquivo json*/
	String json = gson.toJson(listaClientes, type);
	
	System.out.println(json);
	List<Cliente> listaRetornoCliente = gson.fromJson(json, type);
	
	//retornar uma lista
	for (Cliente clienteRetorno : listaRetornoCliente) {
		System.out.println(clienteRetorno.getCodigo());
		System.out.println(clienteRetorno.getNome());
		System.out.println(clienteRetorno.getEmail());
		System.out.println(clienteRetorno.getData());
		System.out.println(clienteRetorno.getDependentes() != null?clienteRetorno.getDependentes().getClass() : "");
		
	}
	
	
	 
}
}
