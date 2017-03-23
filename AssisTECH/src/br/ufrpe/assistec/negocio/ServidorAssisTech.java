package br.ufrpe.assistec.negocio;
/*Fachada: serve para as classes de UI do sistema terem acesso a todas as funcionalidades do mesmo.*/

import java.util.List;

import br.ufrpe.assistec.negocio.beans.Cliente;
import br.ufrpe.assistec.negocio.beans.Equipamento;
import br.ufrpe.assistec.negocio.beans.Ordem;
import br.ufrpe.assistec.negocio.beans.Tecnico;
import br.ufrpe.assistec.exceptions.*;

public class ServidorAssisTech {
	private ControladorClientes clientes;
	private ControladorTecnicos tecnicos;
	private ControladorOrdens ordens;
	private ControladorEquipamentos equipamentos;

	private static ServidorAssisTech instance;

	private ServidorAssisTech() {
		this.clientes = new ControladorClientes();
		this.tecnicos = new ControladorTecnicos();
		this.ordens = new ControladorOrdens();
		this.equipamentos = new ControladorEquipamentos();
	}


	/**
	 * Implementando padrão Singleton
	 * 
	 * @return A instância da desta fachada
	 */
	public static ServidorAssisTech getInstance() {
		if(instance == null) {
			instance = new ServidorAssisTech();
		}

		return instance;
	}

	public void cadastrarCliente(Cliente c) throws ClienteJahCadastradoException { 
		clientes.cadastrar(c);
	}

	public Cliente buscarCliente(String cpf) throws ClienteNaoCadastradoException {
		return clientes.buscar(cpf);
	}
	
	public void buscarClientePorLogin(String usrName, String passwd) throws NomeDeUsuarioOuSenhaInvalidaException {
		clientes.buscarPorLogin(usrName, passwd);
	} 

	public void removerCliente(String cpf) { 
		clientes.remover(cpf);
	}

	public void atualizar (Cliente c) { 
		clientes.atualizar(c);
	}

	public List<Cliente> listarClientes() {
		return clientes.listar();
	}
	
	public void cadastrarTecnico(Tecnico tecnico) throws TecnicoJahExisteException {
		tecnicos.cadastrar(tecnico);
	}

	public Tecnico buscarTecnico(String mat) throws TecnicoNaoCadastradoException{
		return tecnicos.buscar(mat);
	}

	public void cadastrarOrdem(Ordem os) throws OSExisteException, EquipamentoEmServicoException {
		ordens.cadastrar(os);
	}

	public Ordem buscarOrdem(String numero) throws OSNaoEncontradaException {
		return ordens.buscar(numero);
	}

	public void removerOS(String numero) throws OSNaoEncontradaException {
		ordens.remover(numero);
	}

	public void listarOrdens() {
		ordens.listar();
	}

	public void cadastrarEquipamento(Equipamento e) throws EquipamentoExisteException {
		equipamentos.cadastrar(e);
	}

	public void removerEquipamento(String numero) throws EquipamentoExisteException, EquipamentoNaoExisteException { 
		equipamentos.remover(numero);
	}

	public void listarEquipamentos() { 
		equipamentos.listar();
	}

	public Equipamento buscarEquipamento(String numero) throws EquipamentoNaoExisteException {
		return equipamentos.buscar(numero);
	}

	public void atualizarEquipamento(Equipamento equip) throws EquipamentoNaoExisteException { 
		equipamentos.atualizar(equip);
	}

	public void alterar(Ordem os, String tipo, Object o) throws OSExisteException, EquipamentoEmServicoException{
		ordens.alterar(os, tipo, o);
	}

	public void listarTecnicos() {
		tecnicos.listar();
	}


	public void buscarTecnicoPorLogin(String usrName, String pswd) throws NomeDeUsuarioOuSenhaInvalidaException {
		tecnicos.buscarPorLogin(usrName, pswd);
		
	}


	public void removerTecnico(String mat) throws TecnicoNaoCadastradoException {
		tecnicos.remover(mat);
		
	}

}
