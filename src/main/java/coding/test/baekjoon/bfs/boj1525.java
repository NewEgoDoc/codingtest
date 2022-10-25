package coding.test.baekjoon.bfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class boj1525 {

	int[] dx = {-1,1,0,0};
	int[] dy = {0,0,-1,1};

	int[][] map;
	Map<String, Integer> visited;
	int solution(int[][] puzzle){
		map = puzzle;

		String startpoint = getPuzzleString();

		bfs(startpoint);

		
		
		Integer num = visited.get("123456780") == null? 0: visited.get("123456780");

		return num -1;
	}

	void bfs(String startPoint){
		Queue<String> q = new LinkedList<>();
		q.add(startPoint);
		visited = new HashMap<>();
		visited.put(startPoint,1);

		while (!q.isEmpty()){
			String poll = q.poll();
			System.out.println("poll = " + poll);
			int zeroIndex = poll.indexOf('0');
			System.out.println("zeroIndex = " + zeroIndex);
			int x = zeroIndex / 3;
			System.out.println("x = " + x);
			int y = zeroIndex % 3;
			System.out.println("y = " + y);

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				int next = nx*3 + ny;

				if(isPositionImpossible(nx, ny)) continue;
				StringBuilder sb = new StringBuilder(poll);
				System.out.println("next = " + next);

				char changePosition = sb.charAt(next);
				sb.setCharAt(next, '0');
				sb.setCharAt(zeroIndex, changePosition);

				if(visited.get(sb.toString()) != null) continue;

				visited.put(sb.toString(), visited.get(poll) + 1);
				q.add(sb.toString());

			}
		}

	}

	private boolean isPositionImpossible(int nx, int ny) {
		return nx < 0 || ny < 0 || nx >= 3 || ny >= 3;
	}

	private String getPuzzleString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				sb.append(map[i][j]);
			}
		}
		return sb.toString();
	}

	@Test
	void test(){
		Assertions.assertEquals(solution(new int[][]{
			{1, 0, 3},
			{4, 2, 5},
			{7, 8, 6}
		}),3);
		Assertions.assertEquals(solution(new int[][]{
			{3, 6, 0},
			{8, 1, 2},
			{7, 4, 5},
		}),-1);
	}
}
