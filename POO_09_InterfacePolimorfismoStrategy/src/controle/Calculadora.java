package controle;

public class Calculadora {
	public double calcular(double a, double b, char c) {
		double res = 0.0;

		/*
		 * não é uma boa pratica de programaçã Padrão de projeto que se aplica a muitos
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
