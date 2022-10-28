package coding.test.baekjoon.combinationpermutation;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class boj1339 {

	int solution(String[] words) {
		int [] alpha = new int[26];
		int n = words.length;

		//ex) AAA
		for(int i = 0; i < n; i++){
			int temp = (int)Math.pow(10,words[i].length()-1); //자릿수

			for(int j = 0; j < words[i].length(); j++){
				alpha[(int)words[i].charAt(j) - 65] += temp;
				temp /=10;
			}
		}

		Arrays.sort(alpha);
		int index = 9;
		int sum =0;
		for(int i=alpha.length-1; i>=0; i--) {
			if (alpha[i] == 0) {
				break;
			}
			sum += alpha[i] * index;
			index--;
		}
		return sum;
	}

	@Test
	void test(){
		Assertions.assertEquals(solution(new String[]{"AAA", "AAA"}), 1998);
		Assertions.assertEquals(solution(new String[]{"GCF", "ACDEB"}), 99437);
		Assertions.assertEquals(solution(new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"}), 45);
		Assertions.assertEquals(solution(new String[]{"AB", "BA"}), 187);
	}


}
