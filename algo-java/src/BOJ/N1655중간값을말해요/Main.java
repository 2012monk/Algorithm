package BOJ.N1655중간값을말해요;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Heap min = new Heap(n, Comparator.comparingInt(v -> v)),
            max=  new Heap(n, Comparator.comparingInt(v -> -v));
        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(br.readLine());
            if (max.size() > min.size()) min.add(v);
            else max.add(v);

            if (!max.isEmpty() && !min.isEmpty() && max.peek() > min.peek()) {
                int t = max.poll();
                max.add(min.poll());
                min.add(t);
            }
            sb.append(max.peek()).append('\n');
        }
        System.out.println(sb);
    }


    static class Heap {
        int[] a;
        int size;
        Comparator<Integer> comp;

        public Heap(int size, Comparator<Integer> comp) {
            this.a = new int[size];
            this.comp = comp;
        }

        boolean isEmpty() {
            return size == 0;
        }

        void add(int v) {
            int i = ++size;
            a[i] = v;
            while (i > 1) {
                int p = a[i >> 1];
                int c = a[i];
                if (!prior(c, p)) break;
                a[i] = p;
                a[i >>= 1] = c;
            }
        }
        int peek() {
            return a[1];
        }
        int size() {
            return size;
        }

        int poll() {
            if (size == 0) return 0;
            int r = a[1];
            a[1] = a[size--];
            int i = 1;
            while ((i <<= 1) <= size) {
                if (i < size && prior(a[i + 1], a[i])) i++;
                int p = a[i >> 1];
                int c = a[i];
                if (!prior(c, p)) break;
                a[i >> 1] = c;
                a[i] = p;
            }
            return r;
        }

        boolean prior(int a, int b) {
            return comp.compare(a, b) < 0;
        }
    }
}
