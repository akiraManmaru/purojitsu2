package lesson12.exam4;

public class Delivering extends State {

	public Delivering(DeliveryRobot4 context) {
		this.context = context;
	}

	public void detectCollapse() {
		System.out.println("荷崩れが起きたので自動積み直しを行い配送を続けます");
	}

	public void voiceCommand() {

		context.setState(context.getWaiting());
		System.out.println("配送を終了しました[->Waiting]");

	}

	public void detectEmergencyVehicle() {
		context.setState(context.getEmergencyStop());
		System.out.println("緊急車両を検知したので緊急停止します[->EmergencyStop]");

	}

	public void detectPrime() {
		context.setState(context.getPrimeDelivering());
		System.out.println("迅速配送の要請が発生したので迅速に配送します[->PrimeDelivering]");

	}

}
