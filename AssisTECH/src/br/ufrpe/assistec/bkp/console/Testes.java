package br.ufrpe.assistec.bkp.console;

import java.util.List;
import java.util.Scanner;

import br.ufrpe.assistec.dados.RepositorioClientesArrayList;
import br.ufrpe.assistec.negocio.ServidorAssisTech;
import br.ufrpe.assistec.negocio.beans.Cliente;

public class Testes {

	public static void main(String[] args) {
		ServidorAssisTech svr = ServidorAssisTech.getInstance();
		//RepositorioClientesArrayList repo = RepositorioClientesArrayList.getInstance();
		Scanner sc = new Scanner(System.in);
		/*Cliente cli4 = new Cliente("1234561", "Norma", "Silva", "Rua das Garças, 72.", "3493-0282", "joao@gmail.com", 2);
		
		
		System.out.println("Adicionando Norma ao Arquivo\n");
		repo.cadastrar(cli4);*/
		
		
		System.out.println("Imprimindo todos os Clientes\n");
		imprimir(svr.listarClientes());
		
		/*System.out.print("Digite o cpf do cliente que deseja buscar no arquivo: ");
		String cpf = sc.nextLine();
		sc.nextLine();
		
		System.out.println("Cliente encontrado: \n");
		System.out.print(repo.buscaPorCpf(cpf));*/
		
		

	}

	public static void imprimir(List<Cliente> listaCli) {
		for(Cliente cli: listaCli) {
			System.out.println(cli);
		}
	}
}
