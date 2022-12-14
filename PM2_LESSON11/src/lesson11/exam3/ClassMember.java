package lesson11.exam3;

/**  　 　
 *  メッセージ交換を行う者（以下，利用者）が備える基本機能を定義する．
 * @author ProjII
 * @version 1.0
 */
public class ClassMember {

	/**  　 　
	 * それぞれの利用者が登録されるメッセージオペレータへの参照
	 */
	private MsgOpInterface messageOperator;
	/**  　 　
	 * 利用者の名前
	 */
	private String name;

	/**  　 　
	 * コンストラクタ：名前と登録するメッセージオペレータを指定
	 * @param name 利用者の名前
	 * @param messageOperator メッセージオペレータ
	 */
	public ClassMember( String name, MsgOpInterface messageOperator ){
		this.name = name;
		this.messageOperator = messageOperator;
		addMember(this);
	}

	/**  　 　
	 *
	 * @return 利用者の名前
	 */
	public String getName(){
		return this.name;
	}

	/**  　 　
	 * 利用者リストに利用者を追加する
	 * @param person 追加する利用者
	 */
	public void addMember( ClassMember person ){
		messageOperator.addMember(person);
	}

	/**  　 　
	 * 利用者にメッセージを受信させる（受信したことを示すメッセージを表示）
	 * @param message 受信メッセージ
	 */
	public void receiveMessage(String message) {
		System.out.println( this.name + "が受信: " + message );
	}

	/**  　 　
	 * 「お知らせ」を送信する
	 * @param message 「お知らせ」の内容
	 */
	public void sendMessage(String message) {
		messageOperator.processMessage(message,this);
	}

	/**  　 　
	 * 「レポート」を送信する
	 * @param message 「レポート」の内容
	 */
	public void submitReport(String message) {
		messageOperator.processReport(message,this);
	}

}
