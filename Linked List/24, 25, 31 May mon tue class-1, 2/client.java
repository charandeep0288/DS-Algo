// import java."path of the file whose features we want to access";
// OR import "";
public class client{
    public static void main(String[] args){
        
        // dono file same folder mai hai isi lia hum isa access kar paa raha hai ( inhertance hoo rahi hai )
        linkedList ll = new linkedList();
        
        // ll.size = 10; // not allowed size koo set karna 
        // System.out.println(ll.size);

        System.out.println( ll.size());
        System.out.println(ll.isEmpty());

        ll.addFirst(10);
        System.out.println(ll.getFirst());
        System.out.println(ll.size());
        ll.addLast(40);
        System.out.println(ll.removeAt(2));
        ll.addAt(1, 2);
        System.out.println(ll.getLast());
        System.out.println(ll); // ll.display();
        System.out.println(ll.getLast());
        System.out.println(ll); // ll.display();
        System.out.println(ll.removeAt(2));
        ll.addLast(50);
        ll.addAt(2, 30);
        System.out.println(ll.getFirst());
        System.out.println(ll); // ll.display();
        System.out.println(ll.getAt(3));
    }
}

// javac client.java && java client > output.txt