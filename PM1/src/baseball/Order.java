package baseball;

import java.util.Iterator;
import java.util.List;

import baseball.player.Batter;
import baseball.player.Pitcher;
import baseball.player.Player;
import baseball.sorting.InsertionSort;
import baseball.sorting.QuickSort;
import baseball.sorting.Sort;

/**
 * 
 * 定数毎に異なるソートを実現するenum
 * 
 * @author mizutani
 *
 */

public enum Order {

	/** ソートをしないときに選択します．文字列は空の文字列を返します． */
	NONE(0, null) {
		public String toString() {
			return "";
		}

		@Override
		public double compare(Player p1, Player p2) {
			return 0;
		}

	},
	/** 試合数順にソートするときに選択します．文字列は"descending game order"を返します． */
	GAME(0, new QuickSort()) {
		public String toString() {
			return "descending game order";
		}

		public double compare(Player p1, Player p2) {
			return p2.getGame() - p1.getGame();
		}

	},
	/** Pitcherを勝利数順にソートするときに選択します．文字列は"descending win order"を返します． */
	WIN(0, new QuickSort()) {
		public String toString() {
			return "descending win order";
		}

		public double compare(Player p1, Player p2) {
			return ((Pitcher) p2).getWin() - ((Pitcher) p1).getWin();
		}
	},
	/** Pitcherを敗戦数順にソートするときに選択します．文字列は"descending loss order"を返します． */
	LOSS(0, new QuickSort()) {
		public String toString() {
			return "descending loss order";
		}

		public double compare(Player p1, Player p2) {
			return ((Pitcher) p2).getLoss() - ((Pitcher) p1).getLoss();
		}
	},
	/** Pitcherをセーブ数順にソートするときに選択します．文字列は"descending save order"を返します． */
	SAVE(0, new QuickSort()) {
		public String toString() {
			return "descending save order";
		}

		public double compare(Player p1, Player p2) {
			return ((Pitcher) p2).getSave() - ((Pitcher) p1).getSave();
		}
	},
	/** Pitcherをホールドポイントの順にソートするときに選択します．文字列は"descending hp order"を返します． */
	HP(0, new QuickSort()) {
		public String toString() {
			return "descending hp order";
		}

		public double compare(Player p1, Player p2) {
			return ((Pitcher) p2).getHp() - ((Pitcher) p1).getHp();
		}
	},
	/** Pitcherを防御率の順にソートするときに選択します．対象にならないPlayer（Pitcher）の判別にアウトを取った数を使います．文字列は"ascending era order"を返します． */
	ERA(432, new InsertionSort()) {
		public String toString() {
			return "ascending era order";
		}

		protected int getValue(Player player) {
			return ((Pitcher) player).getOut();
		}

		public double compare(Player p1, Player p2) {
			return ((Pitcher) p1).getEra() - ((Pitcher) p2).getEra();
		}
	},
	/** Pitcherを勝率順にソートするときに選択します．対象にならないPlayer（Pitcher）の判別に勝利数を使います．文字列は"descending winning percentage order"を返します． */
	PERCENTAGE(10, new InsertionSort()) {
		public String toString() {
			return "descending winning percentage order";
		}

		protected int getValue(Player player) {
			return ((Pitcher) player).getWin();
		}

		public double compare(Player p1, Player p2) {
			return ((Pitcher) p2).calcPercentage() - ((Pitcher) p1).calcPercentage();
		}
	},
	/** Batterを打率の順にソートするときに選択します．対象にならないPlayer（Batter）の判別に打席数を使います．文字列は"descending average order"を返します． */
	AVERAGE(444, new InsertionSort()) {
		public String toString() {
			return "descending era order";
		}

		protected int getValue(Player player) {
			return ((Batter) player).getPa();
		}

		public double compare(Player p1, Player p2) {
			return ((Batter) p1).calcAverage() - ((Batter) p2).calcAverage();
		}
	},
	/** Batterを打席数の順にソートするときに選択します．文字列は"descending pa order"を返します． */
	PA(0, new QuickSort()) {
		public String toString() {
			return "descending era order";
		}

		public double compare(Player p1, Player p2) {
			return ((Batter) p2).getPa() - ((Batter) p1).getPa();
		}
	},
	/** Batterを安打数順にソートするときに選択します．文字列は"descending hit order"を返します． */
	HIT(0, new QuickSort()) {
		public String toString() {
			return "descending era order";
		}

		public double compare(Player p1, Player p2) {
			return ((Batter) p2).getHit() - ((Batter) p1).getHit();
		}
	},
	/** Batterを本塁打数順にソートするときに選択します．文字列は"descending homerun order"を返します． */
	HOMERUN(0, new QuickSort()) {
		public double compare(Player p1, Player p2) {
			return ((Batter) p2).getHomerun() - ((Batter) p1).getHomerun(); // 多い方が前;
		}

		public String toString() {
			return "descending homerun order";
		}
	},
	/** Batterを打点順にソートするときに選択します．文字列は"descending rbi order"を返します． */
	RBI(0, new QuickSort()) {
		public String toString() {
			return "descending rbi order";
		}

		public double compare(Player p1, Player p2) {
			return ((Batter) p2).getRbi() - ((Batter) p1).getRbi();
		}
	},
	/** Batterを三振数順にソートするときに選択します．文字列は"descending strike out order"を返します． */
	STRIKE_OUT(0, new QuickSort()) {
		public String toString() {
			return "descending strike out order";
		}

		public double compare(Player p1, Player p2) {
			return ((Batter) p2).getStrikeOut() - ((Batter) p1).getStrikeOut();
		}
	},
	/** Batterを長打率の順にソートするときに選択します．対象にならないPlayer（Batter）の判別に打席数を使います．文字列は"descending slugging percentage order"を返します． */
	SLG(444, new QuickSort()) {
		public double compare(Player p1, Player p2) {
			return ((Batter) p2).calcSlg() - ((Batter) p1).calcSlg(); // 多い方が前;
		}

		protected int getValue(Player player) {
			return ((Batter) player).getPa();
		}

		public String toString() {
			return "descending slugging percentage order";
		}
	};

