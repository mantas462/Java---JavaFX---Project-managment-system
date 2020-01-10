package Antrinis;

import java.util.ArrayList;
import java.util.Date;

public class Task {
	private int id;
	private static int idCounter=1;
	private String title;
	private Date createdOn, completedOn;
	private User createdBy, completedBy;
	private boolean done = false;
	private ArrayList<Task> subTasks = new ArrayList();
	private Project project;
	
	public Task(String title, Project p, User createdBy) {
		id = idCounter++;
		this.title=title;
		this.createdBy=createdBy;
		createdOn=new Date();
		project=p;
	}
	
	@Override
	public String toString() {
		return "Task [id=" + id + ", title=" + title + "]";
	}



	public ArrayList<Task> getAllTasks() {
		ArrayList<Task> all = new ArrayList();
		for (Task t:subTasks) {
		all.addAll(t.getAllTasks());
		}
		return all;
	}
	
	public void addTask(Task t) {
		subTasks.add(t);
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getCompletedOn() {
		return completedOn;
	}

	public void setCompletedOn(Date completedOn) {
		this.completedOn = completedOn;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public User getCompletedBy() {
		return completedBy;
	}

	public void setCompletedBy(User completedBy) {
		this.completedBy = completedBy;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	
	public String getProjectTitle() {
		return project.getTitle();
	}
	
	public String getStatus() {
		if(done==false) {
		return "In Progress";
	}
		else {
			return "Done";
		}
	}
	
}
