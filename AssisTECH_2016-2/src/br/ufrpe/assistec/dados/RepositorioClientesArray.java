package br.ufrpe.assistec.dados;

import br.ufrpe.assistec.negocio.beans.Cliente;

public class RepositorioClientesArray implements IRepositorioClientes {
	private Cliente[] clientes;
	private int proximo;
	
	public RepositorioClientesArray() {
		this.clientes = new Cliente[100];
		this.proximo = 0;
	}
	
	public void cadastrar(Cliente cliente) {
		this.clientes[proximo] = cliente;
		this.proximo++;
	}
	
	public Cliente buscar(String cpf) {
		Cliente cliente = null;
		for(int i = 0; i < this.proximo; i++) {
			if( cpf.equals( this.clientes[i].getCpf() ) ) {
				cliente = new Cliente();
				cliente = this.clientes[i];
				break;
			}
		}
		
		return cliente;
	}
	
	public void remover(String cpf) {
		int i = this.procurarIndice(cpf);                          //removerCadastro(String cpf) - remove o cadastro do array de clientes, seguindo as regras
		if(i == this.proximo - 1) {                                            // 1 -  se o cliente for o último do array, ou seja, se i == this.proximo - 1 
			this.clientes[i] = null;                                           // esta posição recebe null 
			this.proximo = this.proximo - 1;                                   // o próximo passa a ser ela ou seja: this.proximo = proximo - 1  
			System.out.print("Cliente Removido com Sucesso.");
		}else{
			this.clientes[i] = this.clientes[this.proximo - 1];                //Se o cliente não for o último do array
			this.clientes[this.proximo -  1] = null;                           //linha 44  o cliente na posição i, que eu encontrei, receberá o cliente da última posição
			this.proximo = this.proximo - 1;                                   //linha 45 então eu atualizo a última posição para null
			System.out.print("Cliente Removido com Sucesso.");                 // linha 46 eu atualizo o valor de próxima para próximo - 1 e a última posição passa
		}		                                                                   // a ser a que era penúltima, anteriormente.
	}
		
																				//Percorreu todo o array e n achou o cliente com aquele cpf:
	                                                                                  // o cliente não existe.
	public void listar() {
		if(this.proximo > 0){
			for(int i = 0; i < this.proximo; i++) {
				System.out.println(clientes[i]);
			}
		} else {
			System.out.println("Nenhum cliente cadastrado.");
		}
	}
	
	public void alterar(Cliente c) {
		String cpf = c.getCpf();
		int i = this.procurarIndice(cpf);
		this.clientes[i] = c;
	}
	
	/*Verifica se um determinado Cliente já está cadastrado no Sistema.
	 * @param Cliente
	 * @returns boolean*/
	public boolean existe(Cliente cliente) {
		boolean resultado = false;
		String cpf1, cpf2;
		cpf1 = cliente.getCpf();
		
		for(int i = 0; i < this.proximo; i++) {
			cpf2 = clientes[i].getCpf();
			
			if(cpf1.equals(cpf2)) {                 //achou um cliente no array com o mesmo cpf. Achou o cliente.
				resultado = true;
				break;
			}
		}

		return resultado;
	}
	
	public int procurarIndice(String cpf) {
		int indice = 0, i;
		for(i = 0; i < this.proximo; i++) { 
			if( this.clientes[i].getCpf().equals(cpf) ) { 
				indice = i;
				break;
			}
		}
		if(i == this.proximo) {
			//IndiceNaoEncontradoException
		}
		
		return indice;
	}
}
