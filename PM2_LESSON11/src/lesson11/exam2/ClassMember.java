package lesson11.exam2;

import java.util.ArrayList;
import java.util.List;

/**  　 　
 * メッセージ交換を行う者（以下，利用者）が備える基本機能を定義する．
 * @author ProjII
 * @version 1.0
 */
public class ClassMember {

	/**  　 　
	 * すべての利用者のリスト.
	 * ［注】クラス変数を使うと集中管理になってしまうので Mediator の反例としては良くないが
	 * メンバーリストまで分散管理にするのは少し煩雑すぎるので今回はこのようにした．
	 */
	static List<ClassMember> members = new ArrayList<ClassMember>();

	/**  　 　
	 * 「お知らせ」を送るメソッドへの参照
	 */
	protected SendMessageFunction sendMessageFunc;
	/**  　 　
	 * 「レポート」を送るメソッドへの参照
	 */
	protected SubmitReportFunction submitReportFunc;

	/**  　 　
	 * 利用者の名前
	 */
	private String name;

	/**  　 　
	 * 利用者の名前を指定しいてインスタンスを作成
	 * @param name 利用者の名前
	 */
	public ClassMember( String name ){
		this.name = name;
		addMember(this);
	}

	/**  　 　
	 * メンバーリストに追加
	 * @param person 追加する利用者
	 */
	public void addMember(ClassMember person){
		members.add(person);
	}

	/**  　 　
	 * メンバーリストから削除
	 * @param person 削除する利用者
	 */
	public void deleteMember(ClassMember person){
		members.remove(person);
	}

	/**  　 　
	 *
	 * @return 利用者の名前
	 */
	public String getName(){
		return this.name;
	}

	/**  　 　
	 * 「お知らせ」を送信する．具体的な処理は sendMessageFunc に委譲する．
	 * @param message 「お知らせ」の内容
	 */
	public void sendMessage( String message ){
		sendMessageFunc.sendMessage(message, this, members);
	}

	/**  　 　
	 * 「レポート」を送信する．具体的な処理は sendReportFunc に委譲する．
	 * @param message 「レポート」の内容
	 */
	public void submitReport( String message ){
		submitReportFunc.submitReport(message, this, members);
	}

	/**  　 　
	 * 利用者にメッセージを受信させる（受信したことを示すメッセージを表示）
	 * @param message 受信メッセージ
	 */
	public void receiveMessage(String message) {
		System.out.println( this.name + "が受信: " + message );
	}

}
