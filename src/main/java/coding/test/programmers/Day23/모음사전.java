package coding.test.programmers.Day23;

public class 모음사전 {

    //점화식 구하는 문제

    public int solution(String word) {
        String str = "AEIOU";
        int[] x = {781,156,31,6,1};
        int index,result=word.length();
        for(int i=0;i<word.length();i++){
            index = str.indexOf(word.charAt(i));
            result+=x[i]*index;
        }
        return result;
    }
}
