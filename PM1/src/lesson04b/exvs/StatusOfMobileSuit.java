package lesson04b.exvs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class StatusOfMobileSuit {
	private HashMap<String, ArrayList<String>> msMap;

	public StatusOfMobileSuit() {

		this.msMap = new HashMap<String, ArrayList<String>>();
		this.msMap.put("TEST", new ArrayList<String>(Arrays.asList("試作機", "テストパイロット")));
		this.msMap.put("RX-78-2", new ArrayList<String>(Arrays.asList("ガンダム", "アムロ・レイ")));
		this.msMap.put("RX-78NT-1", new ArrayList<String>(Arrays.asList("アレックス", "クリスチーナ・マッケンジー")));
		this.msMap.put("RX-78GP03S", new ArrayList<String>(Arrays.asList("ガンダム試作3号機", "コウ・ウラキ")));
		this.msMap.put("RX-178", new ArrayList<String>(Arrays.asList("ガンダムMK2", "エマ・シーン")));
		this.msMap.put("RX-93", new ArrayList<String>(Arrays.asList("ニューガンダム", "アムロ・レイ")));
	}

	public void showMsMap() {
		for (String str : msMap.keySet()) {
			System.out.println("型式番号：" + str + " 機体名・パイロット：" + msMap.get(str));
		}
	}

	public HashMap<String, ArrayList<String>> getMsMap() {
		return this.msMap;
	}

}