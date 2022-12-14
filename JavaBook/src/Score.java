
public class Score {
	private String studentID;
	private int point = 0;

	public Score(String studentID, int point) {
		this.studentID = studentID;
		this.point = point;
	}

	public String getStudentID() {
		return studentID;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

}
