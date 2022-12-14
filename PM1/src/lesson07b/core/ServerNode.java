package lesson07b.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
*
* 通信可能な端末(Node.java)を継承した，チャットシステムにおけるサーバの挙動を実現するクラス．
* @author mizutani
*
*/
public class ServerNode extends Node {
	/**
	 * 全Clientの発言内容を保存するList．
	 */
	private List<TalkInfo> talkHistories = new ArrayList<TalkInfo>();
	/**
	 * Clientのアドレスと名前を保存するHashMap．
	 */
	private Map<String, Integer> participants = new HashMap<String, Integer>();

	public ServerNode(int address) {
		super(address);
	}

	public void broadcast(TalkInfo talk) {
		talkHistories.add(talk);
		for (String name : participants.keySet()) {
			send(new Message(this.getAddress(), participants.get(name), ClientEvent.RECEIVE_TALK, talk));
		}

	}

	public void enter(int clientAddress, String name) {
		if (participants.containsKey(name) && !participants.containsValue(clientAddress)) {
			participants.put(name, clientAddress);
			send(new Message(this.getAddress(), clientAddress, ClientEvent.SUCCESS_ENTER, talkHistories));
			broadcast(new TalkInfo(name, "入室しました. "));

		} else {
			TalkInfo ti = new TalkInfo("サーバ", "(アドレス: " + clientAddress + ", 名前: " + name + "）はアドレスまたは名前が既に利用されています.");
			send(new Message(this.getAddress(), clientAddress, ClientEvent.RECEIVE_TALK, ti));
		}
	}

	public void exit(int clientAdress, String name) {

	}

	/**
	 * Clientから送られてきたメッセージ内のメッセージタイプ毎に対応するメソッドへ処理を依頼するメソッド．
	 * @param message ClientNodeから送られてきたメッセージ
	 *
	 */
	@Override
	public void receive(Message message) {
		//本メソッドは完成済のため変更しないこと
		ServerEvent type = (ServerEvent) message.getEvent();
		type.handle(message, this);
	}

	/**
	 * ServerのgetAddressメソッドおよびgetConnectStateメソッドの返り値を表示するメソッド．
	 */
	public void showNetworkInfo() {
		//本メソッドは完成済のため変更しないこと
		System.out.println("サーバ: (" + super.getAddress() + ")の接続状態: " + super.getConnectState());
	}

	/**
	 * Messageの送信元のクライアントのアドレスを表示するメソッド（内容を変更しないこと）
	 *  @param clientAddress Clientのアドレス
	 */
	public void showClientInfo(int clientAddress) {
		//本メソッドは完成済のため変更しないこと
		System.out.println("アドレス: " + clientAddress + "のクライアントからメッセージを受信");
	}

}