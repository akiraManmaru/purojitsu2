package lesson10b.testdrive;

import java.awt.event.ActionEvent;
import java.lang.reflect.Field;
import java.awt.Label;
import java.awt.TextField;
import java.awt.CheckboxGroup;
import java.awt.Checkbox;

import lesson10b.converter.ConverterView;

public class Test04ConverterView {
	public static void main(String[] args) throws Exception{

		ConverterView cw = new ConverterView();
		cw.createView();
		final Field fbg = cw.getClass().getDeclaredField("baseGroup"); // フィールドの取得
        fbg.setAccessible(true); // private変数へのアクセス制限を解除	
		final Field fntf = cw.getClass().getDeclaredField("numTextField"); // フィールドの取得
        fntf.setAccessible(true); // private変数へのアクセス制限を解除		
		final Field fml = cw.getClass().getDeclaredField("msgLabel"); // フィールドの取得
        fml.setAccessible(true); // private変数へのアクセス制限を解除		
		final Field fb2l = cw.getClass().getDeclaredField("base2Label"); // フィールドの取得
        fb2l.setAccessible(true); // private変数へのアクセス制限を解除		
		final Field fb8l = cw.getClass().getDeclaredField("base8Label"); // フィールドの取得
        fb8l.setAccessible(true); // private変数へのアクセス制限を解除		
		final Field fb10l = cw.getClass().getDeclaredField("base10Label"); // フィールドの取得
        fb10l.setAccessible(true); // private変数へのアクセス制限を解除		
		final Field fb16l = cw.getClass().getDeclaredField("base16Label"); // フィールドの取得
        fb16l.setAccessible(true); // private変数へのアクセス制限を解除

		CheckboxGroup bg = (CheckboxGroup)fbg.get(cw);
		TextField ntf = (TextField)fntf.get(cw);
		Label ml = (Label)fml.get(cw);
		Label b2l = (Label)fb2l.get(cw);
		Label b8l = (Label)fb8l.get(cw);
		Label b10l = (Label)fb10l.get(cw);
		Label b16l = (Label)fb16l.get(cw);
        
		// 2進数の計算
        ActionEvent event = new ActionEvent(new Object(), 0, "2進数");
		bg.setSelectedCheckbox(new Checkbox("2進数",false,bg));
        cw.actionPerformed(event); // 2進数の選択
		ntf.setText("1101010");
		event = new ActionEvent(new Object(), 0, "変換");
		cw.actionPerformed(event); // 変換を押下
		printResult(ml.getText().equals("2進数の1101010を変換します"),
				"メッセージ「2進数の1101010を変換します」");
		printResult(b2l.getText().equals("2進数は1101010"),
				"「2進数は1101010」と出力");
		printResult(b8l.getText().equals("8進数は152"),
				"「8進数は152」と出力");
		printResult(b10l.getText().equals("10進数は106"),
				"「10進数は106」と出力");
		printResult(b16l.getText().equals("16進数は6a"),
				"「16進数は6a」と出力");		
		
		// 10進数の計算
        event = new ActionEvent(new Object(), 0, "10進数");
		bg.setSelectedCheckbox(new Checkbox("10進数",false,bg));
        cw.actionPerformed(event); // 10進数の選択
		ntf.setText("586");
		event = new ActionEvent(new Object(), 0, "変換");
		cw.actionPerformed(event); // 変換を押下
		printResult(ml.getText().equals("10進数の586を変換します"),
				"メッセージ「10進数の586を変換します」");
		printResult(b2l.getText().equals("2進数は1001001010"),
				"「2進数は1001001010」と出力");
		printResult(b8l.getText().equals("8進数は1112"),
				"「8進数は1112」と出力");
		printResult(b10l.getText().equals("10進数は586"),
				"「10進数は586」と出力");
		printResult(b16l.getText().equals("16進数は24a"),
				"「16進数は24a」と出力");				
		
		// 16進数の計算
        event = new ActionEvent(new Object(), 0, "16進数");
		bg.setSelectedCheckbox(new Checkbox("16進数",false,bg));
        cw.actionPerformed(event); // 16進数の選択
		ntf.setText("acf");
		event = new ActionEvent(new Object(), 0, "変換");
		cw.actionPerformed(event); // 変換を押下
		printResult(ml.getText().equals("16進数のacfを変換します"),
				"メッセージ「16進数のacfを変換します」");
		printResult(b2l.getText().equals("2進数は101011001111"),
				"「2進数は101011001111」と出力");
		printResult(b8l.getText().equals("8進数は5317"),
				"「8進数は5317」と出力");
		printResult(b10l.getText().equals("10進数は2767"),
				"「10進数は2767」と出力");
		printResult(b16l.getText().equals("16進数はacf"),
				"「16進数はacf」と出力");				
		
		System.exit(0);
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