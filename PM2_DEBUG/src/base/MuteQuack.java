package base;
/**
 * 鳴かない
 */
public class MuteQuack implements QuackBehavior {
	public void quack() {
		System.out.println("<<沈黙>>");
	}
}
