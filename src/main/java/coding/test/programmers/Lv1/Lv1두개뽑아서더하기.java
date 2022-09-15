package coding.test.programmers.Lv1;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;

public class Lv1두개뽑아서더하기 {

	private int[] array;
	private int[] result;
	private int n;
	private int index;
	private int start;

	private Set<Integer> resultSet;

	public int[] solution(int[] numbers){
		array = numbers;
		index = 0;
		start = 0;

		n = numbers.length;
		result = new int[n];

		resultSet = new TreeSet<>();
		combination();

		return resultSet.stream()
			.mapToInt(Integer::intValue)
			.toArray();
	}

	private void combination() {
		if(index == 2){
			int sum = 0;
			for (int i = 0; i < index; i++) {
				sum += result[i];
			}
			resultSet.add(sum);
			return;
		}
		for (int i = start; i < n; i++) {
			result[index] = array[i];
			start = i + 1;
			index++;
			combination();
			index--;
		}
	}

	@Test
	void test(){
		solution(new int[]{100,100});
	}
}
