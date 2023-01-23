package coding.test.commulearning.week1.section1;

public class 기지국설치 {
    public int solution(int n, int[] stations, int w) {
        int position = 1;
        int index = 0;
        int count = 0;

        while(position <= n){//일단 전부 순회

            //현재의 아파트가 전파범위에 속하는지 확인 - 속한다면
            if(index < stations.length && position >= stations[index] - w){
                //아파트를 기지국에서 범위를 더한 한칸 뒤로 이동
                position = stations[index] + w + 1;
                //다음 기지국 확인
                index++;
                continue;
            }
            //일단 기지국 세우고
            count++;
            //위치를 w 만큼 뒤에 세우고
            //기지국의 w 만큼 그리고 한칸 뒤에서 부터 시작
            position += 2*w + 1;

        }
        return count;
    }
}
