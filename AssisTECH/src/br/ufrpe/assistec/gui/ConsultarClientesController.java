package br.ufrpe.assistec.gui;

import java.io.IOException;

import br.ufrpe.assistec.exceptions.ClienteNaoCadastradoException;
import br.ufrpe.assistec.negocio.ServidorAssisTech;
import br.ufrpe.assistec.negocio.beans.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class ConsultarClientesController {
	
	@FXML private Button btnPesquisar;
	@FXML private TextField txtBuscar;
	@FXML private Label txtCpf;
	@FXML private Label txtNome;
	@FXML private Label txtEmail;
	@FXML private Label txtTelefone;
	@FXML private Label txtEndereco;
	ServidorAssisTech svr = ServidorAssisTech.getInstance();
	
	@FXML
	public void buscar(ActionEvent event) {
		try {
			Cliente cli = svr.buscarCliente(txtBuscar.getText());
			txtCpf.setText(cli.getCpf());
			txtNome.setText(cli.getNomeCompleto());
			txtEmail.setText(cli.getEmail());
			txtTelefone.setText(cli.getTelefone());
			txtEndereco.setText(cli.getEndereco());
		} catch (ClienteNaoCadastradoException e) {
			Alert err = new Alert(AlertType.ERROR);
			err.setContentText(e.getMessage());
			err.showAndWait();
		}
	}
	
}
