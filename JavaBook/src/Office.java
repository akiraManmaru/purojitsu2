import java.util.ArrayList;

public class Office {
	private ArrayList<Score> scoreList;
	private ArrayList<String> studentIDList;

	public Office() {
		scoreList = new ArrayList<>();
		studentIDList = new ArrayList<>();
	}

	public void registerScore(Score score) {
		scoreList.add(score);
	}

	public void addStudent(String studentID) {
		studentIDList.add(studentID);
	}

	public ArrayList<String> getStudentIDList() {
		return studentIDList;
	}

	public int retrievePoint(String studentID) {
		int point = -1;
		for (Score score : scoreList) {
			if (studentID.equals(score.getStudentID())) {
				point = score.getPoint();
				break;
			}
		}
		return point;
	}

}
