package lesson07b.testdrive;

import lesson07b.core.ClientNode;
import lesson07b.core.ServerNode;

public class TestDrive05CheckExit {
	public static void main(String[] args) {
		ClientNode c1 = new ClientNode(0);
		ClientNode c2 = new ClientNode(1);
		ServerNode s = new ServerNode(100);
		c1.connectToTheInternet();
		c2.connectToTheInternet();
		s.connectToTheInternet();
		c1.enterServer(100, "Taro");
		c2.enterServer(100, "Jiro");
		c1.showTalks();
		c2.showTalks();
		
		//退室
		c1.exitFromServer();
		c2.showTalks();
		
		//退室後に画面を表示
		c1.showTalks();

	}
}
