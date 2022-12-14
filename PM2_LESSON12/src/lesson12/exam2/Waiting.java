package lesson12.exam2;

public class Waiting implements State {

	private DeliveryRobot2 context;

	public Waiting(DeliveryRobot2 context) {
		this.context = context;
	}

	public void detectCollapse() {
		System.out.println("（その操作は無効です）");

	}

	public void resetCommand() {
		System.out.println("（その操作は無効です）");

	}

	public void voiceCommand() {
		System.out.println("配送を開始しました[->Delivering]");
		context.setState(context.getDelivering());

	}

}
