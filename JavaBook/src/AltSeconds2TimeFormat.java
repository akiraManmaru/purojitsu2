
/*
 * 提出者 21-1-037-0034 池上開世
 * 課題 4-4
 * 提出日 2021/10/5
 */
/*
 * 秒を日時分秒に変換するクラス
 */
import java.util.Scanner;

/*
 * 秒を年日時分秒に変換するクラス
 */

public class AltSeconds2TimeFormat {
	private int years, days, hours, minutes, seconds;

	//コンストラクタ、秒を年日時分秒に変換
	public AltSeconds2TimeFormat(int seconds) {
		this.years = seconds / (60 * 60 * 24 * 365);
		int remainYears = seconds % (60 * 60 * 24 * 365);
		this.days = remainYears / (60 * 60 * 24);
		int remainDays = remainYears % (60 * 60 * 24);
		this.hours = remainDays / (60 * 60);
		int remainHours = remainDays % (60 * 60);
		this.minutes = remainHours / 60;
		int remainMinutes = remainHours % 60;
		this.seconds = remainMinutes;
	}

	//年日時分秒を表示
	public void printResult() {
		System.out.printf("%d年 %d日 %d時間 %d分 %d秒です", years, days, hours, minutes, seconds);
	}

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner keyBoardScanner = new Scanner(System.in);
		System.out.print("秒数を入力してください");
		int input = keyBoardScanner.nextInt();
		AltSeconds2TimeFormat altSecond2TimeFormat = new AltSeconds2TimeFormat(input);
		altSecond2TimeFormat.printResult();
		keyBoardScanner.close();

	}

}
