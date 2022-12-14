package lesson07b.core;
/**
 * 会話の内容を保存するクラス．
 * @author mizutani
 *
 */

public class TalkInfo {
	/**
	 * 会話に用いる名前
	 */
	private String name;
	/**
	 * 会話内容
	 */
	private String body;

	/**
	 * 名前と会話内容をフィールド変数に保存
	 * @param name 名前
	 * @param body 会話内容
	 */
	public TalkInfo(String name, String body) {
		this.name = name;
		this.body = body;
	}

	/**
	 * 会話内容のを返すメソッド
	 * @return body
	 */
	public String getBody() {
		return body;
	}

	/**
	 * 会話に用いる名前を返すメソッド
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 名前と会話内容を表示するメソッド
	 */
	public void showInfo() {
		System.out.println("名前: " + this.name + ": " + this.body);
	}

}
