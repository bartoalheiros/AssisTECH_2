package br.ufrpe.assistec.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.ufrpe.assistec.negocio.beans.Cliente;
import br.ufrpe.assistec.negocio.beans.Tecnico;

public class RepositorioTecnicoArrayList implements IRepositorioTecnicos, Serializable {
	private List<Tecnico> listaTecnicos = null;
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
	
	public boolean existe(Tecnico tecnico) {
		for(Tecnico tec: this.listaTecnicos) {
			if(tecnico.equals(tec)) {
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public boolean cadastrar(Tecnico tecnico) {
		if(getInstance().listaTecnicos.contains(tecnico)){
			return false;
		}else {
			getInstance().listaTecnicos.add(tecnico);
			this.salvarArquivo();
			return true;
		}
	}
	
	public boolean buscarPorLogin(String usrName, String pswd) {

		for(Tecnico cli: getInstance().listaTecnicos) {
			if(cli.getUsrName().equals(usrName) && cli.getPasswrd().equals(pswd)) {
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public Tecnico buscar(String mat) {
		Tecnico tecnico = null;
		
		for(Tecnico tec: getInstance().listaTecnicos) {
			if(tec.getMatricula().equals(mat)) {
				tecnico = tec;
				break;
			}
		}
		return tecnico;
	}

	public List<Tecnico> listarTodos() {
		return getInstance().listaTecnicos;

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
		for(Tecnico tec: getInstance().listaTecnicos) {
			if(tec.getMatricula().equals(matricula)) {
				getInstance().listaTecnicos.remove(tec);
				return true;
			}
		}
		return false;
	}
	

	@Override
	public void atualizar(Tecnico tec1, Tecnico tec2) {
		
		getInstance().listaTecnicos.set(getInstance().listaTecnicos.indexOf(tec1), tec2);
	}
	
	public static void main(String[] args) {
		RepositorioTecnicoArrayList repo = RepositorioTecnicoArrayList.getInstance();
		Tecnico tec = new Tecnico("joao", "1234", "1234", "Joao", "Silva", "joao@gmail.com", "3492-3200", "Rua augusto de campos, 72.", 0);
		
		repo.cadastrar(tec);
		System.out.println("Tencico cadastrado.\n Listando Técnicos.\n");
		
		imprimir(repo.listarTodos());
		
	}
	
	public static void imprimir(List<Tecnico> listaTec) {
		for(Tecnico tec: listaTec) {
			System.out.println(tec);
		}
	}

}
