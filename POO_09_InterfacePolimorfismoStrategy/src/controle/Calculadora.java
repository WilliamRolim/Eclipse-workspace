package controle;

public class Calculadora {
	public double calcular(double a, double b, char c) {
		double res = 0.0;

		/*
		 * n�o � uma boa pratica de programa�� Padr�o de projeto que se aplica a muitos
		 * if e else chama-se STRATEGY
		 */
		if (c == '+') {
			res = a + b;
		} else if (c == '-') {
			res = a - b;
		} else if (c == '*') {
			res = a * b;
		} else if (c == '/') {
			res = a / b;
		}

		return res;
	}

}
