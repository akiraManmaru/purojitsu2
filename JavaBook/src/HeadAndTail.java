/**
 * 提出者 21-1-037-0034 池上開世
 * 課題番号 11-1
 * 提出日 2021/12/10
 */
/**
 * 各文字列の頭文字末尾の文字を表示する
 */
public class HeadAndTail {
	//先頭と末尾の文字を取り出し、合わせて返す
	public String headAndTail(String word) {
		char head, tail;
		head = word.charAt(0);
		tail = word.charAt(word.length() - 1);
		String ht = head + "," + tail;
		return ht;
	}

	//メインメソッド
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		if (args.length == 1) {
			System.out.println("コマンドライン引数を2つ以上入力してください");
		} else {
			HeadAndTail hat = new HeadAndTail();//オブジェクト生成
			int i;

			for (i = 0; i < args.length; i++) {

				System.out.printf("%d番目の引数%sの先頭と末尾の文字は%sです\n", i + 1, args[i], hat.headAndTail(args[i]));
			}
		}

	}

}
