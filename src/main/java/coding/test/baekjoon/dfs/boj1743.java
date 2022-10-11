package coding.test.baekjoon.dfs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class boj1743 {

	int[] dx = {1, -1, 0, 0};
	int[] dy = {0, 0, 1, -1};

	boolean[][] visited;

	int[][] map;

	int r;
	int n;

	List<Integer> answers;

	int solution(int R, int N, int[][] trashes) {
		answers = new ArrayList<>();
		r = R;
		n = N;

		mapSetting(trashes);

		for (int[] trash : trashes) {
			dfs(new int[] {trash[0] - 1, trash[1] - 1});
		}

		Collections.sort(answers, Math::max);
		return answers.get(0);
	}

	private void mapSetting(int[][] trashes) {
		map = new int[r][n];
		visited = new boolean[r][n];
		for (int[] trash : trashes) {
			map[trash[0] - 1][trash[1] - 1] = 1;
		}
	}

	void dfs(int[] initialPoint) {

		if (visited[initialPoint[0]][initialPoint[1]])
			return;

		Stack<int[]> stack = new Stack<>();
		stack.push(initialPoint);
		visited[initialPoint[0]][initialPoint[1]] = true;

		int count = 1;
		while (!stack.isEmpty()) {
			int[] pop = stack.pop();
			int x = pop[0];
			int y = pop[1];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || ny < 0 || nx >= r || ny >= n)
					continue;
				if (visited[nx][ny] || map[nx][ny] == 0)
					continue;

				visited[nx][ny] = true;
				stack.push(new int[] {nx, ny});
				count++;
			}
		}
		System.out.println("count = " + count);
		answers.add(count);
	}

	int dfs(int x, int y,int count){
		visited[x][y] = true;
		for(int i = 0; i < 4; i++){
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || ny < 0 || nx >= r || ny >= n)
				continue;
			if (visited[nx][ny] || map[nx][ny] == 0)
				continue;

			dfs(nx, ny, count+1);

		}
		return count;
	}

	void bfs(int[] initialPoint) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(initialPoint);

		visited[initialPoint[0]][initialPoint[1]] = true;

		while (!q.isEmpty()) {
			int[] pop = q.poll();
			int x = pop[0];
			int y = pop[1];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || ny < 0 || nx >= r || ny >= n)
					continue;
				if (visited[nx][ny] || map[nx][ny] == 0)
					continue;

				visited[nx][ny] = true;
				map[nx][ny] = map[x][y] + 1;
				q.offer(new int[] {nx, ny});
			}
		}
	}

	@Test
	void test() throws IOException {
		Assertions.assertEquals(solution(3, 4, new int[][] {
			{3, 2},
			{2, 2},
			{3, 1},
			{2, 3},
			{1, 1}}), 4);
		Assertions.assertEquals(solution(3, 4, new int[][] {
			{3, 2},
			{2, 2},
			{3, 1},
			{2, 3},
			{2, 4},
			{1, 1}}), 5);
	}
}
