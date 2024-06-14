package model.vo;

public class User {
	String id;
	String pasword;
	String name;
	String gender;
	int birth;
	String email;
	String interest;

	public User() {
		super();
	}

	public User(String id, String pasword, String name, String gender, int birth, String email, String interest) {
		super();
		this.id = id;
		this.pasword = pasword;
		this.name = name;
		this.gender = gender;
		this.birth = birth;
		this.email = email;
		this.interest = interest;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasword() {
		return pasword;
	}

	public void setPasword(String pasword) {
		this.pasword = pasword;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getBirth() {
		return birth;
	}

	public void setBirth(int birth) {
		this.birth = birth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

}
