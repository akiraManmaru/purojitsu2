package lesson07b.core;

import java.util.ArrayList;
import java.util.List;
/**
 * Client, Server間でやり取りするメッセージを実装したクラス
 *
 * @author mizutani
 *
 */
public class Message {
	/**
	 * 自身のアドレス
	 */
	private int address;
	/**
	 * 宛先のアドレス
	 */
	private int destinationAddress;
	/**
	 * 処理を場合分けするイベント(なお,ジェネリクスの ? はEnumクラスであれば代入可能を意味する．)
	 */
	private Enum<?> event;
	/**
	 * 会話の履歴
	 */
	private List<TalkInfo> talkHistories;
	/**
	 * 会話の内容（名前と会話）を保存するTakInfoのインスタンス
	 */
	private TalkInfo talk;
	/**
	 * 入退室イベントの場合はname, その他はエラーメッセージ
	 */
	private String str;

	/**
	 * @param address 自身のアドレス
	 * @param destinationAddress 宛先のアドレス
	 * @param event 処理を場合分けするイベント(なお,ジェネリクスの?はEnumクラスであれば代入可能を意味する．)
	 * @param talkHistories Serverに蓄積されている全会話のリスト
	 */
	public Message(int address, int destinationAddress, Enum<?> event, List<TalkInfo> talkHistories) {
		this.address = address;
		this.destinationAddress = destinationAddress;
		this.event = event;
		this.talkHistories = talkHistories;
	}

	/**
	 * @param address 自身のアドレス
	 * @param destnationAddress 宛先のアドレス
	 * @param event 処理を場合分けするイベント(なお,ジェネリクスの?はEnumクラスであれば代入可能を意味する．)
	 */
	public Message(int address, int destnationAddress, Enum<?> event) {
		this.address = address;
		this.destinationAddress = destnationAddress;
		this.event = event;
	}

	/**
	 * @param address 自身のアドレス
	 * @param destinationAddress 宛先のアドレス
	 * @param event 処理を場合分けするイベント(なお,ジェネリクスの?はEnumクラスであれば代入可能を意味する．)
	 * @param str 入退室処理を行う場合はname, それ以外の場合はエラーメッセージに利用
	 */
	public Message(int address, int destinationAddress, Enum<?> event, String str) {
		this.address = address;
		this.destinationAddress = destinationAddress;
		this.event = event;
		this.str = str;
	}

	/**
	 * @param address 自身のアドレス
	 * @param destinationAddress 宛先のアドレス
	 * @param event 処理を場合分けするイベント(なお,ジェネリクスの?はEnumクラスであれば代入可能を意味する．)
	 * @param talk Clientの会話内容を保存するクラス(TalkInfo)のインスタンス
	 */
	public Message(int address, int destinationAddress, Enum<?> event, TalkInfo talk) {
		this.address = address;
		this.destinationAddress = destinationAddress;
		this.event = event;
		this.talk = talk;
	}

	/**
	 * addressを返すメソッド
	 * @return address
	 */
	public int getAddress() {
		return address;
	}

	/**
	 * destinationAddressを返すメソッド
	 * @return destinationAddress
	 */
	public int getDestination() {
		return destinationAddress;
	}

	/**
	 * eventを返すメソッド
	 * @return event
	 */
	public Enum<?> getEvent() {
		return event;
	}

	/**
	 * strを返すメソッド
	 * @return str
	 */
	public String getStr() {
		return str;
	}

	/**
	 * talkを返すメソッド
	 * @return talk
	 */
	public TalkInfo getTalk() {
		return talk;
	}

	/**
	 *talkHistoriesを返すメソッド
	 * @return talkHistories
	 */
	public ArrayList<TalkInfo> getTalkHistories() {
		return new ArrayList<>(talkHistories);
	}

}
