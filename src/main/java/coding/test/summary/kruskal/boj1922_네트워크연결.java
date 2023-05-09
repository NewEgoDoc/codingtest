package coding.test.summary.kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj1922_네트워크연결 {

    static int n,m;
    static int[] parents;
    static int[][] edges;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());//노드 수
        m = Integer.parseInt(br.readLine());//간선 수

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
                total += edges[i][2];
                union(edges[i][0], edges[i][1]);
            }
        }
        System.out.println(total);
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
