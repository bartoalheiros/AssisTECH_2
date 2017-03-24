package br.ufrpe.assistec.gui;

import br.ufrpe.assistec.exceptions.ClienteNaoCadastradoException;
import br.ufrpe.assistec.negocio.ServidorAssisTech;
import br.ufrpe.assistec.negocio.beans.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class RemoverClienteController {
	@FXML private Button btnPesquisar;
	@FXML private Button btnRemover;
	@FXML private TextField txtBuscar;
	@FXML private Label txtNome;
	@FXML private Label txtEmail;
	@FXML private Label txtTelefone;
	@FXML private Label txtNumeroDeOSS;
	@FXML private Label txtResultado;
	ServidorAssisTech svr = ServidorAssisTech.getInstance();
	
	Long cpf = null;
	
	@FXML
	public void buscar(ActionEvent event) {
		try{
			cpf = Long.parseLong(txtBuscar.getText());
		}catch(NumberFormatException e) {
			Alert err = new Alert(AlertType.ERROR);
			err.setContentText("Preencha o campo CPF corretamente.");
			err.showAndWait();
			return;
		}
		
		try {
			Cliente cli = svr.buscarCliente(cpf);
			txtNome.setText(cli.getNomeCompleto());
			txtEmail.setText(cli.getEmail());
			txtTelefone.setText(cli.getTelefone());
			txtNumeroDeOSS.setText(cli.getNumOrdens().toString());
		} catch (ClienteNaoCadastradoException e) {
			Alert err = new Alert(AlertType.ERROR);
			err.setContentText(e.getMessage());
			err.showAndWait();
		}
	}
	
	@FXML
	public void remover(ActionEvent event) throws ClienteNaoCadastradoException {
		
		Alert err = new Alert(AlertType.CONFIRMATION);
		err.setContentText("Tem certeza de que deseja remover este cliente?");
		err.showAndWait();
		
		svr.removerCliente(cpf);
		txtResultado.setText("Cliente Removido com Sucesso!");
	}
}
