package BOJ.N5904Moo게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[] seq = new int[101];

    static boolean moo(int n, int i){
        if (n <= 3) return n == 1;
        if (seq[i - 1] < n && seq[i - 1] + i + 3 >= n) return n - seq[i - 1] == 1;
        return moo(seq[i-1]>n ? n : n - seq[i-1] - i - 3, i - 1);
    }

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        seq[0] = 3;
        int i = 1;
        for (;i < 101; i++) {
            seq[i] = seq[i-1]*2+i+3;
            if (seq[i] > n) break;
        }
        System.out.println(moo(n, i)?"m":"o");
    }
}
