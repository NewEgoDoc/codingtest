package coding.test.summary.combination;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CombinationTest {

	private Combination combination;

	@Test
	void combinationTest(){
		combination = new Combination(new int[]{3,8,9,10,16,18,22}, 2);
		combination.execute();
	}

}