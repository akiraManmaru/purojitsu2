package headfirst.strategy;

/**
 * 模型のカモ
 */
public class ModelDuck extends Duck {
	public ModelDuck() {
		//飛ばないが、ガーガー鳴く
		super(new FlyNoWay(), new Quack());

	}

	public void display() {
		System.out.println("模型の鴨です");
	}
}
