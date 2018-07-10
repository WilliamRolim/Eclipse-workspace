package JDBC_Alura;

import java.sql.SQLException;

import javax.sql.DataSource;

import com.mysql.jdbc.Connection;
import org.hsqldb.jdbc.JDBCPool;
public class Database{
	private DataSource dataSource;
	Database(){
		JDBCPool pool = new JDBCPool();
		pool.setUrl("jdbc:mysql://localhost:3306/loja2");
		pool.setUrl("root");
		pool.setPassword("");
		
		//armazenar o pool de conexoes
		this.dataSource = pool;
		
	}
     Connection getConnection() throws SQLException {
	
	//Drivermanager = gerenciador de drivers jdbc
	//Connection connection =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/loja2","root","");
    	Connection connection = (Connection) dataSource.getConnection();
    	 return connection;
}
}
