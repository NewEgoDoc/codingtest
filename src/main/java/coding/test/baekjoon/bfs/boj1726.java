package coding.test.baekjoon.bfs;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class boj1726 {

	int[] dx = {0, -1, 1, 0, 0};
	int[] dy = {0, 0, 0, -1, 1};

	boolean[][] visited;

	int[][] maze;

	int solution(int[][] map, int[] start, int[] end){
		maze = map;
		visited = new boolean[map.length][map[0].length];
		bfs(new int[]{start[0] - 1, start[1] - 1, start[2] },new int[]{ end[0] - 1, end[1] - 1, end[2]});

		return 0;
	}

	private void bfs(int[] start, int[] end) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(start);

		while(!q.isEmpty()){
			int[] poll = q.poll();

			for (int i = 1; i <= 4; i++) {
				int nx = poll[0] + dx[i];
				int ny = poll[1] + dy[i];

				if(nx < 0 || ny < 0 || nx >= maze.length || ny >= maze[0].length) continue;


			}

		}

	}

	@Test
	void test(){
		Assertions.assertEquals(solution(
			new int[][]{
				{0, 0, 0, 0, 0, 0},
				{0, 1, 1, 0, 1, 0},
				{0, 1, 0, 0, 0, 0},
				{0, 0, 1, 1, 1, 0},
				{1, 0, 0, 0, 0, 0}}
			,new int[] {4, 2, 3}
			,new int[] {2, 4, 1}),9);
	}
}
