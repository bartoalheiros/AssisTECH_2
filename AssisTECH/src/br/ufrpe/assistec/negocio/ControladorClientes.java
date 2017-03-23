package br.ufrpe.assistec.negocio;

import java.util.List;

import br.ufrpe.assistec.dados.IRepositorioClientes;
import br.ufrpe.assistec.dados.RepositorioClientesArray;
import br.ufrpe.assistec.dados.RepositorioClientesArrayList;
import br.ufrpe.assistec.exceptions.*;
import br.ufrpe.assistec.negocio.beans.Cliente;

public class ControladorClientes {
	private IRepositorioClientes repositorio;

	public ControladorClientes() {
		this.repositorio = RepositorioClientesArrayList.getInstance();
	}

	public boolean existe(Cliente c) {
		boolean resultado = ((RepositorioClientesArrayList)this.repositorio).existe(c);

		return resultado;
	}

	public void cadastrar(Cliente cliente) throws ClienteJahCadastradoException {

		if (cliente == null) {
			throw new IllegalArgumentException("Parâmetro inválido");
		}
		
		if (this.existe(cliente)) {
			throw new ClienteJahCadastradoException(cliente.getCpf());
		}
		
		this.repositorio.cadastrar(cliente);
		
		
//		boolean r = this.repositorio.cadastrar(cliente);
//
//		if (cliente != null) {
//			if(r == false) {
//				String cpf = cliente.getCpf();
//				throw new ClienteJahCadastradoException(cpf);
//			} 
//		}else {
//			throw new IllegalArgumentException("Parâmetro inválido");
//		}

	}

	public Cliente buscar(String cpf) throws ClienteNaoCadastradoException {
		Cliente cli = ((RepositorioClientesArrayList)this.repositorio).buscaPorCpf(cpf);

		if(cli == null) {
			throw new ClienteNaoCadastradoException(cpf);
		}

		return cli;
	}

	public void buscarPorLogin(String usrName, String passwd) throws NomeDeUsuarioOuSenhaInvalidaException {
		boolean resultado =  ((RepositorioClientesArrayList)this.repositorio).buscarPorLogin(usrName, passwd);

		if(resultado == false) {
			throw new NomeDeUsuarioOuSenhaInvalidaException();
		}	

	}

	public void atualizar (Cliente c) {
		if(this.existe(c)){
			((RepositorioClientesArrayList)this.repositorio).atualizar(c);
		}
	}

	public void remover(String cpf) {
		
		((RepositorioClientesArrayList)this.repositorio).remover(cpf);
		
	}

	public List<Cliente> listar() { 
		return ((RepositorioClientesArrayList)this.repositorio).listarTodos();
	}


}
