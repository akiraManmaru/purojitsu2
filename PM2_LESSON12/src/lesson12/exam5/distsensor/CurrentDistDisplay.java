package lesson12.exam5.distsensor;

/**
 * 現在の距離を表示する
 */
public class CurrentDistDisplay implements Observer, DisplayElement {
	/**
	 * 観察対象
	 */
	DistSensor distSensor;

	/**
	 * 距離
	 */
	protected float distance;

	/**
	 * コンストラクタ
	 *
	 * @param distSensor
	 *            観察対象
	 */
	public CurrentDistDisplay(DistSensor distSensor) {
		this.distSensor = distSensor;
		distSensor.registerObserver(this);
	}

	/**
	 * 距離を更新して、現在の距離を表示する
	 *
	 * @param dist 距離
	 */
	public void update(float dist) {
		distance=dist;
		display();
	}

	/**
	 * 現在の距離を表示する
	 */
	public void display() {
		System.out.println("現在の距離は" + distance + "です。");
	}
}
