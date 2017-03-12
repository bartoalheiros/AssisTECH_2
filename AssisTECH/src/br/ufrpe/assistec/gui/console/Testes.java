package br.ufrpe.assistec.gui.console;

import java.util.List;

import br.ufrpe.assistec.dados.RepositorioClientesArrayList;
import br.ufrpe.assistec.negocio.beans.Cliente;

public class Testes {

	public static void main(String[] args) {
		RepositorioClientesArrayList repo = RepositorioClientesArrayList.getInstance();
		
		Cliente cli4 = new Cliente("1234561", "Norma", "Silva", "Rua das Garças, 72.", "3493-0282", "joao@gmail.com", 2);
		
		
		System.out.println("Adicionando Norma ao Arquivo\n");
		repo.cadastrar(cli4);
		
		
		
		

	}

	public static void imprimir(List<Cliente> listaCli) {
		for(Cliente cli: listaCli) {
			System.out.println(cli);
		}
	}
}
