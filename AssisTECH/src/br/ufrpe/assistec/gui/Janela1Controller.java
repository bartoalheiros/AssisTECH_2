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
	@FXML private MenuItem cadastrarCliente;
	@FXML private MenuItem cadastrarTecnico;
	@FXML private MenuItem cadastrarEquipamento;
	@FXML private MenuItem consultarCliente;
	
	@FXML public void cadastrarCliente(ActionEvent event) throws IOException {
		Parent parent = FXMLLoader.load(getClass().getResource("CadastrarCliente.fxml"));
		Stage stage = new Stage();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setTitle("Cadastrar Cliente");
		stage.show();
	}
	
	@FXML public void cadastrarTecnico(ActionEvent event) throws IOException {
		Parent parent = FXMLLoader.load(getClass().getResource("CadastrarTecnico.fxml"));
		Stage stage = new Stage();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setTitle("Cadastrar Técnico");
		stage.show();
	}
	
	@FXML public void cadastrarEquipamento(ActionEvent event) throws IOException {
		Parent parent = FXMLLoader.load(getClass().getResource("CadastrarEquipamento.fxml"));
		Stage stage = new Stage();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setTitle("Cadastrar Equipamento");
		stage.show();
	}
	
	@FXML public void consultarCliente(ActionEvent event) throws IOException {
		Parent parent = FXMLLoader.load(getClass().getResource("ConsultarClientes.fxml"));
		Stage stage = new Stage();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setTitle("Consultar Cliente");
		stage.show();
	}
}
