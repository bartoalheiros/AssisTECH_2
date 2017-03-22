package br.ufrpe.assistec.dados;

import java.util.List;

import br.ufrpe.assistec.exceptions.ClienteJahCadastradoException;
import br.ufrpe.assistec.negocio.beans.Cliente;

public interface IRepositorioClientes {
	public boolean cadastrar(Cliente cliente);
	
	public Cliente buscaPorCpf(String cpf);
	
	public void remover(String cpf);
	
	public void atualizar(Cliente cli);
	
	//public List<Cliente> listarTodos();
}
