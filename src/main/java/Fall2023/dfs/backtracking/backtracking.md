![완전 탐색](https://github.com/KoEonYack/PracticeCoding/blob/master/Article/Algorithm/Backtracking/Introduce/img/%5B0%5D_%EB%B0%B1%ED%8A%B8%EB%9E%98%ED%82%B9%EC%9D%B4%EB%9E%80_%EB%AC%B8%EC%A0%9C%EC%B6%94%EC%B2%9C/algo_map.jpg?raw=true)
거의 모든 코딩 테스트에서 다루고 있는 완전 탐색에 대해서 알아보자
그림과 같이 백트랙킹은 완전탐색의 카테고리에 있다. 또한 그림에서 안보이는 내용은 백트랙킹은 DFS의 응용이라는 것이다.

# 백트랙킹

- 완전 탐색에서 불필요한 분기를 가지치기 한다는 의미 이기도 하다.
  - 정답이 중간에서 도출 되지 않을 것이라면 해당 분기점을 통과하거나 버리고 다음으로 넘어간다는 뜻이다.
- 이러한 "가지치기"나 "분기점 통과"를 통해 이전에 진행했던 완전탐색(DFS)보다 효율을 높일 수 있다.


# 어떻게 풀까?
- 앞선 개념에서 말을 했듯이 DFS라는 완전탐색 내에서 분기점 통과를 통해 문제의 해답을 이끌어 내기 때문에 DFS의 부터 진행을 해보자

[백준 알파벳](https://www.acmicpc.net/problem/1987)

- 일단 백트랙킹을 배제하고 DFS로 문제를 접근해보자
```java
    


```