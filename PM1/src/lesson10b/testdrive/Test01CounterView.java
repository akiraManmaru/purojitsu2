package lesson10b.testdrive;

import java.awt.Color;
import java.awt.Container;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import lesson10b.counter.CounterView;

public class Test01CounterView {
	public static void main(String[] args) throws Exception{
		// instance テスト
		CounterView cw = new CounterView();
		printResult(cw instanceof CounterView, "cwはCounterViewのインスタンス");

		// frameのチェック
		final Frame frm = cw.createView();
		printResult(frm.getWidth() == 400, "frameの幅は400");
		printResult(frm.getHeight() == 50, "frameの高さは50");
		printResult(frm.getTitle().equals("Counter"), "frameのタイトルはCounter");
		
		// panelのチェック
		//final Container ctn = frm.getContentPane();
		final Container ctn = frm;
		final Panel pnl = (Panel)ctn.getComponent(0); 
		printResult(pnl.getBackground() == Color.orange, "panelの色はオレンジ");		
		printResult(pnl.getLayout().toString()
				.equals("java.awt.GridLayout[hgap=0,vgap=0,rows=1,cols=5]"),
				"panelはグリッドレイアウトで1行5列");
		
		// buttonのチェック
		Button btn = (Button)pnl.getComponent(0);
		printResult(btn.getActionCommand().equals(">>3"), "1番目の部品はボタンで>>3");		
		btn = (Button)pnl.getComponent(1);
		printResult(btn.getActionCommand().equals("-1"), "2番目の部品はボタンで-1");		
		btn = (Button)pnl.getComponent(3);
		printResult(btn.getActionCommand().equals("+1"), "4番目の部品はボタンで+1");		
		btn = (Button)pnl.getComponent(4);
		printResult(btn.getActionCommand().equals("<<3"), "5番目の部品はボタンで<<3");
		
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
