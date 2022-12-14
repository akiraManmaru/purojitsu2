package lesson07b.core;

import java.util.HashMap;
import java.util.Map;

/**
 * 通信可能な端末間の通信を実現するクラス．
 * Staticで宣言したフィールド変数，メソッドを持っており各Nodeのアドレスを一元的に管理している．
 * @author mizutani
 *
 */

public class TheInternet {
	private static Map<Integer, Node> globalAddresses = new HashMap<Integer, Node>();

	//コンストラクタは完成済のため変更しないこと
	private TheInternet() {
	};

	public static void connect(Node node) {
		if (!globalAddresses.containsKey(node.getAddress())) {
			globalAddresses.put(node.getAddress(), node);
		}
	}

	public static boolean checkConnectedState(int address) {
		//System.out.println(globalAddresses.get(address));
		boolean flag = false;
		if (globalAddresses.containsKey(address)) {
			flag = true;
		}
		return flag;

	}

	public static void pass(Message message) {
		if (globalAddresses.containsKey(message.getDestination())) {
			globalAddresses.get(message.getDestination()).receive(message);
		}
	}

}
