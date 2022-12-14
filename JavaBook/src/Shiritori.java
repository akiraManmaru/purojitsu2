
/**
 * 提出者 21-1-037-0034 池上開世
 * 課題番号 11-3
 * 提出日 2021/12/10
 */
import java.util.Scanner;

/**
 * しりとりを行うクラス
 */
public class Shiritori {
	private String prevWord;
	//private ArrayList<String> wordlist;

	//コンストラクタ
	public Shiritori(String word) {
		this.prevWord = word;

	}

	//ゲッター
	public String getPrevWord() {
		return prevWord;
	}

	//セッター
	public void setPrevWord(String word) {
		prevWord = word;
	}

	//語尾にん、ンがないか確認するメソッド
	public boolean checkLastChar(String word) {
		boolean rez = false;
		int a = word.length();
		if (word.charAt(a - 1) == 'ん' || word.charAt(a - 1) == 'ン') {
			rez = true;
		}
		return rez;

	}

	//しりとりが最後の文字と先頭の文字が同じか確認するメソッド
	public boolean checkConnection(String word) {
		boolean rez = true;
		if (word.charAt(0) == prevWord.charAt(prevWord.length() - 1)) {
			rez = false;
		}
		return rez;
	}

	//メインメソッド
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		boolean flag = true;
		Scanner kbScanner = new Scanner(System.in);
		System.out.print("最初の言葉を入力してください:");
		String word = kbScanner.next();
		Shiritori shiritori = new Shiritori(word);//オブジェクト生成
		if (shiritori.checkLastChar(word)) {
			flag = false;//ん、ンで終わっているならfalse
		}
		shiritori.setPrevWord(word);//セット

		if (flag) {//ん、ンで終わっているならfalse
			while (true) {
				System.out.printf("%sに続く言葉を入力してください:", shiritori.getPrevWord());
				String word2 = kbScanner.next();
				if (shiritori.checkLastChar(word2)) {
					System.out.printf("%sは ン または ん で終わっています", word2);
					break;
				}
				if (shiritori.checkConnection(word2)) {
					System.out.printf("%sは%sに続く言葉ではありません", word2, shiritori.getPrevWord());
					break;
				}
				shiritori.setPrevWord(word2);
			}

		} else {
			System.out.printf("%sは ン または ん で終わっています", shiritori.getPrevWord());
		}
		kbScanner.close();

	}

}
