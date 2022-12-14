package lesson11.exam1;

import java.util.ArrayList;
import java.util.List;

/**  　 　
 *  メッセージ交換を行う者（以下，利用者）が備える基本機能を定義する．
 * @author ProjII
 * @version 1.0
 */
public class ClassMember {

	/**  　 　
	 * すべての利用者のリスト.
	 * クラス変数を使うと集中管理になってしまうので Mediator の反例としては良くないが
	 * メンバーリストまで分散管理にするのは少し煩雑すぎるので今回はこのようにした．
	 */
	static List<ClassMember> members = new ArrayList<ClassMember>();
	/**  　 　
	 * 利用者の名前
	 */
	private String name;

	/**  　 　
	 * @param name 利用者の名前
	 */
	public ClassMember(String name) {
		this.name = name;
		addMember(this);
	}

	/**  　 　
	 * メンバーリストに追加
	 * @param person 追加する利用者
	 */
	public void addMember(ClassMember person) {
		members.add(person);
	}

	/**  　 　
	 * メンバーリストから削除
	 * @param person 削除する利用者
	 */
	public void deleteMember(ClassMember person) {
		members.remove(person);
	}

	/**  　 　
	 * @return 利用者の名前
	 */
	public String getName() {
		return this.name;
	}

	/**  　 　
	 * 利用者にメッセージを受信させる（受信したことを示すメッセージを表示）
	 * @param message 受信メッセージ
	 */
	public void receiveMessage(String message) {
		System.out.println(this.name + "が受信: " + message);
	}

	/**  　 　
	 * 「お知らせ」を送信する
	 * @param message 「お知らせ」の内容
	 */
	public void sendMessage(String message) {
		for (ClassMember cm : members) {
			cm.receiveMessage(makeMessageStr(message, this.name));
		}

	}

	/**  　 　
	 * 「レポート」を送信する
	 * @param message 「レポート」の内容
	 */
	public void submitReport(String message) {
		//ここに実装する
		for (ClassMember cm : members) {
			if (cm instanceof Lecturer) {
				cm.receiveMessage(makeMessageStr(message, this.name));
			}
		}
	}

	/**  　 　
	 * メッセージ本文と送り元から文字列をつくる．
	 * @param message メッセージ本文
	 * @param senderName 送り元の名前
	 */
	private String makeMessageStr(String message, String senderName) {
		String retString = "[ 送信元: " + senderName + ", メッセージ: " + message + " ]";
		return retString;
	}

}
