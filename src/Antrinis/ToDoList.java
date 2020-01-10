package Antrinis;

import java.util.ArrayList;

public class ToDoList {

	private ArrayList<User> users = new ArrayList();
	private ArrayList<Project> projects = new ArrayList();
	private ArrayList<Task> tasks=new ArrayList();
	private User loggedIn  = null;

	public Person registerPerson(String login, String pass, String name, String surname) throws TooShort {
			if (login.length() > 2 && pass.length() > 2 && name.length() > 2 && surname.length()> 2) {
				Person newPerson = new Person(login, pass, name, surname);
				users.add(newPerson);
				return newPerson;
			} 
			else {
				throw new TooShort("Strings are too short");
			}
	}

	public Company registerCompany(String login, String pass, String companyName) throws TooShort {
		if (login.length() > 2 && pass.length() > 2 && companyName.length() > 2) {
			Company newCompany = new Company(login, pass, companyName);
			users.add(newCompany);
			return newCompany;
		} else {
			throw new TooShort("Strings are too short");
		}
	}

	public String getCurrentUser() {
		User u = loggedIn;
		String name;
		name = u.getLogin();
		return name;
	}

	// public User login(String login, String pass) throws Exception {
	// for (User u : users) {
	// if (u.getLogin().equals(login) && u.getPass().equals(pass) && u.isActive()) {
	// loggedIn = u;
	//
	// return u;
	// }
	// }
	// throw new ObjectNotExists("Incorrect login data");
	// }

	public User login(String login, String pass) throws Exception {
		for (User u : users) {
			if (u.getLogin().equals(login) && u.getPass().equals(pass) && u.isActive()) {
				loggedIn = u;
				return u;
			}
		}
		throw new ObjectNotExists("Incorrect login data");
	}

	public User fastLogin(String login, String pass) {
		for (User u : users) {
			if (u.getLogin().equals(login) && u.getPass().equals(pass) && u.isActive()) {
				loggedIn = u;
				System.out.println("Welcome back " + u.getLogin());
				return u;
			}
		}
		return null;
	}

	public void logout() {
		loggedIn = null;
	}

	public void editPersonInfoByAdmin(int id, String name, String surname) {
		User current = getUserById(id);
		if (current != null && current.getClass().equals(Person.class)) {
			Person p = (Person) current;
			p.setName(name);
			p.setSurname(surname);
		}
	}

	public boolean loggedIn() {
		if (loggedIn == null) {
			return false;
		} else
			return true;
	}

	public boolean loggedInPersonOrCompany() {
		User current = getUserById(loggedIn.getId());
		if (current.getClass().equals(Person.class)) {
			return true;
		} else {
			return false;
		}
	}

	public void editCompanyInfoByAdmin(int id, String companyName) {
		User current = getUserById(id);
		if (current != null && current.getClass().equals(Company.class)) {
			Company p = (Company) current;
			p.setCompanyName(companyName);
		}
	}

	public ArrayList<User> getAllUsers() {
		return users;
	}

	public ArrayList<User> gettAllUsersForFileReading() {
		return users;
	}

	public ArrayList<User> getAllActiveUsers() {
		if (loggedIn != null && loggedIn.isActive()) {
			ArrayList<User> filtered = new ArrayList();
			for (User u : users) {
				if (loggedIn != null && u.isActive()) {
					filtered.add(u);
				}
			}
			return filtered;
		}
		return new ArrayList();
	}

	public boolean disableUser(int id) {
		if (loggedIn != null && loggedIn.isActive()) {
			User forDeletion = getUserById(id);
			if (forDeletion != null && forDeletion.isActive()) {
				forDeletion.setActive(false);
				return true;
			}
		}
		return false;
	}

	public User getUserByLogin(String login) {
		for (User u : users) {
			if (u.getLogin().equals(login)) {
				return u;
			}
		}
		return null;
	}

	public User getUserById(int id) {
		for (User u : users) {
			if (u.getId() == id) {
				return u;
			}
		}
		return null;
	}

	public Project addProject(String title) throws TooShort {
		if (title.length() > 0) {
			Project newProject = new Project(title, loggedIn);
			projects.add(newProject);
			loggedIn.addProject(newProject);
			return newProject;
		}
			else {
				return null;
			}
	}
	
	
	public Project addProjectToUserByAdmin(String title, int userId) throws TooShort {
			if (title.length()>0) {
			User u=getUserById(userId);
			Project newProject = new Project(title, u);
			projects.add(newProject);
			u.addProject(newProject);
			
			return newProject;
			}
			else {
				throw new TooShort("Strings are too short");
			}
	}
	
	public Project getUserProjectById(int id) {
			for (Project p : loggedIn.getProjects()) {
				if (p.getId() == id) {
					return p;
				}
			}
		return null;
	}

