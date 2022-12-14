package lesson07b.core;

/**
 * ClientからServerに対して要求するイベントをEnum型で記述したクラス
 * @author mizutani
 *
 */
public enum ServerEvent {

	ENTER {
		@Override
		public void handle(Message m, ServerNode s) {
			s.enter(m.getAddress(), m.getStr());
		}

	},
	EXIT {
		@Override
		public void handle(Message m, ServerNode s) {
			s.exit(m.getAddress(), m.getStr());
		}
	},
	TALK {
		@Override
		public void handle(Message m, ServerNode s) {
			s.broadcast(m.getTalk());
		}
	},
	ECHO {
		@Override
		public void handle(Message m, ServerNode s) {
			s.showClientInfo(m.getAddress());
		}
	};

	private ServerEvent() {

	}

	/**
	 *
	 * 該当するイベントに対する処理を記述するメソッド．ServerNodeのメソッドを呼び出す．
	 * @param m 受信したメッセージ
	 * @param s ServerNodeのインスタンス
	 */
	public abstract void handle(Message m, ServerNode s);

}
