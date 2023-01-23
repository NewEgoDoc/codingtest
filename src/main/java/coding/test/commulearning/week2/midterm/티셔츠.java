package coding.test.commulearning.week2.midterm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class 티셔츠 {
    public int solution(int[] people, int[] tshirts) {
        int answer = 0;
        //미리 정렬
        Arrays.sort(people);
        Arrays.sort(tshirts);

        int shirtIndex = 0;
        int peopleIndex = 0;
        //두개의 배열의 범위가 넘어가지 않게
        while(shirtIndex < tshirts.length && peopleIndex < people.length){
            //티셔츠의 사이즈가 같거나 크다면 개수+1, 다음 사람으로 넘어가고
            if(people[peopleIndex] <= tshirts[shirtIndex]){
                answer++;
                peopleIndex++;
            }

            //같든 그보다 작든 무조건 티셔츠의 범위는 넘어가게됨
            //ex people = 3,4 t-shirt = 2,3
            //            -             -       (x)
            //            -               -     (o) -> answer++;
            shirtIndex++;
        }

        return answer;
    }

    @Test
    void test(){
        Assertions.assertEquals(solution(new int[]{2,3}, new int[]{1,2,3}),2);
        Assertions.assertEquals(solution(new int[]{1,2,3}, new int[]{1,1}),1);
    }
}
