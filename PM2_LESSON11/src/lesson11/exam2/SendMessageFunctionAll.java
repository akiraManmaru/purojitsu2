package lesson11.exam2;

import java.util.List;

public class SendMessageFunctionAll implements SendMessageFunction {

	@Override
	public void sendMessage(String message, ClassMember sender,
			List<ClassMember> members) {
		for (ClassMember cm : members) {
			cm.receiveMessage("[ 送信元: " + sender.getName() + ", メッセージ: " + message + " ]");
		}

	}

}
