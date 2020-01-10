package LoginRegister;



import Antrinis.ToDoList;
import Antrinis.TooShort;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Start extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    

	@Override
	public void start(Stage stage) throws Exception {
		ToDoList todo=new ToDoList();
		loadData(todo);
		SetToDo.setToDo(todo);
		
		FXMLLoader load = new FXMLLoader(getClass().getResource("LoginRegister.fxml"));
		Parent root = load.load();	
		Scene scene = new Scene(root);
		
		stage.setScene(scene);
		stage.setTitle("3-asis laboratorinis darbas");
		stage.show();
		
	}


	private void loadData(ToDoList todo) throws TooShort {
		todo.registerCompany("123", "123", "123");
		
		
		todo.addProjectToUserByAdmin("PROJECT1", 1);
		todo.addProjectToUserByAdmin("PROJECT2", 1);
		todo.addProjectToUserByAdmin("PROJECT3", 1);
		todo.addProjectToUserByAdmin("PROJECT4", 1);
		todo.addProjectToUserByAdmin("PROJECT5", 1);
		
		todo.makeProjectDone(3);
		todo.makeProjectDone(4);
		
		
		todo.addTaskToProject(1, "FirstTask");
		todo.addTaskToProject(1, "SecondTask");
		todo.addTaskToProject(1, "FirstTask");
		todo.addTaskToProject(1, "SecondTask");
		todo.addTaskToProject(1, "FirstTask");
		todo.addTaskToProject(1, "SecondTask");
		todo.addTaskToProject(1, "FirstTask");
		todo.addTaskToProject(1, "SecondTask");
		todo.addTaskToProject(1, "FirstTask");
		todo.addTaskToProject(1, "SecondTask");
		todo.addTaskToProject(1, "FirstTask");
		todo.addTaskToProject(1, "SecondTask");
		
		todo.addTaskToProject(2, "Third Task");
		
		todo.registerCompany("124", "124", "124");
		todo.registerCompany("125", "125", "125");
		todo.registerPerson("MANTAS", "MAAA", "ASDSAD", "ASDDAS");
		todo.registerPerson("MANTAS11", "MAAA", "ASDSAD", "ASDDAS");
		
		todo.registerCompany("LABAS1", "LABAS", "LABAS");
		todo.registerCompany("LABAS2", "LABAS", "LABAS");
		todo.registerCompany("LABAS3", "LABAS", "LABAS");
		
		todo.addFriendByAdmin(1, 2);
		todo.addFriendByAdmin(1, 3);
		todo.addFriendByAdmin(1, 4);
		todo.addFriendByAdmin(1, 5);
		todo.addFriendByAdmin(1, 6);
	
	}
}