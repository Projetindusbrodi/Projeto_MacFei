import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Window.Type;


public class abaGeral extends JFrame{
	
	
	public abaGeral(){
		setType(Type.UTILITY);
		
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 45, 79, 45);
		getContentPane().add(panel);
		
		JButton btnNewButton = new JButton("+");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton.setBounds(192, 56, 41, 23);
		getContentPane().add(btnNewButton);
		
		JButton button = new JButton("-");
		button.setBounds(99, 56, 41, 23);
		getContentPane().add(button);
		
		JButton btnC = new JButton("C");
		btnC.setBounds(214, 11, 19, 23);
		getContentPane().add(btnC);
		
		JLabel lblContador = new JLabel("Contador");
		lblContador.setBounds(150, 60, 29, 14);
		getContentPane().add(lblContador);
		
		
	}
}
