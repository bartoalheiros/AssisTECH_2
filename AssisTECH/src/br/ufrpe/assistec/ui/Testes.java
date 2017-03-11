package br.ufrpe.assistec.ui;

import java.util.List;

import br.ufrpe.assistec.dados.RepositorioClientesArrayList;
import br.ufrpe.assistec.negocio.beans.Cliente;

public class Testes {

	public static void main(String[] args) {
		RepositorioClientesArrayList repo = RepositorioClientesArrayList.getInstance();
		
		System.out.println("Imprimindo todos os clientes: \n");
		imprimir(repo.listarTodos());

	}

	public static void imprimir(List<Cliente> listaCli) {
		for(Cliente cli: listaCli) {
			System.out.println(cli);
		}
	}
}
