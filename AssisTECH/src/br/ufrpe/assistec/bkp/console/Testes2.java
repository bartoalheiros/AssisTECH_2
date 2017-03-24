package br.ufrpe.assistec.bkp.console;

import java.util.List;
import java.util.Scanner;

import br.ufrpe.assistec.dados.RepositorioClientesArrayList;
import br.ufrpe.assistec.negocio.beans.Cliente;

public class Testes2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String cpf = null, nome = null, sobrenome = null, endereco = null, telefone = null, email = null;
		int numOrdens = 0;
		RepositorioClientesArrayList repo = RepositorioClientesArrayList.getInstance();
		
		//Cliente cli4 = new Cliente("1234561", "Norma", "Silva", "Rua das Garças, 72.", "3493-0282", "joao@gmail.com", 2);
		
		System.out.println("Imprimindo todos os Clientes");
		imprimir(repo.listarTodos());
		
		System.out.println("Retirando Cristiano Silva\n");
		repo.remover("1234569");
		
		System.out.println("Imprimindo todos os Clientes");
		imprimir(repo.listarTodos());
		
		System.out.println("Criando um novo Cliente\n");
		System.out.print("Digite o cpf: ");
		cpf = sc.nextLine();
		sc.nextLine();
		
		System.out.print("Digite o nome: ");
		nome = sc.nextLine();
		sc.nextLine();
		
		System.out.print("Digite o sobrenome: ");
		sobrenome = sc.nextLine();
		sc.nextLine();
		
		System.out.print("Digite o endereco: ");
		endereco = sc.nextLine();
		sc.nextLine();
		
		System.out.print("Digite o telefone: ");
		telefone = sc.nextLine();
		sc.nextLine();
		
		System.out.print("Digite o email: ");
		email = sc.nextLine();
		sc.nextLine();
		
		System.out.print("Digite o email: ");
		numOrdens = sc.nextInt();
		sc.nextLine();
		
		Cliente cli = new Cliente(cpf, nome, sobrenome, endereco, telefone, email, numOrdens);
		
		System.out.println("Cadastrando" + cli.getNomeCompleto() + "no Arquivo de clientes!\n");
		
		repo.cadastrar(cli);
		
		System.out.println("Imprimindo todos os Clientes");
		imprimir(repo.listarTodos());
	}
	
	public static void imprimir(List<Cliente> listaCli) {
		for(Cliente cli: listaCli) {
			System.out.println(cli);
		}
	}

}
