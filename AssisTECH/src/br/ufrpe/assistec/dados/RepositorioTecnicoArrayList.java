package br.ufrpe.assistec.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import br.ufrpe.assistec.exceptions.TecnicoJahExisteException;
import br.ufrpe.assistec.negocio.beans.Tecnico;

public class RepositorioTecnicoArrayList implements IRepositorioTecnicos {
	List<Tecnico> listaTecnicos = null;
	private static RepositorioTecnicoArrayList instance;
	
	private RepositorioTecnicoArrayList() {
		this.listaTecnicos = new ArrayList();
	}
	
	public static RepositorioTecnicoArrayList getInstance() {
		if(instance == null) {
			instance = lerDoArquivo();
		}

		return instance;
	}
	
	@Override
	public void cadastrar(Tecnico tecnico) {
		if(getInstance().listaTecnicos.contains(tecnico)) { 
			throw new TecnicoJahExisteException();
		}else {
			getInstance().listaTecnicos.add(tecnico);
			this.salvarArquivo();
		}
		
		
		

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

	public List<Tecnico> listarTodos() {
		return this.listaTecnicos;

	}
	
	private static RepositorioTecnicoArrayList lerDoArquivo() {
		RepositorioTecnicoArrayList instanciaLocal = null;

		File in = new File("tecnico.dat");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instanciaLocal = (RepositorioTecnicoArrayList) o;
		} catch (Exception e) {
			instanciaLocal = new RepositorioTecnicoArrayList();
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {/* Silent exception */
				}
			}
		}

		return instanciaLocal;
	}

	public void salvarArquivo() {
		if (instance == null) {
			return;
		}
		File out = new File("tecnico.dat");
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			fos = new FileOutputStream(out);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(instance);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try { oos.close(); } catch (IOException e) {/*Silent*/}
			}
		}
	}

	@Override
	public boolean remover(String matricula) {
		Tecnico tecnico = null;
		boolean r = false;
		
		for(Tecnico tec: this.listaTecnicos) {
			if(tec.getMatricula().equals(matricula)) {
				tecnico = tec;
				r = true;
			}
		}
		return r;
	}

	@Override
	public void atualizar(Tecnico tec) {
		

	}

}
