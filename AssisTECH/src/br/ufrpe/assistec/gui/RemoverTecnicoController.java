package br.ufrpe.assistec.gui;

import br.ufrpe.assistec.exceptions.ClienteNaoCadastradoException;
import br.ufrpe.assistec.exceptions.TecnicoNaoCadastradoException;
import br.ufrpe.assistec.negocio.ServidorAssisTech;
import br.ufrpe.assistec.negocio.beans.Tecnico;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class RemoverTecnicoController {
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
			Tecnico tec = svr.buscarTecnico(txtBuscar.getText());
			txtNome.setText(tec.getNomeCompleto());
			txtEmail.setText(tec.getEmail());
			txtTelefone.setText(tec.getTelefone());
			txtNumeroDeOSS.setText(tec.getNumOrdens().toString());
		} catch (TecnicoNaoCadastradoException e) {
			Alert err = new Alert(AlertType.ERROR);
			err.setContentText(e.getMessage());
			err.showAndWait();
		}
	}
	
	@FXML
	public void remover(ActionEvent event) throws TecnicoNaoCadastradoException {
		svr.removerTecnico(txtBuscar.getText());
		txtResultado.setText("Técnico Removido com Sucesso!");
	}
}
