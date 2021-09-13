package algo.kakao.T0911.sixth;

public class Solution {

    public void skill(int x, int y, int tx, int ty, int degree, int[][] b){
        for (int i = x; i <= tx; i++) {
            for (int j = y; j <= ty; j++) {
                b[i][j] += degree;
            }
        }
    }

    public int solution(int[][] board, int[][] skill) {
        for (int[] s : skill) {
            int d = s[5];
            if (s[0] == 1) d = -s[5];
            skill(s[1],s[2],s[3],s[4],d,board);
        }
        int r = 0;
        for (int[] b : board) {
            for (int i : b) {
                if (i > 0) r+= 1;
            }
        }
        return r;
    }
}
