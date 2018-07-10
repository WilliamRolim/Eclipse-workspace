package leitorjson.entidade;

public class Veiculo {
private int p;//Prefixo do veiculo
private boolean a;//Indica se o veiculo � (true) ou n�o (false) acessivel para pessoas com defici�ncia
private String ta;//Indica o hor�rio universal (UTC) em que a localiza��o foi caputrada. Essa informa��o esta no padr�o
private Double py;//Informa��o de latitude da localiza��o do veiculo
private Double px;//Informa��o de longitude da localiza��o do veiculo
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
