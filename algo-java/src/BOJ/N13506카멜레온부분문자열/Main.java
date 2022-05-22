package BOJ.N13506카멜레온부분문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    int[] fail;
    char[] src;
    boolean[] v;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        new Main().solve(br.readLine());
    }

    void solve(String s) {
        src = s.toCharArray();
        v = new boolean[src.length];
        fail = buildFail(src);
        String ans = "-1";
        int x = fail[src.length - 1];
        while (x > 0) {
            if (v[x]) {
                ans = String.valueOf(src, 0, x);
                break;
            }
            x = fail[x - 1];
        }
        System.out.println(ans);
    }

    int[] buildFail(char[] src) {
        int[] fail = new int[src.length];
        for (int i = 1, j = 0; i < src.length; i++) {
            while (j > 0 && src[i] != src[j]) j = fail[j - 1];
            if (src[i] == src[j]) fail[i] = ++j;
            if (i != src.length - 1) v[fail[i]] = true;
        }
        return fail;
    }
}
