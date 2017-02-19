package br.ufrpe.assistec.dados;

import br.ufrpe.assistec.negocio.OSNaoEncontradaException;
import br.ufrpe.assistec.negocio.beans.Ordem;

public interface IRepositorioOrdens {
	
	public void cadastrar(Ordem os);
	
	public Ordem buscar(String numero) throws OSNaoEncontradaException;
	
	public void remover(String numero);
	
	public void listar();
}
