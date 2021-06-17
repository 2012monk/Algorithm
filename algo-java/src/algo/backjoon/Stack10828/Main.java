package algo.backjoon.Stack10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 정수를 사용하는 스택 구현
 */
public class Main {

    private static final AtomicInteger pointer = new AtomicInteger(0);
    private static int[] arr = new int[20];
    private static boolean isEmpty = true;

    public static int pop() {
        if (isEmpty) {
            return -1;
        }

        int currentPos = pointer.get() - 1;
        if (currentPos == 0) {
            isEmpty = true;
        }
        pointer.decrementAndGet();
        return arr[currentPos];
    }

    public static int size() {
        return pointer.get();
    }

    public static int empty() {
        if (isEmpty) {
            return 1;
        }
        return 0;
    }

    public static int top() {
        if (isEmpty) {
            return -1;
        }
        return arr[pointer.get() - 1];
    }

    public static boolean push(int next) {
        int nextPos = pointer.get();
        if (nextPos >= arr.length) {
            int[] temp = new int[arr.length + 20];

            System.arraycopy(arr, 0, temp, 0, arr.length);
            arr = temp;
        }
        isEmpty = false;
        arr[nextPos] = next;
        pointer.incrementAndGet();
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());

        for (int i = 0; i < size; i++) {
            String cmd = reader.readLine();
            switch (cmd) {
                case "top":
                    System.out.println(top());
                    break;

                case "size":
                    System.out.println(size());
                    break;
                case "empty":
                    System.out.println(empty());
                    break;
                case "pop":
                    System.out.println(pop());
                    break;
                default:
                    int n = Integer.parseInt(cmd.split(" ")[1]);
                    push(n);
                    break;
            }
        }
    }

    public static void test(String in) {
        String[] input = in.split("\n");
        int size = Integer.parseInt(input[0]);
        for (int i = 0; i < size; i++) {
            String cmd = input[i + 1];
            switch (cmd) {
                case "top":
                    System.out.println(top());
                    break;

                case "size":
                    System.out.println(size());
                    break;
                case "empty":
                    System.out.println(empty());
                    break;
                case "pop":
                    System.out.println(pop());
                    break;
                default:
                    int n = Integer.parseInt(cmd.split(" ")[1]);
                    push(n);
                    break;
            }
        }
    }


}
