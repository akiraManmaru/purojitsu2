package lesson12.exam5.selfdrivingtruck;

public class FastMoving implements State {

	private SelfDrivingTruck context;

	public FastMoving(SelfDrivingTruck context) {
		this.context = context;
	}

	public void updateDistance(float dist) {
		if (dist < 35) {

		}
	}

}
