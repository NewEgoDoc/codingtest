package coding.test.academy.Feb18th;

import java.util.Collections;
import java.util.LinkedList;

public class Problem3 {
    /*
    문제 3] 연결 리스트 자배열
    정렬되지 않은 정수형 단일 리스트가 존재, 정수 n이 주어질 때 n 주위의 노드를 재배열하는 코드 작성
    n을 기준으로 보다 작은 숫자는 n 앞으로 오게하고, n 보다 큰 숫자는 n뒤로 오게 배치한다
     */
    public void quickSort(LinkedList<Integer> list) {
        if (list.size() <= 1) {
            return;
        }
        Integer pivot = list.getFirst();
        LinkedList<Integer> less = new LinkedList<Integer>();
        LinkedList<Integer> greater = new LinkedList<Integer>();
        for (Integer element : list) {
            if (element < pivot) {
                less.add(element);
            } else if (element > pivot) {
                greater.add(element);
            }
        }
        quickSort(less);
        quickSort(greater);
        list.clear();
        list.addAll(less);
        list.addAll(greater);
    }
}
