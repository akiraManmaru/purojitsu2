package headfirst.factory.factory;

import java.util.HashMap;
import java.util.Map;

import headfirst.factory.curry.カツカレー;
import headfirst.factory.curry.カレー;
import headfirst.factory.curry.シーフードカレー;
import headfirst.factory.curry.スペシャルカレー;
import headfirst.factory.curry.野菜カレー;

/**
 * カレーの種類とそれを作るクラスの表
 */
public class Type2CurryClass {
	private static final Map<String, Class<? extends カレー>> type2ClassTable = new HashMap<String, Class<? extends カレー>>() {
		private static final long serialVersionUID = 1L; // おまじないです。気にする必要はありません。
		{
			put("カツ", カツカレー.class);
			put("野菜", 野菜カレー.class);
			put("シーフード", シーフードカレー.class);
			put("スペシャル", スペシャルカレー.class);
		}
	};

	/*
	 * 登録したHashMapのゲッター
	 */
	public static Map<String, Class<? extends カレー>> getType2ClassTable() {
		return type2ClassTable;
	}
}
