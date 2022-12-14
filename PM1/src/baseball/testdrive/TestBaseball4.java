package baseball.testdrive;

import java.util.List;

import baseball.Order;
import baseball.io.DumpPlayers;
import baseball.io.ScanPlayers;
import baseball.player.Player;

/*
 * SortMethodの実装クラス,PlayerComparatorの実装クラスの
 * 動作確認のためのテストプログラム
 */
public class TestBaseball4 {

	public static void main(String[] args) {

		List<Player> aList1 = ScanPlayers.scanPitchers("pitchers.csv");
		Order.WIN.sort(aList1);// インサーションソートを用いて勝利数順に並び替え
		DumpPlayers.dumpPlayers("outputTestBaseball4_1.csv",aList1); // dumpPlayers(String, ArrayList)による出力

		Order.HP.sort(aList1);// クイックソートを用いてホールドポイント順に並び替え
		DumpPlayers.dumpPlayers("outputTestBaseball4_2.csv",aList1); // dumpPlayers(String, ArrayList)による出力

		List<Player> aList2 = ScanPlayers.scanBatters("batters.csv");
		Order.HIT.sort(aList2);// クイックソートにて安打数順に並び替え
		DumpPlayers.dumpPlayers("outputTestBaseball4_3.csv",aList2); // dumpPlayers(String, ArrayList)による出力

		Order.SLG.sort(aList2); // クイックソートを用いて長打率順に並び替え
		DumpPlayers.dumpPlayers("outputTestBaseball4_4.csv",aList2); // dumpPlayers(String, ArrayList)による出力
	}
}
