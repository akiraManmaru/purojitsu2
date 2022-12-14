package lesson11.exam2;

/**  　 　
 * 講師の振る舞い・動作を定義する．
 * @author ProjII
 * @version 1.0
 */
public class Lecturer extends ClassMember {
	/**
	 * nameをもちいて親クラスを初期化．
	 * sendMessageFuncとsubmitReportFuncを初期化．
	 * @param name 名前
	 */
	public Lecturer(String name) {
		super(name);
		sendMessageFunc = new SendMessageFunctionAll();
		submitReportFunc = new SubmitReportFunctionLecturerTA();
	}
	
}
