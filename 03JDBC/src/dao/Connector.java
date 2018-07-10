package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
	static String url = "jdbc:mysql://localhost/cadastro2" ;//jdbc:mysql://localhost:3306/
    static String usuario = "root";
    static String senha = "";
    static Connection con;
    
    public static Connection getConexao() throws SQLException {

        try{
            Class.forName("org.gjt.mm.mysql.Driver");
            if(con == null){
                con = DriverManager.getConnection(url,usuario,senha);
            }
            return con;
        }catch(ClassNotFoundException e){
            throw new SQLException(e.getMessage());
        }
    }
}
