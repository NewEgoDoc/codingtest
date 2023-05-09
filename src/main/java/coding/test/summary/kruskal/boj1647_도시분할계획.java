package coding.test.summary.kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj1647_도시분할계획 {
    static int n,m;
    static int[] parents;
    static int[][] edges;

    static int previous;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        n = Integer.parseInt(nums[0]);//노드 수
        m = Integer.parseInt(nums[1]);//간선 수

        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        int total = 0;
        edges = new int[m][3];
        for (int i = 0; i < m; i++) {
            String[] str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            int cost = Integer.parseInt(str[2]);
            edges[i] = new int[]{a, b, cost};
        }
        Arrays.sort(edges,(o1, o2)->(o1[2]-o2[2]));

        //union find
        for (int i = 0; i < edges.length; i++) {
            if(find(edges[i][0]-1) != find(edges[i][1]-1)){
                previous = edges[i][2];
                total += edges[i][2];
                union(edges[i][0], edges[i][1]);
            }
        }

        System.out.println(Arrays.toString(parents));
        System.out.println(total - previous);
    }

    private static int find(int i){
        if (parents[i] == i)
            return i;
        return find(parents[i]);
    }

    private static void union(int a, int b) {
        int a_parent = find(a - 1);
        int b_parent = find(b - 1);

        if (a_parent < b_parent)
            parents[b_parent] = a_parent;
        else
            parents[a_parent] = b_parent;
    }
}
