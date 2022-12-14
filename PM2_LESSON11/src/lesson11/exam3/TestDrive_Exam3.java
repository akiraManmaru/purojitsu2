package lesson11.exam3;

public class TestDrive_Exam3 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		MessageOperator operator = new MessageOperator();

		ClassMember smith = new Lecturer("スミス講師", operator);
		ClassMember johnson = new Lecturer("ジョンソン講師", operator);
		ClassMember michael = new Student("マイケル", operator);
		ClassMember william = new Student("ウィリアム", operator);
		ClassMember daniel = new Student("ダニエル", operator);

		System.out.println("テスト１回目：");
		smith.sendMessage("みなさんこんにちは．スミスです．このメッセージが読めますか？");
		System.out.println("テスト２回目：");
		william.sendMessage("みなさんこんにちは．ウィリアムです．よろしくお願いします．");
		System.out.println("テスト３回目：");
		daniel.submitReport("ダニエルです．レポートを提出します．よろしくお願いします．");
	}

}
