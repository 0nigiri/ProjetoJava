package controller;

import java.util.ArrayList;
import java.util.List;

import dao.AlunoDAO;
import model.Aluno;

public class ControladorAluno {
	
	
	public List<Aluno> consultarListaAluno(){
		AlunoDAO alunoDAO = new AlunoDAO();
		return alunoDAO.consultarListaAluno();
		
	}
	
	public Aluno  consultarUnicoAluno(int matricula){
		AlunoDAO alunoDAO = new AlunoDAO();
		return alunoDAO.consultarAluno(matricula);
		
	}
	
	
	public Aluno  deletarAluno(int matricula){
		AlunoDAO alunoDAO = new AlunoDAO();
		 alunoDAO.deletarAluno(matricula);
		return null;
		
	}
	
	
	public void cadastrarAluno(Aluno aluno) {
		System.out.println("Aluno " + aluno.getNome() + " do curso " + aluno.getCurso() + " cadastrado com sucesso!");
		
		AlunoDAO alunoDAO = new AlunoDAO();
		alunoDAO.cadastrarAluno(aluno);
		
	}
	
	public void editarAluno(Aluno aluno, int index) {
		System.out.println("Aluno " + aluno.getNome() + " do curso " + aluno.getCurso() + " editado com sucesso!");
		AlunoDAO alunoDAO = new AlunoDAO();
		alunoDAO.alterarAluno(aluno);
	}
	
	
	
	
}
