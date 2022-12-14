package lesson07b.testdrive;

import lesson07b.core.ClientNode;
import lesson07b.core.ServerNode;

public class TestDrive02CheckEcho {
	public static void main(String[] args) {
		ClientNode c = new ClientNode(0);
		ClientNode c1 = new ClientNode(1);
		ServerNode s = new ServerNode(100);
		c.connectToTheInternet();
		c1.connectToTheInternet();
		s.connectToTheInternet();
		c.executeEcho(100);
		c1.executeEcho(100);

	}

}
