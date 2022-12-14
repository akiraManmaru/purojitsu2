package lesson11.exam2;

import java.util.List;

public class SendMessageFunctionCannot implements SendMessageFunction {

	@Override
	public void sendMessage(String message, ClassMember sender, List<ClassMember> members) {
		sender.receiveMessage("[ 送信元: " + "システム" + ", メッセージ: " + "あなたはお知らせを送信できません" + " ]");
	}

}
