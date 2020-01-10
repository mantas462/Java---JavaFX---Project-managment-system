package Antrinis;

public class Company extends User {
	
	private String companyName;
	
	public Company(String login, String pass, String companyName) {
		super(login, pass);
		this.companyName=companyName;
	}

	@Override
	public String toString() {
		return "Company [login=" + getLogin() + ", password=" + getPass() + ", company name=" + companyName + "]";
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	
	

}