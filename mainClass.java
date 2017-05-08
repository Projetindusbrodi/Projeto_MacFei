package Projeto;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Test.MainFrame;



public class mainClass extends JFrame {
	private JTextField txtUser;
	private JTextField txtPassw;
	
	
	public mainClass() {
		ClassBD BD = new ClassBD();
		
		setTitle("Acesso");
        setResizable(true);
        getContentPane().setLayout(null);
        
        JLabel lblUser = new JLabel("Usu\u00E1rio:");
        lblUser.setBounds(29, 60, 46, 14);
        getContentPane().add(lblUser);
        
        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setBounds(29, 90, 46, 14);
        getContentPane().add(lblSenha);
        
        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(77, 131, 89, 23);
        getContentPane().add(btnLogin);
        
        txtUser = new JTextField();
        txtUser.setBounds(94, 57, 108, 20);
        getContentPane().add(txtUser);
        txtUser.setColumns(10);
        
        txtPassw = new JTextField();
        txtPassw.setColumns(10);
        txtPassw.setBounds(94, 87, 108, 20);
        getContentPane().add(txtPassw);
		setType(Type.UTILITY);
		
		if(!ClassBD.getConnection()){
			  JOptionPane.showMessageDialog(null,
					  "Falha na conexão, o sistema será fechado!");	
			  System.exit(EXIT_ON_CLOSE);
			}
	}

	public static void main(String[] args)  {
		
		
		MainFrame janela = null;
		
		try {
			janela = new MainFrame();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*mainClass janela= new mainClass();*/
		
		Dimension tela=Toolkit.getDefaultToolkit().getScreenSize();
		janela.setLocation((tela.width-janela.getSize().width)/2,
				(tela.height-janela.getSize().height)/2);
		janela.setVisible(true);
	}}