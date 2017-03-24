package br.ufrpe.assistec.bkp.console;

import java.util.Scanner;



public class Programa {


	public static void main(String[] args) throws Exception {

		MenuTextual menuTextual = new MenuTextual();
		Scanner sc = new Scanner(System.in);
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
			System.out.println("9 - Listar Ordens\n");
			System.out.println("10 - Sair\n\n");
			System.out.println("Opção: "); 

			
			try{	
				entrada = sc.nextInt(); 
			}catch(Exception e) {
				System.err.println("Parâmetro inválido!!");
				sc.nextLine(); // Limpando o buffer do teclado
			}

			menuTextual.menuPrincipal(entrada);

		}while(entrada < 10 || entrada == 0);

		System.out.println("Obrigado por utilizar AssisTech!!");
		sc.close();
	}}