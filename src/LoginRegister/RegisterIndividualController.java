package LoginRegister;

import java.io.IOException;
import java.util.Set;

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

public class RegisterIndividualController {
	Stage stage;

	@FXML
	private TextField individualUsername;
	@FXML
	private PasswordField individualPassword;
	@FXML
	private TextField individualName;
	@FXML
	private TextField individualSurname;
	@FXML 
	private Button backToLogginButton;
	@FXML
	private Button registerButton;
	
	
	public void backToLogin() throws IOException {
		FXMLLoader load = new FXMLLoader(getClass().getResource("LoginRegister.fxml"));
		Parent root = load.load();
		stage = (Stage) backToLogginButton.getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("3-asis laboratorinis darbas");
		stage.show();
	}
	
	public void register() {
		String username=individualUsername.getText();
		String password=individualPassword.getText();
		String name=individualName.getText();
		String surname=individualSurname.getText();
		ToDoList todo=new ToDoList();
		todo=SetToDo.getToDo();
		try {
			todo.registerPerson(username, password, name, surname);
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
