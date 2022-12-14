/*
 * 提出者 21-1-037-0034 池上開世
 * 予習課題 4-1
 * 提出日 2021/10/5
 */
/*
 * インクリメント演算子の使用例
 */
import java.util.Scanner;
public class IncrementDecrement {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner keyBoardScanner = new Scanner(System.in);
		System.out.print("整数を入力してください");
		int input = keyBoardScanner.nextInt();
		
		System.out.printf("前置インクレメント時の値：%d\n",++input); //先に足す
		System.out.printf("後置インクレメント時の値：%d\n",input++); //後で足す 
		System.out.printf("２回のインクレメント後の値：%d\n",input);
		System.out.printf("前置デクレメント時の値：%d\n",--input); //先に引く
		System.out.printf("後置デクレメント時の値：%d\n",input--); //後で引く
		System.out.printf("２回のデクレメント後の値：%d\n",input);
		keyBoardScanner.close();

	}

}
