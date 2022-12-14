package lesson10b.testdrive;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionListener;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Checkbox;
import java.awt.TextField;

import lesson10b.converter.ConverterView;

public class Test03ConverterView {
	public static void main(String[] args) throws Exception{
		// instance テスト
		ConverterView cw = new ConverterView();
		printResult(cw instanceof ConverterView, "cwはConverterViewのインスタンス");
		printResult(cw instanceof ActionListener, "cwはActionListenerのインスタンス");

		// frameのチェック
		final Frame frm = cw.createView();
		printResult(frm.getWidth() == 500, "frameの幅は500");
		printResult(frm.getHeight() == 300, "frameの高さは300");
		printResult(frm.getTitle().equals("Converter"), "frameのタイトルはConverter");
		
		// 全体パネルのチェック
		//final Container ctn = frm.getContentPane();
		final Container ctn = frm;
		final Panel pnl = (Panel)ctn.getComponent(0); 
		printResult(pnl.getBackground() == Color.pink, "panelの色はピンク");
		printResult(pnl.getLayout().toString()
				.equals("java.awt.GridLayout[hgap=0,vgap=0,rows=7,cols=1]"),
				"panelはグリッドレイアウトで7x1");
		
		// 1行目のパネルのチェック
		Panel rpnl = (Panel)pnl.getComponent(0);
		printResult(rpnl.getBackground() == Color.cyan, 
				"1行目のパネルの色はシアン");
		Checkbox rbtn = (Checkbox)rpnl.getComponent(0);
		printResult(rbtn.getLabel().equals("2進数"), 
				"1行目1番目の部品はラジオボタンで2進数");				
		rbtn = (Checkbox)rpnl.getComponent(1);
		printResult(rbtn.getLabel().equals("8進数"), 
				"1行目2番目の部品はラジオボタンで8進数");				
		rbtn = (Checkbox)rpnl.getComponent(2);
		printResult(rbtn.getLabel().equals("10進数"), 
				"1行目3番目の部品はラジオボタンで10進数");				
		rbtn = (Checkbox)rpnl.getComponent(3);
		printResult(rbtn.getLabel().equals("16進数"), 
				"1行目4番目の部品はラジオボタンで16進数");				

		// 2行目のパネルのチェック		
		rpnl = (Panel)pnl.getComponent(1);
		printResult(rpnl.getBackground() == Color.cyan, 
				"2行目のパネルの色はシアン");
		TextField txt = (TextField)rpnl.getComponent(0);
		printResult(txt.getText().equals(""), 
				"2行目1番目の部品はテキストフィールドで空文字");				
		Button btn = (Button)rpnl.getComponent(1);
		printResult(btn.getActionCommand().equals("変換"), 
				"2行目2番目の部品はボタンで変換");				
		
		// 3行目のパネルのチェック
		Label lbl = (Label)pnl.getComponent(2);
		printResult(lbl.getText().equals("メッセージ"), 
				"3行目1番目の部品はラベルでメッセージ");				
		
		// 4行目のパネルのチェック
		lbl = (Label)pnl.getComponent(3);
		printResult(lbl.getText().equals("2進数は?"), 
				"4行目1番目の部品はラベルで2進数は?");				
		
		// 5行目のパネルのチェック
		lbl = (Label)pnl.getComponent(4);
		printResult(lbl.getText().equals("8進数は?"), 
				"5行目1番目の部品はラベルで8進数は?");				
		
		// 6行目のパネルのチェック
		lbl = (Label)pnl.getComponent(5);
		printResult(lbl.getText().equals("10進数は?"), 
				"6行目1番目の部品はラベルで10進数は?");				
		
		// 7行目のパネルのチェック
		lbl = (Label)pnl.getComponent(6);
		printResult(lbl.getText().equals("16進数は?"), 
				"7行目1番目の部品はラベルで16進数は?");				
		
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
