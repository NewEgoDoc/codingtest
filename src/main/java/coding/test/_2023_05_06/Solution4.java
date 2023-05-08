package coding.test._2023_05_06;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class Solution4 {
    int[][] graph;
    public int solution(int n, int[][] network, int[][] repair) {
        /* 그래프는 모든 노드의 연결을 담습니다. */
        graph = new int[network.length + repair.length][3];

        /* network 에 있는 연결 graph 에 추가 */
        for (int i = 0; i < network.length; i++) {
            graph[i] = new int[]{network[i][0], network[i][1], 0};
        }
        /* repair 에 있는 연결 graph 에 추가 */
        for (int i = 0; i < repair.length; i++) {
            graph[i+network.length] = new int[]{repair[i][0], repair[i][1], repair[i][2]};
        }

        int[] parent = new int[n];
        int total = 0;

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        /* graph를 비용에 따라 오름차순으로 정렬 */
        Arrays.sort(graph, Comparator.comparingInt(o -> o[2]));

        for(int[] g: graph){
            System.out.println(Arrays.toString(g));
        }

        /* union find */
        for (int i = 0; i < graph.length; i++) {
            if(find(parent, graph[i][0]-1) != find(parent, graph[i][1]-1)) {
                total += graph[i][2];
                union(parent, graph[i][0], graph[i][1]);
            }
        }

        /* 모든 노드가 연결 되지 않았다면 -1 */
        if(!isConnected(parent)) return -1;

        return total;
    }

    private boolean isConnected(int[] parent) {
        boolean isConnected = true;
        int root = find(parent, 0);
        for (int i = 1; i < parent.length; i++) {
            if (find(parent, i) != root) {
                isConnected = false;
                break;
            }
        }
        return isConnected;
    }

    private void union(int[] parent, int a, int b) {
        int a_parent = find(parent, a - 1);
        int b_parent = find(parent, b - 1);

        if (a_parent < b_parent)
            parent[b_parent] = a_parent;
        else
            parent[a_parent] = b_parent;
        System.out.println("parent: " +Arrays.toString(parent));
    }

    private int find(int[] parent, int i){
        if (parent[i] == i)
            return i;
        return find(parent, parent[i]);
    }

    private void kruskal() {

    }

    @Test
    void test(){
        Assertions.assertEquals(solution(6,
                new int[][]{{1, 2}, {3, 5}, {4, 2}, {5, 6}},
                new int[][]{{3, 2, 10}, {5, 4, 15}}),10);
        Assertions.assertEquals(solution(4,
                new int[][]{{1, 2}},
                new int[][]{{2, 3, 10}, {3, 1, 12}}),-1);
        Assertions.assertEquals(solution(5,
                new int[][]{{1, 2},{1, 3},{4, 5}},
                new int[][]{{1, 5, 156}, {3, 5, 12}}),12);
    }
}
