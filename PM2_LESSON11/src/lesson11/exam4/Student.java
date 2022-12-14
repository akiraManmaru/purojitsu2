package lesson11.exam4;

public class Student extends ClassMember {

	private String number;

	public Student(String name, MessageOperator messageOperator, String number) {
		super(name, messageOperator);
		this.number = number;
	}

	public String getNumber() {
		return number;
	}

}
