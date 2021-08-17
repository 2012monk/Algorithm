package dataStructure.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Heap {

    private final int[] array;

    private int size = 1;

    public Heap() {
        int initSize = 200;
        this.array = new int[initSize];
    }

    public Heap(int size) {
        this.array = new int[size];
    }

    public int size() {
        return this.size - 1;
    }

    private void percolateUp() {
        int i = size();
        int parent = i / 2;
        while (parent > 0) {
            if (array[i] < array[parent]) {
                int t = array[i];
                array[i] = array[parent];
                array[parent] = t;
            }
            i = parent;
            parent = i / 2;
        }
    }

    public void insert(int item) {
        if (size == array.length) return;
        array[size++] = item;
        percolateUp();

    }

    private void print() {
        for (int i = 1; i < array.length; i++) {
            System.out.print("index = " + i + " val  " + array[i] + "  ");
        }
        System.out.println();
        int a[]= new int[2];
    }

    public int extract() {
        print();
        int result = array[1];
        array[1] = array[--size];
        array[size] = 0;
        percolateDown(1);

        return result;
    }

    private void percolateDown(int i){
        int left = i * 2;
        int right = i * 2 + 1;
        int smallest = i;
        if (left <= size() && array[left] < array[smallest]) smallest = left;
        if (right <= size() && array[right] < array[smallest]) smallest = right;

        if (smallest != i) {
            int t = array[i];
            array[i] = array[smallest];
            array[smallest] = t;
            percolateDown(smallest);
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap(10);
        heap.insert(4);
        heap.insert(1);
        heap.insert(8);
        System.out.println("1 heap.extract() = " + heap.extract());
        System.out.println("2 heap.extract() = " + heap.extract());
        System.out.println("3 rheap.extract() = " + heap.extract());
    }


}
