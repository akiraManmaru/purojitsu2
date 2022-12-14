package lesson03b.testdrive;

import lesson03b.fgo.Servant;
import lesson03b.fgo.ServantAlter;


public class TestDrive05ServantAlter {

	public static void main(String[] args) {
		Servant servant;
		servant = new Servant("アルトリア", "Saver");
		servant.showInfo();
		servant.showState();

		servant = new ServantAlter("アルトリア", "Saver");
		servant.showInfo();
		servant.showState();


	}

}
