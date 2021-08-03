import java.util.LinkedList;

public class queueUsingJavaLL {
    
    public static class queue{
        private LinkedList<Integer> ll = new LinkedList<>();

        public int size(){
            return ll.size();
        }

        public boolean isEmpty(){
            return this.ll.isEmpty();
        }

        public void add( int data ){
            this.ll.addLast(data);
        }

        public int peek(){
            return ll.getFirst();
        }

        public int remove(){
            return this.ll.removeFirst();
        }
    }

    public static void main(String[] args){
        queue que = new queue(); 

        que.add(10);
        que.add(20);
        System.out.println(que.remove()); // 10
        que.add(30);
        System.out.println(que.remove()); // 20
        que.add(40);
        que.add(50);
        que.add(60);

        while( que.size() != 0 ){
            System.out.println(que.remove()); // 30 40 50 60
        }
    }
}

// javac queueUsingJavaLL.java && java queueUsingJavaLL 
