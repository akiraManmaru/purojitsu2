/*
 * 提出者 21-1-037-0034 池上開世
 * 課題 3-2
 * 提出日 2021/9/28
 */

import java.util.Scanner;
/*
 * RectangleDoubleクラスを用い、数値を入力することのできるsquareオブジェクトを生成する。
 */
public class SquareMain {
	
    //メインメソッド
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner kbScanner = new Scanner(System.in);
		
		//キーボード入力を変数に代入
		System.out.print("x座標入力:");
		int xPosition2 = kbScanner.nextInt();
		System.out.print("y座標入力:");
		int yPosition2 = kbScanner.nextInt();
		System.out.print("辺の長さ入力:");
		int length = kbScanner.nextInt();
		
		//オブジェクト生成
		RectangleDouble square = new RectangleDouble(xPosition2,yPosition2,length,length);
		//squareオブジェクトの情報表示
		square.showState();
		//キーボード入力を変数に代入
		System.out.print("x軸方向移動距離入力:");
		double xMove2 = kbScanner.nextDouble();
		System.out.print("y軸方向移動距離入力:");
		double yMove2 = kbScanner.nextDouble();
		//moveメソッド始動
		square.move(xMove2, yMove2);
		//squareオブジェクトの情報表示
		square.showState();
		//3倍に
		square.resize(3);
		square.showState();
		square.resize(5e-01);
		//半分に
		square.showState();
		kbScanner.close();

	}

}
