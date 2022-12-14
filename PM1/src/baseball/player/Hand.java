package baseball.player;

/**
 * 利き腕の種別を持つ列挙型です．
 *
 */
public enum Hand {

	/** 右を表す種別です． */
	RIGHT("0") {
		@Override
		public String toString() {
			// TODO 自動生成されたメソッド・スタブ
			return "0";
		}
	},
	/** 左を表す種別です． */
	LEFT("1") {
		@Override
		public String toString() {
			// TODO 自動生成されたメソッド・スタブ
			return "1";
		}
	},
	/** 両を表す種別です． */
	SWITCH("2") {
		@Override
		public String toString() {
			// TODO 自動生成されたメソッド・スタブ
			return "2";
		}
	};

	/**
	 * このフィールドは，各種別のデータベース内での整数値を表します．
	 */
	private final String id;

	/**
	 * Handのコンストラクタです．フィールドidを設定します．
	 *
	 * @param id 利き腕の種別（1, 2, 3のString）
	 */
	private Hand(String id) {
		this.id = id;
	}

	/**
	 * String型引数に対して，対応するHand種別を戻します．
	 *
	 * @param id 利き腕の種別（1, 2, 3のString）
	 * @return 対応するHandです．
	 */
	public static Hand parseHand(String id) {
		Hand ret = null;
		for (Hand h : values()) {
			if (h.getId().equals(id)) {
				ret = h;
			}
		}
		return ret;
	}

	/**
	 * フィールドidのゲッターです．メソッドparseHandで使うプライベートメソッドです．
	 *
	 * @return フィールドid
	 */
	private String getId() {
		return id;
	}

	/**
	 * 種別に対応する文字列を返すメソッド（種別に応じて右・左・両を返す）
	 */
	public abstract String toString();

}
