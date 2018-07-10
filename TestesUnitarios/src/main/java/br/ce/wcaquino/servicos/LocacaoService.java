package br.ce.wcaquino.servicos;

import static br.ce.wcaquino.utils.DataUtils.adicionarDias;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquinho.dados.LocacaoDAO;
import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.exceptions.FilmeSemEstoqueException;
import br.ce.wcaquino.exceptions.LocadoraException;
import br.ce.wcaquino.servicos.SPCService;
import br.ce.wcaquino.utils.DataUtils;

public class LocacaoService {

	private LocacaoDAO dao;
	private SPCService spc;//referencia para spc service
	
	public Locacao alugarFilme(Usuario usuario, List<Filme> filmes) throws FilmeSemEstoqueException, LocadoraException  {

	    
	    if (usuario == null){
	    	throw new LocadoraException("Usario vazio");
	    }
	    
	    if (filmes == null || filmes.isEmpty()) {
	    	throw new LocadoraException("Filme Vazio");
	    }
	    
          
	    for (Filme filme : filmes) {
	    if (filme.getEstoque() == 0 ) {
				//throw new Exception("Filme sem estoque");
	    	throw new FilmeSemEstoqueException();
	    }
	    }
	    
		if(SPCService.possuiNegativacao(usuario)) {
			throw new LocadoraException("Usu√°rio Negativado");
		}

	 
	    
		Locacao locacao = new Locacao();
		locacao.setFilmes(filmes);
		locacao.setUsuario(usuario);
		locacao.setDataLocacao(new Date());
		
		Double valorTotal = 0d;
		/*for (Filme filme : filmes) {
			valorTotal += filme.getPrecoLocacao();
		}*/
		
		for (int i = 0; i < filmes.size(); i++) {//saber qual È o filme 1, 2 ou 3
			Filme filme = filmes.get(i);
			Double valorfilme = filme.getPrecoLocacao();
			
			//realizando a refatoraÁ„o - substituindo o if pela estrutura case
			switch (i) {
			case 2:valorfilme = valorfilme * 0.75;break;
			case 3:valorfilme = valorfilme * 0.5;break;
			case 4:valorfilme = valorfilme * 0.25;break;
			case 5:valorfilme = 0d;break;
			}
			/*
			if (i == 2) {//no terceiro filme
				valorfilme = valorfilme * 0.75; //75 porcento de desconto
			}
			if (i == 3) {//no quarto filme
				valorfilme = valorfilme * 0.5;//50 porcento de desconto
			}
			if (i == 4) {//no quinto filme
				valorfilme = valorfilme * 0.25;//25 porcento de desconto
			}
			
			if (i == 5) {//no sexto filme
				valorfilme = 0d;//100 porcento de desconto
			}
			*/
			valorTotal += valorfilme;
		}
		
		locacao.setValor(valorTotal);

		//Entrega no dia seguinte
		Date dataEntrega = new Date();
		dataEntrega = adicionarDias(dataEntrega, 1);
		if (DataUtils.verificarDiaSemana(dataEntrega, Calendar.SUNDAY)) {
			dataEntrega = adicionarDias(dataEntrega,1);
		}
		locacao.setDataRetorno(dataEntrega);
		
		//Salvando a locacao...	
		//TODO adicionar m√©todo para salvar
		dao.Salvar(locacao);
		
		return locacao;
	}
	

	
	// InjeÁ„o da dependencia
	public void setLocacaoDAO(LocacaoDAO dao) {
		this.dao = dao; // agora posso passar uma instancia do DAO externamente para minha classe de service
	}
	
	public void setSPCService(SPCService spc) {
		this.spc = spc;
	}

}