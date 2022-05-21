package BOJ.N13505두수XOR;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        Node root= new Node();
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        stz = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(stz.nextToken());
            root.add(31, a[i]);
        }
        int ans = 0;
        for (int i : a) {
            ans = Math.max(ans, root.query(31, i));
        }
        System.out.println(ans);
    }

    static class Node {
        Node[] children = new Node[2];

        void add(int i, int d) {
            if (i < 0) return;
            int next = 0;
            if ((d & (1 << i)) > 0) next = 1;
            if (children[next] == null) children[next] = new Node();
            children[next].add(i - 1, d);
        }

        int query(int i, int d) {
            if (i < 0) return 0;
            int ret = 0, next = 0;
            if ((d & (1 << i)) > 0) next = 1;
            next ^= 1;
            if (children[next] == null) next ^= 1;
            else ret |= 1 << i;
            return ret | children[next].query(i - 1, d);
        }
    }
}
