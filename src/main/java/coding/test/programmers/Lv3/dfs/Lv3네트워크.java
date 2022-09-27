package coding.test.programmers.Lv3.dfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Lv3네트워크 {

	int N;

	public int solution(int n, int[][] computers) {
		int answer = 0;
		N = n;
		boolean[] visited = new boolean[n];

		for (int i = 0; i < N; i++) {
			if(!visited[i]){
				dfs(computers,visited,i);
				answer++;
			}
		}


		return answer;
	}

	private void dfs(int[][] computers, boolean[] visited, int start) {
		visited[start] = true;

		for (int i = 0; i < N; i++) {
			if(computers[start][i] == 1 && !visited[i]){
				dfs(computers,visited,i);
			}
		}
	}

	@Test
	void test(){
		Assertions.assertEquals(solution(3,new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 1, 1}}),2);
		Assertions.assertEquals(solution(3,new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}),1);
	}
}
