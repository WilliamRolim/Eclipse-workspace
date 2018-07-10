package controle;
//EXTENDS mulher faz tudo o que uma pessoa faz mais algumas coisas

public class Mulher extends Pessoa implements Casamento{


	public void casar(Pessoa p) {
		System.out.println(this.getNome() + " Esta casada com " + p.getNome());
		
	}


}
