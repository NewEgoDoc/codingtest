package Fall2023.dfs.backtracking;

import org.junit.Test;

public class Lv3퍼즐조각채우기 {
    public int solution(int[][] game_board, int[][] table) {
        int answer = -1;
        //규칙에 맞게 최대한 많은 퍼즐 조각을 채워 넣을 경우, 총 몇 칸을 채울 수 있는지 return

        int len = game_board.length;

        //game_board 0, 1 바꿔주기
        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                if(game_board[i][j]==1){
                    game_board[i][j] = 0;
                }
                else game_board[i][j] = 1;
            }
        }

        boolean[][] visited_t = new boolean[len][len];
        boolean[][] visited_g = new boolean[len][len];

        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                //table에서 블록 추출
                if(table[i][j]==1 && !visited_t[i][j])
                    bfs(i, j, table, visited_t, t);

                //game_board에서 빈공간 추출
                if(game_board[i][j]==1 && !visited_g[i][j])
                    bfs(i, j, game_board, visited_g, g);
            }
        }

        //table의 블록과 board 빈 공간의 블록을 회전하면서 비교해주기
        answer = compareBlock(t, g, answer);

        return answer;
        return answer;
    }

    @Test
    public void test(){

    }
}
