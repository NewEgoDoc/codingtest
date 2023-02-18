package coding.test.academy.Feb18th;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Problem1 {
    //정렬되지 않은 정수형 연결 리스트(단일)가 있다. 이 연결 리스트에서 중복 노드를 제거 하는 코드를 작성
    void removeDups () {
        Node n = header;
        while (n.next != null) {
            Node r = n;
            while (r.next != null) {
                if (n.data == r.next .data) {
                    r.next = r.next. next;
                }else {
                    r = r.next;
                }
            }
            n = n.next;
        }
    }
}
