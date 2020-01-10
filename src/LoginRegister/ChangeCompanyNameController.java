package LoginRegister;

import java.io.IOException;

import Antrinis.Person;
import Antrinis.ToDoList;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ChangeCompanyNameController {

	Stage stage;
	
	
	@FXML
	private TextField newNameInput;
	@FXML
	private Text text;	
	
	
	
	public void changeName() throws IOException {
		String newName=newNameInput.getText();
		ToDoList todo;
		todo=SetToDo.getToDo();
		
		try {
			todo.changeCompanyName(newName);
			SetToDo.setToDo(todo);
			text.setVisible(true);
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Incorrect data");
			alert.setHeaderText("Username or password was incorrect");
			alert.setContentText("Please insert correct information");
			alert.showAndWait();
		}
	}
	
	public void projects() throws IOException {
		FXMLLoader load = new FXMLLoader(getClass().getResource("MainProgram.fxml"));
		Parent root = load.load();
		
		MainProgramController controller=load.getController();
		
	    controller.setProjects();
	    controller.setPieChart();
		
		stage = (Stage) text.getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("3-asis laboratorinis darbas");
		stage.show();
	}
	
	public void logout() throws IOException {
		ToDoList todo=new ToDoList();
		todo=SetToDo.getToDo();
		todo.logout();
		SetToDo.setToDo(todo);
		
		
		FXMLLoader load = new FXMLLoader(getClass().getResource("LoginRegister.fxml"));
		Parent root = load.load();	
		Scene scene = new Scene(root);
		stage = (Stage) text.getScene().getWindow();
		stage.setScene(scene);
		stage.setTitle("3-asis laboratorinis darbas");
		stage.show();
	}
	
	public void about() {
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("About");
		alert.setHeaderText("About notification");
		alert.setContentText("Tai yra Manto Nacicko III-iasis labaratorinis darbas ir šiame darbe yra praktikuojamos ir pritaikomos JavaFX žinios");
		alert.showAndWait();
	}
	
	public void close() {
		Platform.exit();
		System.exit(0);
	}
	
	public void changePassowrd() throws IOException {
		FXMLLoader load = new FXMLLoader(getClass().getResource("ChangePassword.fxml"));
		Parent root = load.load();
		stage = (Stage) text.getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("3-asis laboratorinis darbas");
		stage.show();
	}
	
}