	/**
	 * このフィールドは，ソートアルゴリズムを表します．
	 */
	private Sort sortMethod;

	/**
	 * このフィールドは，規定数（この値より少ない場合は対象外にする）を表します．
	 */
	private int limit;

	/**
	 * それぞれのOrderの指定された2つのPlayerの項目の値を比較した結果を返します．
	 *
	 * @param p1 1人目のPlayerを指定します．
	 * @param p2 2人目のPlayerを指定します．
	 * @return p1の方が前になるときは0より小さく，p2の方が前になるときは0より大きくし，同点（入れ替えなし）の時は0にする．
	 */
	public abstract double compare(Player p1, Player p2);

	/**
	 * それぞれのOrderの文字列を返します．
	 * 
	 * @return 文字列を返します．
	 */
	public abstract String toString();

	/**
	 * Orderのコンストラクタです．フィールドlimit, sortMethodを設定します．
	 * 
	 * @param limit      それぞれのOrderのときの規定数（この値より少ない場合は対象外にする）を定めます．
	 * @param sortMethod それぞれのOrderのときのソートアルゴリズムを定めます．
	 */
	private Order(int limit, Sort sortMethod) {
		this.sortMethod = sortMethod;
		this.limit = limit;
	}

	/**
	 * それぞれのOrderの規定数，ソートアルゴリズムでselectedPlayersのPlayerをソートします．
	 * Pitcherの防御率と勝率，Batterの打率と長打率でソートするとき，対象にならないPlayerを，出力対象Playerを格納するListから削除します．
	 *
	 * @param selectedPlayers ソート対象の選手のリストを定めます．
	 */
	public void sort(List<Player> selectedPlayers) {
		if (limit != 0) {
			Iterator<Player> iterator = selectedPlayers.iterator();
			while (iterator.hasNext()) {
				Player player = iterator.next();
				if (getValue(player) < limit) {
					iterator.remove();
				}
			}
		}
		if (sortMethod != null) {
			sortMethod.sort(selectedPlayers, this);
		}
	}

	/**
	 * それぞれのOrderの，対象にならないPlayerの判別に用いる，指定されたPlayerの項目の値を返します．
	 *
	 * @param player Playerを指定します．
	 * @return 項目の値
	 */
	protected int getValue(Player player) {
		return 0;
	}

}
