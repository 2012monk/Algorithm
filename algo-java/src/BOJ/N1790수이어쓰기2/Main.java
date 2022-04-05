package BOJ.N1790수이어쓰기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;

    public static void main(String[] args) throws IOException {
        stz = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stz.nextToken());
        int m = Integer.parseInt(stz.nextToken());

        int len = 0;
        int next = 10;
        int p = 1;
        String ans = "";
        for (int i = 1; i <= n; i++) {
            if (i >= next) {
                next *= 10;
                p += 1;
            }
            len += p;
            if (len >= m) {
                ans = String.valueOf(i);
                break;
            }
        }
        if (len < m) {
            System.out.println(-1);
        } else {
            System.out.println(ans.charAt(ans.length() - 1 + m - len));
        }
    }
}
