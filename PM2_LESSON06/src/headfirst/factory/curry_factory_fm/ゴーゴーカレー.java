package headfirst.factory.curry_factory_fm;

public class ゴーゴーカレー extends カレーチェーン店 {
	public カレー createCurry(String item) {
		カレー curry = null;

		if (item.equals("カツ")) {

			curry = new ゴーゴーカツカレー();
			curry.setName("ゴーゴーカツカレー");

		} else if (item.equals("野菜")) {

			curry = new ゴーゴー野菜カレー();
			curry.setName("ゴーゴー野菜カレー");

		}

		return curry;
	}

}
