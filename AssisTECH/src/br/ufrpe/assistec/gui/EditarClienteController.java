package br.ufrpe.assistec.gui;

import br.ufrpe.assistec.exceptions.ClienteNaoCadastradoException;
import br.ufrpe.assistec.negocio.ServidorAssisTech;
import br.ufrpe.assistec.negocio.beans.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class EditarClienteController {
	@FXML private TextField txtNome;
	@FXML private TextField txtSobreNome;
	@FXML private TextField txtCpf;
	@FXML private TextField txtEndereco;
	@FXML private TextField txtTelefone;
	@FXML private TextField txtEmail;
	
	@FXML private Button btnPesquisar;
	@FXML private Button btnSalvar;
	ServidorAssisTech svr = ServidorAssisTech.getInstance();
	Cliente cli = null;
	
	@FXML
	public void buscar(ActionEvent event) {
		try {
			cli = svr.buscarCliente(txtCpf.getText());
			txtNome.setText(cli.getPrimeiroNome());
			txtSobreNome.setText(cli.getSegundoNome());
			txtEmail.setText(cli.getEmail());
			txtTelefone.setText(cli.getTelefone());
			txtEndereco.setText(cli.getEndereco());
		} catch (ClienteNaoCadastradoException e) {
			Alert err = new Alert(AlertType.ERROR);
			err.setContentText(e.getMessage());
			err.showAndWait();
		}
	}
			
	@FXML public void atualizar(ActionEvent event) {
		cli.setPrimeiroNome(txtNome.getText());
		cli.setSegundoNome(txtSobreNome.getText());
		cli.setEmail(txtEmail.getText());
		cli.setTelefone(txtTelefone.getText());
		cli.setEndereco(txtEndereco.getText());
		svr.atualizar(cli);
	}
}
