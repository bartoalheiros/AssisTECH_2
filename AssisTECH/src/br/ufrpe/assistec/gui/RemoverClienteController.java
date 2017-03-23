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
	
	@FXML
	public void buscar(ActionEvent event) {
		try {
			Cliente cli = svr.buscarCliente(txtBuscar.getText());
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
		svr.removerCliente(txtBuscar.getText());
		txtResultado.setText("Técnico Removido com Sucesso!");
	}
}
