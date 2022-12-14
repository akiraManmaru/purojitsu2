package baseball.io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;

import baseball.player.Player;

/**
 * Playerの成績をcsvファイルに出力するためのクラス
 *
 */
public class DumpPlayers {

	/**
	 * 時刻の入ったファイル名にPlayerの成績を出力します．
	 * 
	 * @param players
	 *            ファイルに成績を出力するPlayerのリスト
	 */
	public static void dumpPlayers(List<Player> players) {
		String outputFileName = new String();
		GregorianCalendar cal = new GregorianCalendar();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddkkmmss");
		outputFileName = "output" + sdf.format(cal.getTime()) + ".csv";

		dumpPlayers(outputFileName, players);
	}

	/**
	 * ファイル名を指定してPlayerの成績を出力します．
	 * 
	 * @param filename
	 *            ファイル名
	 * @param players
	 *            ファイルに成績を出力するPlayerのリスト
	 */
	public static void dumpPlayers(String filename, List<Player> players) {

		Path path = Paths.get(filename);

		try (BufferedWriter writer = Files.newBufferedWriter(path)) {
			for (Player sp : players) {
				writer.write(sp.toStringData() + "\n");
			}

		} catch (IOException e) {
			System.out.println(e);
		}

	}
}