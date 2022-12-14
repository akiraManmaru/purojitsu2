
public class SplitString {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		String[] lines = { "0001,山田太郎,2,3,42",
				"0002,田中一郎,2,6,31",
				"0003,斎藤花子,2,2,4" };
		int numOfStudents = lines.length;
		String[][] students = new String[numOfStudents][];

		for (int i = 0; i < numOfStudents; i++)
			students[i] = lines[i].split(",");

		for (int i = 0; i < numOfStudents; i++)
			System.out.printf("%s の欠席日数は%s日です\n", students[i][1], students[i][3]);

	}

}
