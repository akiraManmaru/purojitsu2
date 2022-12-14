package lesson07b.core;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 通信可能な端末(Node.java)を継承した，チャットシステムにおけるクライアントの挙動を実現するクラス．
 * @author mizutani
 *
 */

public class ClientNode extends Node {
	/**
	 * 全クライアントの発言内容を保存するList
	 */
	private List<TalkInfo> talkHistories = new ArrayList<TalkInfo>();
	/**
	 * Serverのアドレス
	 */
	private int serverAddress = -1;
	/**
	 * 会話に用いる名前
	 *
	 */
	private String name = null;

	public ClientNode(int address) {
		super(address);
	}

	public void enterServer(int serverAddress, String name) {
		this.serverAddress = serverAddress;
		this.name = name;
		send(new Message(this.getAddress(), serverAddress, ServerEvent.ENTER, name));

	}

	public void executeEcho(int serverAddress) {

		send(new Message(super.getAddress(), serverAddress, ServerEvent.ECHO));

	}

	public void exitFromServer(int serverAdress) {

	}

	/**
	 * Serverから送られてきたメッセージ内のメッセージタイプ毎に対応するメソッドへ処理を依頼するメソッド．
	 * @param message ClientNodeから送られてきたメッセージ．
	 *
	 */
	@Override
	public void receive(Message message) {
		//本メソッドは完成済のため変更しないこと
		ClientEvent event = (ClientEvent) message.getEvent();
		event.handle(message, this);
	}

	public void receiveTalk(TalkInfo talk) {

	}

	public void reciveTalkHistories(ArrayList<TalkInfo> talkHistories) {
		this.talkHistories = talkHistories;

	}

	public void resetTalkHistories() {

	}

	/**
	 *
	 * TheInternetへの接続状態を表示するメソッド．
	 */
	@Override
	public void showNetworkInfo() {
		//本メソッドは完成済のため変更しないこと
		System.out.println("クライアント: (" + super.getAddress() + ")の接続状態: " + super.getConnectState());
	}

	/**
	 *
	 * talkHistoriesの内容を表示するするメソッド．
	 */
	public void showTalks() {
		//本メソッドは完成済のため変更しないこと
		System.out.println("-----クライアント: (" + name + ")の画面----");
		for (TalkInfo talk : talkHistories) {
			talk.showInfo();
		}
	}

	public void talk(String talk) {

	}

}
