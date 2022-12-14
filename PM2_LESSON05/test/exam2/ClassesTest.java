package exam2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ClassesTest {

	/**
	 * 課題で提示されたクラスの実装検査
	 */
	@Test
	public void クラス実装検査01() {
		/**
		 * 検査対象の（パッケージ名付き）完全クラス名の作成
		 */
		String PACKAGE_NAME = "lesson05.exam2.factory";   // <== 修正箇所
		String[] CLASSES ={"VehicleGenerator", "CarGenerator"}; // <== 修正箇所

		List<String> classes = new ArrayList<String>();
		for(int i=0;i < CLASSES.length; i++){
			classes.add(PACKAGE_NAME + "." + CLASSES[i]);
		}

		/**
		 * クラスローダを使用してクラスが実装されているか検査する
		 */
		for(String name:classes){
			try {
				Class.forName(name);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				assertEquals("実装すべきクラス:"+name, name+"クラスが実装されていません。");
			}
		}
	}
}
