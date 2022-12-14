package lesson03b.fgo;

public class ServantSystem {
	private Servant servant;
	private ServantRecord servantRecord;

	public ServantSystem(String name, String summonedClass) {
		servantRecord = new ServantRecord();
		if (servantRecord.getServantMap().get(name).contains(summonedClass)) {
			servant = new Servant(name, summonedClass);

		} else {
			servant = null;
		}

	}

	public Servant summonServant() {
		return servant;
	}

}
