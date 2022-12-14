package lesson11.exam4;

public class TestDrive_Exam4 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		MessageOperator operator = new MessageOperator();

		ClassMember smith = new Lecturer("スミス講師", operator);
		ClassMember johnson = new Lecturer("ジョンソン講師", operator);
		ClassMember isabel = new TA("イザベルTA", operator);
		ClassMember emma = new TA("エマTA", operator);
		ClassMember chloe = new TA("クロエTA", operator);
		ClassMember michael = new Student("マイケル", operator,"25-001");
		ClassMember william = new Student("ウィリアム", operator,"25-002");
		ClassMember daniel = new Student("ダニエル", operator,"25-003");

		System.out.println("テスト１回目：");
		smith.sendMessage("みなさんこんにちは．スミスです．このメッセージが読めますか？");
		System.out.println("テスト２回目：");
		william.sendMessage("みなさんこんにちは．ウィリアムです．よろしくお願いします．");
		System.out.println("テスト３回目：");
		daniel.submitReport("ダニエルです．レポートを提出します．よろしくお願いします．");
		System.out.println("テスト４回目：");
		chloe.sendMessage("みなさんこんにちは．TAのクロエです．頑張ってください．");

	}
}
