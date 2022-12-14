package lesson12.exam4;

public class DeliveryRobot4 {

	/**
	 * 各状態への参照型変数の定義とgetter
	 */
	/**
	 * 現在の状態を保持
	 */
	private State state = null;
	/**
	 * 「待ち」状態を保持
	 */
	private State waiting = null;

	private State emergencyStop = null;

	private State delivering = null;

	private State primeDelivering = null;

	/**
	 * 「待ち」状態を返す
	 * @return
	 * 「待ち」状態
	 */
	public State getWaiting() {
		return waiting;
	}

	/**
	 * 現在の状態を返す
	 * @return
	 * 現在の状態
	 */
	public State getState() {
		return state;
	}

	public State getEmergencyStop() {
		return emergencyStop;
	}

	public State getDelivering() {
		return delivering;
	}

	public State getPrimeDelivering() {
		return primeDelivering;
	}

	/**
	 * コンストラクタ
	 * 初期状態は「待ち」にする
	 */
	public DeliveryRobot4() {
		waiting = new Waiting(this);
		emergencyStop = new EmergencyStop(this);
		delivering = new Delivering(this);
		primeDelivering = new PrimeDelivering(this);
		state = waiting;
	}

	/**
	 * 状態をセットする
	 * @param state
	 * 状態を指す参照型変数
	 */
	public void setState(State state) {
		this.state = state;
	}

	/**
	 * 音声コマンドを実行する
	 */
	public void voiceCommand() {
		state.voiceCommand();

	}

	public void resetCommand() {
		state.resetCommand();
	}

	public void detectCollapse() {

		state.detectCollapse();
	}

	public void detectEmergencyVehicle() {
		state.detectEmergencyVehicle();
	}

	public void detectPrime() {
		state.detectPrime();
	}

}
