package coding.test.commulearning.Step1_4;


import java.util.Arrays;

public class 숫자게임 {
    public static final int INF = -1;
    public int solution(int[] A, int[] B) {
        int answer = 0;

        // sort
        Arrays.sort(A);
        Arrays.sort(B);

        // A를 이길 수 있는 B 찾기
        for(int i=0;i < A.length; i++){
            boolean check = false;
            for(int j=0; j< B.length; j++){
                if (check)
                    break;

                // 낮은 것 중 이기는 거
                if(A[i] < B[j]){
                    B[j] = INF;
                    check = true;
                    answer++;
                }
            }
        }

        return answer;
    }
}
