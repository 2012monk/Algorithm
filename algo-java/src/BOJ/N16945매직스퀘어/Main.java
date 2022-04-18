package BOJ.N16945매직스퀘어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] arr = new int[9], path = new int[9];
    static int ans = Integer.MAX_VALUE;
    static boolean[] v = new boolean[10];
    static int[][] lines = {
        {3,4,5},{6,7,8},
        {0, 3,6},{1,4,7},{2,5,8},
        {0,4,8},{2,4,6}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        for (int i = 0; i < 3; i++) {
            stz = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i*3+j] = Integer.parseInt(stz.nextToken());
            }
        }
        find(0);
        System.out.println(ans);
    }

    static void find(int x) {
        if (x == 9) {
            if (isMagicSquare()) {
//                System.out.println(Arrays.toString(path)+" "+calculateCost());
                ans = Math.min(ans, calculateCost());
            }
            return;
        }
        for (int i = 1; i < 10; i++) {
            if (v[i]) continue;
            v[i] = true;
            path[x] = i;
            find(x + 1);
            v[i] = false;
        }
    }

    private static int calculateCost() {
        int ret = 0;
        for (int i = 0; i < 9; i++) {
            ret += Math.abs(arr[i] - path[i]);
        }
        return ret;
    }

    static boolean isMagicSquare() {
        int sum, tmp;
        sum = path[0] + path[1] + path[2];
        for (int[] line : lines) {
            tmp = 0;
            for (int i : line) {
                tmp += path[i];
            }
            if (tmp != sum) return false;
        }
        return true;
    }
}
