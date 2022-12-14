package lesson13a.testdrive;

import java.util.ArrayList;

import lesson13a.baseball.SimpleDumpPlayers;
import lesson13a.baseball.SimplePlayer;
import lesson13a.baseball.SimpleScanPlayers;

public class Test3_ScanAndDumpPlayers {
	public static void main(String[] args) {
		ArrayList<SimplePlayer> players = new ArrayList<SimplePlayer>();
		players.addAll(SimpleScanPlayers.readPlayerData("players.csv"));
		players.addAll(SimpleScanPlayers.readPlayerData("dumpplayers.csv"));
		for (int i=11; i>0; i-=2){
			players.remove(i);
		}
		//for (SimplePlayer p: players) {
		//	p.printInfo();
		//}
		SimpleDumpPlayers.writePlayers("dumpplayers2.csv", players);
	}

}
