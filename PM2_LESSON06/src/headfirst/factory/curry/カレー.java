package headfirst.factory.curry;

import java.util.*;

import headfirst.factory.curry.ingredient.*;
import headfirst.factory.factory.カレー店厨房;

/**
 * カレー　  　 
 */
public abstract class カレー {
	protected カレー店厨房 ingredientFactory;
	protected String name;

	protected サイズ size;//サイズ
	protected ルー roux;//ルーの辛さ
	protected List<野菜> veggies;//野菜のトッピング（複数可）
	protected List<カツ> cutlet;//カツのトッピング（複数可）
	protected List<シーフード> seafood;//シーフードのトッピング（複数可）
	protected 卵 egg;//卵のトッピング
	protected スペシャル special;//スペシャルカレーのトッピング

	/**
	 * カレーの準備手順
	 */
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
		if (roux != null) {//ルーの辛さ
			result.append(roux.getName());
			result.append("\n");
		}
		if (size != null) {//大きさ
			result.append(size.getName());
			result.append("\n");
		}
		if (veggies != null) {//野菜のトッピング
			for (int i = 0; i < veggies.size(); i++) {
				result.append(veggies.get(i).getName());
				if (i < veggies.size()-1) {
					result.append(", ");
				}
			}
			result.append("\n");
		}
		if (cutlet != null) {//カツのトッピング
			for (int i = 0; i < cutlet.size(); i++) {
				result.append(cutlet.get(i).getName());
				if (i < cutlet.size()-1) {
					result.append(", ");
				}
			}
			result.append("\n");
		}
		if (seafood != null) {//シーフードのトッピング
			for (int i = 0; i < seafood.size(); i++) {
				result.append(seafood.get(i).getName());
				if (i < seafood.size()-1) {
					result.append(", ");
				}
			}
			result.append("\n");
		}
		if (special != null) {//スペシャルカレーのトッピング
			result.append(special.getName());
			result.append("\n");
		}
		if (egg != null) {//卵のトッピング
			result.append(egg.getName());
			result.append("\n");
		}
		result.append("------------------------------\n");
		return result.toString();
	}
}
