package lesson12.exam4;

public class PrimeDelivering extends State {

	public PrimeDelivering(DeliveryRobot4 context) {
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

}
