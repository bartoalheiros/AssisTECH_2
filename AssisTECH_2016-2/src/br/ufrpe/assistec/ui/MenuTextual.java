package br.ufrpe.assistec.ui;

import java.util.Scanner;

import br.ufrpe.assistec.negocio.ClienteJahCadastradoException;
import br.ufrpe.assistec.negocio.ClienteNaoCadastradoException;
import br.ufrpe.assistec.negocio.EquipamentoExisteException;
import br.ufrpe.assistec.negocio.EquipamentoNaoExisteException;
import br.ufrpe.assistec.negocio.ServidorAssisTech;
import br.ufrpe.assistec.negocio.TecnicoNaoCadastradoException;
import br.ufrpe.assistec.negocio.beans.Cliente;
import br.ufrpe.assistec.negocio.beans.Equipamento;
import br.ufrpe.assistec.negocio.beans.Ordem;
import br.ufrpe.assistec.negocio.beans.Tecnico;
import br.ufrpe.assistec.negocio.beans.Usuario;

public class MenuTextual {
	
	ServidorAssisTech servidor = ServidorAssisTech.getInstance();
	Scanner input = new Scanner(System.in);
	
	public void MenuPrincipal(int entrada) throws ClienteJahCadastradoException{
		
		
		switch(entrada) {

		
		case 1:
			//Cadastrar Cliente
			
			Cliente cli = this.novoCliente();
			
			try{
				servidor.cadastrarCliente(cli);
				System.out.println("Cliente Cadastrado com Sucesso!");
			}catch(ClienteJahCadastradoException e0) {
				System.err.println(e0.getMessage());
			}
			
			break;

		case 2:
			//Buscar Cliente
			
			this.buscarCliente();
			
			break;

		case 3:
			//Cadastrar Técnico
			
			String var2 = null;
			
			System.out.println("Digite o cpf do tecnico: ");
			var2 = input.nextLine();
			input.nextLine(); //Limpa o buffer do teclado
			
			//Criando um tecnico, utilizando o Construtor que tem como parâmetro a String matrícula.
			Usuario tec = new Tecnico(var2);
			
			System.out.println("Digite o nome: ");
			var2 = input.nextLine();
			input.nextLine(); //Limpa o buffer do teclado
			
			tec.setNomeCompleto(var2);
			
			System.out.println("Endereço: ");
			var2 = input.nextLine();
			input.nextLine(); //Limpa o buffer do teclado
			
			tec.setEndereco(var2);
			
			System.out.println("Telefone: ");
			var2 = input.nextLine();
			input.nextLine(); //Limpa o buffer do teclado
			
			tec.setTelefone(var2);
			
			System.out.println("E-mail: ");
			var2 = input.nextLine();
			input.nextLine(); //Limpa o buffer do teclado
			
			tec.setEmail(var2);
			
			servidor.cadastrarTecnico((Tecnico)tec);
			
			System.out.println("Tecnico Cadastrado com Sucesso!");
			
			break;

		case 4:
			//Buscar Técnico
			
			Usuario tec_2 = new Tecnico();
			String cpf_2 = null;
			
			System.out.println("Digite a matrícula do Técnico procurado: ");
			cpf_2 = input.nextLine();
			input.nextLine(); //Limpa o buffer do teclado
			
			try{
				tec_2 = servidor.buscarTecnico(cpf_2);
				System.out.println(tec_2);
			}catch(TecnicoNaoCadastradoException e1) {
				System.out.println(e1.getMessage());
			}
			
			break;
		
		case 5:
			//Cadastrar Equipamento
			
			Equipamento equip = new Equipamento();
			String var_3 = null;
			System.out.println("Digite o no de Série: ");
			var_3 = input.nextLine();
			input.nextLine(); //Limpa o buffer do teclado
			
			equip.setNumeroSerie(var_3);
			
			System.out.println("Tipo de Equipamento: ");
			var_3 = input.nextLine();
			input.nextLine(); //Limpa o buffer do teclado
			
			equip.setTipo(var_3);
			
			System.out.println("OS no" + equip.getOs());
			
			try {
				servidor.cadastrarEquipamento(equip);
			}catch(EquipamentoExisteException e2) {
				System.out.println(e2.getMessage());
			}
			
			break;
			
		case 6:	
			//Buscar Equipamento
			
			Equipamento equip_2 = new Equipamento();
			String numSerie = null;
			
			System.out.println("Digite o número de Série do equipamento: ");
			numSerie = input.nextLine();
			input.nextLine(); //Limpa o buffer do teclado
			
			try {
				equip_2 = servidor.buscarEquipamento(numSerie);
				System.out.println(equip_2); // caso ele encontre o equipamento. Ele printa o objetio para o usuário.
			}catch(EquipamentoNaoExisteException e3) {
				System.out.println(e3.getMessage());
			}
			
			break;
			
		case 7:
			//Nova Ordem
			
			Ordem os = new Ordem();
			System.out.println("OS Número: \n");
			String num = input.nextLine();
			input.nextLine(); //Limpa o buffer do teclado
			os.setNumero(num);

			System.out.println("Data de Entrada: \n");
			String data = input.nextLine();
			os.setDataEntrada(data);
			input.nextLine(); //Limpa o buffer do teclado
			
			System.out.println("Portador: \n");
			String portador = input.nextLine();
			input.nextLine(); //Limpa o buffer do teclado
			os.setPortador(portador);
			
			Cliente cliente = this.cadastrarCliente();
			
			
			break;
			
		case 8:
			//Buscar Ordem
			
			break;
			
		default: 
			

	}	

	}
	
