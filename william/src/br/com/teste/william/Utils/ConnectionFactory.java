package br.com.teste.william.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;
 
public class ConnectionFactory {	
	private static String url;
	private static String driver;
	private static String user;
	private static String password;
	private static int initialSize;
	private static int minIdle;
	private static int maxTotal;
	private static int minEvictableIdleTimeMillis;
	
	private static Properties properties = null;

	private static BasicDataSource dataSource;
	
	private static Logger log = Logger.getLogger(Connection.class);
	
	public ConnectionFactory(){
//		this.log4jConfing();
		this.carregarConfiguracoesBd();//Carrega as configs do bd a partir de arquivos
		this.configurarDataSourceRAC();//Configura o BasicDataSource
	}
	
//	private void log4jConfing(){
//		// --------------------------------------------
//		//PERTENCE AO LOG4j
//		URI configuration;
//		
//		String S_O = System.getProperty("os.name");
//		
//		if (S_O.substring(0,1).toUpperCase().equals("W")){
//			configuration = new File((System.getenv("CATALINA_HOME")+"\\conf\\log4j2.xml")).toURI();
//		}else{
//			configuration = new File((System.getenv("CATALINA_HOME")+"/conf/log4j2.xml")).toURI();
//		}
//		
//		 Configurator.initialize("config", null, configuration);
//	}
	
	public synchronized void carregarConfiguracoesBd(){  
	      if (properties == null) {  
	    	  readProperties();
	    	  System.out.println("Objeto properties criado. Lendo arquivo.");
	      }  
	   }  	
	
    /**
     * Método que carrega os dados de acesso ao banco a partir de um
     * arquivo properties
     */
	private static void readProperties(){
		try {		
			FileInputStream		connectionConfPath	= null;
			connectionConfPath = new FileInputStream(new File(new File(new File(System.getProperty("catalina.home")),"/conf"),"connection_mysql.props"));
			int fatorConversao = 600000;
			int initialSizeDefault = 10;
			int minIdleDefault = 10;
			int maxTotalDefault = 500;
			int minIdleTimeDefault = 10;
			
			properties = new Properties();
			properties.load(connectionConfPath);

			log.debug("Conectando Base:" + properties.getProperty("type").toString());			
			
			if (properties.getProperty("user") != null) {
				url 		= properties.getProperty("url").toString();
				driver 		= properties.getProperty("driver").toString();
				user 		= properties.getProperty("user").toString();
				password 	= properties.getProperty("password").toString();
				
				if (properties.getProperty("initialSize") != null && !properties.getProperty("initialSize").equals("")
																	&& !properties.getProperty("initialSize").equals("0")){

					initialSize 	= Integer.parseInt(properties.getProperty("initialSize"));
				} else {
					initialSize	= initialSizeDefault;
				}
				
				if (properties.getProperty("minIdle") != null && !properties.getProperty("minIdle").equals("")
																&& !properties.getProperty("minIdle").equals("0")){
				
					minIdle 	= Integer.parseInt(properties.getProperty("minIdle"));
				} else {
					minIdle	= minIdleDefault;
				}
				
				if (properties.getProperty("maxTotal") != null && !properties.getProperty("maxTotal").equals("")
																&& !properties.getProperty("maxTotal").equals("0")){
					
					maxTotal 	= Integer.parseInt(properties.getProperty("maxTotal"));
				} else {
					maxTotal	= maxTotalDefault;
				}
				
				if (properties.getProperty("minIdleTime") != null && !properties.getProperty("minIdleTime").equals("")
																	&& !properties.getProperty("minIdleTime").equals("0")){
					
					minEvictableIdleTimeMillis = fatorConversao * Integer.parseInt(properties.getProperty("minIdleTime"));
				} else {
					minEvictableIdleTimeMillis = fatorConversao * minIdleTimeDefault;
				}	
			}
			connectionConfPath.close();
		} catch (IOException e) {
			log.fatal("ConnectionFactory.ArquivoConf(). Arquivo de configuracao nao encontrado");
		} catch (Exception e) {			
			log.fatal("ConnectionFactory.ArquivoConf(). Erro de Criptografia [Exception]");
		}
	}
	
	   /**
     * Método que configura o BaseDataSource
     */
    private void configurarDataSourceRAC(){
    	if(dataSource==null){
	        ConnectionFactory.dataSource = new BasicDataSource();
	        ConnectionFactory.dataSource.setDriverClassName(driver);
	        ConnectionFactory.dataSource.setUsername(user);
	        ConnectionFactory.dataSource.setPassword(password);
	        ConnectionFactory.dataSource.setUrl(url);
	        ConnectionFactory.dataSource.setInitialSize(initialSize);//Seta o pool para apenas uma conexão ativa
	        ConnectionFactory.dataSource.setMinIdle(minIdle);//Obriga o pool a ter pelo menos uma conexão sempre ativa
	        ConnectionFactory.dataSource.setMaxActive(maxTotal);
	        ConnectionFactory.dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
	        ConnectionFactory.dataSource.setTestOnReturn(true);//Habilita o teste da conexão antes de retorná-la
	        ConnectionFactory.dataSource.setRemoveAbandoned(true); // remove conexoes abondonadas
	        ConnectionFactory.dataSource.setRemoveAbandonedTimeout(30);// remove as conexoes abondonadas depois de determinado tempo 
	        //ConnectionFactory.dataSource.setValidationQuery("SELECT sysdate FROM dual");//Query que serve para atestar conectividade (para oracle)
    	}
    }

    /**
     * Método que retorna uma conexão do BasicDataSource.
     * Nesse caso ele verifica se existe uma conexão pronta, senão existir verifica
     * se o número de conexões está abaixo do que foi estabelecido, se estiver cria
     * a conexão e devolve.
     * @return Uma conexão do pool
     */
    public Connection getConexaoRAC(){
        try{
             return ConnectionFactory.dataSource.getConnection();
             
        }catch (SQLException sqle){
        	log.fatal("Erro ao conectar no Banco de Dados (SQLException). " + sqle.getMessage());
        }catch (Exception e){
        	log.fatal("Erro ao conectar no Banco de Dados (Exception). " + e.getMessage());
        }

        return null;

    }

    /**
     * Mostra informações do DataSource
     */
    public void showStatusDataSource(){
    	System.out.println("Conexoes ativas: " + ConnectionFactory.dataSource.getNumActive());
    	System.out.println("Conexoes inativas: " + ConnectionFactory.dataSource.getNumIdle());
        //log.debug("Conexoes ativas: " + ConnectionFactory.dataSource.getNumActive());
        //log.debug("Conexoes inativas: " + ConnectionFactory.dataSource.getNumIdle());
    }

    /**
     * Fecha tudo o que foi usado pelos DAO's incluindo a conexão.
     * Nesse caso a conexão não é fechada de fato como no JDCB puro, e sim devolvida
     * ao pool de conexão (BasicDataSource)
     * @param rs ResultSet
     * @param ps PreparedStatement
     * @param conn Connection (oriunda do BasicDataSource, mas pode ser a do JDBC também)
     */
    public static void liberarRecursosBD(ResultSet rs, PreparedStatement ps, Connection conn){
        try{
            if (ps != null)
            	ps.close();
            if (rs != null)
                rs.close();
            if (conn != null)
                conn.close();
        }catch (SQLException sqle){
        	log.fatal("Erro ao liberar recurso do Banco de Dados (SQLException). " + sqle.getMessage());
        }catch (Exception e){
        	log.fatal("Erro ao liberar recurso do Banco de Dados (SQLException). " + e.getMessage());            
        }

    }	
}