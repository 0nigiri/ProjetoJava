package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controller.ControladorFuncionario;
import model.Funcionario;


public class ListaFuncionario {

	static DefaultTableModel tableModel;
	final JFrame frame = new JFrame("Lista de Funcionario");
	private JButton cadastroFuncionarioButton;
	private	JButton editar;
	private static  int selectedRowIndex =-1;
	private static Funcionario funcionario;
	
     

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaFuncionario window = new ListaFuncionario();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public static void inicializarListaFuncionario() {

		ControladorFuncionario controladorFuncionario = new ControladorFuncionario();
		for (Funcionario funcionario : ControladorFuncionario.ListaFuncionario) {
			Object[] data = { funcionario.getCodigo(), funcionario.getNome(), funcionario.getCargo() ,
					funcionario.getDataNascimento(), funcionario.getCpf(), funcionario.geteMail(),
					funcionario.getEndereco(), funcionario.getSexo(), funcionario.getSalario(),
					funcionario.getValeAlimentacao(), funcionario.getValeRefeicao(), funcionario.getValeTransporte(),
					funcionario.getDisciplina() };
			tableModel.addRow(data);
		}
	}
	

	
	public static void adicionarNaListaFuncionario() {
		ControladorFuncionario controladorFuncionario= new ControladorFuncionario();
		int tamanhoLista = controladorFuncionario.ListaFuncionario.size();

		Funcionario funcionario = controladorFuncionario.ListaFuncionario.get(tamanhoLista - 1);//ultimo professor incluso
		
		Object[] data = {funcionario.getCodigo(), funcionario.getNome(), funcionario.getCargo() ,
				funcionario.getDataNascimento(), funcionario.getCpf(), funcionario.geteMail(),
				funcionario.getEndereco(), funcionario.getSexo(), funcionario.getSalario(),
				funcionario.getValeAlimentacao(), funcionario.getValeRefeicao(), funcionario.getValeTransporte(),
				funcionario.getDisciplina() };
		tableModel.addRow(data);
	}
	

	public static void editarNaListaFuncionario() {
		ControladorFuncionario controladorFuncionario = new ControladorFuncionario();
		int tamanhoLista = controladorFuncionario.ListaFuncionario.size();

		Funcionario funcionario = controladorFuncionario.ListaFuncionario.get(selectedRowIndex);//ultimo professor incluso
		
		Object[] data = {funcionario.getCodigo(), funcionario.getNome(), funcionario.getCargo() ,
				funcionario.getDataNascimento(), funcionario.getCpf(), funcionario.geteMail(),
				funcionario.getEndereco(), funcionario.getSexo(), funcionario.getSalario(),
				funcionario.getValeAlimentacao(), funcionario.getValeRefeicao(), funcionario.getValeTransporte(),
				funcionario.getDisciplina() };
		tableModel.insertRow(selectedRowIndex, data);
		tableModel.removeRow(selectedRowIndex+1);
	}
	/*			
	 * 
	 * */
	
	public ListaFuncionario() {
		initialize();
	}

	private void initialize() {
		
		
		inicializarListaFuncionario();
		
		 JPanel painelFundo = new JPanel();
		 
		//painelFundo.setLayout(new GridLayout(1, 1));

		String[] colunas = { "Codigo", "Nome", "Cargo"};
		tableModel = new DefaultTableModel(colunas, 0);

		final JTable tabela = new JTable(tableModel);
		//painelFundo.setLayout(new GridLayout(1, 1));
		JScrollPane barraRolagem = new JScrollPane(tabela);
		painelFundo.setBounds(5, 5, 485, 300);

		painelFundo.add(barraRolagem);

		cadastroFuncionarioButton = new JButton("Novo item");
		
		cadastroFuncionarioButton.setBackground(Color.BLACK);
		cadastroFuncionarioButton.setForeground(Color.WHITE);
		cadastroFuncionarioButton.setBounds(10, 50, 50, 23);
		painelFundo.add(cadastroFuncionarioButton);
		
		editar = new JButton("Editar");
		
		editar.setBackground(Color.YELLOW);
		editar.setForeground(Color.BLACK);
		editar.setBounds(60,50,50,23);
		painelFundo.add(editar);
		editar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				selectedRowIndex = tabela.getSelectedRow();
				Funcionario funcionario= ControladorFuncionario.ListaFuncionario.get(selectedRowIndex);
				EditarFuncionario EditarFuncionario =  new EditarFuncionario(funcionario, selectedRowIndex);
				
			}
		});
		
		
		cadastroFuncionarioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastroFuncionario cadastroFuncionario= new CadastroFuncionario();
			}
		});		

		frame.getContentPane().add(painelFundo);
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}


}


