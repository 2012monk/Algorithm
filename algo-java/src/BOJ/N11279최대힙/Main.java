package BOJ.N11279최대힙;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n, size = 0;
    static int[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=  new StringBuilder();
        n = Integer.parseInt(br.readLine());
        a = new int[n];

        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            if (k == 0) {
                sb.append(pop()).append('\n');
                continue;
            }
            push(k);
        }
        System.out.println(sb);
    }

    static void push(int v) {
        int i = ++size;
        while (i != 1 && v > a[i / 2]) {
            a[i] = a[i /= 2];
        }
        a[i] = v;
    }

    static int pop() {
        if (size == 0) return 0;
        int ret = a[1];
        a[1] = a[size--];
        int child, parent = 1;

        while (true) {
            child = parent * 2;
            if (child + 1 <= size && a[child] < a[child + 1]) child++;
            if( child > size || a[child] < a[parent]) break;
            swap(child, parent);
            parent = child;
        }

        return ret;
    }

    private static void swap(int A, int B) {
        int tmp = a[A];
        a[A] = a[B];
        a[B] = tmp;
    }
}
