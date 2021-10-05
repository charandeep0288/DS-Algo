public class stack{

    private int[] arr;
    private int tos; // top of the stack
    private int size; // size of the stack
    private int maxSize; // maximum size of the stack
    // protected int maxSize; 
 
    // protected => because we want to use it in dynamic stack class
    protected void initialize( int len ){
        this.arr = new int[len];
        this.tos = -1;
        this.size = 0;
        this.maxSize = len;
    }

    // default constructor
    public stack(){
        initialize(5); // intial size stack kaa hamna 5 dia hai
    }

    // parameterised constructor
    public stack( int size){
        initialize(size);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for( int i = tos ; i >= 0 ; i-- )
        {
            sb.append(this.arr[i]);
            if( i != 0 )
                sb.append(", ");
        }
        sb.append("]");

        return sb.toString();
    }

    private void stackIsEmptyException() throws Exception{
        if( this.size == 0 )
            throw new Exception("stackIsEmptyException: -1");
    }

    private void stackIsOverflowException() throws Exception{
        if( this.size == this.maxSize )
            throw new Exception("stackIsOverflowException: -1");
    }

    // O(1)
    public int size(){
        return this.size;
    }
    
    public int maxSize(){ // for dynamic stack
        return this.maxSize;
    }

    // O(1)
    public boolean isEmpty(){
            return this.size == 0;
    }

    private void push_( int data ){
        arr[++this.tos] = data;
        this.size++;
    }

    // O(1)
    public void push(int data) throws Exception{
        stackIsOverflowException();
        // if( this.size == this.maxSize)
            // return; 
        push_(data);
    }


    // O(1)
    public int top() throws Exception{

        // try{
        //     stackIsEmptyException();
        //     return this.arr[this.tos];
        // }catch(Exception e){
        //     System.out.println("Hi I'm resolved");
        // }
        // return -1;

        stackIsEmptyException();

        // if( this.size == 0 )
            // throw new Exception("stackIsEmptyException: -1");
        
        return this.arr[this.tos];
    }


    private int pop_()
    {
        int data = arr[this.tos]; // data joo remove karna hai
        arr[this.tos--] = 0;
        this.size--;

        return data; // removed element from stack
    }

    // O(1)
    public int pop() throws Exception{
        stackIsEmptyException();
        // if( this.size == 0 )
        //     throw new Exception("stackIsEmptyException: -1");

        return pop_();    
    }
}