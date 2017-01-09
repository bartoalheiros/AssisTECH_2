package br.ufrpe.assistec.ui;

import br.ufrpe.assistec.negocio.ClienteJahCadastradoException;
import br.ufrpe.assistec.negocio.EquipamentoEmServicoException;
import br.ufrpe.assistec.negocio.EquipamentoExisteException;
import br.ufrpe.assistec.negocio.EquipamentoNaoExisteException;
import br.ufrpe.assistec.negocio.OSExisteException;
import br.ufrpe.assistec.negocio.OSNaoEncontradaException;
import br.ufrpe.assistec.negocio.ServidorAssisTech;
import br.ufrpe.assistec.negocio.beans.Cliente;
import br.ufrpe.assistec.negocio.beans.Equipamento;
import br.ufrpe.assistec.negocio.beans.Ordem;
import br.ufrpe.assistec.negocio.beans.Tecnico;

import java.util.Scanner;

import br.ufrpe.assistec.dados.*;

public class Demo {

	public static void main(String[] args) throws OSNaoEncontradaException, EquipamentoEmServicoException, OSExisteException, ClienteJahCadastradoException, EquipamentoNaoExisteException, EquipamentoExisteException {
		
		ServidorAssisTech servidor = ServidorAssisTech.getInstance();
		
		Ordem os = new Ordem();
		
		//Criando, preenchendo cadastro de cliente e salvando em seu repositório
		Cliente cli = new Cliente("032401127-59", "José Padilha Almeida Caetano", "Rua das Flores, Nova Atalaia, 701, São Paulo - SP", "3437-4132", "josepad27@yahoo.com.br", 0);
		cli.aumentarNumOrdens();
		servidor.cadastrarCliente(cli);
		
		Equipamento equipamento = new Equipamento();
		Tecnico tecnico = new Tecnico();
		
		os.setNumero("123456");
		os.setDataEntrada("24/09/2016");
		os.setPortador("Josias Miguel");
		
		//Cadastro do equipamento
		equipamento.setTipo("Computador HP 200 G1 Slim Tower");
		equipamento.setNumeroSerie("LW430UA#ABA");
		equipamento.setOs(os.getNumero());
		servidor.cadastrarEquipamento(equipamento);
		
		//cadastrando técnico
		tecnico.setNomeCompleto("Cláudio Araújo");
		tecnico.setTelefone("3071-8763");
		tecnico.setEmail("tec_claudio@diginfo.com.br");
		tecnico.aumentarNumOrdens();
		servidor.cadastrarTecnico(tecnico);
		
		/*Setando os dados na OS.*/
		os.setCliente(cli);
		os.setEquipamento(equipamento);
		os.setTecnicoResponsavel(tecnico);
		
		os.setCaracteristicasDefeito("Equipamento não liga. Luz Power não acende.");
		os.setRelatorioDeManutencao("Equipamento ainda não aberto por um técnico.");
		
		servidor.cadastrarOrdem(os);
		
		Equipamento equip3 = null;
		equip3 = servidor.buscarEquipamento("LW430UA#ABA");
		
		Ordem os3 = null;
		os3 = servidor.buscarOrdem("123456");
		
		System.out.println("OS do equipamento3 eh: " + equip3.getOs());
		System.out.println();
		System.out.println(equip3);
		
		System.out.println("Printando ordem: ");
		System.out.println();
		System.out.println(os3);
		
		//servidor.listarOrdens();
		System.out.println("\n");
		
		Ordem os2 = null;
		Scanner input = new Scanner(System.in);
		
		Equipamento equip2 = new Equipamento();
		os2 = new Ordem();
		
		try {
			
			os2.setNumero("1234567");
			os2.setDataEntrada("24/09/2016");
			os2.setPortador("Josias Miguel");
			
			cli.setNomeCompleto("José Padilha Almeida Caetano");
			cli.setEmail("josepad27@yahoo.com.br");
			cli.setTelefone("3437-4132");
			
			equip2.setTipo("Computador HP 200 G1 Slim Tower");
			equip2.setNumeroSerie("LW430UA#ABA");
			os2.setEquipamento(equip2);
			
			servidor.cadastrarOrdem(os2);
			
		} catch(OSExisteException existeExcept) {
			
			System.err.println(existeExcept.getMessage());
			
		} catch(EquipamentoEmServicoException equipEmServico) {
			
			System.out.println("cheguei aqui");
			System.err.print(equipEmServico.getMessage());
		
		}
	
		
		
	}

}
