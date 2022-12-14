package lesson11.exam2;

import java.util.List;

public interface SendMessageFunction {
	public void sendMessage(String message, ClassMember sender, List<ClassMember> members);
}
