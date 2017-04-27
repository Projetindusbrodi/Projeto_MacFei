import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;




public class Pedidos extends JFrame{
	

	public Pedidos() throws SQLException{
		
		JLabel lblNewLabel = new JLabel("New label");
		getContentPane().add(lblNewLabel, BorderLayout.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		getContentPane().add(lblNewLabel_1, BorderLayout.SOUTH);
		CLassBD banco = new CLassBD();
		
		banco.getConnection();
		
		banco.resultSet = banco.statement.executeQuery("Select * from tbproduto");
		
		while(banco.resultSet.next()){
			String a = banco.resultSet.getString("Nome");
			lblNewLabel.setText(a);
			lblNewLabel_1.setText(String.valueOf(banco.resultSet.getInt("Valor")));
		}
		
		
	}

}
