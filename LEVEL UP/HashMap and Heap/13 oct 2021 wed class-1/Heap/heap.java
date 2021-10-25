import java.util.ArrayList;

public class heap {
    // khud kaa data type -> 
    private ArrayList<Integer> arr;
    // private int size = 0;

    public heap() {
        this.arr = new ArrayList<>();
    }

    // lagti time complexity -> O(n + nLog(n)) hai --> real complexity -> O(n)  (we need to proof this)
    public heap(int[] arr) { // SET OF DATA -> ARRAY KO HEAP MAI CONVERT KARNA HAI , but PQ mai 
        this(); // constructor chaining
        for(int ele : arr) // joo user naa array dya usa koi change nahi kar raha 
            this.arr.add(ele);

        for(int i = this.arr.size() - 1 ; i >= 0 ; i++) // ArrayList koo last se traverse karo, & downHeapify() fn call kar doo iss pura ArrayList pai
            downHeapify(i);
    }

    // O(1)
    // yaa fn 'x' kaa bara mai bata raha hai -> ki woo 'x' ki value badri hai ki nahi 'y' ki value se
    public boolean compareTo(int x, int y) { // this -> x, other -> y
        return this.arr.get(x) > this.arr.get(y); // this kaa respact mai answer nikal raha hai other kaa sath
    }

    // O(1)
    private void swap(int x, int y) {
        int v1 = this.arr.get(x); // value 1
        int v2 = this.arr.get(y); // value 2

        this.arr.set(x, v2);
        this.arr.set(y, v1);
    }

    // Log(n) 
    private void downHeapify(int pi) { // pi -> parent index
        int lci = 2 * pi + 1; // left child index
        int rci = 2 * pi + 2; // right child index
        int maxIdx = pi; 

        if(lci < arr.size() && compareTo(lci, maxIdx))
            maxIdx = lci;

        if(rci < arr.size() && compareTo(rci, maxIdx)) 
            maxIdx = rci;

        if(pi != maxIdx) {
            swap(maxIdx, pi);
            downHeapify(maxIdx);
        }
    }

    // Log(n)
    private void upheapify(int ci) { // child index
        int pi = (ci - 1) / 2; // parent index
        if(pi >= 0 && compareTo(ci, pi)) {
            swap(ci, pi);
            upheapify(pi);
        }
    }

    // O(1)
    public int size() {
        return this.arr.size();
    }

    // Log(n) 
    public int remove() {
        int re = this.arr.get(0); // remove element
        
        swap(0, arr.size() - 1);
        this.arr.remove(this.arr.size() - 1);
        downHeapify(0);
        
        return re;
    }

    // Log(n) 
    public void add(int data) {
        this.arr.add(data);
        upheapify(this.arr.size() - 1);
    }

    // O(1) 
    public int peek() {
        return this.arr.get(0);
    }
}