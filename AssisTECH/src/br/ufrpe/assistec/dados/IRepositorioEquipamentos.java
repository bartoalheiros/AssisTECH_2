package br.ufrpe.assistec.dados;

import java.util.List;

import br.ufrpe.assistec.exceptions.EquipamentoNaoExisteException;
import br.ufrpe.assistec.negocio.beans.Equipamento;

public interface IRepositorioEquipamentos {
	public boolean cadastrar (Equipamento e);
	
	public List<Equipamento> listar();
	
	public void remover(String numSerie);
	
	public Equipamento buscar(String numSerie);
	
	public boolean atualizar(Equipamento equip);
}
