package baseball.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import baseball.player.Batter;
import baseball.player.Pitcher;
import baseball.player.Player;

/**
 * あらかじめ決められたフォーマットのcsvファイルからPlayerのデータを読み出すためのクラスです．
 *
 */
public class ScanPlayers {

	/**
	 * 指定されたファイル名のcsvファイルからPitcherのデータを読み出し，PlayerクラスのListとして戻します．
	 *
	 * @param filename
	 *            Pitcherのデータが入っているcsvファイル
	 * @return PitcherのデータのArrayList
	 */
	public static List<Player> scanPitchers(String filename) {
		return readPlayerData(filename, true);
	}

	/**
	 * 指定されたファイル名のcsvファイルからBatterのデータを読み出し，PlayerクラスのListとして戻します．
	 *
	 * @param filename
	 *            Batterのデータが入っているcsvファイル
	 * @return BatterのデータのArrayList
	 */
	public static List<Player> scanBatters(String filename) {
		return readPlayerData(filename, false);
	}

	/**
	 * 指定されたファイル名のcsvファイルからPitcherまたはBatterのデータを読み出し，１行ずつ文字列を区切ってPlayerクラスのインスタンスに
	 * 変換し，Listとして戻します．PitcherかBatterかは引数により指定します．PitcherとBatterの読み出しを同時にはしません．
	 *
	 * @param filename
	 *            PitcherまたはBatterのデータが入っているcsvファイル
	 * @param isPitcher
	 *            filenameのファイルがPitcherのcsvファイルならtrue,Batterのcsvファイルならfalseにします．
	 * @return PitcherまたはBatterのデータのArrayList
	 */
	private static List<Player> readPlayerData(String filename, boolean isPitcher) {

		List<Player> ret = new ArrayList<Player>();
		Path path = Paths.get(filename);
		try (BufferedReader reader = Files.newBufferedReader(path)) {
			String line;
			int i = 0;
			while ((line = reader.readLine()) != null) {
				String[] token = line.split(",");
				Player sp = null;

				if (isPitcher && i > 1) {
					sp = new Pitcher(token[0], token[1], token[2], token[3], token[4],
							token[5], token[6], token[7],
							token[8], token[9]);
					ret.add(sp);
				} else if (!isPitcher && i > 1) {
					sp = new Batter(token[0], token[1], token[2], token[3], token[4],
							token[5], token[6], token[7],
							token[8], token[9], token[10], token[11]);
					ret.add(sp);
				}

				i++;
			}
		} catch (IOException e) {
			System.out.println(e);
		}

		return ret;
	}

}
