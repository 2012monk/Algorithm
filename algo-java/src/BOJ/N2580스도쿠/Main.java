package BOJ.N2580스도쿠;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Integer> candidates = new ArrayList<>();
    static int[][] grid = new int[9][9];
    static int[] ver = new int[9], hoz = new int[9], square = new int[9];
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        for (int i = 0; i < 9; i++) {
            stz = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                grid[i][j] = Integer.parseInt(stz.nextToken());
                if (grid[i][j] != 0) {
                    mark(i, j, grid[i][j]);
                } else{
                    candidates.add(i*9+j);
                }
            }
        }
        if (find(0)) {
            for (int[] g : grid) {
                for (int i : g) {
                    System.out.printf("%d ", i);
                }
                System.out.println();
            }
            System.out.println(count);
        } else {
            System.out.println("ERR");
        }
    }

    public static boolean find(int p) {
        count++;
        if (p == candidates.size()) {
            return true;
        }
        int x = candidates.get(p) / 9, y = candidates.get(p) % 9;
        if (grid[x][y] != 0) {
            return find(p + 1);
        }
        for (int i = 1; i <= 9; i++) {
            if (!isValid(x, y, i)) {
                continue;
            }
            mark(x, y, i);
            if (find(p + 1)) {
                return true;
            }
            unMark(x, y, i);
        }
        return false;
    }

    static void mark(int x, int y, int val) {
        grid[x][y] = val;
        ver[x] |= 1 << val;
        hoz[y] |= 1 << val;
        square[(x / 3) * 3 + y / 3] |= 1 << val;
    }

    static void unMark(int x, int y, int val) {
        grid[x][y] = 0;
        ver[x] &= ~(1 << val);
        hoz[y] &= ~(1 << val);
        square[(x / 3) * 3 + y / 3] &= ~(1 << val);

    }

    static boolean isValid(int x, int y, int val) {
        boolean v = (ver[x] & (1 << val)) == 0;
        boolean h = (hoz[y] & (1 << val)) == 0;
        boolean sq = (square[(x / 3) * 3 + y / 3] & (1 << val)) == 0;
        return v && h && sq;
    }
}
