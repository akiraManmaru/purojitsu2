package lesson06b.testdrive;

import java.lang.reflect.Modifier;
import java.util.ArrayList;

/**
 * BusTimeフィールド，コンストラクタ，メソッドの定義（中身の実装はできてなくて良い）が完成したら実行すること
 * @author handa
 *
 */
public class TestDrive01BusTime {
	/** 
	 * テスト対象のクラスはlesson06b.bus.BusTime
	 */
	private static Class<?> target = lesson06b.bus.BusTime.class;
	private static int count = 0;

	public static void main(String[] args) {
		System.out.println("クラスの修飾子の検査");
		クラスの修飾子の検査();
		System.out.println("フィールド実装の検査");
		フィールド実装検査();
		System.out.println("コンストラクタ実装の検査");
		コンストラクタ実装検査();
		System.out.println("メソッド実装の検査");
		メソッド実装検査();
		System.out.println("全部で54個のOKが出ていたら次に進んでください: " + count);
	}
	
	
	private static void クラスの修飾子の検査() {
		printResult(Modifier.isPublic(target.getModifiers()), "クラスのアクセス修飾子はpublic?");
		printResult(!Modifier.isAbstract(target.getModifiers()), "クラスにはabstract修飾子がついていない?");
	}

	private static void フィールド実装検査() {
		
		ArrayList<FieldCheck> fields = new ArrayList<>();
		
		fields.add(new FieldCheck("HOUR", int.class, Modifier.PRIVATE, true));
		fields.add(new FieldCheck("MINUTE", int.class, Modifier.PRIVATE, true));
		fields.add(new FieldCheck("route", lesson06b.bus.Route.class, Modifier.PRIVATE, false));
		fields.add(new FieldCheck("hour", int.class, Modifier.PRIVATE, false));
		fields.add(new FieldCheck("minute", int.class, Modifier.PRIVATE, false));
		fields.add(new FieldCheck("delay", int.class, Modifier.PRIVATE, false));
		
		for (FieldCheck f: fields) {
			printResult(f.isExisit(target),f.getName()+"が存在する？");
			printResult(f.isCorrectAccessor(target), f.getName()+"の修飾子が正しい？");
			printResult(f.isCorrectType(target), f.getName()+"の変数の型が正しい？");
		}
		printResult(fields.size() == target.getDeclaredFields().length, "余分なフィールドを宣言していない?");
	}
	
	private static void コンストラクタ実装検査() {
		ArrayList<ConstructorCheck> constructors = new ArrayList<>();
		
		constructors.add(new ConstructorCheck(new Class<?>[]{int.class, int.class}, Modifier.PUBLIC));
		constructors.add(new ConstructorCheck(new Class<?>[]{int.class, int.class, lesson06b.bus.Route.class}, Modifier.PUBLIC));
		
		for (ConstructorCheck c: constructors) {
			printResult(c.isExisit(target), "コンストラクタが存在する？");
			printResult(c.isCorrectAccessor(target), "コンストラクタのアクセス修飾子は正しい？");
		}
		printResult(constructors.size() == target.getConstructors().length, "余分なコンストラクタを宣言していない?");
	}
	
	public static void メソッド実装検査() {
		ArrayList<MethodCheck> methods = new ArrayList<>();
		
		methods.add(new MethodCheck("getHour", int.class, new Class<?>[]{}, Modifier.PUBLIC, false));
		methods.add(new MethodCheck("getMinute", int.class, new Class<?>[]{}, Modifier.PUBLIC, false));
		methods.add(new MethodCheck("getDelay", int.class, new Class<?>[]{}, Modifier.PUBLIC, false));
		methods.add(new MethodCheck("getRoute", lesson06b.bus.Route.class, new Class<?>[]{}, Modifier.PUBLIC, false));
		methods.add(new MethodCheck("isEarlier", boolean.class, new Class<?>[]{lesson06b.bus.BusTime.class}, Modifier.PUBLIC, false));
		methods.add(new MethodCheck("isValidTime", boolean.class, new Class<?>[]{int.class, int.class}, Modifier.PUBLIC, true));
		methods.add(new MethodCheck("setDelay", void.class, new Class<?>[]{int.class}, Modifier.PUBLIC, false));
			
		
		for (MethodCheck m: methods) {
			printResult(m.isExisit(target), m.getName()+"が存在する？");
			printResult(m.isCorrectAccessor(target), m.getName()+"の修飾子が正しい？");
			printResult(m.isCorrectReturnType(target), m.getName()+"の戻り値の型が正しい？");
			printResult(!m.isAbstract(target), m.getName()+"にabstract修飾子が付いていない？");
		}
	}



	/**
	 * テスト結果を表示する
	 * @param result テスト結果
	 * @param test テスト項目
	 */
	static void printResult(boolean result, String test) {
		if (result) {
			count++;
			System.out.printf("%s \tOK\n", test);
		} else {
			System.out.printf("%s \tNG\n", test);
		}
	}

}
