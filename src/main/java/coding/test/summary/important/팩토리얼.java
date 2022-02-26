package coding.test.summary.important;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 팩토리얼 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        sb.append(dfs(5));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int dfs(int i) {

        if(i == 0){
            return 1;
        }
        return i*dfs(i-1);

    }
}
