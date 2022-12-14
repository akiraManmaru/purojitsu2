package lesson11.exam2;

public class Student extends ClassMember {

	public Student(String name) {
		super(name);
		sendMessageFunc = new SendMessageFunctionCannot();
		submitReportFunc = new SubmitReportFunctionLecturerTA();
	}

}
