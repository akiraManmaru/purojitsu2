package lesson07b.core;

/**
 * 通信可能な端末を実現するクラス．ClientNode, ServerNodeのスーパークラス．
 * 具象クラスに対して送受信機能を提供する．
 * @author mizutani
 *
 */
public abstract class Node {
	/**
	 * NodeをTheInternet上にて一意に示す値（アドレス）
	 */
	private int address;
	/**
	 * TheInternetへの接続状態
	 */
	private boolean connectState = false;

	public Node(int address) {
		this.address = address;
	}

	public void connectToTheInternet() {
		TheInternet.connect(this);

	}

	public int getAddress() {
		return address;
	}

	public boolean getConnectState() {
		connectState = TheInternet.checkConnectedState(address);
		return connectState;
	}

	public void send(Message message) {
		TheInternet.pass(message);

	}

	/**
	 * TheInternetの接続状態を表示するメソッド．
	 */
	public abstract void showNetworkInfo();

	/**
	 * 受信処理を記述するメソッド．
	 * messageを受信し，messageのEvent毎に処理を記述．
	 * @param message 送受信対象のmessage
	 */
	public abstract void receive(Message message);

}
