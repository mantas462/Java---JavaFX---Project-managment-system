package LoginRegister;

import java.io.IOException;

import Antrinis.ToDoList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class RegisterCompanyController {

	Stage stage;

	@FXML
	private TextField companyUsername;
	@FXML
	private PasswordField companyPassword;
	@FXML
	private TextField companyName;
	@FXML
	private Button backToLoginButton;
	@FXML
	private Button registerButton;

	public void backToLogin() throws IOException {
		FXMLLoader load = new FXMLLoader(getClass().getResource("LoginRegister.fxml"));
		Parent root = load.load();
		stage = (Stage) backToLoginButton.getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("3-asis laboratorinis darbas");
		stage.show();
	}

	public void register() {
		String username = companyUsername.getText();
		String password = companyPassword.getText();
		String name = companyName.getText();
		ToDoList todo;
		todo = SetToDo.getToDo();
		try {
			todo.registerCompany(username, password, name);
			todo.fastLogin(username, password);
			SetToDo.setToDo(todo);
			welcomeUser();
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Incorrect data");
			alert.setHeaderText("Inserted data is too short");
			alert.setContentText("Username, password and name should be longer than 3 symbols");
			alert.showAndWait();
		}

	}

	public void welcomeUser() throws IOException {
		FXMLLoader load = new FXMLLoader(getClass().getResource("WelcomeUser.fxml"));
		Parent root = load.load();
		
		WelcomeUserController controller=load.getController();
	    controller.upload();
		
		stage = (Stage) registerButton.getScene().getWindow();
		Scene scene = new Scene(root);
		
		stage.setScene(scene);
		stage.setTitle("3-asis laboratorinis darbas");
		stage.show();
	}

}
