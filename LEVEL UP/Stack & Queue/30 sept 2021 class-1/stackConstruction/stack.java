
public class stack {
    private int[] arr;
    private int tos; // top of stack
    private int NoOfElements;
    private int MaxCapacipty;

    // oop's ka concept kaa hisab se ->  same line of code ik jaga likh dia hai tho usa dubara nahi likha gai 

    stack(int size) {
        initilize(size);
    }

    // constructor chaining -> ik constructor mai dusra constructor ko call lagana 
    stack() {
        this(10); // Constructor call must be the first statement in a constructor -> koiki agar constructor mai dusra constructor call kar raha hai tho woo point humara iss constructor call sa phala hai & yaa huma allowed nahi hai for security reasons
    }

    
    // protected bana se hum yaa -> iss class mai & iski sub class mai iss fn ko use kar sakta hai extends keyword ka use karka, bahar koi banda isa use nahi kar sakta   
    protected void initilize(int size){
        this.NoOfElements = 0;
        this.MaxCapacipty = size;
        this.arr = new int[this.MaxCapacipty];
        this.tos = 0;
    }

    // Exception ----------------------------------------

    private void underflowException() throws Exception{
        if(this.NoOfElements == 0)
            throw new Exception("underflowException");
    }

    protected void overflowException() throws Exception{
        if(this.NoOfElements == this.MaxCapacipty)
            throw new Exception("overflowException");
    }

    // functions -----------------------------------------

    // for dynamic stack
    public int capacity(){
        return this.MaxCapacipty;
    }

    private void push_(int data){
        this.arr[++this.tos] = data;
        this.NoOfElements++;
    }

    // O(1)
    public void push(int data) throws Exception {
        overflowException();

        push_(data);
    }

    // O(1)
    public int peek() throws Exception {
        underflowException();

        return this.arr[this.tos];
    }

    private int pop_(){
        int rv = this.arr[this.tos]; // remove value
        this.arr[this.tos--] = 0;
        this.NoOfElements--;

        return rv;
    }

    // O(1)
    public int pop() throws Exception{
        underflowException();

        return pop_();
    }

}