package coding.test.trial.no1;

import java.util.Locale;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Second {
	boolean solution(String s){
		String string = s.toLowerCase(Locale.ROOT);

		char[] charArr = string.toCharArray();

		int pCount = 0;
		int yCount = 0;

		for (char c: charArr) {
			if(c == 'p') pCount++;
			if(c == 'y') yCount++;
		}

		return  pCount == yCount;
	}

	@Test
	void test(){
		Assertions.assertEquals(solution("pPoooyY"),true);
		Assertions.assertEquals(solution("Pyy"),false);
	}
}
