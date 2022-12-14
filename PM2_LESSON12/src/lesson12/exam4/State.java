package lesson12.exam4;/** * 各状態での振る舞いに関するインターフェースを定義する * @author Hitoshi Habe (habe@kindai.ac.jp) * @version 1.0.0 */public abstract class State {	protected DeliveryRobot4 context;	/**	 * 各状態において共通に振る舞う（抽象）メソッドの定義	 */	/**	 * 音声コマンドを実行する	 */	public void voiceCommand() {		System.out.println("（その操作は無効です）");	}	/**	 * リセットコマンドを実行する	 */	public void resetCommand() {		System.out.println("（その操作は無効です）");	}	public void detectCollapse() {		System.out.println("（その操作は無効です）");	}	public void detectEmergencyVehicle() {		System.out.println("（その操作は無効です）");	}	public void detectPrime() {		System.out.println("（その操作は無効です）");	}}