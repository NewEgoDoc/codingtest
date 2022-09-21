package coding.test.trial.no1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Third {

	private char[] array;
	private int start;
	private int index;
	private char[] result;
	StringBuilder sb = new StringBuilder();
	Map<String, Integer> map;

	void combination(int r){
		if(index == r){
			Arrays.sort(result);
			for (char c: result) sb.append(c);

			map.merge(sb.toString(), 1, Integer::sum);

			sb.delete(0,r);
			return;
		}

		for (int i = start; i < array.length; i++) {
			result[index] = array[i];
			start = i + 1;
			index++;
			combination(r);
			index--;
		}
	}

	public String[] solution(String[] orders, int[] course){
		Set<String> answerList = new TreeSet<>();

		for (int r: course) {//2, 3, 4
			map = new HashMap<>();

			for (String order: orders) {//"XYZ", "XWY", "WXA"
				char[] charArr = order.toCharArray();
				Arrays.sort(charArr);//정렬 => 'X' 'Y' 'Z', 'W' 'X' 'Y', 'A' 'W' 'X'
				array = charArr;
				index = 0;
				start = 0;
				result = new char[r];
				combination(r);//조합 찾기
			}

			/* 최대값 찾기 */
			int max = 1;
			for(String key: map.keySet()){
				if(map.get(key) > max) max = map.get(key);
			}

			/* 가장 큰 값의 String 으로 set 구성 */
			for(String key: map.keySet()){
				if(map.get(key) == max && map.get(key) > 1) answerList.add(key);
			}
		}
		return answerList.toArray(new String[0]);//array로 변환 then return
	}


	@Test
	void test(){
		Assertions.assertArrayEquals(
			solution(new String[]{"ABCFG","AC","CDE","ACDE","BCFG","ACDEH"},new int[]{2,3,4}),
			new String[]{"AC","ACDE","BCFG","CDE"}
		);

		Assertions.assertArrayEquals(
			solution(new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"},new int[]{2,3,5}),
			new String[]{"ACD", "AD", "ADE", "CD", "XYZ"}
		);

		Assertions.assertArrayEquals(
			solution(new String[]{"XYZ", "XWY", "WXA"},new int[]{2,3,4}),
			new String[]{"WX", "XY"}
		);
	}
}
