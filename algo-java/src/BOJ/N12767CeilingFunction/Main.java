package BOJ.N12767CeilingFunction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int n,k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        k = Integer.parseInt(stz.nextToken());
        Set<String> set = new HashSet<>();
        List<Tree> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Tree t = new Tree();
            stz = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++) {
                t.add(Integer.parseInt(stz.nextToken()));
            }
            t.shape.sort(Comparator.comparingInt(v->v));
            set.add(t.shape());
        }
        System.out.println(set.size());
    }


    static class Tree {
        Node root;
        List<Integer> shape = new ArrayList<>();

        void add(int v) {
            root = add(root, v, 1);
        }

        Node add(Node node, int v, int idx) {
            if (node == null) {
                shape.add(idx);
                return new Node(v);
            }
            if (v < node.v) {
                node.l = add(node.l, v, idx * 2);
            }
            if (v > node.v) {
                node.r = add(node.r, v, idx * 2 + 1);
            }
            return node;
        }
        String shape() {
            StringBuilder sb = new StringBuilder();
            shape(sb, root);
            return sb.toString();
        }

        void shape(StringBuilder sb, Node node) {
            if (node == null) {
                sb.append('n');
                return;
            }
            sb.append('o');
            shape(sb,node.l);
            shape(sb, node.r);
        }
    }

    static class Node {
        int v;
        Node l,r;

        public Node(int v) {
            this.v = v;
        }
    }
}
