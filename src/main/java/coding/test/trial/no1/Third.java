package coding.test.trial.no1;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
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

	List<String> answerList = new ArrayList<>();

	void combination(int r){
		if(index == r){
			Arrays.sort(result);
			for (char c: result) sb.append(c);

			if(map.get(sb.toString()) == null) map.put(sb.toString(), 1);
			else map.put(sb.toString(), map.get(sb.toString()) + 1);

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
		map = new HashMap<>();
		for (String order: orders) {
			array = order.toCharArray();
			for (int r : course) {
				result = new char[r];
				start = 0;
				index = 0;
				combination(r);
			}

			// 3. 가장 많은 조합 answer에 저장
			if (!map.isEmpty()) {
				List<Integer> countList = new ArrayList<>(map.values());
				int max = Collections.max(countList);

				if (max > 1)
					for (String key : map.keySet())
						if (map.get(key) == max)
							answerList.add(key);
				map.clear();
			}
		}

		Collections.sort(answerList);
		String[] answer = new String[answerList.size()];
		for (int i = 0; i < answer.length; i++)
			answer[i] = answerList.get(i);

		return answer;
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
