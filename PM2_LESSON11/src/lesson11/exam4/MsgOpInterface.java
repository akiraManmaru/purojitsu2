package lesson11.exam4;


/**  　 　
 * メッセージ交換を集中処理する「メッセージオペレータ」が備えるべきインタフェースを定義する
 * @author ProjII
 * @version 1.0
 */
public interface MsgOpInterface {
    /**  　 　
     * 利用者リストに利用者を追加する
     * @param person 追加する利用者
     */
    public void addMember(ClassMember person);
	/**  　 　
	 * 利用者リストから利用者を削除する
	 * @param person 削除する利用者
	 */
	public void deleteMember(ClassMember person);
	/**  　 　
	 * 「お知らせ」を処理する
	 * @param message 「お知らせ」の本文
	 * @param sender 送り元
	 */
	public void processMessage(String message, ClassMember sender);
	/**  　 　
	 * 「レポート」を処理する
	 * @param message 「レポート」の本文
	 * @param sender 送り元
	 */
	public void processReport(String message, ClassMember sender);

}