package lesson13a.baseball;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class SimpleDumpPlayers {
	public static void writePlayers(String filename, List<SimplePlayer> players) {
		Path path = Paths.get(filename);

		try (BufferedWriter writer = Files.newBufferedWriter(path)) {
			for (SimplePlayer sp : players) {
				writer.write(sp.toStringData() + "\n");
			}

		} catch (IOException e) {
			System.out.println(e);
		}

	}
}