package lesson07b.testdrive;

import lesson07b.core.ClientNode;
import lesson07b.core.ServerNode;

public class TestDrive04CheckDoubleEnter {
	public static void main(String[] args) {
		ServerNode s = new ServerNode(100);
		s.connectToTheInternet();

		ClientNode c1 = new ClientNode(0);
		c1.connectToTheInternet();
		c1.enterServer(100, "Taro");
		c1.showTalks();

		//同一のアドレス、同一の名前で参加
		c1.enterServer(100, "Taro");
		c1.showTalks();

		//同一のアドレス、異なる名前で参加
		c1.enterServer(100, "Taro1");
		c1.showTalks();

		//異なるアドレス、同一の名前で参加
		ClientNode c2 = new ClientNode(10);
		c2.connectToTheInternet();
		c2.enterServer(100, "Taro");
		c2.showTalks();

	}
}
