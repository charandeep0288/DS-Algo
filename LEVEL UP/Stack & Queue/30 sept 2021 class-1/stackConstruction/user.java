public class user {
    
    public static void main(String[] args) throws Exception { // yaa fn bhi infected hoo sakda hai, so then we write -> throws Exception
        stack st = new stack(100);

        // st.initilize(size); // same folder mai iss lia access kar paa raha hai iss case mai 

        System.out.println(st.peek());
    }
}

// javac user.java && java user