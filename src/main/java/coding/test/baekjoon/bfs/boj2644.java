package coding.test.baekjoon.bfs;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class boj2644 {

	int[][] matrix;
	int[] visited;
	int N;
	int X;
	int Y;

	int solution(int n, int x, int y, int[][] connections) {
		N = n;
		X = x - 1;
		Y = y - 1;

		matrix = new int[N][N];
		for (int[] connection : connections) {
			matrix[connection[0] - 1][connection[1] - 1] = 1;
			matrix[connection[1] - 1][connection[0] - 1] = 1;
		}

		bfs();

		for (int i = 0; i < N; i++) {
			System.out.println("visited[" + i + "] = " + visited[i]);
		}

		return visited[Y] - 1;
	}

	private void bfs() {
		Queue<Integer> q = new LinkedList<>();
		visited = new int[N];
		visited[X] = 1;
		q.add(X);

		while (!q.isEmpty()) {
			Integer poll = q.poll();

			for (int i = 0; i < N; i++) {
				if (visited[i] == 0 && matrix[poll][i] == 1) {
					visited[i] = visited[poll] + 1;
					q.add(i);
				}
			}
		}
	}

	@Test
	void test() {
		Assertions.assertEquals(solution(9, 7, 3, new int[][] {{1, 2}, {1, 3}, {2, 7}, {2, 8}, {2, 9}, {4, 5}, {4, 6}}),
			3);
		Assertions.assertEquals(solution(9, 8, 6, new int[][] {{1, 2}, {1, 3}, {2, 7}, {2, 8}, {2, 9}, {4, 5}, {4, 6}}),
			-1);
	}
}
