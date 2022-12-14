package lesson03b.testdrive;

import java.util.ArrayList;
import java.util.Arrays;

import lesson03b.fgo.Servant;
import lesson03b.fgo.ServantSystem;

public class TestDrive03ServantSystem {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		ArrayList<String> listOfServantName = new ArrayList<String>( Arrays.asList("アルトリア", "クー・フーリン", "ギルガメッシュ" ) );
		ArrayList<String> listOfServantClass = new ArrayList<String>( Arrays.asList("Saver", "Lancer", "Archer", "Caster") );
		ArrayList<Servant> listOfServants = new ArrayList<Servant>();

		ServantSystem servantSystem;
		for(String servantName : listOfServantName){
			for(String servantClass : listOfServantClass){
				servantSystem = new ServantSystem(servantName, servantClass);
				if(servantSystem.summonServant() != null){
					listOfServants.add(servantSystem.summonServant());
				}
				else{
					System.out.println("Attention!!!  " + servantName + "は役割" + servantClass + "で召喚できません．");
				}
			}
		}

		for(Servant srvnt : listOfServants){
			srvnt.showState();
		}
	}

}
