package lesson12.exam2;/** * 各状態での振る舞いに関するインターフェースを定義する * @author Hitoshi Habe (habe@kindai.ac.jp) * @version 1.0.0 */public interface State {	/**	 * 各状態において共通に振る舞う（抽象）メソッドの定義	 */	/**	 * 音声コマンドを実行する	 */	public abstract void voiceCommand();	/**	 * リセットコマンドを実行する	 */	public abstract void resetCommand();	public abstract void detectCollapse();}