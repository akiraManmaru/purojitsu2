package lesson06b.testdrive;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * クラスBusStopのフィールド，コンストラクタ，メソッドの定義が完成したら実行すること
 * ##################メソッドnextBus，setDelay, findSameDestination, getBustime, printTimeTableのメソッドの中身はまだ定義しなくてよい（Routeクラスが完成ないとできないので）##################
 * @author handa
 *
 */
public class TestDrive03BusStop {
	/** 
	 * テスト対象のクラスはlesson06b.bus.BusStop
	 */
	private static Class<?> target = lesson06b.bus.BusStop.class;
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
		System.out.println("全部で40個のOKが出ていたら次に進んでください: " + count);

	}
	
	
	private static void クラスの修飾子の検査() {
		printResult(Modifier.isPublic(target.getModifiers()), "クラスのアクセス修飾子はpublic?");
		printResult(!Modifier.isAbstract(target.getModifiers()), "クラスにはabstract修飾子がついていない?");
	}

	private static void フィールド実装検査() {
		
		ArrayList<FieldCheck> fields = new ArrayList<>();
		
		fields.add(new FieldCheck("name", String.class, Modifier.PRIVATE, false));
		fields.add(new FieldCheck("busTimes", List.class, Modifier.PRIVATE, false));
		
		for (FieldCheck f: fields) {
			printResult(f.isExisit(target),f.getName()+"が存在する？");
			printResult(f.isCorrectAccessor(target), f.getName()+"の修飾子が正しい？");
			printResult(f.isCorrectType(target), f.getName()+"の変数の型が正しい？");
		}
		printResult(fields.size() == target.getDeclaredFields().length, "余分なフィールドを宣言していない?");
	}
	
	private static void コンストラクタ実装検査() {
		ArrayList<ConstructorCheck> constructors = new ArrayList<>();
		
		constructors.add(new ConstructorCheck(new Class<?>[]{String.class}, Modifier.PUBLIC));
		
		for (ConstructorCheck c: constructors) {
			printResult(c.isExisit(target), "コンストラクタが存在する？");
			printResult(c.isCorrectAccessor(target), "コンストラクタのアクセス修飾子は正しい？");
		}
		printResult(constructors.size() == target.getConstructors().length, "余分なコンストラクタを宣言していない?");
	}
	
	public static void メソッド実装検査() {
		ArrayList<MethodCheck> methods = new ArrayList<>();
		
		methods.add(new MethodCheck("findSameDestination", boolean.class, new Class<?>[]{List.class, String.class}, Modifier.PRIVATE, false));
		methods.add(new MethodCheck("addBusTime", void.class, new Class<?>[]{lesson06b.bus.BusTime.class}, Modifier.PUBLIC, false));
		methods.add(new MethodCheck("getBusTime", lesson06b.bus.BusTime.class, new Class<?>[]{lesson06b.bus.Route.class}, Modifier.PUBLIC, false));
		methods.add(new MethodCheck("printTimeTable", void.class, new Class<?>[]{}, Modifier.PUBLIC, false));
		methods.add(new MethodCheck("setDelay", void.class, new Class<?>[]{lesson06b.bus.Route.class, int.class}, Modifier.PUBLIC, false));
		methods.add(new MethodCheck("getName", String.class, new Class<?>[]{}, Modifier.PUBLIC, false));
		methods.add(new MethodCheck("nextBus", List.class, new Class<?>[]{int.class, int.class}, Modifier.PUBLIC, false));
			
		
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
