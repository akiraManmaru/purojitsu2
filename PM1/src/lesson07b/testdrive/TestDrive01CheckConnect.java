package lesson07b.testdrive;

import lesson07b.core.ClientNode;
import lesson07b.core.ServerNode;

public class TestDrive01CheckConnect {

	public static void main(String[] args) {
		ClientNode c = new ClientNode(0);
		ServerNode s = new ServerNode(100);
		c.connectToTheInternet();
		s.connectToTheInternet();
		c.showNetworkInfo();
		s.showNetworkInfo();
	}

}
