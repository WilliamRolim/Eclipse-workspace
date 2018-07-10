package leitorjson.entidade;

import java.util.Arrays;

class LinhaLocalizada{ //Representa as linhas da cidade de SP
private String c;//Letreiro completo
private int cl;//Codigo identificador da linha
private int sl; //Sentido de operacao onde 1 significa terminal principal para terminal segundario e 2 de terminal
private String lt0;//Letreiro de destino da linha;
private String lt1;//Letreiro de origem da linha
private int qv;//Qtde de veiculos localizados
private Veiculo[] vs; //Veiculos localizados

public String getC() {
	return c;
}
public void setC(String c) {
	this.c = c;
}
public int getCl() {
	return cl;
}
public void setCl(int cl) {
	this.cl = cl;
}
public int getSl() {
	return sl;
}
public void setSl(int sl) {
	this.sl = sl;
}
public String getLt0() {
	return lt0;
}
public void setLt0(String lt0) {
	this.lt0 = lt0;
}
public String getLt1() {
	return lt1;
}
public void setLt1(String lt1) {
	this.lt1 = lt1;
}
public int getQv() {
	return qv;
}
public void setQv(int qv) {
	this.qv = qv;
}
public Veiculo[] getVs() {
	return vs;
}
public void setVs(Veiculo[] vs) {
	this.vs = vs;
}
@Override
public String toString() {
	return "LinhaLocalizada [c=" + c + ", cl=" + cl + ", sl=" + sl + ", lt0=" + lt0 + ", lt1=" + lt1 + ", qv=" + qv
			+ ", vs=" + Arrays.toString(vs) + "]";
}



}
