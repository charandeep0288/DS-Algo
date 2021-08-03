import java.util.LinkedList;

public class stackUsingJavaLL{

    // class static declare ki hai kio ki main() fn isi file vali class mai hai, naa ki kisi aur .java file(client.java) mai 
    // main() fn se sirf static fn koo call lagi jaa sakti hai
    public static class stack{

        private LinkedList<Integer> ll = new LinkedList<>();

        // Stack<Integer> st = new Stack<>();

        public int size(){
            return this.ll.size();
        }

        public boolean isEmpty(){
            return this.ll.isEmpty();
        }

        public void push( int data ){
            this.ll.addFirst(data);
        }

        public int top(){
            return this.ll.getFirst();
        }

        public int pop(){
            return this.ll.removeFirst();
        }

    }

    public static void main(String[] args){
        stack st = new stack();

        st.push(10);
        st.push(20);
        System.out.println(st.pop()); // 20
        st.push(30);
        System.out.println(st.pop()); // 30
        st.push(40);
        st.push(50);
        st.push(60);

        while( st.size() != 0 ){
            System.out.println(st.pop()); // 60 50 40 10
        }
    }
}

// javac stackUsingJavaLL.java && java stackUsingJavaLL