	public ArrayList<Project> getAllUserProjects() {
			return loggedIn.getProjects();
	}

	public Project getProjectById(int id) {
		for (Project u : projects) {
			if (u.getId() == id) {
				return u;
			}
		}
		return null;
	}

	public void addProjectMember(int projectId, int userId) throws TooShort {
			boolean memberAlreadyExist = false;
			Project current = getProjectById(projectId);
			ArrayList<User> filtered = current.getMembers();
			for (User u : filtered) {
				if (u.getId() == userId) {
					memberAlreadyExist = true;
					break;
				}
			}
			if (memberAlreadyExist == false) {
				User toAdd = getUserById(userId);
				if (current != null && toAdd != null) {
					current.addMember(toAdd);
				}
			}
			else {
				throw new TooShort("Member already exists");
			}
	}

	public void deleteProject(int id) {
		Project current = getProjectById(id);
		if (current != null) {
			projects.remove(current);
			for (User u : current.getMembers()) {
				u.getProjects().remove(current);
			}
		}
	}

	public void addTaskToProject(int projectId, String title) {
			Project my = getProjectById(projectId);
			Task newTask = new Task(title, my, getUserById(1));
			my.addTask(newTask);
	}
	
	public ArrayList<Task> getAllProjectTasks(int projectId) {
		return getProjectById(projectId).getAllTasks();	
	}

	public Task addTaskToTask(int taskId, String title) {
		if (loggedIn != null) {
			Task my = getUserTaskById(taskId);
			Task newTask = new Task(title, my.getProject(), loggedIn);
			my.addTask(newTask);
			return newTask;

		}
		return null;
	}

	public Task getUserTaskById(int id) {
		for (Project p : loggedIn.getProjects()) {
			ArrayList<Task> allTasks = p.getAllTasks();
			for (Task t : allTasks) {
				if (t.getId() == id) {
					return t;
				}
			}
		}
		return null;
	}
	// MANO RASYTOS FUNKCIJOS
	
	public User getLoggedIn() {
		return loggedIn;
	}

	public boolean editPersonInfoByUser(String name, String surname) {
		if (!name.isEmpty() && !surname.isEmpty()) {
			User current = loggedIn;
			Person p = (Person) current;
			p.setName(name);
			p.setSurname(surname);
			System.out.println("Changed!");
			return true;
		} else
			System.out.println("Some fields are empty");
		return false;
	}

	public boolean editCompanyInfoByUser(String companyName) {
		if (!companyName.isEmpty()) {
			User current = loggedIn;
			Company c = (Company) current;
			c.setCompanyName(companyName);
			System.out.println("Changed!");
			return true;
		} else {
			System.out.println("Some fields are empty");
			return false;
		}
	}

	public ArrayList<User> getProjectMembers(int projectId) {
			Project current = getProjectById(projectId);
			ArrayList<User> filtered = current.getMembers();
			return filtered;
	}

	public ArrayList<Project> getAllProjects() {
			return projects;
	}
	
	public int usersProjectsNumber() {
		
		int projectsNumber=loggedIn.getProjects().size();
		return projectsNumber;
		
	}

	public void editProjectInfo(int projectId, String title) {
		Project current = getProjectById(projectId);
		current.setTitle(title);
	}

	public ArrayList<Task> getProjectTasks(int projectId) {
		Project current = getProjectById(projectId);
		return current.getAllTasks();
	}
	
	
	public boolean addFriendByAdmin(int oneUser, int otherUser) {
		if (getUserById(oneUser) != null && getUserById(otherUser)!=null && !getUserById(oneUser).equals(getUserById(otherUser))) {
					getUserById(oneUser).addFriend(getUserById(otherUser));
					getUserById(otherUser).addFriend(getUserById(oneUser));
					return true;
				}
		else return false;
	}

	
	
	
	public boolean addFriendByUser(int userId) {
		if (getUserById(userId) != null) {
			if (!getUserById(userId).equals(getUserById(loggedIn.getId()))) {
				boolean isFriendAlreadyAdded = false;
				for (User u : getUserById(loggedIn.getId()).getFriends()) {
					if (getUserById(userId).equals(u)) {
						isFriendAlreadyAdded = true;
					}
				}
				if (isFriendAlreadyAdded == false) {
					User newFriend = getUserById(userId);
					newFriend.addFriend(loggedIn);
					loggedIn.addFriend(newFriend);
					return true;
				} else {
					System.out.println("Friend is already in your list");
					return false;
				}
			} else {
				System.out.println("You can not add yourself to your friendlist");
				return false;
			}
		} else {
			System.out.println("User which you want to add does not exist");
			return false;
		}
	}

