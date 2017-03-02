package br.ufrpe.assistec.dados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.ufrpe.assistec.negocio.beans.Cliente;

public class RepositorioClientesArrayList implements IRepositorioClientes{
	List<Cliente> listaClientes = null;
	
	public RepositorioClientesArrayList() {
		this.listaClientes = new ArrayList(); 
	}
	
	@Override
	public void cadastrar(Cliente cliente) {
		this.listaClientes.add(cliente);
		
	}

	@Override
	public Cliente buscaPorCpf(String cpf) {
		Cliente cliente = null;
		
		for(Cliente cli: listaClientes) {
			if(cli.getCpf().equals(cpf)) {
				cliente = cli;
				break;
			}
		}
		return cliente;
	}

	@Override
	public void remover(String cpf) {
		
		for(Cliente cli: listaClientes) {
			if(cli.getCpf().equals(cpf)) {
				this.listaClientes.remove(cli);
			}
		}
		
	}

	public List<Cliente> listarTodos() {
		return this.listaClientes;
		
	}
	
	public List<Cliente> listarTodosOrdenadosPorNome() {
		
		Collections.sort(this.listaClientes);
		
		return this.listaClientes;
		
	}
	
	public static void main(String[] args) {
		Cliente cli1 = new Cliente("1234567", "João", "Silva", "Rua das Garças, 72.", "3493-0282", "joao@gmail.com", 2);
		Cliente cli2 = new Cliente("1234568", "Cláudio", "Silva", "Rua das Garças, 72.", "3493-0282", "joao@gmail.com", 2);
		Cliente cli3 = new Cliente("1234569", "Cristiano", "Silva", "Rua das Garças, 72.", "3493-0282", "joao@gmail.com", 2);
		Cliente cli4 = new Cliente("1234561", "Norma", "Silva", "Rua das Garças, 72.", "3493-0282", "joao@gmail.com", 2);
		
		RepositorioClientesArrayList repo = new RepositorioClientesArrayList();
		
		System.out.println("Adicionando CLientes");
		repo.cadastrar(cli1);
		repo.cadastrar(cli2);
		repo.cadastrar(cli3);
		
		System.out.println("Imprimindo todos os Clientes");
		imprimir(repo.listarTodos());
		
		System.out.println("Clientes em Ordem Alfabética");
		imprimir(repo.listarTodosOrdenadosPorNome());
	}
	
	public static void imprimir(List<Cliente> listaCli) {
		for(Cliente cli: listaCli) {
			System.out.println(cli);
		}
	}

}
