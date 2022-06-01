package BOJ.N2109순회강연;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;

        int n = Integer.parseInt(br.readLine());
        int[][] s = new int[n][2];
        for (int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine());
            s[i][0] = Integer.parseInt(stz.nextToken());
            s[i][1] = Integer.parseInt(stz.nextToken());
        }
        Arrays.sort(s, Comparator.comparingInt(v -> v[1]));
        PriorityQueue<Integer> q = new PriorityQueue<>();
        long ans = 0;
        for (int[] vv : s) {
            q.add(vv[0]);
            ans += vv[0];
            if (q.size() > vv[1]) {
                ans -= q.poll();
            }
        }
        System.out.println(ans);
    }
}
