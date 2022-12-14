package lesson11.exam2;

public class TestDrive_Exam2 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		ClassMember smith = new Lecturer("スミス講師");
		ClassMember johnson = new Lecturer("ジョンソン講師");
		ClassMember isabel = new TA("イザベルTA");
		ClassMember emma = new TA("エマTA");
		ClassMember chloe = new TA("クロエTA");
		ClassMember michael = new Student("マイケル");
		ClassMember william = new Student("ウィリアム");
		ClassMember daniel = new Student("ダニエル");
				
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
