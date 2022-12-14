package lesson03b.fgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ServantRecord {
	private HashMap<String, ArrayList<String>> servantMap;

	public ServantRecord() {

		this.servantMap = new HashMap<String, ArrayList<String>>();
		this.servantMap.put("アルトリア", new ArrayList<String>(Arrays.asList("Saver", "Lancer")));
		this.servantMap.put("クー・フーリン", new ArrayList<String>(Arrays.asList("Lancer", "Caster")));
		this.servantMap.put("ギルガメッシュ", new ArrayList<String>(Arrays.asList("Saver", "Lancer", "Archer", "Caster")));
	}

	public void showKey() {
		System.out.println("英霊を表示します．");
		System.out.println();
	}

	public void showServantRecord() {
		System.out.println("英霊の一覧と対応する役割を表示します．");

		for (String str : servantMap.keySet()) {
			System.out.println("真名：" + str + " クラス：" + servantMap.get(str));
		}
	}

	public HashMap<String, ArrayList<String>> getServantMap() {
		return this.servantMap;
	}

}
