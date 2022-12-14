package lesson07b.testdrive;

import lesson07b.core.ClientNode;
import lesson07b.core.ServerNode;

public class TestDrive03CheckEnter {
	public static void main(String[] args) {
		ClientNode c = new ClientNode(0);
		ClientNode c1 = new ClientNode(1);
		ServerNode s = new ServerNode(100);
		c.connectToTheInternet();
		c1.connectToTheInternet();
		s.connectToTheInternet();
		
		//TaroのClientNodeが入室
		c.enterServer(100, "Taro");
		
		//JiroのClientNodeが入室
		c1.enterServer(100, "Jiro");
		c.showTalks();
		c1.showTalks();
	}
}
