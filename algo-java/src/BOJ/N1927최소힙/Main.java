package BOJ.N1927최소힙;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Heap h = new Heap(n);
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            if (k == 0) {
                sb.append(h.pop()).append('\n');
                continue;
            }
            h.push(k);
        }
        System.out.println(sb);
    }

    static class Heap {
        int[] heap;
        int size;

        public Heap(int size) {
            heap = new int[size];
        }

        void push(int v) {
            int i = ++size;
            while (i != 1 && v < heap[i / 2]) heap[i] = heap[i/=2];
            heap[i] =v;
        }

        int pop() {
            if (size == 0) return 0;
            int r = heap[1];
            heap[1] = heap[size--];
            int p = 1, c;
            while (true) {
                c = p * 2;
                if (c < size && heap[c] > heap[c + 1]) c++;
                if (c > size || heap[c] > heap[p]) break;
                swap(c, p);
                p = c;
            }
            return r;
        }

        void swap(int i, int j) {
            int tmp = heap[i];
            heap[i] =heap[j];
            heap[j] = tmp;
        }
    }


}
