package headfirst.observer.distanceobserver;

public class NearWarning extends CurrentDistDisplay {
	protected float distThreshold;

	public NearWarning(DistSensor distSensor, float dist) {
		super(distSensor);
		this.distThreshold = dist;
	}

	public void display() {
		System.out.println("近すぎます。距離は" + distance + "です。");
	}

	public void update(float dist) {
		this.distance = dist;
		if (distance < distThreshold) {
			display();
		}

	}

}
