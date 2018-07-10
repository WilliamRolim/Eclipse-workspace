package construindo_servlets_Funcionario;

import java.util.ArrayList;
import java.util.List;

//CLASSE QUE IRÁ REPRESENTAR O BANCO DE DADOS
public class Dados {
    private static List<Funcionario>funcionarios = new ArrayList<Funcionario>();
    
    public static void cadastrarFuncionario(Funcionario funcionario){
        funcionarios.add(funcionario);
    }
    public static List<Funcionario> listarFuncionarios(){
        return funcionarios;
    }
}
