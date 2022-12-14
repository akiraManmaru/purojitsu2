package lesson11.exam3;

import java.util.ArrayList;
import java.util.List;

/**  　 　
 * メッセージ交換を集中処理する「メッセージオペレータ」を具体的に定義する
 * @author ProjII
 * @version 1.0
 */
public class MessageOperator implements MsgOpInterface {

	/**  　 　
	 * すべての利用者のリスト
	 */
	protected List<ClassMember> members;

	/**  　 　
	 * コンストラクタでは members を初期化するだけ
	 */
	public MessageOperator() {
		this.members = new ArrayList<ClassMember>();
	}

	/**  　 　
	 * 利用者リストに利用者を追加する
	 * @param person 追加する利用者
	 */
	public void addMember(ClassMember person) {
		members.add(person);
	}

	/**  　 　
	 * 利用者リストから利用者を削除する
	 * @param person 削除する利用者
	 */
	public void deleteMember(ClassMember person) {
		members.remove(person);
	}

	/**  　 　
	 * 「お知らせ」を受け付けてすべての利用者に送信する．
	 */
	@Override
	public void processMessage(String message, ClassMember sender) {
		for (ClassMember cm : members) {
			cm.receiveMessage(makeMessageStr(message, sender.getName()));
		}
	}

	/**  　 　
	 * 「レポート」を受け付けて講師のみに送信する．
	 */
	@Override
	public void processReport(String message, ClassMember sender) {

		for (ClassMember cm : members) {
			if (cm instanceof Lecturer) {
				cm.receiveMessage(makeMessageStr(message, sender.getName()));
			}
		}
	}

	/**  　 　
	 * メッセージ本文と送り元から文字列をつくる．
	 * @param message メッセージ本文
	 * @param senderName 送り元の名前
	 * @return 生成した文字列
	 */
	private String makeMessageStr(String message, String senderName) {
		String retString = "[ 送信元: " + senderName + ", メッセージ: " + message + " ]";
		return retString;
	}

}
