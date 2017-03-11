package br.ufrpe.assistec.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.ufrpe.assistec.negocio.beans.Cliente;

public class RepositorioClientesArrayList implements IRepositorioClientes, Serializable{
	private List<Cliente> listaClientes = null;
	private static RepositorioClientesArrayList instance;
	
	private RepositorioClientesArrayList() {
		this.listaClientes = new ArrayList(); 
	}
	
	public static RepositorioClientesArrayList getInstance() {
		if(instance == null) {
			 instance = lerDoArquivo();
		}
		
		return instance;
	}
	
	@Override
	public void cadastrar(Cliente cliente) {
		this.listaClientes.add(cliente);
		this.salvarArquivo();
		
	}

	@Override
	public Cliente buscaPorCpf(String cpf) {
		Cliente cliente = null;
		
		for(Cliente cli: listaClientes) {
			if(cli.getCpf().equals(cpf)) {
				cliente = cli;
				break;
			}
		}
		return cliente;
	}

	@Override
	public void remover(String cpf) {
		
		for(Cliente cli: listaClientes) {
			if(cli.getCpf().equals(cpf)) {
				this.listaClientes.remove(cli);
			}
		}
		
	}
	
	private static RepositorioClientesArrayList lerDoArquivo() {
        RepositorioClientesArrayList instanciaLocal = null;

        File in = new File("clientes.dat");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(in);
            ois = new ObjectInputStream(fis);
            Object o = ois.readObject();
            instanciaLocal = (RepositorioClientesArrayList) o;
        } catch (Exception e) {
            instanciaLocal = new RepositorioClientesArrayList();
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
	        File out = new File("clientes.dat");
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

	public List<Cliente> listarTodos() {
		return this.listaClientes;
		
	}
	
	public List<Cliente> listarTodosOrdenadosPorNome() {
		
		Collections.sort(this.listaClientes);
		
		return this.listaClientes;
		
	}
	
	public static void main(String[] args) {
		
		RepositorioClientesArrayList repo = RepositorioClientesArrayList.getInstance();
		
		Cliente cli1 = new Cliente("1234567", "Jo�o", "Silva", "Rua das Gar�as, 72.", "3493-0282", "joao@gmail.com", 2);
		Cliente cli2 = new Cliente("1234568", "Cl�udio", "Silva", "Rua das Gar�as, 72.", "3493-0282", "joao@gmail.com", 2);
		Cliente cli3 = new Cliente("1234569", "Cristiano", "Silva", "Rua das Gar�as, 72.", "3493-0282", "joao@gmail.com", 2);
		Cliente cli4 = new Cliente("1234561", "Norma", "Silva", "Rua das Gar�as, 72.", "3493-0282", "joao@gmail.com", 2);
		
		
		
		System.out.println("Adicionando CLientes");
		repo.cadastrar(cli1);
		repo.cadastrar(cli2);
		repo.cadastrar(cli3);
		
		
		
		System.out.println("Imprimindo todos os Clientes");
		imprimir(repo.listarTodos());
		
		System.out.println("Clientes em Ordem Alfab�tica");
		imprimir(repo.listarTodosOrdenadosPorNome());
		
		
		
		
	}
	
	public static void imprimir(List<Cliente> listaCli) {
		for(Cliente cli: listaCli) {
			System.out.println(cli);
		}
	}

}