	/*cadastrarCliente():
	 * 
	 * Submenu que cadastra um cliente numa ordem*/
	
	public Cliente cadastrarCliente() {
		System.out.println("Deseja criar um novo cadastro de Cliente ou buscar no sistema?");
		System.out.println("1 - Cadastrar novo Cliente");
		System.out.println("2 - Utilizar Cliente já cadastrado");
		
		int opcao = input.nextInt();
		
		if(opcao == 1) {
			Cliente cli = this.novoCliente();
			
			try{
				servidor.cadastrarCliente(cli);
				System.out.println("Cliente Cadastrado com Sucesso!");
			}catch(ClienteJahCadastradoException e0) {
				System.err.println(e0.getMessage());
			}
			
		}else if(opcao == 2) {
			
		}else{
			throw new IllegalArgumentException("Opção Inválida!");
		}
		return null;
	}
	
	public Cliente novoCliente() {
		
		String var = null;
		
		System.out.println("Digite o cpf do cliente: ");
		var = input.nextLine();
		input.nextLine(); //Limpa o buffer do teclado
		
		//Criando um cliente, utilizando o Construtor que tem como parâmetro a String cpf.
		Cliente cli = new Cliente(var);
		
		System.out.println("Digite o nome: ");
		var = input.nextLine();
		input.nextLine(); //Limpa o buffer do teclado
		
		cli.setNomeCompleto(var);
		
		System.out.println("Endereço: ");
		var = input.nextLine();
		input.nextLine(); //Limpa o buffer do teclado
		
		cli.setEndereco(var);
		
		System.out.println("Telefone: ");
		var = input.nextLine();
		input.nextLine(); //Limpa o buffer do teclado
		
		cli.setTelefone(var);
		
		System.out.println("E-mail: ");
		var = input.nextLine();
		input.nextLine(); //Limpa o buffer do teclado
		
		cli.setEmail(var);
	
		return cli;
		
	}
	
	public void buscarCliente() {

		Cliente cli_2 = new Cliente();
		String cpf = null;
		
		System.out.println("Digite o cpf: ");
		cpf = input.nextLine();
		input.nextLine(); //Limpa o buffer do teclado
		
		try{
			cli_2 = servidor.buscarCliente(cpf);
			System.out.println(cli_2);
		}catch(ClienteNaoCadastradoException e1) {
			System.out.println(e1.getMessage());
		}
   }

}//Teste GitKraken_2