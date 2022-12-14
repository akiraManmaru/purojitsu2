package lesson13a.testdrive;

import java.util.ArrayList;
import java.util.List;

import lesson13a.baseball.SimpleDumpPlayers;
import lesson13a.baseball.SimplePlayer;

public class Test2_DumpPlayers {
	public static void main(String[] args) {
		List<SimplePlayer> players = new ArrayList<SimplePlayer>();
		players.add(new SimplePlayer("名前1","a","0"));
		players.add(new SimplePlayer("名前2","b","1"));
		players.add(new SimplePlayer("名前3","c","2"));
		players.add(new SimplePlayer("名前4","d","1"));
		SimpleDumpPlayers.writePlayers("dumpplayers.csv", players);
	}

}
