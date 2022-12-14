package headfirst.factory.factory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import headfirst.factory.curry.ingredient.たっぷりアサリ;
import headfirst.factory.curry.ingredient.イカ;
import headfirst.factory.curry.ingredient.カツ;
import headfirst.factory.curry.ingredient.キノコ;
import headfirst.factory.curry.ingredient.サイズ;
import headfirst.factory.curry.ingredient.シーフード;
import headfirst.factory.curry.ingredient.スペシャル;
import headfirst.factory.curry.ingredient.トマトアスパラ;
import headfirst.factory.curry.ingredient.メンチカツ;
import headfirst.factory.curry.ingredient.ルー;
import headfirst.factory.curry.ingredient.卵;
import headfirst.factory.curry.ingredient.大盛り;
import headfirst.factory.curry.ingredient.完熟カットトマト;
import headfirst.factory.curry.ingredient.甘口;
import headfirst.factory.curry.ingredient.生卵;
import headfirst.factory.curry.ingredient.野菜;

public class ゴーゴーカレー厨房 extends カレー店厨房 {
	public サイズ setSize() {
		return new 大盛り();
	}

	public ルー setRoux() {
		return new 甘口();
	}

	public List<カツ> setCutlet() {
		return new ArrayList<カツ>(Arrays.asList(new メンチカツ()));
	}

	public List<野菜> setVeggies() {
		return new ArrayList<野菜>(Arrays.asList(new 完熟カットトマト(), new トマトアスパラ()));
	}

	public List<シーフード> setSeafood() {
		return new ArrayList<シーフード>(Arrays.asList(new たっぷりアサリ(), new イカ()));
	}

	public スペシャル setSpecial() {
		return new キノコ();
	}

	public 卵 setEgg() {
		return new 生卵();
	}

}
