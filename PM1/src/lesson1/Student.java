package lesson1;

public class Student {
	public String id;
	public String name;

	public Student(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public void printInfo() {
		System.out.println("学籍番号" + id + "の" + name + "です.");
	}

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Student mizutani = new Student("21-1-037-0034", "池上");
		mizutani.printInfo();

	}

}
