package BOJ.N1914하노이탑;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int[] num, carry;

    static void hanoi(int l, int r, int n) throws IOException {
        if (n == 0) return;
        hanoi(l, 6-l-r, n - 1);
        bw.write(l+" "+r+"\n");
        hanoi(6-l-r,r,n-1);

    }

    static void big(int n) throws IOException {
        num = new int[32];
        carry = new int[34];
        num[31] = 2;
        for (int i = 0; i < n-1; i++) {
            Arrays.fill(carry, 0);
            for (int j = 31; j >= 0; j--) {
                int tmp = num[j]*2 + carry[j + 1];
                num[j] = tmp%10;
                carry[j] = tmp/10;
            }
        }
        int start = 0;
        for (int i = 0; i < 32; i++) {
            start = i;
            if (num[i] != 0) break;
        }
        num[31]--;
        for (int i = start; i < 32; i++) {
            bw.write(String.valueOf(num[i]));
        }
        bw.write("\n");
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        BigInteger r = BigInteger.valueOf(2);
        bw.write(String.valueOf(r.pow(N).add(new BigInteger(String.valueOf(-1)))));
        bw.write("\n");
        big(N);
        if (N <= 20) hanoi(1, 3, N);
        bw.flush();
    }


}
