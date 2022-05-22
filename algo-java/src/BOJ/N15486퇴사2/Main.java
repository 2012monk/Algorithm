package BOJ.N15486퇴사2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;

        int n = Integer.parseInt(br.readLine()), t, p;
        int[] d = new int[n + 1];
        for (int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine());
            t = Integer.parseInt(stz.nextToken());
            p = Integer.parseInt(stz.nextToken());
            d[i + 1] = Math.max(d[i + 1], d[i]);
            if (i + t > n) continue;
            d[i + t] = Math.max(d[i + t], d[i] + p);
        }
        System.out.println(d[n]);
    }
}
