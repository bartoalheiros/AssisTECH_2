package br.ufrpe.assistec.dados;

import java.util.ArrayList;
import java.util.List;

import br.ufrpe.assistec.negocio.beans.Tecnico;

public class RepositorioTecnicoArrayList implements IRepositorioTecnicos {
	List<Tecnico> listaTecnicos = null;
	
	public RepositorioTecnicoArrayList() {
		this.listaTecnicos = new ArrayList();
	}
	
	@Override
	public void cadastrar(Tecnico tecnico) {
		this.listaTecnicos.add(tecnico);

	}

	@Override
	public Tecnico buscar(String mat) {
		Tecnico tecnico = null;
		
		for(Tecnico tec: this.listaTecnicos) {
			if(tec.getMatricula().equals(mat)) {
				tecnico = tec;
				break;
			}
		}
		return tecnico;
	}

	@Override
	public List<Tecnico> listar() {
		

	}

	@Override
	public void remover(String matricula) {
		// TODO Auto-generated method stub

	}

	@Override
	public void atualizar(Tecnico tec) {
		// TODO Auto-generated method stub

	}

}
