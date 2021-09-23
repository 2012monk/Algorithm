package BOJ.N2263트리의순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;

    static int N;
    static int[] postorder;
    static Map<Integer, Integer> indices = new HashMap<>();
    static StringBuilder res = new StringBuilder();

    static void recover(int inStart, int inEnd,int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) return;
        int e = postorder[postEnd];
        int idx = indices.get(e);
        res.append(e).append(" ");
        recover(inStart, idx-1, postStart, postStart + (idx-inStart) - 1);
        recover( idx+1, inEnd, postStart + (idx-inStart),postEnd -1);
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        postorder = new int[N+1];
        stz = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            indices.put(Integer.parseInt(stz.nextToken()), i);
        }

        stz = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            postorder[i] = Integer.parseInt(stz.nextToken());
        }

        recover(0, N-1,0, N-1);
        System.out.println(res);
    }


}

/*TC
9
3 2 5 4 6 1 7 9 8
3 5 6 4 2 9 8 7 1

1 2 3 4 5 6 7 8 9

6
6 5 4 3 2 1
6 5 4 3 2 1

1 2 3 4 5 6

21
1 3 2 7 4 6 5 15 11 9 12 8 13 10 14 21 19 17 20 16 18
1 2 3 4 5 6 7 11 12 9 13 14 10 8 15 19 20 17 18 16 21

21 15 7 3 1 2 6 4 5 8 9 11 12 10 13 14 16 17 19 20 18
 */