package LoginRegister;

import java.io.IOException;

import Antrinis.ToDoList;
import Antrinis.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class WelcomeUserController {
Stage stage;
	@FXML
	private Text text;
	
	
	public void upload() {
		ToDoList todo;
		todo=SetToDo.getToDo();
		text.setText("Welcome " + todo.getLoggedIn().getLogin());
	}
	
	
	public void start() throws IOException {
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
	
	
	public void setText(String text) {
		this.text.setText("Welcome " + text);
	}



}
