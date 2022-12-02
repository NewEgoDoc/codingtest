package coding.test.programmers.Day14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class 괄호변환 {
    String result ;
    public String solution(String p) {
        result = "";
        recursive(p);
        return result;
    }
    public String recursive (String w){
        String u="";
        String v="";

        // 1번 빈문자열 확인
        if(w == ""){
            return w;
        }

        //2번 균형잡힌 문자열로 분리하기
        for(int i = 2; i <= w.length(); i += 2){
            u = w.substring(0,i);
            v = w.substring(i);
            int left = 0;
            int right = 0;
            for(int j = 0; j < u.length(); j++){

                if(u.charAt(j) == '(') {
                    left++;
                    continue;
                }

                right++;
            }
            if(left == right){
                break;
            }
        }

        boolean flag = true;
        //조건 3번: u 가 올바르면 이어붙이고 v를재귀
        Stack<String> confirm = new Stack<>();
        for(int i = 0; i < u.length(); i++){
            if(u.charAt(i) == '('){
                confirm.push("(");
                continue;
            }

            if(confirm.empty()) {
                flag = false;
                break;
            }

            confirm.pop();
        }
        //3-1 올바른 괄호 문자열이면 v를 재귀 + u를 result 더하기
        if(flag){
            result += u+recursive(v);
            return result;
        }

        //조건4: 올바른 문자열이 아닌경우
        result+="("+recursive(v);
        u = u.substring(1,u.length()-1);
        u = u.replace("(","1");
        u = u.replace(")","2");
        u = u.replace("1",")");
        u = u.replace("2","(");
        result += ")" + u;

        return result;
    }

    @Test
    void test(){
        Assertions.assertEquals(solution(""),"");
        Assertions.assertEquals(solution("(()())()"),"(()())()");
        Assertions.assertEquals(solution(")("),"()");
        Assertions.assertEquals(solution("()))((()"),"()(())()");
    }
}
