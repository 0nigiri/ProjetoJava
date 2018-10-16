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
import dao.BancoDados;

public class AlunoDAO {
	
	private BancoDados db = null;
	
	public AlunoDAO() {
		try {
			db = new BancoDados("curso_java_fti");
		} catch (NamingException e) {
			System.out.println("Erro ao instanciar o Banco de Dados: " + e);
		}
	}
	
	public void cadastrarAluno(Aluno aluno) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = db.obterConexao();
			conn.setAutoCommit(false);
			
			StringBuffer sql = new StringBuffer();
			
			sql.append("INSERT INTO aluno( nome, cpf, data_de_nascimento, endereco, telefone, email, sexo, curso)");
			sql.append("VALUES(?,?,?,?,?,?,?,?)");

			stmt = conn.prepareStatement(sql.toString());

			stmt.setString(1, aluno.getNome());
			stmt.setString(2, aluno.getCpf());
			stmt.setDate  (3, Date.valueOf(aluno.getDataNascimento()));
			stmt.setString(4, aluno.getEndereco());
			stmt.setString(5, aluno.getTelefone());
			stmt.setString(6, aluno.geteMail());
			stmt.setString(7, aluno.getSexo());
			stmt.setString(8, aluno.getCurso());

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
		
		System.out.println("Professor " + aluno.getNome() + " da disciplina " + aluno.getCurso() + " cadastrado com sucesso!");
	}
	
	
	public List<Aluno> consultarListaAluno() {

		List<Aluno> listaAluno= new ArrayList<Aluno>();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = db.obterConexao();

			String sql = "SELECT  matricula, nome, cpf, data_de_nascimento, endereco, telefone, email, sexo, curso "
					+ "FROM  aluno "
					+ "ORDER BY matricula ASC";

			stmt = conn.prepareStatement(sql.toString());

			
			
			rs = stmt.executeQuery();

			while (rs.next()) {
				Aluno aluno = new Aluno();

				aluno.setMatricula(rs.getInt("matricula"));
				aluno.setNome(rs.getString("nome"));
				aluno.setCpf(rs.getString("cpf"));
				aluno.setDataNascimento(rs.getDate("data_de_nascimento").toLocalDate());
				aluno.setEndereco(rs.getString("endereco"));
				aluno.setTelefone(rs.getString("telefone"));
				aluno.seteMail(rs.getString("email"));
				aluno.setSexo(rs.getString("sexo"));
				aluno.setCurso(rs.getString("curso"));

				
				listaAluno.add(aluno);
				
				
				
			}

		} catch (SQLException e) {
			System.out.println("Erro no m�todo consultarListaAluno");
			e.printStackTrace();
		} finally {
			db.finalizaObjetos(rs, stmt, conn);
		}
		return listaAluno;
	}
	
	public Aluno consultarAluno(int matricula) {

		Aluno aluno = new Aluno();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = db.obterConexao();

			String sql = "SELECT  matricula, nome, cpf, data_de_nascimento, endereco, telefone, email, sexo, curso "
					+ "FROM  aluno "
					+ "WHERE matricula = ?";

			stmt = conn.prepareStatement(sql.toString());
			stmt.setInt(1, matricula);

			rs = stmt.executeQuery();

			if (rs.next()) {
				aluno.setMatricula(rs.getInt("matricula"));
				aluno.setNome(rs.getString("nome"));
				aluno.setCpf(rs.getString("cpf"));
				aluno.setDataNascimento(rs.getDate("data_de_nascimento").toLocalDate());
				aluno.setEndereco(rs.getString("endereco"));
				aluno.setTelefone(rs.getString("telefone"));
				aluno.seteMail(rs.getString("email"));
				aluno.setSexo(rs.getString("sexo"));
				aluno.setCurso(rs.getString("curso"));
			}

		} catch (SQLException e) {
			System.out.println("Erro no m�todo consultarAluno");
			e.printStackTrace();
		} finally {
			db.finalizaObjetos(rs, stmt, conn);
		}
		return aluno;
	}	
	
	public void deletarAluno(int matricula) {
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
			sql.append("WHERE matricula = ? ");
			
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
	
	public void alterarAluno(Aluno aluno) {
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
					+ "nome = ? ,"
					+ "cpf = ? ,"
					+ "data_de_nascimento = ? ,"
					+ "endereco = ? ,"
					+ "telefone = ? ,"
					+ "email = ? ,"
					+ "sexo = ? ,"
					+ "curso = ? ");
			//sql.append("WHERE nome_campo_id = ?;");
			sql.append("WHERE matricula = ? ");
			
			stmt = conn.prepareStatement(sql.toString());
			
			//stmt.setInt(1, professor.getId());
			stmt.setString(1, aluno.getNome());
			stmt.setString(2, aluno.getCpf());
			stmt.setDate  (3, Date.valueOf(aluno.getDataNascimento()));
			stmt.setString(4, aluno.getEndereco());
			stmt.setString(5, aluno.getTelefone());
			stmt.setString(6, aluno.geteMail());
			stmt.setString(7, aluno.getSexo());
			stmt.setString(8, aluno.getCurso());
			stmt.setInt(9, aluno.getMatricula());

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