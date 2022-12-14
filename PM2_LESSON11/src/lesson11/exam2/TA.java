package lesson11.exam2;

public class TA extends ClassMember {

	public TA(String name) {
		super(name);
		sendMessageFunc = new SendMessageFunctionCannot();
		submitReportFunc = new SubmitReportFunctionLecturerTA();
	}

}
