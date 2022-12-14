package lesson14a;

public class Unit {
	private Status status;

	public Unit(String name, int hitPoint, int age){
		this.status = new Status(name, hitPoint, age);
	}

	public void showStatus(){
		status.showStatus();
	}

	public Status getStatus(){
		return status;
	}

}
