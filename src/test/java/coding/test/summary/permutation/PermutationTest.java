package coding.test.summary.permutation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PermutationTest {

	private Permutation permutation;

	@Test
	void 순열_테스트(){
		permutation = new Permutation(new int[]{1,4,8,32}, 2);
		permutation.execute();
		System.out.println("개수 : " + permutation.getNum());
	}

}