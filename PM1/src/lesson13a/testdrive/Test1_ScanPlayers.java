package lesson13a.testdrive;

import java.util.ArrayList;
import java.util.List;

import lesson13a.baseball.SimplePlayer;
import lesson13a.baseball.SimpleScanPlayers;

public class Test1_ScanPlayers {
	public static void main(String[] args) {
		List<SimplePlayer> players = new ArrayList<SimplePlayer>();
		players.addAll(SimpleScanPlayers.readPlayerData("players.csv"));
		for (SimplePlayer p: players) {
			p.printInfo();
		}
	}

}
