package lesson05b.shiritori;

import java.util.List;

public interface Rule {
	public boolean checkCurrentWord(List<String> prevWord, String currWord);

}
