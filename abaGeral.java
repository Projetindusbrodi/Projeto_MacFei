package Projeto;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;


import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;
import javax.swing.JTextField;


public class abaGeral extends JFrame{
	
	Carregar cg = new Carregar();
	ResultSet rs = cg.carregarItem(1);
	ClassBD banco = new ClassBD();
	private JTextField textField;
	
	
	public abaGeral() throws SQLException{
		setTitle("Loja");
		
		setType(Type.UTILITY);
		setBounds(0,0,261,270);
		setResizable(false);
		setVisible(true);
		
		getContentPane().setLayout(null);

		try{
			//Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:8080/projetcdb","root","mark");
			//String sql = "select * from tbproduto where IDprod = 1";
			//PreparedStatement ps = connection.prepareStatement(sql);
		    //ResultSet rs = ps.executeQuery();
		    
			JLabel lblContador = new JLabel("Contador");
			lblContador.setBounds(10, 109, 73, 14);
			if(rs.next())
			lblContador.setText(rs.getString("Nome"));
			getContentPane().add(lblContador);
			
		    
		}catch (Exception error) {
			JOptionPane.showMessageDialog(null,error.getMessage());}
		
		
		
		JPanel pnImg = new JPanel();
		pnImg.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnImg.setBounds(10, 45, 53, 34);
		getContentPane().add(pnImg);	
		
	
		JButton btSom = new JButton("");
		btSom.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btSom.setBounds(190, 56, 41, 23);
		ImageIcon icon = new ImageIcon("C:\\Users\\MarcusVinicius\\Pictures\\Icons\\png\\operadorSoma.png");
		Image img = icon.getImage();  
		Image newimg = img.getScaledInstance( 20, 20,  java.awt.Image.SCALE_SMOOTH ) ;  
		icon = new ImageIcon( newimg );
		btSom.setIcon(icon);
		
		
		btSom.setBorder(BorderFactory.createEmptyBorder());
		btSom.setContentAreaFilled(false);
		
		getContentPane().add(btSom);
		
		JButton btSub = new JButton("-");
		btSub.setBounds(85, 56, 41, 23);
		getContentPane().add(btSub);
		
		JButton btnCar = new JButton("C");
		btnCar.setBounds(190, 11, 53, 23);
		getContentPane().add(btnCar);
		

		JButton btAdd = new JButton("Add");
		btAdd.setBounds(136, 207, 60, 23);
		getContentPane().add(btAdd);		
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(146, 59, 31, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
	}	
}
