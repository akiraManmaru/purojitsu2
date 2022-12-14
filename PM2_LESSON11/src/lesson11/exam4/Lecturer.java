package lesson11.exam4;

/**  　 　
 *  講師の振る舞い・動作を定義する．
 * @author ProjII
 * @version 1.0
 */
public class Lecturer extends ClassMember {

	/**  　 　
	 * コンストラクタ：名前と登録するメッセージオペレータを指定
	 * @param name 利用者の名前
	 * @param messageOperator メッセージオペレータ
	 */
	public Lecturer(String name, MessageOperator messageOperator) {
		super(name, messageOperator);
	}

}
