package coding.test.academy.Feb18th;

import java.util.Queue;
import java.util.Stack;

public class Problem4 {
    //스택을 이용하여 문자열을 역으로 출력하는 소스 코딩
    void reversePrint(String string){
        Stack<Character> stack = new Stack<>();//조건: 스택을 이용
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            stack.add(string.charAt(i));
        }
        while(!stack.empty()){
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());//문자열 역으로 출력
    }
}
