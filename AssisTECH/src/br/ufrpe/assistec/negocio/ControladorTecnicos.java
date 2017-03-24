package br.ufrpe.assistec.negocio;

import java.util.List;

import br.ufrpe.assistec.bkp.RepositorioTecnicosArray;
import br.ufrpe.assistec.dados.IRepositorioTecnicos;
import br.ufrpe.assistec.dados.RepositorioClientesArrayList;
import br.ufrpe.assistec.dados.RepositorioTecnicoArrayList;
import br.ufrpe.assistec.negocio.beans.Cliente;
import br.ufrpe.assistec.negocio.beans.Tecnico;
import br.ufrpe.assistec.exceptions.*;

public class ControladorTecnicos {
	private IRepositorioTecnicos repositorio;

	public ControladorTecnicos() {
		this.repositorio = RepositorioTecnicoArrayList.getInstance();
	}
	
	public boolean existe(Tecnico tecnico) { 
		return ((RepositorioTecnicoArrayList)this.repositorio).existe(tecnico);
	}
	
	public void buscarPorLogin(String usrName, String pswd) throws NomeDeUsuarioOuSenhaInvalidaException {
		boolean resultado =  ((RepositorioTecnicoArrayList)this.repositorio).buscarPorLogin(usrName, pswd);

		if(resultado == false) {
			throw new NomeDeUsuarioOuSenhaInvalidaException();
		}	

	}

	public Tecnico buscar(String mat) throws TecnicoNaoCadastradoException{
		Tecnico tec = null;
		Tecnico tec2 = new Tecnico();
		tec2.setMatricula(mat);

		if(this.existe(tec2)) {
			tec = this.repositorio.buscar(mat);
		}else {
			throw new TecnicoNaoCadastradoException(mat);
		}

		return tec;
	}

	public void cadastrar(Tecnico tecnico) throws TecnicoJahExisteException {
		if(!this.repositorio.cadastrar(tecnico)) {
			throw new TecnicoJahExisteException(tecnico.getMatricula(), tecnico.getNomeCompleto());
		}
	}

	public List<Tecnico> listar() { 
		return ((RepositorioTecnicoArrayList)this.repositorio).listarTodos();
	}

	public void remover(String mat) throws TecnicoNaoCadastradoException {
		Tecnico tecnico = new Tecnico();
		tecnico.setMatricula(mat);
		
		if(this.existe(tecnico)) {
			((RepositorioTecnicoArrayList)this.repositorio).remover(mat);
		}else{
			throw new TecnicoNaoCadastradoException(mat);
		}
	}

}
