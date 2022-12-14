package lesson14a;

public class Status {
	private String name;
	private int hitPoint;
	private int age;

	public Status(String name, int hitPoint, int age){
		this.name = name;
		this.hitPoint = hitPoint;
		this.age = age;
	}

	public void showStatus(){
		System.out.println(name + "はヒットポイント" + hitPoint + "、年齢" + age + "です。");
	}

	public String getName(){
		return name;
	}

	public int getHitPoint(){
		return hitPoint;
	}

	public int getAge(){
		return age;
	}

}
