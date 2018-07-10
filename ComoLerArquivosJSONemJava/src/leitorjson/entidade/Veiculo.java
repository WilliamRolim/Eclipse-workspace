package leitorjson.entidade;

public class Veiculo {
private int p;//Prefixo do veiculo
private boolean a;//Indica se o veiculo é (true) ou não (false) acessivel para pessoas com deficiência
private String ta;//Indica o horário universal (UTC) em que a localização foi caputrada. Essa informação esta no padrão
private Double py;//Informação de latitude da localização do veiculo
private Double px;//Informação de longitude da localização do veiculo
public int getP() {
	return p;
}
public void setP(int p) {
	this.p = p;
}
public boolean isA() {
	return a;
}
public void setA(boolean a) {
	this.a = a;
}
public String getTa() {
	return ta;
}
public void setTa(String ta) {
	this.ta = ta;
}
public Double getPy() {
	return py;
}
public void setPy(Double py) {
	this.py = py;
}
public Double getPx() {
	return px;
}
public void setPx(Double px) {
	this.px = px;
}
@Override
public String toString() {
	return "Veiculo [p=" + p + ", a=" + a + ", ta=" + ta + ", py=" + py + ", px=" + px + "]";
}

}
