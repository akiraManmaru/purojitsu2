package lesson12.exam2;

public class EmergencyStop implements State {

	private DeliveryRobot2 context;

	public EmergencyStop(DeliveryRobot2 context) {
		this.context = context;
	}

	public void detectCollapse() {
		System.out.println("（その操作は無効です）");
	}

	public void resetCommand() {
		System.out.println("リセットしました[->Waiting]");
		context.setState(context.getWaiting());

	}

	public void voiceCommand() {
		System.out.println("（その操作は無効です）");
	}

}
