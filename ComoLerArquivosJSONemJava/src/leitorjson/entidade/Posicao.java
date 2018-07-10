package leitorjson.entidade;

import java.util.Arrays;

import leitorjson.entidade.LinhaLocalizada;
public class Posicao {
private String hr;//Horario da referencia da geração de informacoes
private LinhaLocalizada[] l;//Relação de linhas localizadas
public String getHr() {
	return hr;
}

public void setHr(String hr) {
	this.hr = hr;
}

public LinhaLocalizada[] getL() {
	return l;
}

public void setL(LinhaLocalizada[] l) {
	this.l = l;
}

@Override
public String toString() {
	return "Posicao [hr=" + hr + ", l=" + Arrays.toString(l) + "]";
}



}
