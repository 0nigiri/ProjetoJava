/*	inicio	27/9 - 15:00 -	17:30 	-> 	mudanca na validação da data de nascimento
*			28/9 - 13:30 -	14:00   ->	finalizando validacao da data de nascimento  
*				   14:00 -	16:00	->	inicio  matricula, apenas aceitar numeroes e com limite de 9 digitos		
*				   16:00 -	16:10	->	atualizando CPF para apenas numeros e com limite de 11 digitos
*				   16:10 -	16:55	->	Atualizar cadastro professor com a nova validacao de data de nascimento e cpf
*	Concluido	   16:55 -	17:25	->	Teste do programa 
*/
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.Font;



public class Cadastro {

	private JFrame frmCadastro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro window = new Cadastro();
					window.frmCadastro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Cadastro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastro = new JFrame();
		frmCadastro.setFont(new Font("Dialog", Font.PLAIN, 13));
		frmCadastro.setTitle("Cadastro");
		frmCadastro.setBounds(100, 100, 410, 213);
		frmCadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastro.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Aluno");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(25, 65, 160, 74);
		frmCadastro.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Funcionario");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(217, 65, 152, 74);
		frmCadastro.getContentPane().add(btnNewButton_1);
		
		JLabel lblQualCadastroDeseja = new JLabel("Qual cadastro deseja realizar?");
		lblQualCadastroDeseja.setFont(new Font("Nirmala UI", Font.BOLD | Font.ITALIC, 20));
		lblQualCadastroDeseja.setBounds(49, 20, 305, 34);
		frmCadastro.getContentPane().add(lblQualCadastroDeseja);

		
	}
}
