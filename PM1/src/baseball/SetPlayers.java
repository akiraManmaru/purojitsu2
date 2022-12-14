package baseball;

import java.util.ArrayList;
import java.util.List;

import baseball.io.DumpPlayers;
import baseball.io.ScanPlayers;
import baseball.player.Player;

/**
 * SetPlayersInterfaceの実装クラスです．
 */
public class SetPlayers implements SetPlayersInterface {

	// private static PlayersData instance = null; // Singletonパターンで使う

	/**
	 * Pitcherクラスのデータを管理するArrayListです．
	 */
	private List<Player> pitchers;

	/**
	 * Batterクラスのデータを管理するArrayListです．
	 */
	private List<Player> batters;

	/**
	 * ファイルに出力するPlayerを格納しておくArrayListです．
	 */
	private List<Player> selectedPlayers;

	/**
	 * 現在対象になっているリーグを格納します．
	 */
	private League league;

	/**
	 * 現在の対象がPitcherかBatterかを格納します．
	 */
	private PlayerType playerType;

	/**
	 * コンストラクタでは，フィールドleague，playerTypeを初期値のNONEに設定します．
	 */
	public SetPlayers() {
		league = League.NONE;
		playerType = PlayerType.NONE;
	}

	/*
	 * public static PlayersData getInstance(){ // Singletonパターン用
	 *
	 * return getInstance(PITCHER_FILENAME, BATTER_FILENAME); }
	 *
	 * public static PlayersData getInstance(String pitcherFilename, String
	 * batterFilename){ // Singletonパターン用
	 *
	 * if(instance == null){ instance = new PlayersData(pitcherFilename,
	 * batterFilename); }
	 *
	 * return instance; }
	 */

	/**
	 * Pitcherのデータはフィールドpitchersへ，BatterのデータはフィールドBattersへ代入します．
	 */
	@Override
	public void scanPlayers(String pitcherFilename, String batterFilename) {
		pitchers = ScanPlayers.scanPitchers(pitcherFilename);
		batters = ScanPlayers.scanBatters(batterFilename);
	}

	/**
	 * ソート対象のLeagueまたはPlayerTypeが前回のソートから変わった場合は，selectedPlayersを初期化して， 引数のLeague, PlayerTypeに一致する全Playerを再格納するようにします．
	 */
	@Override
	public void setLeague(League league, PlayerType playerType) {

		// 学生配布時に削除
		if (this.league != league || this.playerType != playerType) {
			System.out.println("change the target league or player type");
			clearPlayers();

			this.league = league; // 現在選択のリーグを記憶
			this.playerType = playerType; // 現在選択のPlayerTypeを記憶

			if (league != League.CENTRAL) // Pacific Leagueを含むとき
				copyLeaguePlayers(true);
			if (league != League.PACIFIC) // Central Leagueを含むとき
				copyLeaguePlayers(false);
			/*			if(playerType == PlayerType.PITCHER || playerType == PlayerType.BOTH) {
							for(Player p : pitchers) { // ピッチャーを selectedPlayers に加える
								if(league)
							}
						}*/
		}
	}

	// Pitcherを検索条件に含めるかを判定
	/**
	 * 現在，Pitcherが対象になっているかを表します．
	 * @return playerTypeがBOTHまたはPITCHERならば，Pitcherが対象なのでtrueを戻します．
	 */
	private boolean isPitcherType() {
		return playerType == PlayerType.PITCHER || playerType == PlayerType.BOTH;
	}

	// Batterを検索条件に含めるかを判定
	/**
	 * 現在，Batterが対象になっているかを表します．
	 * @return typeがBOTHまたはBATTERならば，Batterが対象なのでtrueを戻します．
	 */
	private boolean isBatterType() {
		return playerType == PlayerType.BATTER || playerType == PlayerType.BOTH;
	}

	/**
	 * selectedPlayersを初期化（新しくArrayListを生成し，leagueとplayerTyeを初期値NONEに設定する）します．
	 */
	@Override
	public void clearPlayers() {
		selectedPlayers = new ArrayList<Player>();
		this.league = League.NONE;
		this.playerType = PlayerType.NONE;
		System.out.println("reset players data");
	}

	/**
	 * 一方のリーグのPlayerを，出力対象Playerを格納するArrayListにコピーします．
	 * @param isPacific trueならパシフィックリーグのPlayerのみ，falseならセントッルリーグのPlayerのみをコピーします．
	 */
	private void copyLeaguePlayers(boolean isPacific) {

		if (isPitcherType()) {
			for (Player p : pitchers) {
				if (p.isPacific() == isPacific)
					selectedPlayers.add(p);
			}
		}
		if (isBatterType()) {
			for (Player p : batters) {
				if (p.isPacific() == isPacific)
					selectedPlayers.add(p);
			}
		}

	}

	@Override
	public void sort(Order order) {
		order.sort(selectedPlayers);
	}

	/**
	 * selectedPlayersのPlayerが順に入ったファイルを出力します．
	 */
	@Override
	public void dumpResult() {
		DumpPlayers.dumpPlayers(selectedPlayers);
	}

	/**
	 * selectedPlayersのPlayerが順に入ったファイルを出力します．
	 */
	@Override
	public void dumpResult(String filename) {
		DumpPlayers.dumpPlayers(filename, selectedPlayers);
	}
}