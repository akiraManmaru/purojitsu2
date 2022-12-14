package lesson07b.core;

/**
 * ServerからClientに対して要求するイベントをEnum型で記述したクラス
 * @author mizutani
 *
 */
public enum ClientEvent {
	SUCCESS_ENTER {
		@Override
		public void handle(Message m, ClientNode c) {
			c.reciveTalkHistories(m.getTalkHistories());

		}
	},
	SUCCESS_EXIT {
		@Override
		public void handle(Message m, ClientNode c) {

		}
	},
	RECEIVE_TALK {
		@Override
		public void handle(Message m, ClientNode c) {

		}
	};

	/**
	 *
	 * 該当するイベントに対する処理を記述するメソッド．ClientNodeのメソッドを呼び出す．
	 * @param m 受信したメッセージ
	 * @param c ClientNodeのインスタンス
	 */
	public abstract void handle(Message m, ClientNode c);

}
