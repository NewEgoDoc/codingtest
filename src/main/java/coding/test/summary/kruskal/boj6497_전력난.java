package coding.test.summary.kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj6497_전력난 {
    static int n,m;
    static int[] parents;
    static int[][] edges;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String[] nums = br.readLine().split(" ");
            m = Integer.parseInt(nums[0]);//집 수
            n = Integer.parseInt(nums[1]);//길 수

            if(m == 0 && n == 0) break;

            parents = new int[m];
            for (int i = 0; i < m; i++) {
                parents[i] = i;
            }

            int total = 0;
            edges = new int[n][3];
            for (int i = 0; i < n; i++) {
                String[] str = br.readLine().split(" ");
                int x = Integer.parseInt(str[0]);
                int y = Integer.parseInt(str[1]);
                int z = Integer.parseInt(str[2]);

                edges[i] = new int[]{x, y, z};

                total += z;
            }
            Arrays.sort(edges, (o1, o2)->(o1[2] - o2[2]));

            int count = 0;
            //union find
            for (int i = 0; i < edges.length; i++) {
                if(find(edges[i][0]) != find(edges[i][1])){
                    union(edges[i][0], edges[i][1]);
                    System.out.println(edges[i][2]);
                    count += edges[i][2];
                }
            }
            int save = total - count;
            System.out.println("total = " + total);
            System.out.println(save);
        }

    }

    private static int find(int i){
        if (parents[i] == i)
            return i;
        return find(parents[i]);
    }

    private static void union(int a, int b) {
        int a_parent = find(a);
        int b_parent = find(b);

        if (a_parent < b_parent)
            parents[b_parent] = a_parent;
        else
            parents[a_parent] = b_parent;
    }
}
