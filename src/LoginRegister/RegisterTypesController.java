package LoginRegister;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class RegisterTypesController {

	Stage stage;
	

	@FXML 
	private Button backToLoginButton;
	@FXML
	private Button registerTypesIndividualButton;
	@FXML
	private Button registerTypesCompanyButton;
	
	
	
	public void registerCompany() throws IOException {
		FXMLLoader load = new FXMLLoader(getClass().getResource("RegisterCompany.fxml"));
		Parent root = load.load();
		stage = (Stage) registerTypesCompanyButton.getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("3-asis laboratorinis darbas");
		stage.show();
	}
	
	
	public void registerIndividual() throws IOException {
		FXMLLoader load = new FXMLLoader(getClass().getResource("RegisterIndividual.fxml"));
		Parent root = load.load();
		stage = (Stage) registerTypesIndividualButton.getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("3-asis laboratorinis darbas");
		stage.show();
	}

	public void backToLogin() throws IOException {
		FXMLLoader load = new FXMLLoader(getClass().getResource("LoginRegister.fxml"));
		Parent root = load.load();
		stage = (Stage) backToLoginButton.getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("3-asis laboratorinis darbas");
		stage.show();
	}

}
