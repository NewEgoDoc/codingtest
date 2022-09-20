package coding.test.trial.no1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class First {
	public double solution(int[] arr) {
		double sum = 0.0;
		for (int element: arr) {
			sum += element;
		}
		sum /= arr.length;

		return sum;
	}

	@Test
	void test(){
		Assertions.assertEquals(solution(new int[]{1,2,3,4}),2.5);
		Assertions.assertEquals(solution(new int[]{5,5}),5.0);
	}
}
