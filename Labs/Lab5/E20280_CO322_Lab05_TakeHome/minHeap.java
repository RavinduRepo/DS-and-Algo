// Lab 05 – Trees 
// E/20/280
// Task 2


public class minHeap {
    private int[] heap;
    private int size;
    private int maxSize;



    public minHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        this.heap = new int[maxSize];

    }

    private int parent(int pos) {
        return (pos - 1) / 2;

    }

    private int leftChild(int pos) {
        // calculaiting left child possition
        return (2 * pos) + 1;  
    }

    private int rightChild(int pos) {
        // calculaiting right child possition
        return (2 * pos) + 2;
    }

    private boolean isLeaf(int pos) {
        // check if is a leaf
        return pos >= (size / 2) && pos < size;
    }

    private void swap(int fpos, int spos) {
        // swap two elements
        int tmp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = tmp;
    }

    private void heapifyDown(int pos) {

        // check if the node is a leaf
        if (isLeaf(pos))
            return;
        // get the left and right child
        int left = leftChild(pos);
        int right = rightChild(pos);
        int smallest = pos;

        if (left < size && heap[left] < heap[smallest])
            smallest = left;

        if (right < size && heap[right] < heap[smallest])
            smallest = right;

        if (smallest != pos) {

            swap(pos, smallest);
            heapifyDown(smallest);
        }
    }

    private void heapifyUp(int pos) {
        int current = pos;
        while (current > 0 && heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public void insert(int element) {
        if (size >= maxSize)
            return;

        heap[size] = element;
        size++;
        heapifyUp(size - 1);
    }

    public int remove() {
        if (size == 0)
            return Integer.MIN_VALUE;

        int popped = heap[0];
        heap[0] = heap[--size];
        heapifyDown(0);
        return popped;
    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Inseting elemnts to minHeap
        minHeap heap = new minHeap(15);
        heap.insert(5);
        heap.insert(3);  
        heap.insert(17); 
        heap.insert(10); 
        heap.insert(84); 
        heap.insert(19);
        heap.insert(6);  
        heap.insert(22);        
        heap.insert(9); 



        System.out.println("minHeap array:");    
        heap.printHeap();

        // print and remove the Root
        System.out.println("The Min vale is " + heap.remove());
        heap.printHeap();

        // removing all elements to see the Sorting
        System.out.println("Sorting: ");
        while (heap.size > 0) {
            System.out.print(heap.remove() + " ");
        }
    }
}
