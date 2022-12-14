package lesson11.exam2;

import java.util.List;

/**  　 　
 * 「レポート」を送信する機能のインタフェース
 * @author ProjII
 * @version 1.0
 */
public interface SubmitReportFunction {
	/**  　 　
	 * 「レポート」を送信する．
	 * @param message 「レポート」の本文
	 * @param sender 送り元
	 * @param members 利用者リスト
	 */
	public abstract void submitReport( String message, ClassMember sender,
			List<ClassMember> members );
}
