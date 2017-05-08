package Projeto;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

import Projeto.Carregar;
import javax.swing.JLabel;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaProduto extends JFrame{
	private static final boolean NULL = false;
	private JTextField textField;
	private JTextField textField_1;
	Carregar cg = new Carregar();
	
	
	public TelaProduto() throws SQLException{
		
		setBounds(0,0,251,194);
		getContentPane().setLayout(null);
	
		Border borda =  BorderFactory.createLineBorder(Color.black,1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(10, 11, 233, 143);
		getContentPane().add(panel_1);
		 
		JPanel panel  = new JPanel();
		panel.setBounds(10, 11, 200, 113);
		panel_1.add(panel);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("img/Bebidas/1.png"));
		lblNewLabel.setBounds(10, 29, 34, 48);
		lblNewLabel.setBorder(borda);
		panel.add(lblNewLabel);
		
		JButton button = new JButton("-");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int quant  = Integer.parseInt(textField.getText());
				if( quant >0)
						{
					 		quant = quant-1;
					 		textField.setText(Integer.toString(quant));
						}
				
			}
		});
		button.setBounds(54, 41, 41, 23);
		panel.add(button);
		
		//Separar em class
		//Botão soma
		JButton button_1 = new JButton("+");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Carregar cg = new Carregar();
					ResultSet rs = cg.carregarItem(1);
					
					float valor = 0;
					
					rs.next();
					//if(rs.next())
					valor = Float.parseFloat(rs.getString("Valor"));
					int disponivel = Integer.parseInt(rs.getString("Disponib"));
					
					/*float total = Float.parseFloat(textField_1.getText());
					total += valor ;
					textField_1.setText(Float.toString(total));*/
					
					//Contador simples
					int quant = Integer.parseInt(textField.getText());
					if(disponivel > quant){
						float total = Float.parseFloat(textField_1.getText());
						total += valor ;
						textField_1.setText(Float.toString(total));
					quant = quant + 1;
					textField.setText(Integer.toString(quant));
					}
				}catch (Exception error){} //Necessario implementar
			}
		});
		button_1.setBounds(149, 41, 41, 23);
		panel.add(button_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		try{
			Carregar cg = new Carregar();
			ResultSet rs = cg.carregarItem(1);
			if(rs.next() != NULL)
			textField.setText(Integer.toString(1)); //Valor default
			textField.setHorizontalAlignment(SwingConstants.CENTER);
		}catch (Exception error){}
			textField.setBounds(105, 42, 31, 20);
			panel.add(textField);
		
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		try{
			Carregar cg = new Carregar();
			ResultSet rs = cg.carregarItem(1);
			if(rs.next() != NULL)
			textField_1.setText(rs.getString("Valor"));	//Valor default
			textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		}catch (Exception error){}
		textField_1.setBounds(125, 75, 68, 20);
		panel.add(textField_1);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(64, 78, 46, 14);
		panel.add(lblTotal);
}
	
	
	public static void main(String[] args) throws SQLException {
		TelaProduto mainF = null;
		try {
			mainF = new TelaProduto();
			mainF.setVisible(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}}
