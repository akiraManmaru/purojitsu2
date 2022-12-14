
public class Teacher {
	private String name;

	public Teacher(String name) {
		this.name = name;
	}

	public void askScore(Office office, String studentID) {
		int point = office.retrievePoint(studentID);
		if (point >= 0)
			System.out.printf("(%s) 学籍番号%sの成績は%d点です。\n", name, studentID, point);

		else
			System.out.printf("(%s) 学籍番号%sの成績は未登録です。\n", name, studentID);
	}

	public void inputScore(Office office) {
		int point = 80;
		for (String studentID : office.getStudentIDList()) {
			office.registerScore(new Score(studentID, point));
			point += 7;
		}
	}

}
