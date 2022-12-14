package headfirst.factory.curry_factory_fm;

/**
 * CoCo壱番屋 　　  　 
 */
public class CoCo壱番屋 extends カレーチェーン店 {

	public カレー createCurry(String item) {
		カレー curry = null;

		if (item.equals("カツ")) {

			curry = new CoCo壱番屋カツカレー();
			curry.setName("CoCo壱番屋カツカレー");

		}
		else if (item.equals("野菜")) {

			curry = new CoCo壱番屋野菜カレー();
			curry.setName("CoCo壱番屋野菜カレー");

		}

		return curry;
	}
}
