/*
 * Name: THANH NGUYEN
 * PID:  A15692943
 */

import java.util.*;

/**
 * @author THANH NGUYEN
 * @since 05/16/2020
 * @param <T> Generic type
 */
public class dHeap<T extends Comparable<? super T>> implements dHeapInterface<T> {

    private T[] heap; // heap array
    private int heapSize;
    private int d; // branching factor
    private int nelems; // number of elements
    private boolean isMaxHeap; // boolean to indicate whether heap is max or min

    private static final int BINARY = 2;
    private static final int DEFAULT_CAP = 6;

    /**
     * Initializes a binary max heap with capacity = 6
     */
    @SuppressWarnings("unchecked")
    public dHeap() {
        /* TODO */
        this(BINARY, DEFAULT_CAP, true);
        nelems = 0;
    }

    /**
     * Initializes a binary max heap with a given initial capacity.
     *
     * @param heapSize The initial capacity of the heap.
     */
    @SuppressWarnings("unchecked")
    public dHeap(int heapSize) {
        /* TODO */
        this(BINARY, heapSize, true);
    }

    /**
     * Initializes a d-ary heap (with a given value for d), with a given initial
     * capacity.
     *
     * @param d         The number of child nodes each node in the heap should have.
     * @param heapSize  The initial capacity of the heap.
     * @param isMaxHeap indicates whether the heap should be max or min
     * @throws IllegalArgumentException if d is less than one.
     */
    @SuppressWarnings("unchecked")
    public dHeap(int d, int heapSize, boolean isMaxHeap) throws IllegalArgumentException {
        /* TODO */
        this.heapSize = heapSize;
        heap = (T[]) new Comparable[heapSize];
        this.d = d;
        isMaxHeap = true;
        nelems = 0;
    }

    /**
     * getting the number of elements currently in the heap
     *
     * @return an int; number of element in the heap
     */
    @Override
    public int size() {
        /* TODO */
        return nelems;
    }

    /**
     * @param data
     * @throws NullPointerException
     */
    @Override
    public void add(T data) throws NullPointerException {
        /* TODO */
        if (data == null) {
            throw new NullPointerException();
        } else if (nelems < heap.length) {
            this.heap[nelems] = data;
            bubbleUp(nelems);
            nelems++;
        } else {
            //resize heap
            this.resize();
            heap[nelems] = data;
            nelems++;
            bubbleUp(nelems - 1);
        }
    }

    @Override
    public T remove() throws NoSuchElementException {
        /* TODO */
        if (nelems == 0) {
            throw new NoSuchElementException();
        }
        heap[0] = heap[nelems - 1];
        nelems--;
        trickleDown(0);
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void clear() {
        /* TODO */
        nelems = 0;
    }

    public T element() throws NoSuchElementException {
        /* TODO */
        if (nelems == 0) {
            throw new NoSuchElementException();
        }
        return heap[0];
    }

    private void trickleDown(int index) {
        /* TODO */
        int childIdx = d * index + 1;
        T value = heap[index];

        while (childIdx < nelems) {
            //find max among the node and all the node's children
            T max = value;
            int maxIdx = -1;
            for (int i = 0; i < d && i + childIdx < nelems; i++) {
                if (heap[i + childIdx].compareTo(max) > 0) {
                    max = heap[i + childIdx];
                    maxIdx = i + childIdx;
                }
            }
            if (max != value) {
                T temp = heap[index];
                heap[index] = heap[maxIdx];
                heap[maxIdx] = temp;
                index = maxIdx;
                childIdx = d * index + 1;
            }
        }
    }

    private void bubbleUp(int index) {
        /* TODO */
        while (index > 0) {
            int parentIdx = parent(index);
            if (heap[index].compareTo(heap[parentIdx]) > 0) {
                T temp = heap[parentIdx];
                heap[parentIdx] = heap[index];
                heap[index] = temp;
                index = parentIdx;
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        /* TODO */
        T[] heapCopy = (T[]) new Comparable[heapSize * BINARY];
        System.arraycopy(heap, 0, heapCopy, 0, nelems);
        heap = heapCopy;
    }

    private int parent(int index) {
        /* TODO */
        int parentIdx = (index - 1) / d;
        return parentIdx;
    }

    public static void main(String[] args) {
        dHeap<Integer> maxHeap1;
        dHeap<Integer> maxHeap2;
        /*dHeap<Integer> maxHeap3;*/

        maxHeap1 = new dHeap<>();
        maxHeap2 = new dHeap<>(3, 10, true);
        /*maxHeap3 = new dHeap<Integer>(4, 20, true);*/

        maxHeap1.add(9);
        maxHeap1.add(5);

        for (Integer i = 5; i < 10; ) {
            maxHeap2.add(i);
            i += 5;
        }

        /*for (Integer i = 3; i < 30; ) {
            maxHeap3.add(i);
            i += 2;
        }*/

        System.out.println(maxHeap1 .element());
    }
}
