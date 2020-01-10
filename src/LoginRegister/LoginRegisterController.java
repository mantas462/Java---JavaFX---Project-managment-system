package LoginRegister;

import java.io.IOException;

import Antrinis.ToDoList;
import Antrinis.TooShort;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginRegisterController {

	Stage stage;

	@FXML
	private Button loginButton;
	@FXML
	private TextField usernameInput;
	@FXML
	private PasswordField passwordInput;

	public void login() throws Exception {
		ToDoList todo;
		todo = SetToDo.getToDo();
		String login = usernameInput.getText();
		String password = passwordInput.getText();
		try {
			todo.login(login, password);
			SetToDo.setToDo(todo);
			welcomeUser();
		} catch (TooShort e) {
			e.printStackTrace();
			if (e.equals("Incorrect login data")) {
				System.out.println("EE");
			}
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Incorrect data");
			alert.setHeaderText("Username or password was incorrect");
			alert.setContentText("Please insert correct information");
			alert.showAndWait();
		}
	}

	private void welcomeUser() throws IOException {
		FXMLLoader load = new FXMLLoader(getClass().getResource("WelcomeUser.fxml"));
		Parent root = load.load();
			

		WelcomeUserController controller=load.getController();
	    controller.upload();

		
		stage = (Stage) loginButton.getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("3-asis laboratorinis darbas");
		stage.show();
	}

	public void register() throws IOException {
		FXMLLoader load = new FXMLLoader(getClass().getResource("RegisterTypes.fxml"));
		Parent root = load.load();
		stage = (Stage) loginButton.getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("3-asis laboratorinis darbas");
		stage.show();
	}
	
	
	

}
