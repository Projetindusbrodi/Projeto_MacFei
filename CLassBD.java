package Projeto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClassBD {

	 public static Connection connection = null;
	    public static Statement statement = null;
	    public static ResultSet resultSet = null; 
	    public static final String DRIVER   = "com.mysql.jdbc.Driver";
	    static final String URL      = "jdbc:mysql://localhost:3306/projetcdb";
	    /** 
	     * método que faz conexão com o banco de dados
	     * retorna true se houve sucesso, ou false em caso negativo
	     */
	    public static boolean getConnection()
	    {
	       try
	       {
	    	   Class.forName(DRIVER);
	    	   Connection connection = DriverManager.getConnection(URL,"root","");
	    	   statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	          return true;
	       }
	       catch(ClassNotFoundException erro)
	       {
	       	  erro.printStackTrace();
	          return false;
	       }
	       catch(SQLException erro)
	       {
	       	  erro.printStackTrace();
	          return false;
	       }
	    }
	    
	    /**
	     * Fecha ResultSet, Statement e Connection
	     */
	    public void close()
	    {
		   closeResultSet();
		   closeStatement();
		   closeConnection();	
		}
		
		private static void closeConnection()
		{
		   try
		   {
		      connection.close();
		      System.out.println("Desconectou");
		   }
		   catch(SQLException erro)
		   {
		      erro.printStackTrace();
		   } 
		}  

		private static void closeStatement()
		{
		   try
		   {
		      statement.close();
		   }
		   catch(Exception e)
		   {
	          e.printStackTrace();
	       }
		}

		private static void closeResultSet()
		{
		   try
		   {
		      resultSet.close();
		   }
		   catch(Exception e)
		   {
	          e.printStackTrace();
		   }
		}
	    
	    /**
	     * Carrega o resultSet com o resultado do script SQL
	     */
	    public static void setResultSet(String sql)
	    {
		   try
		   {
			  resultSet = statement.executeQuery(sql);
		   }
	       catch(SQLException erro)
	       {
	          erro.printStackTrace();
	       } 
	    }  

	    /**
	     * Executa um script SQL de atualização
	     * retorna um valor inteiro contendo a quantidade de linhas afetadas
	     */
	    public static int runSQL(String sql)
	    {
		   int quant = 0; 
		   try
		   {
			  quant = statement.executeUpdate(sql);
		   }
		   catch(SQLException erro)
		   {
		   	  erro.printStackTrace();
		   } 
	       return quant;
		}  
	
}
