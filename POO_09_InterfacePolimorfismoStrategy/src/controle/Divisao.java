package controle;

public class Divisao implements Calculador {


	
	public double calcular(double a, double b) {
		if (b == 0) {
			return 0;
		}else {
		double result = a / b;
		return result;
		}
	}

}
