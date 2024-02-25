package codingtest;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import java.util.*;


public class Lv2과제진행하기 {
	public String[] solution(String[][] plans) {
		String[] answer = {};
		return answer;
	}

	@Test
	public void test(){
		Assertions.assertArrayEquals(new String[][]{{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}},
			new String[]{"korean", "english", "math"});
		Assertions.assertArrayEquals(new String[][]{{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}},
			new String[]{"science", "history", "computer", "music"});
		Assertions.assertArrayEquals(new String[][]{{"aaa", "12:00", "20"}, {"bbb", "12:10", "30"}, {"ccc", "12:40", "10"}},
			new String[]{"bbb", "ccc", "aaa"});
	}
}
