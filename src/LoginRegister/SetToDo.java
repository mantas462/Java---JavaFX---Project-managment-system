package LoginRegister;

import Antrinis.ToDoList;

public class SetToDo {

	static ToDoList todolist;
	
	public static ToDoList getToDo() { 
		return todolist;
	}
	
	public static void setToDo(ToDoList todo) { 
		todolist=todo;
	}
	
}
