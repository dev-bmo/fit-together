package model.vo;

public class Gym {
	int id;
	String name;
	String type;
	String location;
	String owner;
	String manager;

	public Gym() {
		super();
	}

	public Gym(int id, String name, String type, String location, String owner, String manager) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.location = location;
		this.owner = owner;
		this.manager = manager;
	}

}
