package lesson11b.testdrive;

import lesson11b.data.DataServer;
import lesson11b.search.SearchAlgorithm;

public class ExecSearch {

	public static void execThreeSearches(DataServer dataServer, int x) {	

		System.out.printf("x=%d\n",x);
		
		// 逐次探索
		execSearch(dataServer, x, SearchAlgorithm.SEQ_SEARCH);
		// 番兵法
		execSearch(dataServer, x, SearchAlgorithm.SENT_SEQ_SEARCH);
		// ２分探索
		execSearch(dataServer, x, SearchAlgorithm.BINARY_SEARCH);		
	}
	
	private static void execSearch(DataServer dataServer, int x,
			SearchAlgorithm searchAlgorithm) {

		long startTime, endTime, estimatedTime;

		startTime = System.nanoTime(); // 開始時刻
		int result = dataServer.search(x, searchAlgorithm);
		endTime = System.nanoTime(); // 終了時刻
		estimatedTime = endTime - startTime;
		System.out.printf("%s\tの戻り値は%d，実行時間は%5dマイクロ秒です。\n", searchAlgorithm, result,
				estimatedTime / 1000);

	}
}
