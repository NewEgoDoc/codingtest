package coding.test.baekjoon.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class boj1987 {
	int r;
	int c;

	char[][] map;
	int[][] visited;

	int[] dx = {-1,1,0,0};
	int[] dy = {0,0,-1,1};

	Set<Character> list;

	int solution(char[][] board){
		c = board.length;
		r = board[0].length;

		map = board;
		visited = new int[c][r];


		bfs(new int[]{0,0});

		for (int i = 0; i < c; i++) {
			for (int j = 0; j < r; j++) {
				System.out.print(visited[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println("list = " + list);
		return list.size();
	}


	private void bfs(int[] point) {
		Stack<int[]> q = new Stack<>();
		list = new TreeSet<>();
		q.add(point);

		while(!q.isEmpty()){
			int[] poll = q.pop();
			int x = poll[0];
			int y = poll[1];
			list.add(map[x][y]);

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if(isImpossible(nx, ny)) continue;
				if(!validate(map[nx][ny]) || visited[nx][ny] > 0) continue;

				q.add(new int[]{nx, ny});
				visited[nx][ny] = visited[x][y] + 1;
			}
		}

	}

	private boolean validate(char letter) {
		for (char c: list) {
			if(letter == c) return false;
		}
		return true;
	}

	private boolean isImpossible(int nx, int ny) {
		return nx < 0 || ny < 0 || nx >= c || ny >= r;
	}

	@Test
	void test(){
		Assertions.assertEquals(solution(new char[][]{
			{'C','A','A','B'},
			{'A','D','C','B'}
		}),3);
		Assertions.assertEquals(solution(new char[][]{
			{'H','F','D','F','F','B'},
			{'A','J','H','G','D','H'},
			{'D','G','A','G','E','H'}
		}),6);
		Assertions.assertEquals(solution(new char[][]{
			{'I','E','F','C','J'},
			{'F','H','F','K','C'},
			{'F','F','A','L','F'},
			{'H','F','G','C','F'},
			{'H','M','C','H','H'}
		}),10);
	}
}
