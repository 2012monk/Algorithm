package BOJ.N10819차이를최대로;

import static java.lang.System.in;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer stz;
        n = Integer.parseInt(br.readLine());
        stz = new StringTokenizer(br.readLine());
        numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(stz.nextToken());
        }
        Arrays.sort(numbers);
        int[] forward = new int[10], backward = new int[10];
        for (int i = 0, j = 1; i < n / 2 + n % 2; i++, j += 2) {
            forward[j] = numbers[i];
            forward[j + 1] = numbers[n - i - 1];
            backward[j] = numbers[n - i - 1];
            backward[j + 1] = numbers[i];
        }
        forward[0] = forward[n];
        forward[n] = 0;
        backward[0] = backward[n];
        backward[n] = 0;
        System.out.println(Math.max(sum(forward), sum(backward)));

    }

    private static int sum(int[] a) {
        int ret = 0;
        for (int i = 0; i < n - 1; i++) {
            ret += Math.abs(a[i] - a[i + 1]);
        }
        return ret;
    }
}
