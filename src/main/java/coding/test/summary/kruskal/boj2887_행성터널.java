package coding.test.summary.kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj2887_행성터널 {
    static int n;
    static List<int[]> connections;
    static int[] parents;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int[][] planets = new int[n][4];
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            planets[i][0] = i;
            planets[i][1] = Integer.parseInt(str[0]);
            planets[i][2] = Integer.parseInt(str[1]);
            planets[i][3] = Integer.parseInt(str[2]);
        }

        connections = new ArrayList<>();
        Arrays.sort(planets, (o1,o2)->(o1[1]-o2[1]));//x 순으로 오름차순
        for (int i = 0; i < n - 1; i++) {
            int[] connection = new int[]{planets[i][0], planets[i+1][0], Math.abs(planets[i][1] - planets[i+1][1])};
            connections.add(connection);
        }

        Arrays.sort(planets, (o1,o2)->(o1[2]-o2[2]));
        for (int i = 0; i < n - 1; i++) {
            int[] connection = new int[]{planets[i][0], planets[i+1][0], Math.abs(planets[i][2] - planets[i+1][2])};
            connections.add(connection);
        }

        Arrays.sort(planets, (o1,o2)->(o1[3]-o2[3]));
        for (int i = 0; i < n - 1; i++) {
            int[] connection = new int[]{planets[i][0], planets[i+1][0], Math.abs(planets[i][3] - planets[i+1][3])};
            connections.add(connection);

        }

        Collections.sort(connections, (o1,o2)->(o1[2]-o2[2]));

        int cost = 0;

        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        // union find
        for (int[] connect: connections) {
            if(find(connect[0]) != find(connect[1])){
                union(connect[0], connect[1]);
                cost += connect[2];
            }
        }
        System.out.println(cost);
    }

    static private int find(int index){
        //System.out.println("index = " + index);
        if(parents[index] == index){
            return index;
        }
        return find(parents[index]);
    }

    static private void union(int i, int j){
        int i1 = find(i);
        int i2 = find(j);

        if(i1 < i2){
            parents[i1] = i2;
        } else {
            parents[i2] = i1;
        }
    }
}
