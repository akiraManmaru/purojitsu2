package lesson12.exam4;

public class EmergencyStop extends State {

	public EmergencyStop(DeliveryRobot4 context) {
		super.context = context;
	}

	public void resetCommand() {
		System.out.println("リセットしました[->Waiting]");
		context.setState(context.getWaiting());

	}

}
