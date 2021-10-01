package BOJ.N1967트리의지름;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;

    static int n, res;
    static List<Node>[] tree;

    static class Node{
        int n; int w;

        public Node(int n, int w) {
            this.n = n;
            this.w = w;
        }
    }

    static int dfs(int node) {
        if (tree[node].isEmpty()) return 0;
        int ret = 0;
        int sc = 0;
        int tmp = 0;
        for (Node child : tree[node]) {
            tmp = dfs(child.n) + child.w;
            if (tmp > ret) {
                sc = ret;
                ret = tmp;
            }
            else if (tmp > sc) sc = tmp;
        }

        if (ret + sc > res) res = ret + sc;
        return ret;
    }

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n+1];
        for (int i = 0; i < n + 1; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            stz = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(stz.nextToken());
            int v = Integer.parseInt(stz.nextToken());
            int w = Integer.parseInt(stz.nextToken());
            tree[u].add(new Node(v, w));
        }

        dfs(1);
        System.out.println(res);

    }


}

/*TC
5
1 2 1
1 3 1
2 4 100
2 5 100
 */