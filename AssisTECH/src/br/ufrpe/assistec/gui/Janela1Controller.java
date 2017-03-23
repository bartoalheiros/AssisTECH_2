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
	@FXML private MenuItem editarCliente;
	@FXML private MenuItem consultarTecnico;
	@FXML private MenuItem removerCliente;
	@FXML private MenuItem removerTecnico;
	@FXML private MenuItem consultarEquipamento;
	
	
	@FXML public void cadastrarCliente(ActionEvent event) throws IOException {
		Parent parent = FXMLLoader.load(getClass().getResource("CadastrarCliente.fxml"));
		Stage stage = new Stage();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setTitle("Cadastrar Cliente");
		stage.setResizable(false);
		stage.show();
	}
	
	@FXML public void cadastrarTecnico(ActionEvent event) throws IOException {
		Parent parent = FXMLLoader.load(getClass().getResource("CadastrarTecnico.fxml"));
		Stage stage = new Stage();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setTitle("Cadastrar Técnico");
		stage.setResizable(false);
		stage.show();
	}
	
	@FXML public void cadastrarEquipamento(ActionEvent event) throws IOException {
		Parent parent = FXMLLoader.load(getClass().getResource("CadastrarEquipamento.fxml"));
		Stage stage = new Stage();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setTitle("Cadastrar Equipamento");
		stage.setResizable(false);
		stage.show();
	}
	
	@FXML public void consultarCliente(ActionEvent event) throws IOException {
		Parent parent = FXMLLoader.load(getClass().getResource("ConsultarClientes.fxml"));
		Stage stage = new Stage();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setTitle("Consultar Cliente");
		stage.setResizable(false);
		stage.show();
	}
	
	@FXML public void editarCliente(ActionEvent event) throws IOException {
		Parent parent = FXMLLoader.load(getClass().getResource("EditarCliente.fxml"));
		Stage stage = new Stage();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setTitle("Editar Cliente");
		stage.setResizable(false);
		stage.show();
	}
	
	@FXML public void consultarTecnico(ActionEvent event) throws IOException {
		Parent parent = FXMLLoader.load(getClass().getResource("ConsultarTecnicos.fxml"));
		Stage stage = new Stage();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setTitle("Consultar Técnico");
		stage.setResizable(false);
		stage.show();
	}
	
	@FXML public void removerCliente(ActionEvent event) throws IOException {
		Parent parent = FXMLLoader.load(getClass().getResource("RemoverCliente.fxml"));
		Stage stage = new Stage();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setTitle("Remover Cliente");
		stage.setResizable(false);
		stage.show();
	}
	
	@FXML public void removerTecnico(ActionEvent event) throws IOException {
		Parent parent = FXMLLoader.load(getClass().getResource("RemoverTecnico.fxml"));
		Stage stage = new Stage();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setTitle("Remover Tecnico");
		stage.setResizable(false);
		stage.show();
	}
	
	@FXML public void consultarEquipamento(ActionEvent event) throws IOException {
		Parent parent = FXMLLoader.load(getClass().getResource("ConsultarEquipamentos.fxml"));
		Stage stage = new Stage();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setTitle("Consultar Equipamentos");
		stage.setResizable(false);
		stage.show();
	}
}
