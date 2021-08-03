import java.util.LinkedList;

public class client {
    
    public static void fun(){

    }


    public static void stackTest() throws Exception{
        // stack st = new stack();
        // System.out.println(st.top());
        // System.out.println(st.pop());
        

        // for( int i = 0 ; i < 5 ; i++ ){
        //     st.push(10);
        // }


        // stack st = new stack(3);
        // st.push(10);
        // // System.out.println(st.top());
        // st.push(100);
        // st.push(1000);
        // System.out.println(st.pop());
        // System.out.println(st.top());
        // st.push(1002);
        // System.out.println(st.top());


        stack st1 = new stack(10);
        for( int i = 1 ; i <= 10 ; i++ )
            st1.push(i * 10);

        System.out.println(st1);
        while( st1.size() != 5 ){
            System.out.println(st1.pop());
        }    
    }

    public static void stackBehaviorUsingLL(){
        LinkedList<Integer> st = new LinkedList<>();

        for( int i = 1 ; i <= 10 ; i++ )
            st.addFirst(i * 10);

        while( st.size() != 0 )
            System.out.println( st.removeFirst() );

    }

    public static void queueTest_01() throws Exception{
        queue que = new queue(10); 

        for( int i = 1 ; i <= 10 ; i++ )
            que.add(i * 10);

        // while( que.size() != 0 ){
        //     System.out.println(que.remove());
        // }

        System.out.println(que);
    }

    public static void queueTest_02() throws Exception{
        queue que = new queue(4); 

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

        System.out.println(que);
    }


    // ------------------- 7 June mon -----------------
     
    public static void dynamicStackTest() throws Exception{

        dynamicStack st1 = new dynamicStack(1);
        for( int i = 1 ; i <= 100 ; i++ )
            st1.push(i * 10);

        System.out.println(st1);
        while( st1.size() != 5 ){
            System.out.println(st1.pop());
        }    
    }


    // top vala function koo call kia hai main() fn mai tho yaa main() fn bhi infected hoo gia tho throws Exception likha gai
    public static void main(String[] args) throws Exception
    {

        fun(); // iss function ko directly call laga raha hai without any object, tho isi lia hamna isa static banya hai
        
        // stackTest();

        // queueTest_01();
        // queueTest_02();

        // stackBehaviorUsingLL();

        dynamicStackTest();

    }
}


// javac client.java && java client > output.txt