package OOD;

//offer()
//        peek()
//        poll()
//        update()


import java.util.Arrays;

public class MinHeap {
    private int[] arr;
    private static final int DEFAULT_SIZE = 10;
    private int size;

    public MinHeap(int capacity) {
        //todo
        if (capacity <= 0) throw new IllegalArgumentException("");
        arr = new int[capacity];
        size = 0;
    }

    public MinHeap() {
        this(DEFAULT_SIZE);
    }

    public MinHeap(int[] array) {
        if (array == null || array.length == 0) throw new IllegalArgumentException();
        arr = Arrays.copyOf(array, array.length * 2);
        size = array.length;
        heapify();
    }

    public void offer(int val) {
        if (size == arr.length) {
            extend();
        }
        arr[size] = val;
        size++;
        bubbleUp(size - 1);
    }

    public int peek() {
        return arr[0];
    }

    public int poll() {
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        int tmp = arr[0];
        arr[0] = arr[size - 1];
        size--;
        bubbleDown(0);
        return tmp;
    }

    public void update(int val, int idx) {
        if (idx < 0 || idx >= size) {
            throw new IllegalArgumentException();
        }
        int tmp = arr[idx];
        arr[idx] = val;
        if (val > tmp) {
            bubbleDown(idx);
        }
        if (val < tmp) {
            bubbleUp(idx);
        }
    }

    private void bubbleUp(int idx) {
        while (idx > 0) {
            int parent = (idx - 1) / 2;
            if (arr[parent] > arr[idx]) {
                swap(idx, parent);
            }else {
                break;
            }
            idx = parent;
        }
    }

    private void bubbleDown(int idx) {
        while (idx <= (size - 2 / 2 )) { //todo
            int left = idx * 2 + 1;
            int right = idx * 2 + 2;
            int swapIdx = left;
            if (right < size && arr[right] < arr[left]) {
                swapIdx = right;
            }
            if (arr[idx] > arr[swapIdx]) {
                swap(idx, swapIdx);
            } else {
                break;
            }
            idx = swapIdx;
        }
    }

    private void heapify() {
        for (int i = (size - 2) / 2; i >= 0; i--) {
            bubbleDown(i);
        }
    }

    private void extend(){
        int[] newArray = Arrays.copyOf(arr, arr.length * 2);
        arr = newArray;
    }

    private void swap(int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
