package br.ufrpe.assistec.ui;

import java.util.Scanner;

import br.ufrpe.assistec.negocio.ClienteJahCadastradoException;
import br.ufrpe.assistec.negocio.ClienteNaoCadastradoException;
import br.ufrpe.assistec.negocio.EquipamentoEmServicoException;
import br.ufrpe.assistec.negocio.EquipamentoExisteException;
import br.ufrpe.assistec.negocio.EquipamentoNaoExisteException;
import br.ufrpe.assistec.negocio.OSExisteException;
import br.ufrpe.assistec.negocio.ServidorAssisTech;
import br.ufrpe.assistec.negocio.TecnicoNaoCadastradoException;
import br.ufrpe.assistec.negocio.beans.Cliente;
import br.ufrpe.assistec.negocio.beans.Equipamento;
import br.ufrpe.assistec.negocio.beans.Ordem;
import br.ufrpe.assistec.negocio.beans.Tecnico;
import br.ufrpe.assistec.negocio.beans.Usuario;

public class MenuTextual {

	ServidorAssisTech servidor = ServidorAssisTech.getInstance();
	Scanner sc = new Scanner(System.in);


	public void menuPrincipal(int entrada) throws ClienteJahCadastradoException, TecnicoNaoCadastradoException{
		Cliente cli;


		switch(entrada) {

		
		case 1:
			//Cadastrar Cliente

			cli = this.novoCliente();

			try{
				servidor.cadastrarCliente(cli);
				System.out.println("Cliente Cadastrado com Sucesso!");
			}catch(ClienteJahCadastradoException e0) {
				System.err.println(e0.getMessage());
			}

			break;

		case 2:
			//Buscar Cliente

			cli = this.buscarCliente();
			System.out.println(cli);

			break;

		case 3:
			//Cadastrar Técnico
			this.cadastrarTecnico();
			
			break;

		case 4:
			//Buscar Técnico

			Usuario tec_2 = new Tecnico();
			String cpf_2 = null;

			System.out.println("Digite a matrícula do Técnico procurado: ");
			cpf_2 = sc.nextLine();
			sc.nextLine(); //Limpa o buffer do teclado

			try{
				tec_2 = servidor.buscarTecnico(cpf_2);
				System.out.println(tec_2);
			}catch(TecnicoNaoCadastradoException e1) {
				System.out.println(e1.getMessage());
			}

			break;

		case 5:
			//Cadastrar Equipamento

			this.cadastrarEquipamento();
			
			break;

		case 6:	
			//Buscar Equipamento

			Equipamento equip_2 = new Equipamento();
			String numSerie = null;

			System.out.println("Digite o número de Série do equipamento: ");
			numSerie = sc.nextLine();
			sc.nextLine(); //Limpa o buffer do teclado

			try {
				equip_2 = servidor.buscarEquipamento(numSerie);
				System.out.println(equip_2); // caso ele encontre o equipamento. Ele printa o objetio para o usuário.
			}catch(EquipamentoNaoExisteException e3) {
				System.out.println(e3.getMessage());
			}

			break;

		case 7:
			//Nova Ordem
			Ordem ordem = this.novaOrdem();
			
			try {
				servidor.cadastrarOrdem(ordem);
			} catch (OSExisteException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			} catch (EquipamentoEmServicoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

			break;

		case 8:
			//Buscar Ordem

			break;


		}

	}

	/*cadastrarCliente():
	 * 
	 * Submenu que cadastra um cliente numa ordem*/

	public Cliente cadastrarCliente(Ordem os) {
		int opcao;

		do {
			System.out.println("Deseja criar um novo cadastro de Cliente ou buscar no sistema?");

			System.out.println("1 - Cadastrar novo Cliente");
			System.out.println("2 - Utilize Cliente já cadastrado");
			System.out.println("3 - Sair");

			Cliente cli;
			opcao = sc.nextInt();


			switch(opcao) {
			case 1:
				cli = this.novoCliente();

				try{
					servidor.cadastrarCliente(cli);
					System.out.println("Cliente Cadastrado com Sucesso!");
				}catch(ClienteJahCadastradoException e0) {
					System.err.println(e0.getMessage());
				}

				break;

			case 2:
				sc.nextLine();
				cli = this.buscarCliente();

				System.out.println(cli);
				System.out.println("Tem certeza de que deseja utilizar este cliente na Ordem?");
				System.out.println("'S' ou 's' para Sim, 'n' ou 'N' para Não.");

				String resposta = sc.next();

				if(resposta.equals("s") || resposta.equals("S")) {
					os.setCliente(cli);
					break;
				}else if (resposta.equals("n") || resposta.equals("N")) {
					this.cadastrarCliente(os);
				}

				break;


			}

			if(opcao  > 3) {
				throw new IllegalArgumentException("Opção Inválida!");
			}

		}while(opcao < 3);


		return null;
	}

	public Cliente novoCliente() {

		String var;

		sc.nextLine();
		System.out.println("Digite o cpf do cliente: ");
		var = sc.nextLine();
		sc.nextLine(); //Limpa o buffer do teclado

		//Criando um cliente, utilizando o Construtor que tem como parâmetro a String cpf.
		Cliente cli = new Cliente(var);

		System.out.println("Digite o nome: ");
		var = sc.nextLine();
		sc.nextLine(); //Limpa o buffer do teclado

		cli.setNomeCompleto(var);

		System.out.println("Endereço: ");
		var = sc.nextLine();
		sc.nextLine(); //Limpa o buffer do teclado

		cli.setEndereco(var);

		System.out.println("Telefone: ");
		var = sc.nextLine();
		sc.nextLine(); //Limpa o buffer do teclado

		cli.setTelefone(var);

		System.out.println("E-mail: ");
		var = sc.nextLine();
		sc.nextLine(); //Limpa o buffer do teclado

		cli.setEmail(var);

		return cli;

	}

	public Cliente buscarCliente() {

		Cliente cli_2 = null;
		String cpf;

		sc.nextLine();
		System.out.println("Digite o cpf: ");
		cpf = sc.nextLine();
		sc.nextLine(); //Limpa o buffer do teclado

		try{
			cli_2 = servidor.buscarCliente(cpf);
		}catch(ClienteNaoCadastradoException e1) {
			System.out.println(e1.getMessage());
		}

		return cli_2;
	}

	public Ordem novaOrdem() throws TecnicoNaoCadastradoException {
		Ordem ordem = new Ordem();
		Equipamento equip;
		String var, relatorio;
		int resposta;
		boolean continuar = true;

		System.out.println("Digite o número da OS: \n");
		var = sc.nextLine();
		sc.nextLine(); //Limpa o buffer do teclado
		ordem.setNumero(var);

		System.out.println("Data de Entrada: \n");
		var = sc.nextLine();
		ordem.setDataEntrada(var);
		sc.nextLine(); //Limpa o buffer do teclado

		System.out.println("Portador: \n");
		var = sc.nextLine();
		sc.nextLine(); //Limpa o buffer do teclado
		ordem.setPortador(var);

		this.cadastrarCliente(ordem);
		
		equip = this.cadastrarEquipamento();
		
		ordem.setEquipamento(equip);
		
		System.out.println("Digite as características do defeito(resumido)");
		var = sc.nextLine();
		ordem.setCaracDefeito(var);
		
		do{
			
			System.out.println("Deseja listar todos os técnicos ou digitar uma matrícula específica?");
			System.out.println("1 - Listar Técnicos\n");
			System.out.println("2 - Digitar uma matrícula de Técnico\n");
			System.out.println("Opção: ");
			resposta = sc.nextInt();
			sc.nextLine(); //Limpando o buffer do teclado.
			
			if(resposta > 2 || resposta < 1) {
				throw new IllegalArgumentException("Parâmetro Inválido!");
			}else {
				continuar = false;
			}
			
		}while(continuar);
		
		if(resposta == 1) {
			servidor.listarTecnicos();
		}
		
		this.associarTecnico(ordem);
		
		System.out.println("Relatório de Manutenção: \n\n");
		System.out.println("Entre com o relatório de Manutenção: \n");
		relatorio = sc.nextLine();
		sc.nextLine(); // limpando buffer do teclado.
		
		ordem.setRelatorio(relatorio);
		
		return ordem;

	}
	
	public void associarTecnico(Ordem ordem) throws TecnicoNaoCadastradoException {
		
		Tecnico tecnico = new Tecnico();
		String matricula, respostta;
		
		System.out.println("Digite a matrícula do técnico que deseja atrelar à OS: ");
		matricula = sc.nextLine();
		sc.nextLine(); //limpando buffer
		
		tecnico = servidor.buscarTecnico(matricula);
		
		System.out.println(tecnico);
		System.out.println("Tem certeza de que deseja cadastrar este técnico na OS?");
		System.out.println("'S' ou 's' para Sim, 'n' ou 'N' para Não.");
		respostta = sc.nextLine();
		sc.nextLine();
		
		if(respostta.equals("S") || respostta.equals("s")) {
			
			ordem.setTecnico(tecnico);
			System.out.println("Técnico associado à ordem " + ordem.getNumero());
			
		}else if(respostta.equals("N") || respostta.equals("n")) {
			
			this.associarTecnico(ordem);
		}
	}
	
	public Equipamento cadastrarEquipamento() {
		
		Equipamento equip = new Equipamento();
		String var = null;
		System.out.println("Digite o no de Série: ");
		var = sc.nextLine();
		sc.nextLine(); //Limpa o buffer do teclado

		equip.setNumeroSerie(var);

		System.out.println("Tipo de Equipamento: ");
		var = sc.nextLine();
		sc.nextLine(); //Limpa o buffer do teclado

		equip.setTipo(var);

		System.out.println("OS no" + equip.getOs());

		try {
			servidor.cadastrarEquipamento(equip);
		}catch(EquipamentoExisteException e2) {
			System.out.println(e2.getMessage());
		}
		
		return equip;
	}
	
	public void cadastrarTecnico() {
		
		String var = null;

		System.out.println("Digite o cpf do tecnico: ");
		var = sc.nextLine();
		sc.nextLine(); //Limpa o buffer do teclado

		//Criando um tecnico, utilizando o Construtor que tem como parâmetro a String matrícula.
		Usuario tec = new Tecnico(var);

		System.out.println("Digite o nome: ");
		var = sc.nextLine();
		sc.nextLine(); //Limpa o buffer do teclado

		tec.setNomeCompleto(var);

		System.out.println("Endereço: ");
		var = sc.nextLine();
		sc.nextLine(); //Limpa o buffer do teclado

		tec.setEndereco(var);

		System.out.println("Telefone: ");
		var = sc.nextLine();
		sc.nextLine(); //Limpa o buffer do teclado

		tec.setTelefone(var);

		System.out.println("E-mail: ");
		var = sc.nextLine();
		sc.nextLine(); //Limpa o buffer do teclado

		tec.setEmail(var);

		servidor.cadastrarTecnico((Tecnico)tec);

		System.out.println("Tecnico Cadastrado com Sucesso!");
		
	}
	
	
}

