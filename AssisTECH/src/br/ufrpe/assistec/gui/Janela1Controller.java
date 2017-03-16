package br.ufrpe.assistec.gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class Janela1Controller {
	@FXML private MenuItem novoCliente;
	
	@FXML public void cadastrar(ActionEvent event) throws IOException {
		Parent parent = FXMLLoader.load(getClass().getResource("CadastrarCliente.fxml"));
		Stage stage = new Stage();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setTitle("Cadastrar Cliente");
		stage.show();
	}
}
