package BOJ.N1202보석도둑;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stz.nextToken());
        int k = Integer.parseInt(stz.nextToken());
        long[] bag = new long[k];
        long[][] s = new long[n][2];
        for (int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine());
            s[i][0] = Long.parseLong(stz.nextToken());
            s[i][1] = Long.parseLong(stz.nextToken());
        }
        for (int i = 0; i < k; i++) {
            bag[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(bag);
        Arrays.sort(s, Comparator.comparingLong(v -> v[0]));
        PriorityQueue<Long> q = new PriorityQueue<>(Comparator.comparingLong(v -> -v));
        long ans = 0;
        int x = 0;
        for (int i = 0; i < k; i++) {
            while (x < n && s[x][0] <= bag[i]) {
                q.add(s[x++][1]);
            }
            if (!q.isEmpty()) ans+=q.poll();
        }
        System.out.println(ans);
    }
}
