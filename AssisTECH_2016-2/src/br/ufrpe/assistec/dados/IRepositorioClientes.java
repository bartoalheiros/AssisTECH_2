package br.ufrpe.assistec.dados;

import br.ufrpe.assistec.negocio.beans.Cliente;

public interface IRepositorioClientes {
	public void cadastrar(Cliente cliente);
	
	public Cliente buscar(String cpf);
	
	public void remover(String cpf);
	
	public void listar();
}
