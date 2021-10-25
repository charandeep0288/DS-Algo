import java.util.ArrayList;

public class hashmap {
    
    // yaa Node class ko bahar likh diya taki linkedlist & hashmap class dono isa use kar pai
    private class Node {
        Integer key = 0; // Integer kaa is liya banya hai taki HashCode generate kar pai iska hum
        Integer value = 0;
        Node next = null;

        Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    // 1
    public class linkedlist {
    
        private Node head = null;
        private Node tail = null;
        private int noOfElements = 0;

        // It is good practice to create a constructor of this LL class.
        public linkedlist() {
            this.head = this.tail = null;
            this.noOfElements = 0;

        }
    
        public int size() {
            return this.noOfElements;
        }

        public void addLast(Node node) {
            if(this.head == null) 
                this.head = this.tail = node;
            else {
                this.tail.next = node;
                this.tail = node;
            }

            this.noOfElements++;
        }

        public int getFirst() {
            return this.head.key;
        }

        public Node removeFirst() {
            Node node = this.head;
            if(this.noOfElements == 0)
                this.head = this.tail = null;
            else {
                this.head = node.next;
                node.next = null;
            }

            this.noOfElements--;
            return node;
        }
    }


    // 'containers' bol loo yaa fir 'bucket' bol loo
    private linkedlist[] containers; // LL type ka contianer banya hai
    private int sizeOfHM = 0; // size of hashmap

    public void assignValues(int size) {
        containers = new linkedlist[size]; // Array ko memory assign kar raha hai
        for(int i = 0 ; i < size ; i++) { // LL ko memory allocate kar raha hai
            containers[i] = new linkedlist();
        }
    }

    public hashmap() { // constructor banana jaruri hai joo humari LL and array koo memory allocate kara gaa
        assignValues(10);
    }

    // 12
    public String display() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int count = 0; // yaa count iss liya rakhna padhra muja taki mai comma (,) vala kam kar pao 
        for(int i = 0 ; i < this.containers.length ; i++) { 
            linkedlist group = this.containers[i];
            int size = group.size();

            while(size-- > 0) {
                Node node = group.removeFirst();
                sb.append("{" + node.key + "=" + node.value + "}");
                count++;

                if(count != sizeOfHM) 
                    sb.append(",");

                group.addLast(node);
            }
        }

        sb.append("]");
        return sb.toString();
    }
 
    // 11
    public void rehash() {
        linkedlist[] backup = this.containers;
        assignValues(2 * this.containers.length);

        for(int i = 0 ; i < backup.length ; i++) {
            linkedlist group = backup[i];
            int size = group.size();

            while(size-- > 0) {
                Node node = group.removeFirst();
                put(node.key, node.value);
            }
        }
    }

    // 10
    public void put(Integer key, Integer value) {
        boolean isKey = containsKey(key);
        linkedlist group = group(key);
        if(isKey) {
            group.head.value = value;
        } else {
            group.addLast(new Node(key, value));
            this.sizeOfHM++;

            double lambda = (group.size() / this.containers.length * 1.0);
            if(lambda > 0.75) {
                rehash();
            }
        }
    }

    // 9
    public void putIfAbsent(Integer key, Integer defaultValue) {
        boolean isKey = containsKey(key);
        if(!isKey)
            put(key, defaultValue);
    }

    // 8
    public ArrayList<Integer> keySet() {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < this.containers.length ; i++) {
            linkedlist group = this.containers[i];
            int size = group.size();

            while(size-- > 0) {
                Node node = group.removeFirst();
                list.add(node.key);
                group.addLast(node);
            }
        }

        return list;
    }

    // 7
    public Integer remove(Integer key) {
        boolean isKey = containsKey(key);
        linkedlist group = group(key);
        if(!isKey) 
            return null;

        // jis key ko remove karna hai humna uspa containsKey() fn ko call kiya hua hai tho -> joo value remove karna hai woo humara uss group ka starting mai aa jai gii tho hum fir uspa removeFirst() fn call kar dai gaa
        Node node = group.removeFirst(); 
        this.sizeOfHM--;
        return node.key;
    }

    // 6
    public Integer getOrDefault(Integer key, Integer defaultValue) {
        Integer value = get(key);
        return value != null ? value : defaultValue;
    }

    // 5
    public Integer get(Integer key) {
        boolean isKey = containsKey(key); 
        linkedlist group = group(key);

        return isKey ? group.head.value : null;
    }

    // 4
    public boolean containsKey(Integer key) {
        linkedlist group = group(key);
        int size = group.size();

        while(size-- > 0) {
            if(group.getFirst() == key) 
                return true;

            // iss method ka use karka hum LL ko iterate kar raha hai iss liya hum -> iss liya huma kabhi HashMap mai sorted data nahi mila gaa -> aur joo element dund raha honga woo LL ka starting mai hoga (ofcouse hum HashTree ka use karka isa sorted bhi rakh sakta hai)
            group.addLast(group.removeFirst()); // LL pai traverse kar raha hai hum iss line ki vaja se
        }

        return false;
    }

    // 3
    public linkedlist group(Integer key) {
        int code = hashCode(key);

        return this.containers[code];
    }

    // 2
    public int hashCode(Integer key) {
        int value = key.hashCode();

        return value % containers.length; // with in range hashcode value lana kaa liya hum modules kar raha hai
    }

    // NOTE -> ISI ORDER MAI HI HUM FUNCTIONS LIKHA GAI NICH SA UPAR JOO NUMBERING GIVEN HAI HUMA
}
