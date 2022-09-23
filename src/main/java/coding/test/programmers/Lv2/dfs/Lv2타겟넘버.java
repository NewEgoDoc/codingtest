package coding.test.programmers.Lv2.dfs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class Lv2타겟넘버 {

	public int solution(int[] numbers, int target) {
		return dfs(numbers,0,0,target);
	}

	public int dfs(int[] numbers, int depth, int sum, int target){
		if(depth==numbers.length){

			if(target == sum) return 1;
			else return 0;
		}
		else{
			return dfs(numbers,depth+1,sum+numbers[depth],target)
				+ dfs(numbers,depth+1,sum-numbers[depth],target);
		}
	}


	@Test
	public void test(){
		assertEquals(solution(new int[]{1, 1, 1, 1, 1},3), 5);
		assertEquals(solution(new int[]{4, 1, 2, 1},4), 2);
	}

}
