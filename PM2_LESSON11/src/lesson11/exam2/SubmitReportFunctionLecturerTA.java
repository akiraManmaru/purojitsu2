package lesson11.exam2;

import java.util.List;

/**  　 　
 * 「レポート」を講師とTAにのみ送信する．．
 * @author ProjII
 * @version 1.0
 */
public class SubmitReportFunctionLecturerTA implements SubmitReportFunction {
	public void submitReport(String message, ClassMember sender, List<ClassMember> members) {
		for( ClassMember person: members ){
			if( person instanceof Lecturer || person instanceof TA ){		
				person.receiveMessage("[ 送信元: "+sender.getName()+", メッセージ: " +message+" ]");
			}
		}	
		sender.receiveMessage("[ 送信元: "+"システム"+", メッセージ: " +"あなたのレポートは正しく送信できました"+" ]");
	}
}
