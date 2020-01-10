package Antrinis;

import java.util.ArrayList;

public class User {
	
	private int id;
	private String login, pass;
	private static int idCounter=1;
	private boolean active=true;
	private ArrayList<Project> projects = new ArrayList();
	private ArrayList<User> friends = new ArrayList();
	
	public User(String login, String pass) {
		this.login=login;
		this.pass=pass;
		this.id=idCounter;
		idCounter++;
	}

	
	
	
	public ArrayList<User> getFriends() {
		return friends;
	}


	public void setFriends(ArrayList<User> friends) {
		this.friends = friends;
	}


	public void addFriend(User newFriend) {
		friends.add(newFriend);
	}
	

	public void addProject(Project p) {
		projects.add(p);
	}
	

	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", pass=" + pass + ", active=" + active + ", projects="
				+ projects + ", friends=" + friends + "]";
	}



	public ArrayList<Project> getProjects() {
		return projects;
	}


	public void setProjects(ArrayList<Project> projects) {
		this.projects = projects;
	}


	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getId() {
		return id;
	}
	


	
	

	
	
	
	
}
