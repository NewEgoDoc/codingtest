package coding.test.trial.no1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Fourth {
	int[][] matrix;
	int N;
	public int solution(int n, int s, int a, int b, int[][] fares) {
		N = n;
		matrix = new int[N][N];

		for (int i = 0; i < fares.length; i++) {
			int x = fares[i][0];
			int y = fares[i][1];
			int cost = fares[i][2];
			matrix[x-1][y-1] = cost;
			matrix[y-1][x-1] = cost;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print("\t" + matrix[i][j]);
			}
			System.out.println();
		}

		int[] distanceFromS = dijkstra(s-1);

		int minDistance = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			int[] distances = dijkstra(i);
			int	distance = distanceFromS[i] + distances[a-1] + distances[b-1];
			if(distance < minDistance) {
				minDistance = distance;
			}
		}
		return minDistance;
	}

	private int[] dijkstra(int start) {
		int[] distance = new int[N];
		Arrays.fill(distance, Integer.MAX_VALUE);
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
		distance[start] = 0;
		boolean visited[] = new boolean[N];
		
		pq.offer(new int[]{0,start});

		while (!pq.isEmpty()){
			int[] cur = pq.poll();
			int index = cur[1];

			if(visited[index]) continue;

			visited[index] = true;

			for (int i = 0; i < N; i++) {
				if(matrix[index][i] == 0){
					continue;
				}
				if(distance[index] + matrix[index][i] < distance[i]){
					distance[i] = distance[index] + matrix[index][i];
					pq.add(new int[]{distance[i], i});
				}
			}
		}
		return distance;
	}

	@Test
	void test(){
		Assertions.assertEquals(solution(6,4,6,2,new int[][]{{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}}),82);
		Assertions.assertEquals(solution(7,3,4,1,new int[][]{{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}}), 14);
		Assertions.assertEquals(solution(6,4,5,6,new int[][]{{2,6,6},{6,3,7},{4,6,7},{6,5,11},{2,5,12},{5,3,20},{2,4,8},{4,3,9}}),18);

	}
}
