package headfirst.factory.curry_factory_fm;

import java.util.*;

import headfirst.factory.curry.ingredient.*;

/**
 * カレー　　  　 
 */
public abstract class カレー {
	String name;

	サイズ size;
	ルー roux;
	List<野菜> veggies;
	List<カツ> cutlet;
	List<シーフード> seafood;
	卵 egg;

	public abstract void prepare();

	public void rice() {
		System.out.println("ご飯を皿に盛る");
	}

	public void roux() {
		System.out.println("ルーをかける");
	}

	public void topping() {
		System.out.println("トッピングをのせる");
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	/**
	 * そのカレーのレシピ
	 * @return レシピを表す文字列
	 */
	public String recipe() {
		StringBuffer result = new StringBuffer();
		result.append("\n---- " + name + " ----\n");
		if (roux != null) {
			result.append(roux.getName());
			result.append("\n");
		}
		if (size != null) {
			result.append(size.getName());
			result.append("\n");
		}
		if (veggies != null) {
			for (int i = 0; i < veggies.size(); i++) {
				result.append(veggies.get(i).getName());
				if (i < veggies.size()-1) {
					result.append(", ");
				}
			}
			result.append("\n");
		}
		if (cutlet != null) {
			for (int i = 0; i < cutlet.size(); i++) {
				result.append(cutlet.get(i).getName());
				if (i < cutlet.size()-1) {
					result.append(", ");
				}
			}
			result.append("\n");
		}
		if (seafood != null) {
			for (int i = 0; i < seafood.size(); i++) {
				result.append(seafood.get(i).getName());
				if (i < seafood.size()-1) {
					result.append(", ");
				}
			}
			result.append("\n");
		}
		if (egg != null) {
			result.append(egg.getName());
			result.append("\n");
		}
		result.append("------------------------------\n");
		return result.toString();
	}
}
