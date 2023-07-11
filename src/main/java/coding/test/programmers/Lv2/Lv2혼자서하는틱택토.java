package coding.test.programmers.Lv2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Lv2혼자서하는틱택토 {
    public int solution(String[] board) {

        int xCount = countTicTacTo(board, 'X');
        int oCount = countTicTacTo(board, 'O');


        //게임이 종료되었을때
        int oBingo = 0;
        int xBingo = 0;
        //가로
        for (int i = 0; i < board.length; i++) {
            if(board[i].charAt(0) == board[i].charAt(1) && board[i].charAt(1) == board[i].charAt(2)){
                if(board[i].charAt(0) == 'O'){
                    oBingo++;
                }
                if(board[i].charAt(0) == 'X'){
                    xBingo++;
                }
            }
        }

        //세로
        for (int i = 0; i < board.length; i++) {
            if(board[0].charAt(i) == board[1].charAt(i) && board[1].charAt(i) == board[2].charAt(i)){
                if(board[0].charAt(i) == 'O'){
                    oBingo++;
                }
                if(board[0].charAt(i) == 'X'){
                    xBingo++;
                }
            }
        }

        //대각선
        if(board[0].charAt(0) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(2)){
            if(board[1].charAt(1) == 'O'){
                oBingo++;
            }
            if(board[1].charAt(1) == 'X'){
                xBingo++;
            }
        }
        if(board[2].charAt(0) == board[1].charAt(1) && board[1].charAt(1) == board[0].charAt(2)){
            if(board[1].charAt(1) == 'O'){
                oBingo++;
            }
            if(board[1].charAt(1) == 'X'){
                xBingo++;
            }
        }


        if(oCount + xCount == 0){
            return 1;
        }
        if(oCount > xCount + 1){
            return 0;
        }
        if(oCount < xCount){
            return 0;
        }

        if(oBingo == 0 && oBingo == xBingo){
            return 1;
        }

        if(xBingo == 0 && oBingo > 0){
            if(xCount < oCount){
                return 1;
            }
        }

        if(xBingo > 0 && oBingo == 0){
            if(xCount == oCount){
                return 1;
            }
        }
        return 0;
    }

    private static int countTicTacTo(String[] board, char o) {
        int oCount = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                if(board[i].charAt(j) == o){
                    oCount++;
                }
            }
        }
        return oCount;
    }

    @Test
    void test(){
        Assertions.assertEquals(solution(new String[]{"O.X", ".O.", "..X"}),1);
        Assertions.assertEquals(solution(new String[]{"OOO", "...", "XXX"}),0);
        Assertions.assertEquals(solution(new String[]{"...", ".X.", "..."}),0);
        Assertions.assertEquals(solution(new String[]{"...", "...", "..."}),1);
    }
}
