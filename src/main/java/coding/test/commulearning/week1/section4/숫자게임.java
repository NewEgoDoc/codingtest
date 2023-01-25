package coding.test.commulearning.week1.section4;

import java.util.Arrays;

public class 숫자게임 {
    public int solution(int[] A, int[] B) {
        int point = 0;
        Arrays.sort(A);
        Arrays.sort(B);

        int aIndex = A.length - 1;
        int bIndex = B.length - 1;

        while(aIndex >= 0 && bIndex >= 0){
            if(A[aIndex] < B[bIndex]){
                bIndex--;
                point++;
            }
            aIndex--;
        }
        return point;
    }
}
