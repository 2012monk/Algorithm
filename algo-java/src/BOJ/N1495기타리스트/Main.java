package BOJ.N1495기타리스트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n,s,m;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        s = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        boolean[][] d = new boolean[n + 1][1001];
        d[0][s] = true;

        stz = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            int k = Integer.parseInt(stz.nextToken());
            for (int j = 0; j <= m; j++) {
                if (!d[i - 1][j]) continue;
                if (j - k >= 0){
                    d[i][j - k] = true;
                }
                if (j + k <= m) {
                    d[i][j + k] = true;
                }
            }
        }
        int ans = m;
        while (ans >= 0 && !d[n][ans]) ans--;
        System.out.println(ans);
    }
}
