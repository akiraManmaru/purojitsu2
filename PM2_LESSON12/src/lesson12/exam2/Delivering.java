package lesson12.exam2;

public class Delivering implements State {

	private DeliveryRobot2 context;

	public Delivering(DeliveryRobot2 context) {
		this.context = context;
	}

	public void detectCollapse() {
		System.out.println("荷崩れが起きたので緊急停止します[->EmergencyStop]");
		context.setState(context.getEmergencyStop());
	}

	public void resetCommand() {
		System.out.println("（その操作は無効です）");

	}

	public void voiceCommand() {

		context.setState(context.getWaiting());
		System.out.println("配送を終了しました[->Waiting]");

	}

}
