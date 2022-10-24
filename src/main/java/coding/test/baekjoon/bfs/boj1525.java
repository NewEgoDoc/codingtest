package coding.test.baekjoon.bfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import org.junit.jupiter.api.Test;

public class boj1525 {

	int[] dx = {};
	int[] dy = {};

	int[][] map;
	Map<String, Boolean> visited;
	int solution(int[][] puzzle){
		map = puzzle;

		int[] startPoint = findStartPoint();
		bfs(startPoint);

		return 0;
	}

	private int[] findStartPoint() {

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if(map[i][j] == 0) return new int[]{i, j};
			}
		}
		return new int[0];
	}

	void bfs(int[] startPoint){
		Queue<int[]> q = new LinkedList<>();
		visited = new HashMap<>();
		visited.put(getPuzzleString(),true);

		while (!q.isEmpty()){
			int[] poll = q.poll();
			int x = poll[0];
			int y = poll[1];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if(isPositionImpossible()) continue;
				if(visited.containsKey()) continue;
			}
		}

	}

	private String getPuzzleString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				sb.append(map[i][j]);
			}
		}
		return sb.toString();
	}

	@Test
	void test(){

	}
}
