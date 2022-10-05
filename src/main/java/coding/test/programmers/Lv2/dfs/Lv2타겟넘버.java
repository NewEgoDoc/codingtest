package coding.test.programmers.Lv2.dfs;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.jupiter.api.Test;

public class Lv2타겟넘버 {

	public int solution(int[] numbers, int target) {
		//return dfs(numbers,0,0,target);
		return dfs(numbers,target);
	}

	public int dfs(int[] numbers, int depth, int sum, int target){
		if(depth==numbers.length){

			if(target == sum) return 1;
			else return 0;
		}

		return dfs(numbers,depth+1,sum+numbers[depth],target)
			+ dfs(numbers,depth+1,sum-numbers[depth],target);

	}

	public int dfs(int[] numbers, int target){
		int count = 0;
		Stack<Integer> stack = new Stack<>();
		List<Integer> list;

		stack.push(numbers[0]);
		stack.push(numbers[0]*-1);

		for (int i = 1; i < numbers.length; i++) {
			int nextNum = numbers[i];
			list = new ArrayList<Integer>();

			while(!stack.isEmpty()) {
				int stackNum = stack.pop();

				list.add(stackNum+nextNum);
				list.add(stackNum+(nextNum*-1));
			}

			for (int j = 0; j < list.size(); j++) {
				stack.push(list.get(j));
			}
		}

		for (Integer sum : stack) {
			if(sum == target)
				count++;
		}
		return count;
	}


	@Test
	public void test(){
		assertEquals(solution(new int[]{1, 1, 1, 1, 1},3), 5);
		assertEquals(solution(new int[]{4, 1, 2, 1},4), 2);
	}

}
