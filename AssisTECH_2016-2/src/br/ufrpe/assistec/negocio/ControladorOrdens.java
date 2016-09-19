package br.ufrpe.assistec.negocio;

import br.ufrpe.assistec.dados.RepositorioOrdensArray;
import br.ufrpe.assistec.negocio.beans.Ordem;


public class ControladorOrdens {
	private RepositorioOrdensArray repositorio;
	
	public ControladorOrdens() {
		this.repositorio = new RepositorioOrdensArray();
	}
	
	public boolean existe(Ordem os) {
		boolean resultado = false;
		
		if(os != null) {
			resultado = this.repositorio.existe(os);
		}else {
			throw new IllegalArgumentException("Parâmetro inválido");
		}
		
		return resultado;
	}
	

    /**
     * Cadastrar uma Ordem de Serviço.
     * A ordem só é cadastrada se ela não existir no repositório: 29 - if(!this.existe(os)) {...} 
     *  
     * @param Ordem
     * @return void
     * @throws OSExisteException 
     * @throws EquipamentoEmServicoException 
     *         
     */
	public void cadastrar(Ordem os) throws OSExisteException {
		if (os != null) {
			if (!this.existe(os)) {
				this.repositorio.cadastrar(os);
			}else {
				String numero = os.getNumero();
				throw new OSExisteException(numero);
			}

		} else {
			throw new IllegalArgumentException("Parâmetro inválido");
		}        
	}
	
	public Ordem buscar(String numero) throws OSNaoEncontradaException {
		Ordem os = this.repositorio.buscar(numero);
		
		if(os == null) {
			throw new OSNaoEncontradaException(numero);
		}
		
		return os;
		
	}
	
	public void remover(String numero) throws OSNaoEncontradaException {
		if(this.buscar(numero) != null){
			this.repositorio.remover(numero);
		}
		
	}
	
	public void listar() {
		this.repositorio.listar();
	}
	
	public boolean validarEquipamento(String serie) throws EquipamentoEmServicoException {
		return this.repositorio.validarEquipamento(serie);
	}
	
	public boolean procurarEquipamento(String serie) throws EquipamentoEmServicoException {
		return this.repositorio.procurarEquipamento(serie);
	}
	
	public void alterar(Ordem os, String tipo, Object o) throws EquipamentoEmServicoException {
		if(os == null) {
			throw new IllegalArgumentException("Os Nula!");
		} else {
		
			this.repositorio.alterar(os, tipo, o);
		
		}
	}
}
