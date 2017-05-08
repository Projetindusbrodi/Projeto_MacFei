package Projeto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class Carregar {

	//instancia classe banco
	ClassBD banco = new ClassBD();
	
	
	public ResultSet carregarItem(int ID){
		
		//Declaração de escopo
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		//Dps explico
		try{
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetcdb","root","");
			ps = connection.prepareStatement(("select * from tbproduto where IDprod = " + ID).toString());
			rs = ps.executeQuery();
		}catch (Exception error) {
			JOptionPane.showMessageDialog(null, error.getMessage());}
		return rs;}
	
	
	
}
