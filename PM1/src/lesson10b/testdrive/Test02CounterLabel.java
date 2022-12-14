package lesson10b.testdrive;

import java.awt.Label;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.lang.reflect.Field;
import lesson10b.counter.CounterLabel;

public class Test02CounterLabel {
	public static void main(String[] args) throws Exception{

		final CounterLabel cl = new CounterLabel();
		final Field field = cl.getClass().getDeclaredField("counter"); // clのcounterフィールドを取得
        field.setAccessible(true); // private変数へのアクセス制限を解除

		// instance テスト
        printResult(cl instanceof CounterLabel, "clはConuterLabelのインスタンス");
		printResult(cl instanceof Label, "clはLabelのインスタンス");
		printResult(cl instanceof ActionListener, "clはActionListenerのインスタンス");

		// テキストのテスト
		printResult(cl.getText().equals(""), "clは最初は空文字");

		// ダミーactionPerformed テスト
		ActionEvent event = new ActionEvent(new Object(), 0, "ev");
		cl.actionPerformed(event);
		printResult(cl.getText().equals("0"), "clのダミーアクション実行、文字は0");
		printResult((int)(field.get(cl))==0, "counterフィールドの値は0");

		// +1 actionPerformed テスト
		event = new ActionEvent(new Object(), 0, "+1");
		for(int i=0; i<3; i++) { // ＋1を3回実行
			cl.actionPerformed(event);
		}
		printResult(cl.getText().equals("3"), "clの+1アクション3回実行、文字は3");
		printResult((int)(field.get(cl))==3, "counterフィールドの値は3");

		// <<3 actionPerformed テスト
		event = new ActionEvent(new Object(), 0, "<<3");
		for(int i=0; i<2; i++) { // <<3を2回実行
			cl.actionPerformed(event);
		}
		printResult(cl.getText().equals("192"), "clの<<3アクション2回実行、文字は192");
		printResult((int)(field.get(cl))==192, "counterフィールドの値は192");

		// -1 actionPerformed テスト
		event = new ActionEvent(new Object(), 0, "-1");
		for(int i=0; i<3; i++) { // -1を2回実行
			cl.actionPerformed(event);
		}
		printResult(cl.getText().equals("189"), "clの-1アクション2回実行、文字は189");
		printResult((int)(field.get(cl))==189, "counterフィールドの値は189");

		// >>3 actionPerformed テスト
		event = new ActionEvent(new Object(), 0, ">>3");
		for(int i=0; i<2; i++) { // -1を2回実行
			cl.actionPerformed(event);
		}
		printResult(cl.getText().equals("2"), "clの>>3アクション2回実行、文字は2");
		printResult((int)(field.get(cl))==2, "counterフィールドの値は2");
	}

	private static void printResult(boolean result, String test) {
		if (result) {
			System.out.printf("%s \tのテストOK\n", test);
		} else {
			System.out.printf("%s \tのテストNG\n", test);
			System.exit(1);
		}
	}
}
