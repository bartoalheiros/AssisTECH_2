package br.ufrpe.assistec.dados;

import java.util.List;

import br.ufrpe.assistec.negocio.beans.Cliente;

public interface IRepositorioClientes {
	public void cadastrar(Cliente cliente);
	
	public Cliente buscaPorCpf(String cpf);
	
	public void remover(String cpf);
	
	//public List<Cliente> listarTodos();
}