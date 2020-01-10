package LoginRegister;

import java.io.IOException;
import java.util.Collections;

import Antrinis.Company;
import Antrinis.Person;
import Antrinis.Project;
import Antrinis.Task;
import Antrinis.ToDoList;
import Antrinis.User;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Accordion;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import jdk.nashorn.internal.runtime.arrays.NumericElements;

public class MainProgramController {

	Stage stage;
	@FXML
	private PieChart piechart;
	@FXML
	private Accordion ac;
	
	
	public void setPieChart() {
		ToDoList todo=new ToDoList();
		todo=SetToDo.getToDo();

			ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
					new PieChart.Data("Done: ", todo.getDoneProjectsNumber()),
					new PieChart.Data("In Progress: ", todo.getInProgressProjectsNumber()));
			piechart.setData(pieChartData);
}
	
	
	public void changePassowrd() throws IOException {
		FXMLLoader load = new FXMLLoader(getClass().getResource("ChangePassword.fxml"));
		Parent root = load.load();
		stage = (Stage) piechart.getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("3-asis laboratorinis darbas");
		stage.show();
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
		stage = (Stage) piechart.getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("3-asis laboratorinis darbas");
		stage.show();
	}
	
	
	public void setProjects() {
		ToDoList todo;
		todo=SetToDo.getToDo();
		int numberOfProjects=todo.getUserProjectsNumber();

		TableView table=null;
		
		TitledPane tp= null;
		
		VBox vbox=null;
		
		Button newTaskButton=null;
	

		
		for(int i=1; i<=numberOfProjects; i++) {
			TableColumn tableColumn1=new TableColumn("Task title");
			tableColumn1.setCellValueFactory(new PropertyValueFactory<>("title"));			
			TableColumn tableColumn2=new TableColumn("Status");
			tableColumn2.setCellValueFactory(new PropertyValueFactory<>("status"));
			
			table=new TableView();
			table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
			ObservableList observableList =FXCollections.observableList(todo.getAllProjectTasks(i));
			
		
			
			table.getItems().add(newTaskButton);
			table.getColumns().add(tableColumn1);
			table.getColumns().add(tableColumn2);
			table.setItems(observableList);
			 
			newTaskButton=new Button("Add new task to the project");
			newTaskButton.setMaxSize(500, 500);
			vbox=new VBox();
			
			vbox.getChildren().add(newTaskButton);
			vbox.getChildren().add(table);
			
			
			tp=new TitledPane(todo.getProjectById(i).getTitle(), vbox);
			ac.getPanes().add(tp);
		}
	}
	
	
	public void logout() throws IOException {
		ToDoList todo=new ToDoList();
		todo=SetToDo.getToDo();
		todo.logout();
		SetToDo.setToDo(todo);
		
		
		FXMLLoader load = new FXMLLoader(getClass().getResource("LoginRegister.fxml"));
		Parent root = load.load();	
		Scene scene = new Scene(root);
		stage = (Stage) piechart.getScene().getWindow();
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
	
	
}