package controle;
//homem tem tudo aquilo que pessoa tem (herdou todos os metodos acessores)
public class Homem extends Pessoa implements Casamento {

	//todos que implementam (assinam) a classe casamento v�o ter que dar corpo para o metodo casar
	//fica a cargo da classe definir como ser� a implementa��o desse metodo
	public void casar(Pessoa p) {
		System.out.println("GAME OVER!! "+this.getNome()+" esta casada com "+p.getNome());
		
	}



	
}
