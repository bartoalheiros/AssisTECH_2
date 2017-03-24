package br.ufrpe.assistec.dados;

import java.util.List;

import br.ufrpe.assistec.exceptions.ClienteJahCadastradoException;
import br.ufrpe.assistec.exceptions.CpfCharException;
import br.ufrpe.assistec.negocio.beans.Cliente;

public interface IRepositorioClientes {
	public boolean cadastrar(Cliente cliente);
	
	public void atualizar(Cliente cli);

	public Cliente buscaPorCpf(Long cpf);


	void remover(Long cpf);
	
	//public List<Cliente> listarTodos();
}
