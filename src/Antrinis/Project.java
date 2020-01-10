package Antrinis;

import java.util.ArrayList;

public class Project {
	private int id;
	private String title;
	private static int idCounter=1;
	private ArrayList<User> members=new ArrayList();
	private ArrayList<Task> tasks=new ArrayList();
	boolean isProjectDone;
	
	public boolean isProjectDone() {
		return isProjectDone;
	}

	public void setProjectDone(boolean isProjectDone) {
		this.isProjectDone = isProjectDone;
	}

	public Project(String title, User creator) {
		this.title=title;
		members.add(creator);
		this.id=idCounter++;
	}
	
	public ArrayList<Task> getAllTasks() {
		ArrayList<Task> all = new ArrayList();
		all.addAll(this.tasks);
		for (Task t:tasks) {
			all.addAll(t.getAllTasks());
		}
		return all;
	}
	
	
	
	@Override
	public String toString() {
		return "Project [id=" + id + ", title=" + title + ", members=" + members + ", tasks=" + tasks + "]";
	}

	public void addMember(User u) {
		members.add(u);
	}
	
	
	public void addTask(Task u) {
		tasks.add(u);
	}
	

	public ArrayList<User> getMembers() {
		return members;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setMembers(ArrayList<User> members) {
		this.members = members;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
