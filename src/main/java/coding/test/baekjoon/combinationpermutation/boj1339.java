package coding.test.baekjoon.combinationpermutation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class boj1339 {

	int n;
	String[] strings;

	String[] result;
	int index;
	int start;

	int[] intReuslt;
	int answer;
	int solution(String[] words) {
		n = words.length;
		strings = words;
		index = 0;
		start = 0;
		result = new String[n];

		combination();

		return answer;
	}

	private void calculate() {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < result[i].length(); j++) {
				char word = change(result[i].charAt(j)); 
				sb.append(word);
			}
			sum += Integer.parseInt(sb.toString());
			System.out.println(sum);
		}

		answer = sum;
	}

	private char change(char x){
		if(x == 'A') return '9';
		if(x == 'B') return '8';
		if(x == 'C') return '7';
		if(x == 'D') return '6';
		if(x == 'E') return '5';
		if(x == 'F') return '4';
		if(x == 'G') return '3';
		if(x == 'H') return '2';
		if(x == 'I') return '1';
		return '0';
	}

	private void combination() {
		if(index == n){
			calculate();
			return;
		}

		for (int i = start; i < n; i++) {
			result[index] = strings[i];
			start = i + 1;
			index++;
			combination();
			index--;
		}

	}

	private void print() {
		for (int i = 0; i < n; i++) {
			System.out.print(result[i] + " ");
		}
		System.out.println();
	}

	@Test
	void test(){
		Assertions.assertEquals(solution(new String[]{"AAA", "AAA"}), 1998);
		Assertions.assertEquals(solution(new String[]{"GCF", "ACDEB"}), 99437);
		Assertions.assertEquals(solution(new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"}), 45);
		Assertions.assertEquals(solution(new String[]{"AB", "BA"}), 187);
	}


}
