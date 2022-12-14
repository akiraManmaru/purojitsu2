package singeroidtestdrive;

import singersystem.Singeroid;

public class TestSample {
	public static void main(String[] args) {
		Singeroid player;
		boolean flg; // 呼び出し時の戻り値

		player = new Singeroid("ミク");
		System.out.println(player);

		//ボリュームの初期値のテスト
		System.out.println(player.getVolume());

		// ボリューム設定失敗時のテスト
		flg = player.setVolume(-1);
		System.out.println(flg);
		System.out.println(player.getVolume());

		// ボリューム設定失敗時のテスト
		flg = player.setVolume(11);
		System.out.println(flg);
		System.out.println(player.getVolume());

		// ボリューム設定成功時のテスト
		flg = player.setVolume(0);
		System.out.println(flg);
		System.out.println(player.getVolume());

		// ボリューム設定成功時のテスト
		flg = player.setVolume(3);
		System.out.println(flg);
		System.out.println(player.getVolume());

		// ボリューム設定成功時のテスト
		flg = player.setVolume(10);
		System.out.println(flg);
		System.out.println(player.getVolume());

		// 音声テスト
		flg = player.sing('c');
		System.out.println(flg);

		flg = player.sing('d');
		System.out.println(flg);

		flg = player.sing('e');
		System.out.println(flg);

		flg = player.sing('f');
		System.out.println(flg);

		flg = player.sing('g');
		System.out.println(flg);

		flg = player.sing('a');
		System.out.println(flg);

		flg = player.sing('b');
		System.out.println(flg);

		//音声テスト失敗時
		flg = player.sing('z');
		System.out.println(flg);
	}
}
