package controller;

import java.util.ArrayList;

import model.Funcionario;

public class ControladorFuncionario{
	
	public static ArrayList<Funcionario> ListaFuncionario;
	
	
	public ControladorFuncionario() {
		if (ListaFuncionario == null) {
			ListaFuncionario  = new ArrayList<Funcionario>();
		}		
	}
	
	public void cadastrarFuncionario(Funcionario funcionario) {
		ListaFuncionario .add(funcionario);
		System.out.println("Aluno " + funcionario.getNome() + " do curso " + funcionario.getCargo() + " cadastrado com sucesso!");
		System.out.println("Qtd funcionario: " +  ListaFuncionario.size());
	}
	
	public void editarFuncionario(Funcionario funcionario, int index) {
		ListaFuncionario.set(index, funcionario);
		System.out.println("Aluno " + funcionario.getNome() + " do curso " + funcionario.getCargo() + " cadastrado com sucesso!");
		System.out.println("Qtd Aluno: " +  ListaFuncionario.size());
	}
}
