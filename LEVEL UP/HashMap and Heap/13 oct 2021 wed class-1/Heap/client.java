public class client {
    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, -2, -3, -4, 5, 6, 7, 8, 9, 22, 11, 13, 14 };
        heap hp = new heap(arr); // true -> maxHeap, false -> minHeap

        while(hp.size() != 0) {
            System.out.print(hp.remove() + " ");
        }
    }
}

// javac client.java && java client > output.txt