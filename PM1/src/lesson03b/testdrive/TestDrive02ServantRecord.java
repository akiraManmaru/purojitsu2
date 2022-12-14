package lesson03b.testdrive;

import java.util.ArrayList;
import java.util.Arrays;

import lesson03b.fgo.ServantRecord;

public class TestDrive02ServantRecord {
	public static void main(String[] args) {
		ServantRecord testServantRecord = new ServantRecord();
		testServantRecord.getServantMap().put("プロト", new ArrayList<String>( Arrays.asList("Saver") ) );

		//System.out.println(testServantRecord.getServantMap());

		String testName = "ServantRecordのshowKey()メソッド";
		System.out.println(testName + "の確認");
		testServantRecord.showKey();

		System.out.println();
		testName = "ServantRecordのshowServantRecord()メソッド";
		System.out.println(testName + "の確認");
		testServantRecord.showServantRecord();

	}
}





