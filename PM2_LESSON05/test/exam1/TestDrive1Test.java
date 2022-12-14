package exam1;

import static org.junit.Assert.*;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.JUnit4TestAdapter;
import lesson05.exam1.factory.VehicleGenerator;
import lesson05.exam1.factory.Type;

/**
 * TestDrive1の実行検査
 */
public class TestDrive1Test {

	private PrintStream _saved;
	private ByteArrayOutputStream _actual;
	private ByteArrayOutputStream _expected;
	private PrintStream _out;

	@Before public void setUp() {
		_saved = System.out;
		_actual = new ByteArrayOutputStream();
		_expected = new ByteArrayOutputStream();
		System.setOut(new PrintStream(new BufferedOutputStream(_actual)));
		_out = new PrintStream(new BufferedOutputStream(_expected));
	}

	@After public void tearDown() {
		System.setOut(_saved);
	}

	@Test
	public void メソッド実装検査01() throws SecurityException, NoSuchMethodException {

		// Expected
		String message1 = "駆動部：\n"
		+ "セダン用のシャーシを準備する\n"
		+ "セダン用のエンジンをとりつける\n"
		+ "セダン用の車軸とタイヤをとりつける\n"
		+ "車体：\n"
		+ "標準型の車体を製造\n"
		+ "標準型の車体をとりつけ\n"
		+ "内装：\n"
		+ "電気系を接続する\n"
		+ "シートと操作部をとりつける\n"
		+ "種別:セダン 名称:カラーロ を製造しました。製造番号は 1 となります\n";
		_out.println(message1);

		String message2 = "駆動部：\n"
		+ "スポーツ車用のシャーシを準備する\n"
		+ "スポーツ車用のエンジンをとりつける\n"
		+ "スポーツ車用の車軸とタイヤをとりつける\n"
		+ "車体：\n"
		+ "標準型の車体を製造\n"
		+ "標準型の車体をとりつけ\n"
		+ "内装：\n"
		+ "電気系を接続する\n"
		+ "シートと操作部をとりつける\n"
		+ "種別:スポーツ車 名称:ネクストレイル を製造しました。製造番号は 2 となります\n";
		_out.println(message2);

		String message3 = "駆動部：\n"
		+ "ミニバン用のシャーシを準備する\n"
		+ "ミニバン用のエンジンをとりつける\n"
		+ "ミニバン用の車軸とタイヤをとりつける\n"
		+ "車体：\n"
		+ "大型の車体を製造\n"
		+ "大型の車体をとりつけ\n"
		+ "内装：\n"
		+ "電気系を接続する\n"
		+ "シートと操作部をとりつける\n"
		+ "種別:ミニバン 名称:スキップワゴン を製造しました。製造番号は 3 となります\n";
		_out.println(message3);

		String message4 = "駆動部：\n"
		+ "トラック用のシャーシを準備する\n"
		+ "トラック用のエンジンをとりつける\n"
		+ "トラック用の車軸とタイヤをとりつける\n"
		+ "車体：\n"
		+ "特殊型の車体を製造\n"
		+ "特殊型の車体をとりつけ\n"
		+ "内装：\n"
		+ "電気系を接続する\n"
		+ "シートと操作部をとりつける\n"
		+ "種別:トラック 名称:スーパーゼット を製造しました。製造番号は 4 となります\n";
		_out.println(message4);
		_out.flush();

		// Actual
		VehicleGenerator generator = new VehicleGenerator();
		generator.orderVehicle(Type.SEDAN);
		generator.orderVehicle(Type.SUV);
		generator.orderVehicle(Type.MINIVAN);
		generator.orderVehicle(Type.TRUCK);
		System.out.flush();

		// Compare
		assertEquals(_expected.toString().replaceAll("\\r\\n", "\n"), _actual.toString().replaceAll("\\r\\n", "\n"));
		//assertEquals(_expected.toString(), _actual.toString());

	}

	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(TestDrive1Test.class);
	}
}
