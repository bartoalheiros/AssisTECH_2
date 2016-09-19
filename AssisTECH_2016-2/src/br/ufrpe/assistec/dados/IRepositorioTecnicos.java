package br.ufrpe.assistec.dados;

import br.ufrpe.assistec.negocio.beans.Tecnico;

public interface IRepositorioTecnicos {
	
	public void cadastrar(Tecnico tecnico);
	
	public Tecnico buscar(String mat);
	
	public void listar();

	public void remover(String matricula);
	
	public void atualizar(Tecnico tec);
	
}
