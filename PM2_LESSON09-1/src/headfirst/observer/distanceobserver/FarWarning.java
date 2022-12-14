package headfirst.observer.distanceobserver;

public class FarWarning extends CurrentDistDisplay {
	protected float distThreshold;

	public FarWarning(DistSensor distSensor, float dist) {
		super(distSensor);
		this.distThreshold = dist;
	}

	public void display() {
		System.out.println("遠すぎます。距離は" + distance + "です。");
	}

	public void update(float dist) {
		this.distance = dist;
		if (distance > distThreshold) {
			display();
		}

	}

}
