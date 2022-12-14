package lesson03b.testdrive;

import java.util.ArrayList;
import java.util.Arrays;

import lesson03b.fgo.Servant;


public class TestDrive01Servant {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		ArrayList<String> listOfServantName = new ArrayList<String>( Arrays.asList("アルトリア", "クー・フーリン", "ギルガメッシュ" ) );
		ArrayList<String> listOfServantClass = new ArrayList<String>( Arrays.asList("Saver", "Lancer", "Archer", "Caster") );

		Servant servant;
		for(String servantName : listOfServantName){
			for(String servantClass : listOfServantClass){
				servant = new Servant(servantName, servantClass);
				servant.showInfo();
				servant.showState();
			}
		}

	}

}
