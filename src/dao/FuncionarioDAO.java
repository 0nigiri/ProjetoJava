package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

import javax.naming.NamingException;

import model.Aluno;
import model.Funcionario;
import dao.BancoDados;

public class FuncionarioDAO {
	
	private BancoDados db = null;
	
	public FuncionarioDAO() {
		try {
			db = new BancoDados("curso_java_fti");
		} catch (NamingException e) {
			System.out.println("Erro ao instanciar o Banco de Dados: " + e);
		}
	}
	
	public void cadastrarFuncionario(Funcionario funcionario) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = db.obterConexao();
			conn.setAutoCommit(false);
			
			StringBuffer sql = new StringBuffer();
			
			sql.append("INSERT INTO aluno( nome_aluno, cpf_aluno, data_de_nascimento_aluno, endereco_aluno, telefone_aluno, email_aluno, sexo_aluno, curso_aluno) ");
			sql.append("VALUES(?,?,?,?,?,?,?,?)");

			stmt = conn.prepareStatement(sql.toString());

			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getCpf());
			stmt.setDate  (3, Date.valueOf(funcionario.getDataNascimento()));
			stmt.setString(4, funcionario.getEndereco());
			stmt.setString(5, funcionario.getTelefone());
			stmt.setString(6, funcionario.geteMail());
			stmt.setString(7, funcionario.getSexo());
			stmt.setString(8, funcionario.getCargo());

			stmt.execute();
			conn.commit();
		} catch (SQLException e) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					System.out.println("Erro no metodo cadastrarAluno - rollback");
				}
			}
			System.out.println("Erro no metodo cadastrarAluno");
			e.printStackTrace();
		} finally {
			db.finalizaObjetos(rs, stmt, conn);
		}
		
		System.out.println("Aluno " + funcionario.getNome() + " da disciplina " + funcionario.getCargo() + " cadastrado com sucesso!");
	}
	
	
	public List<Funcionario> consultarListaFuncionario() {

		List<Funcionario> listaFuncionario= new ArrayList<Funcionario>();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = db.obterConexao();

			String sql = "SELECT  matricula_aluno, nome_aluno, cpf_aluno, data_de_nascimento_aluno, endereco_aluno, telefone_aluno, email_aluno, sexo_aluno, curso_aluno  "
					+ "FROM  aluno "
					+ "ORDER BY matricula_aluno ASC";

			stmt = conn.prepareStatement(sql.toString());

			
			
			rs = stmt.executeQuery();

			while (rs.next()) {
				Funcionario funcionario = new Funcionario();

				funcionario.setCodigo(rs.getInt("matricula_aluno"));
				funcionario.setNome(rs.getString("nome_aluno"));
				funcionario.setCpf(rs.getString("cpf_aluno"));
				funcionario.setDataNascimento(rs.getDate("data_de_nascimento_aluno").toLocalDate());
				funcionario.setEndereco(rs.getString("endereco_aluno"));
				funcionario.setTelefone(rs.getString("telefone_aluno"));
				funcionario.seteMail(rs.getString("email_aluno"));
				funcionario.setSexo(rs.getString("sexo_aluno"));
				funcionario.setCargo(rs.getString("curso_aluno"));

				
				listaFuncionario.add(funcionario);
				
				
				
			}

		} catch (SQLException e) {
			System.out.println("Erro no m�todo consultarListaAluno");
			e.printStackTrace();
		} finally {
			db.finalizaObjetos(rs, stmt, conn);
		}
		return listaFuncionario;
	}
	
	public Funcionario consultarFuncionario(int matricula) {

		Funcionario funcionario= new Funcionario();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = db.obterConexao();

			String sql = "SELECT matricula_aluno, nome_aluno, cpf_aluno, data_de_nascimento_aluno, endereco_aluno, telefone_aluno, email_aluno, sexo_aluno, curso_aluno "
					+ "FROM  aluno "
					+ "WHERE matricula_aluno = ?";

			stmt = conn.prepareStatement(sql.toString());
			stmt.setInt(1, matricula);

			rs = stmt.executeQuery();

			if (rs.next()) {
				funcionario.setCodigo(rs.getInt("matricula_aluno"));
				funcionario.setNome(rs.getString("nome_aluno"));
				funcionario.setCpf(rs.getString("cpf_aluno"));
				funcionario.setDataNascimento(rs.getDate("data_de_nascimento_aluno").toLocalDate());
				funcionario.setEndereco(rs.getString("endereco_aluno"));
				funcionario.setTelefone(rs.getString("telefone_aluno"));
				funcionario.seteMail(rs.getString("email_aluno"));
				funcionario.setSexo(rs.getString("sexo_aluno"));
				funcionario.setCargo(rs.getString("curso_aluno"));
			}

		} catch (SQLException e) {
			System.out.println("Erro no m�todo consultarAluno");
			e.printStackTrace();
		} finally {
			db.finalizaObjetos(rs, stmt, conn);
		}
		return funcionario;
	}	
	
	public void deletarFuncionario(int matricula) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = db.obterConexao();
			conn.setAutoCommit(false);

			StringBuffer sql = new StringBuffer();
			
			
			//sql.append("UPDATE nome_tabela SET nome_campo = ? ");
			sql.append("DELETE FROM aluno ");
			//sql.append("WHERE nome_campo_id = ?;");
			sql.append("WHERE matricula_aluno = ? ");
			
			stmt = conn.prepareStatement(sql.toString());
			
			//stmt.setInt(1, professor.getId());
	/*		stmt.setString(1, aluno.getNome());
			stmt.setString(2, aluno.getCpf());
			stmt.setDate  (3, Date.valueOf(aluno.getDataNascimento()));
			stmt.setString(4, aluno.getEndereco());
			stmt.setString(5, aluno.getTelefone());
			stmt.setString(6, aluno.geteMail());
			stmt.setString(7, aluno.getSexo());
			stmt.setString(8, aluno.getCurso());
*/
			stmt.setInt(1, matricula);
			
			stmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					System.out.println("Erro no m�todo alterarAluno - rollback");
				}
			}
			System.out.println("Erro no m�todo alterarAluno");
			e.printStackTrace();
		} finally {
			db.finalizaObjetos(rs, stmt, conn);
		}
	}	
	
	public void alterarFuncionario(Funcionario funcionario) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = db.obterConexao();
			conn.setAutoCommit(false);

			StringBuffer sql = new StringBuffer();
			
			//sql.append("UPDATE nome_tabela SET nome_campo = ? ");
			sql.append("UPDATE aluno "
					+ "SET "
					+ "nome_aluno = ? ,"
					+ "cpf_aluno = ? ,"
					+ "data_de_nascimento_aluno = ? ,"
					+ "endereco_aluno = ? ,"
					+ "telefone_aluno = ? ,"
					+ "email_aluno = ? ,"
					+ "sexo_aluno = ? ,"
					+ "curso_aluno = ? ");
			//sql.append("WHERE nome_campo_id = ?;");
			sql.append("WHERE matricula_aluno = ? ");
			
			stmt = conn.prepareStatement(sql.toString());
			
			//stmt.setInt(1, professor.getId());
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getCpf());
			stmt.setDate  (3, Date.valueOf(funcionario.getDataNascimento()));
			stmt.setString(4, funcionario.getEndereco());
			stmt.setString(5, funcionario.getTelefone());
			stmt.setString(6, funcionario.geteMail());
			stmt.setString(7, funcionario.getSexo());
			stmt.setString(8, funcionario.getCargo());
			stmt.setInt(9, funcionario.getCodigo());

			stmt.execute();
			conn.commit();
		} catch (SQLException e) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					System.out.println("Erro no m�todo alterarAluno - rollback");
				}
			}
			System.out.println("Erro no m�todo alterarAluno");
			e.printStackTrace();
		} finally {
			db.finalizaObjetos(rs, stmt, conn);
		}
	}	
	
}
