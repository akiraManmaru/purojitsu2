package lesson12.exam4;

public class Waiting extends State {

	public Waiting(DeliveryRobot4 context) {
		this.context = context;
	}

	public void voiceCommand() {
		System.out.println("配送を開始しました[->Delivering]");
		context.setState(context.getDelivering());

	}

}
