
public class ScoreAdministration {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Office office1 = new Office();
		Teacher aoki = new Teacher("青木");
		Teacher endo = new Teacher("遠藤");

		office1.addStudent("0001");
		office1.addStudent("0002");
		office1.addStudent("0003");

		aoki.inputScore(office1);

		endo.askScore(office1, "0001");
		endo.askScore(office1, "0002");
		endo.askScore(office1, "0004");

	}

}
