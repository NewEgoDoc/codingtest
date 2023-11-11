package Fall2023.implement;

import java.io.*;
public class boj8979올림픽 {
    static class Country {
        public int x, y, z;
        public Country (int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str1[] = br.readLine().split(" ");
        int N = Integer.parseInt(str1[0]);
        int K = Integer.parseInt(str1[1]);
        Country countries[] = new Country[N + 1];
        for (int i = 1; i <= N; i++) {
            String str2[] = br.readLine().split(" ");
            int c = Integer.parseInt(str2[0]);
            int x = Integer.parseInt(str2[1]);
            int y = Integer.parseInt(str2[2]);
            int z = Integer.parseInt(str2[3]);
            countries[c] = new Country(x, y, z);
        }
        int result = 1;
        Country k = countries[K];
        for (int i = 1; i <= N; i++) {
            Country c = countries[i];
            if (c.x > k.x || (c.x == k.x && c.y > k.y) || (c.x == k.x && c.y == k.y && c.z > k.z)) result++;
        }
        bw.write(String.valueOf(result));
        bw.flush();
    }
}