	/*
	 * public User login(String login, String pass) throws Exception { for(User
	 * u:users) { if (u.getLogin().equals(login) && u.getPass().equals(pass) &&
	 * u.isActive()) { loggedIn=u; System.out.println("Welcome back " +
	 * u.getLogin()); return u; } } throw new
	 * ObjectNotExists("Incorrect login data"); }
	 */

	public ArrayList<User> getAllUserFriends() {
			ArrayList<User> friends = new ArrayList();
			for (User u : getUserById(loggedIn.getId()).getFriends()) {
				friends.add(getUserById(u.getId()));
			}
			return friends;
	}
	
	public int getUserCompanyFriends () {
		int numberOfCompanyFriends=0;
		ArrayList<User> companyFriends= new ArrayList();
		for (User u: getAllUserFriends()) {
			if (u.getClass().equals(Company.class)) {
				numberOfCompanyFriends++;
			}
		}
		return numberOfCompanyFriends;
	}
	
	
	public int getUserIndividualFriends () {
		int numberOfIndividualFriends=0;
		ArrayList<User> individualFriends= new ArrayList();
		for (User u: getAllUserFriends()) {
			if (u.getClass().equals(Person.class)) {
				numberOfIndividualFriends++;
			}
		}
		return numberOfIndividualFriends;
	}
	


	public boolean checkLoggedIn() {
		if (loggedIn == null) {
			return false;
		} else {
			return true;
		}
	}

	public int[] getUserCount() {
		int[] num = new int[2];
		for (User u : users) {
			if (u.getClass().equals(Person.class)) {
				num[0]++;
			} else {
				num[1]++;
			}
		}
		return num;
	}

	public int getUserProjectsNumber() {
		int numberOfProjects=0;
		numberOfProjects=loggedIn.getProjects().size();	
		return numberOfProjects;
	}
	
	public int getDoneProjectsNumber() {
		int numberOfDoneProjects=0;
		for(Project p: projects) {
			if(p.isProjectDone==true) {
				numberOfDoneProjects++;
			}
		}
		return numberOfDoneProjects;
	}
	
	public int getInProgressProjectsNumber() {
		int numberOfInProgressProjectsNumber=0;
		for(Project p: projects) {
			if(p.isProjectDone==false) {
				numberOfInProgressProjectsNumber++;
			}
		}
		return numberOfInProgressProjectsNumber;
	}
	
	public void makeProjectDone(int projectId) {
		Project p=getProjectById(projectId);
		p.setProjectDone(true);
	}
	
	public void changePassword(String newPassword, String repeatedPassword) throws ObjectNotExists {
		if (newPassword.length()>2 && newPassword.equals(repeatedPassword)) {
		loggedIn.setPass(newPassword);
		}
		else {
			throw new ObjectNotExists("Incorrect login data");
		}
	}
	
	public void checkCurrentPassword(String currentPassword) throws ObjectNotExists {
		if (!currentPassword.trim().equals(loggedIn.getPass().trim())) {
			throw new ObjectNotExists("Incorrect login data");
		}
	}
	
	public void changeCompanyName(String newName) throws ObjectNotExists {		
		if(newName.length()>2) {
			Company c=(Company) loggedIn;
			c.setCompanyName(newName);
		}
		else {
			throw new ObjectNotExists("Incorrect login data");
		}
		
	}
	
	
	public void changePersonNameAndSurname(String newName, String newSurname) {	
		
		if(newName.length()>2 && newSurname.length()>2) {
			Person p=(Person) loggedIn;
			p.setName(newName);
			p.setSurname(newSurname);
		}
		
	}

//	User current = getUserById(id);
//	if (current != null && current.getClass().equals(Person.class)) {
//		Person p = (Person) current;
//		p.setName(name);
//		p.setSurname(surname);
	
	
	/*
	 * public ArrayList<User> getAllActiveUsers() { if(loggedIn!=null &&
	 * loggedIn.isActive()) { ArrayList<User> filtered= new ArrayList(); for(User u:
	 * users) { if(loggedIn!=null && u.isActive()) { filtered.add(u); } } return
	 * filtered; } return new ArrayList(); }
	 */

	/*
	 * public Project addProject(String title) { if(loggedIn!=null &&
	 * title.length()>3) { Project newProject = new Project(title, loggedIn);
	 * projects.add(newProject); loggedIn.addProject(newProject); return newProject;
	 * } return null; }
	 */

	/*
	 * public Company registerCompany(String login, String pass, String companyName)
	 * { if(getUserByLogin(login)==null) { Company newCompany= new Company(login,
	 * pass, companyName); users.add(newCompany); return newCompany; } return null;
	 * }
	 * 
	 */

}
