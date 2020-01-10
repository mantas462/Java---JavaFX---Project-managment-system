package LoginRegister;

import java.io.IOException;

import Antrinis.ObjectNotExists;
import Antrinis.Person;
import Antrinis.ToDoList;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ChangePasswordController {

	Stage stage;
	
	@FXML
	private PasswordField currentPasswordInput;
	@FXML
	private PasswordField newPasswordInput;
	@FXML
	private PasswordField repeatPasswordInput;
	@FXML
	private Button submitButton;
	@FXML
	private Text text;
	
	public void submit() throws ObjectNotExists {
		ToDoList todo;
		todo = SetToDo.getToDo();
		
		String currentPassword = currentPasswordInput.getText();
		String newPassword = newPasswordInput.getText();
		String repeatedPassword = repeatPasswordInput.getText();
		try {
			todo.checkCurrentPassword(currentPassword);
			todo.changePassword(newPassword, repeatedPassword);
			SetToDo.setToDo(todo);
			text.setVisible(true);
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Incorrect data");
			alert.setHeaderText("Inserted data is incorect");
			alert.setContentText("Current password input is incorrect, new password is less than 2 symbols or repeated password is not as password");
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
	
	public void changeName() throws IOException {
		ToDoList todo;
		todo=SetToDo.getToDo();
		
		String fileName;
		
		if(todo.getLoggedIn().getClass().equals(Person.class)) {
			fileName="ChangePersonName.fxml";
		}
		else {
			fileName="ChangeCompanyName.fxml";
		}
		
		FXMLLoader load = new FXMLLoader(getClass().getResource(fileName));
		Parent root = load.load();
		stage = (Stage) text.getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("3-asis laboratorinis darbas");
		stage.show();
	}
	
	
	
}
