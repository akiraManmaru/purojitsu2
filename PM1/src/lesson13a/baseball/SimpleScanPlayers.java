package lesson13a.baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SimpleScanPlayers {
	public static List<SimplePlayer> readPlayerData(String filename) {
		List<SimplePlayer> ret = new ArrayList<SimplePlayer>();
		Path path = Paths.get(filename);

		try (BufferedReader reader = Files.newBufferedReader(path)) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] token = line.split(",");
				SimplePlayer sp = new SimplePlayer(token[0], token[1], token[2]);
				ret.add(sp);
			}
		} catch (IOException e) {
			System.out.println(e);
		}

		return ret;
	}
}