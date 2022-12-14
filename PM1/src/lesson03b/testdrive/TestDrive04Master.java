package lesson03b.testdrive;

import lesson03b.fgo.Master;

public class TestDrive04Master {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		Master master = new Master("士郎");
		master.showName();
		master.showServant();
		System.out.println("サーヴァントを召喚します．");
		master.summonServant("アルトリア", "Saver");
		master.summonServant("アルトリア", "Lancer");
		master.summonServant("クー・フーリン", "Saver");
		master.summonServant("ギルガメッシュ", "Caster");
		master.showServant();



	}

}
