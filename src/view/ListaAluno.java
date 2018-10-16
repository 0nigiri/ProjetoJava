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

import controller.ControladorAluno;
import dao.AlunoDAO;
import model.Aluno;

public class ListaAluno {

	static DefaultTableModel tableModel;
	final JFrame frame = new JFrame("Lista de Aluno");
	private JButton cadastroAlunoButton;
	private	JButton editar;
	private JButton deletar;
	private static  int selectedRowIndex =-1;
	private static Aluno aluno;
	
     

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaAluno window = new ListaAluno();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public static void inicializarListaAlunos() {
			tableModel.setRowCount(0);
		ControladorAluno controladorAluno= new ControladorAluno();
		
		
		for (Aluno aluno : controladorAluno.consultarListaAluno()) {
			Object[] data = { aluno.getMatricula(), aluno.getNome(), aluno.getCurso(), aluno.getDataNascimento(),
					aluno.getCpf(), aluno.getDataNascimento() ,aluno.geteMail(), aluno.getEndereco(), aluno.getSexo() };
			tableModel.addRow(data);
		}
	}


	public static void editarNaListaAluno() {
		ControladorAluno controladorAluno = new ControladorAluno();
	//	int tamanhoLista = controladorAluno.ListaAlunos.size();
    //	Aluno aluno = controladorAluno.ListaAlunos.get(selectedRowIndex);// ultimo professor incluso

		Object[] data =  { aluno.getMatricula(), aluno.getNome(), aluno.getCurso(), aluno.getDataNascimento(),
				aluno.getCpf(), aluno.getDataNascimento() ,aluno.geteMail(), aluno.getEndereco(), aluno.getSexo() };
		tableModel.insertRow(selectedRowIndex, data);
		tableModel.removeRow(selectedRowIndex + 1);
	}
	/*			
	 * 
	 * */
	
	public ListaAluno() {
		initialize();
	}

	private void initialize() {
		
		
		
		 JPanel painelFundo = new JPanel();
		 
		//painelFundo.setLayout(new GridLayout(1, 1));

		String[] colunas = { "Matricula", "Nome", "Curso"};
		tableModel = new DefaultTableModel(colunas, 0);

		final JTable tabela = new JTable(tableModel);
		//painelFundo.setLayout(new GridLayout(1, 1));
		JScrollPane barraRolagem = new JScrollPane(tabela);
		painelFundo.setBounds(5, 5, 485, 300);

		painelFundo.add(barraRolagem);
		inicializarListaAlunos();

		cadastroAlunoButton = new JButton("Novo item");
		
		cadastroAlunoButton.setBackground(Color.BLACK);
		cadastroAlunoButton.setForeground(Color.WHITE);
		cadastroAlunoButton.setBounds(10, 50, 50, 23);
		painelFundo.add(cadastroAlunoButton);
		
		editar = new JButton("Editar");
		
		editar.setBackground(Color.YELLOW);
		editar.setForeground(Color.BLACK);
		editar.setBounds(60,50,50,23);
		painelFundo.add(editar);
		editar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent editar) {

				selectedRowIndex = tabela.getSelectedRow();
				int matricula = (int) tabela.getValueAt(tabela.getSelectedRow(), 0);
				
		//		Aluno aluno = Contro ladorAluno.ListaAlunos.get(selectedRowIndex);
				ControladorAluno controladorAluno = new ControladorAluno();
				aluno = controladorAluno.consultarUnicoAluno(matricula);
				
				EditarAluno editarAluno =  new EditarAluno(aluno, selectedRowIndex);
				
			}
		});
		
	deletar = new JButton("Deletar");
		
		deletar.setBackground(Color.RED);
		deletar.setForeground(Color.BLACK);
		deletar.setBounds(100,50,50,23);
		painelFundo.add(deletar);
		deletar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent deletar) {
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente deletar?", "Aviso", JOptionPane.YES_NO_OPTION);

				if (resposta == JOptionPane.YES_OPTION) {
					
					
					selectedRowIndex = tabela.getSelectedRow();
					int matricula = (int) tabela.getValueAt(tabela.getSelectedRow(), 0);
					
			//		Aluno aluno = Contro ladorAluno.ListaAlunos.get(selectedRowIndex);
					ControladorAluno controladorAluno = new ControladorAluno();
					aluno = controladorAluno.consultarUnicoAluno(matricula);
					controladorAluno.deletarAluno(matricula);
					
					selectedRowIndex = tabela.getSelectedRow();
					tableModel.removeRow(selectedRowIndex);
				} 
				
				
			}
		});
		
		
		
		
		cadastroAlunoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastroAluno cadastroAluno = new CadastroAluno();
				
			}
		});		

		frame.getContentPane().add(painelFundo);
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}


}


