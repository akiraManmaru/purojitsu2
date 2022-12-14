package headfirst.factory.curry_factory_fm;

/**
 * カレーチェーン店　　  　 
 */
public abstract class カレーチェーン店 {
 
	public abstract カレー createCurry(String item);
 
	public カレー orderCurry(String type) {
		カレー curry = createCurry(type);
		System.out.println("---" + curry.getName() + "を作る ---");
		curry.prepare();
		curry.rice();
		curry.roux();
		curry.topping();
		System.out.println("---" + curry.getName() + "が完成 ---");
		return curry;
	}
}
