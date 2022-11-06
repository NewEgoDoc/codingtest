package coding.test.baekjoon.bfs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class boj3197 {

	int n;
	int m;
	char[][] map;


	int solution(int N, int M, char[][] spaces){

		return 0;
	}

	@Test
	void test(){
		Assertions.assertEquals(solution(10,2,new char[][]{
			{'.','L'},
			{'.','.'},
			{'X','X'},
			{'X','X'},
			{'X','X'},
			{'X','X'},
			{'X','X'},
			{'X','X'},
			{'.','.'},
			{'.','L'}
		}),3);
		Assertions.assertEquals(solution(4,11,new char[][]{
			{'.','.','X','X','X','.','.','.','X','.','.'},
			{'.','X','.','X','X','X','.','.','.','L','.'},
			{'.','.','.','.','X','X','X','.','.','X','.'},
			{'X','.','L','.','.','X','X','X','.','.','.'}
		}),3);
		Assertions.assertEquals(solution(8,17,new char[][]{
			{'.','.','.','X','X','X','X','X','X','.','.','X','X','.','X','X','X'},
			{'.','.','.','.','X','X','X','X','X','X','X','X','X','.','X','X','X'},
			{'.','.','.','X','X','X','X','X','X','X','X','X','X','X','X','.','.'},
			{'.','.','X','X','X','X','X','.','L','X','X','X','X','X','X','.','.'},
			{'.','X','X','X','X','X','X','.','.','X','X','X','X','X','X','.','.'},
			{'X','X','X','X','X','X','X','.','.','.','X','X','X','X','.','.','.'},
			{'.','.','X','X','X','X','X','.','.','.','X','X','X','.','.','.','.'},
			{'.','.','.','.','X','X','X','X','X','.','X','X','X','L','.','.','.'},
		}),3);
	}
}
