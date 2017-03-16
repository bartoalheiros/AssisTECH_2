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

	public void cadastrar(Cliente c) throws ClienteJahCadastradoException {
		if (c != null) {
			if(!this.existe(c)) {
				this.repositorio.cadastrar(c);
			} else {
				String cpf = c.getCpf();
				throw new ClienteJahCadastradoException(cpf);
			} 
		}else {
			throw new IllegalArgumentException("Parâmetro inválido");
		}

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

	public void alterar (Cliente c) throws ClienteNaoCadastradoException {
		if(this.existe(c)){
			((RepositorioClientesArray)this.repositorio).alterar(c);
		}else {
			String cpf = c.getCpf();
			throw new ClienteNaoCadastradoException(cpf);
		}
	}

	public void remover(String cpf) throws ClienteNaoCadastradoException {
		if(this.buscar(cpf) != null){
			((RepositorioClientesArray)this.repositorio).remover(cpf);
		}else {
			throw new ClienteNaoCadastradoException(cpf);
		}
	}

	public List<Cliente> listar() { 
		return ((RepositorioClientesArrayList)this.repositorio).listarTodos();
	}


}
