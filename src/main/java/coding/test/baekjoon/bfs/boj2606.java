package coding.test.baekjoon.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class boj2606 {

	int[][] map;
	boolean[] visited;
	int solution(int n, int[][] connections){
		map = new int[n+1][n+1];

		for (int i = 0; i < connections.length; i++) {
			int x = connections[i][0];
			int y = connections[i][1];
			
			map[x][y] = 1;
			map[y][x] = 1;
		}
		visited = new boolean[n+1];
		return dfs(1);
	}

	private int bfs(int start) {

		Queue<Integer> q = new LinkedList<>();
		visited[start] = true;
		q.offer(start);

		int count = 0;
		while (!q.isEmpty()){
			Integer pop = q.poll();
			// System.out.println("pop = " + pop);
			for (int i = 1; i < map.length; i++) {
				// System.out.println("map[pop]["+i+"] = " + map[pop][i]);
				// System.out.println("visited["+i+"] = " + visited[i]);
				if(map[pop][i] == 1 && !visited[i]){
					count++;
					visited[i] = true;
					q.offer(i);
				}
			}
		}
		return count;
	}

	private int dfs(int start) {

		Stack<Integer> stack = new Stack<>();
		visited[start] = true;
		stack.push(start);

		int count = 0;
		while (!stack.isEmpty()){
			Integer pop = stack.pop();
			// System.out.println("pop = " + pop);
			for (int i = 1; i < map.length; i++) {
				// System.out.println("map[pop]["+i+"] = " + map[pop][i]);
				// System.out.println("visited["+i+"] = " + visited[i]);
				if(map[pop][i] == 1 && !visited[i]){
					count++;
					visited[i] = true;
					stack.push(i);
				}
			}
		}
		return count;
	}

	@Test
	void test(){
		Assertions.assertEquals(solution(7, new int[][]{{1, 2},{2, 3},{1, 5},{5, 2},{5, 6},	{4, 7}}),4);
	}
}
