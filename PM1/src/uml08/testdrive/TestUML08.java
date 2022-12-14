package uml08.testdrive;

import uml08.source.Designer;
import uml08.source.Programmer;
import uml08.source.Worker;

public class TestUML08 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Worker d = new Designer("Alice");
		d.printName();
		d.getIdentityCard().printType();
		d.work();

		Worker p = new Programmer("Bob");
		p.printName();
		p.getIdentityCard().printType();
		p.work();

	}

}
