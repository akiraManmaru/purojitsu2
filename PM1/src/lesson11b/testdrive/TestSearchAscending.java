package lesson11b.testdrive;

import lesson11b.data.DataServer;
import lesson11b.data.Order;

public class TestSearchAscending {

	public static void main(String[] args) {

		final int NUM = 100000;
		DataServer dataServer = new DataServer(NUM, Order.ASCENDING);
		System.out.printf("n=%d\n",NUM);

		int x = 100000;
		ExecSearch.execThreeSearches(dataServer, x);

		x = 10;
		ExecSearch.execThreeSearches(dataServer, x);

		x = 999999;
		ExecSearch.execThreeSearches(dataServer, x);

	}

}
