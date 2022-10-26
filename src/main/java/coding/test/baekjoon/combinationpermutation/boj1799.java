package coding.test.baekjoon.combinationpermutation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class boj1799 {

	int n;
	int[][] map;
	int[][] visited;

	int[] dx = {-1,1,-1,1};
	int[] dy = {-1,-1,1,1};

	int count;

	int solution(int[][] chess){
		n = chess.length;
		map = chess;
		visited = new int[n][n];
		count = 0;
		func(0);

		return count;
	}

	private void func(int index) {

		if(index >= n) {
			return;
		}

		for (int i = 0; i < n; i++) {
			if(map[index][i] == 0) visited[index][i] = 1;
			if(map[index][i] == 1 && visited[index][i] == 0) {
				visited[index][i] = 2;
				count++;
				markBishopTraces(index, i);
			}
		}
		func(index + 1);
	}

	private void markBishopTraces(int index, int i) {
		int x = index;
		int y = i;

		for (int j = 0; j < 4; j++) {
			for (int k = 1; k < n; k++) {
				int nx = x + (dx[j]*k);
				int ny = y + (dy[j]*k);

				if(isImpossiblePosition(nx, ny)) continue;

				visited[nx][ny] = 3;
			}
		}
	}

	private boolean isImpossiblePosition(int nx, int ny) {
		return nx < 0 || ny < 0 || nx >= n || ny >= n;
	}

	@Test
	void test(){
		Assertions.assertEquals(solution(new int[][]{
			{1, 1, 0, 1, 1},
			{0, 1, 0, 0, 0},
			{1, 0, 1, 0, 1},
			{1, 0, 0, 0, 0},
			{1, 0, 1, 1, 1}
		}),7);
	}

}
