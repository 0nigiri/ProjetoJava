package view;

/*	inicio 5/10
 * 		13:20	-	17:30	-	criacao da tabela Aluno
 * 			8/10
 * 		13:30	-	-17:40	-	cadastrar/editar Aluno tabela
 * 			9/10
 * 		13:20	-	14:20	-	teste cadastro/editar aluno tabela
 * 		14:20	-			-	Inicio criacao de tabela Funcionario/professor
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

public class MenuPrincipal {

	private JFrame frmCadastro;
	private JButton tabelaAluno;
	private JButton tabelaFuncionario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal window = new MenuPrincipal();
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
	public MenuPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastro = new JFrame();
		frmCadastro.setFont(new Font("Dialog", Font.PLAIN, 13));
		frmCadastro.setTitle("Menu Principal");
		frmCadastro.setBounds(100, 100, 452, 190);
		frmCadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastro.getContentPane().setLayout(null);
		frmCadastro.setResizable(false);

		tabelaAluno = new JButton("Aluno");
		tabelaAluno.setFont(new Font("Tahoma", Font.BOLD, 16));
		tabelaAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListaAluno listaAluno = new ListaAluno();
			}
		});
		tabelaAluno.setBounds(33, 49, 160, 74);
		frmCadastro.getContentPane().add(tabelaAluno);

		tabelaFuncionario = new JButton("Funcionario");
		tabelaFuncionario.setFont(new Font("Tahoma", Font.BOLD, 16));
		tabelaFuncionario.setBounds(233, 49, 152, 74);
		frmCadastro.getContentPane().add(tabelaFuncionario);

	}
}
