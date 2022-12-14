package headfirst.factory.factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import headfirst.factory.curry.カツカレー;
import headfirst.factory.curry.カレー;
import headfirst.factory.curry.シーフードカレー;
import headfirst.factory.curry.スペシャルカレー;
import headfirst.factory.curry.野菜カレー;

/**
 * カレーチェーン店　　  　
 */
public abstract class カレーチェーン店 {
	protected Map<String, Class<? extends カレー>> type2ClassTable;

	public abstract カレー createCurry(String item);

	public Map<String, Class<? extends カレー>> getType2ClassTable() {
		return type2ClassTable;
	}

	public カレー orderCurry(String type) {
		カレー curry = createCurry(type);
		if (curry == null) {
			System.out.println("当店では" + type + "カレーは扱っておりません\n");
		} else {
			System.out.println("---" + curry.getName() + "を作る ---");
			curry.prepare();
			curry.rice();
			curry.roux();
			curry.topping();
			System.out.println("---" + curry.getName() + "が完成 ---");
		}
		return curry;
	}

	public カレー createCurryInCookroom(String item, カレー店厨房 ingredientFactory) {
		return createCurryInCookroom2(item, ingredientFactory);
		// 課題5では以下に変更する
		// return createCurryInCookroom2(item, ingredientFactory);
	}

	public カレー createCurryInCookroom1(String item, カレー店厨房 ingredientFactory) {
		カレー curry = null;

		if (item.equals("カツ")) {
			curry = new カツカレー(ingredientFactory);
		} else if (item.equals("野菜")) {
			curry = new 野菜カレー(ingredientFactory);
		} else if (item.equals("シーフード")) {
			curry = new シーフードカレー(ingredientFactory);
		} else if (item.equals("スペシャル")) {
			curry = new スペシャルカレー(ingredientFactory);
		}
		return curry;
	}

	public カレー createCurryInCookroom2(String item, カレー店厨房 ingredientFactory) {
		カレー curry;
		type2ClassTable = Type2CurryClass.getType2ClassTable(); // null を適切な値にする

		Class<?>[] types = { カレー店厨房.class };
		Constructor<? extends カレー> constructor;
		Class<? extends カレー> curryClass = type2ClassTable.get(item); // null を適切な値にする
		try {
			// CurryStoreCookroom型の引数を一つ持つコンストラクタの取得
			constructor = curryClass.getConstructor(types);
		} catch (SecurityException e) {
			throw new RuntimeException(e);
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(e);
		}
		// コンストラクタの実引数の生成
		// 引数の数は１つ
		Object[] args = new Object[1];
		args[0] = ingredientFactory;
		try {
			// コンストラクタ呼び出しによるインスタンスの取得
			curry = constructor.newInstance(args);
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(e);
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		}

		return curry; // null を適切な値にする
	}
}
