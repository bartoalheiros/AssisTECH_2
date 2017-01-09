package br.ufrpe.assistec.ui;

import java.util.Scanner;

import br.ufrpe.assistec.negocio.ClienteJahCadastradoException;
import br.ufrpe.assistec.negocio.ClienteNaoCadastradoException;
import br.ufrpe.assistec.negocio.EquipamentoExisteException;
import br.ufrpe.assistec.negocio.EquipamentoNaoExisteException;
import br.ufrpe.assistec.negocio.OSExisteException;
import br.ufrpe.assistec.negocio.OSNaoEncontradaException;



public class Programa {
	
		
	public static void main(String[] args) throws OSNaoEncontradaException, OSExisteException, ClienteJahCadastradoException, ClienteNaoCadastradoException, EquipamentoExisteException, EquipamentoNaoExisteException {
		
		MenuTextual menuTextual = new MenuTextual();
		Scanner input = new Scanner(System.in);
		
		int entrada;
		
		do{
			entrada = 0;
			System.out.println("=========================================================");
			System.out.println("Bem vindo a AssisTec. \n Versão. 1.0");
			System.out.println("=========================================================");
			System.out.println("Escolha a opcao desejada: \n\n");
			System.out.println("1 - Cadastrar Cliente\n");
			System.out.println("2 - Buscar Cliente\n");
			System.out.println("3 - Cadastrar Técnico\n");
			System.out.println("4 - Buscar Técnico\n");
			System.out.println("5 - Cadastrar Equipamento\n");
			System.out.println("6 - Buscar Equipamento\n");
			System.out.println("7 - Nova Ordem\n");
			System.out.println("8 - Buscar Ordem\n");
			System.out.println("9 - Sair\n\n");
			System.out.println("Opção: "); entrada = input.nextInt(); 
			input.nextLine(); //Limpa o buffer do teclado
			
			if(entrada > 9 || entrada == 0) {
				System.out.println("Opção inválida!");
			}
			
			try{
				menuTextual.MenuPrincipal(entrada);
			}catch(IllegalArgumentException e1) {
				System.err.println(e1.getMessage());
			}

					
		}while(entrada < 9);


}}