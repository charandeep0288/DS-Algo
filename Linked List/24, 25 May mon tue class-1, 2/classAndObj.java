import java.util.Scanner;
public class classAndObj{
  
    public static Scanner scr = new Scanner(System.in);

    // class mai kabi static nahi chalta 

    // class ko static bana doo dubara kabi class mai static use karna ki jarura nahi padra gii
    // iss wrapper class se static hata dia tho iss class ka data member & member fn class ka bahar access nahi kar sakta
    // wrapper class
    public static class phone{
        String brand;
        String model;
        String color;
        int ram;
        int storage;
        int battery;

        // joo bhi code likha unique hona chahia

        // constructor kuch return nahi karta, but In reality behind the seen this ko return karta hai 
        // public constructor ko sakta hai, lakin static nahi hona chahia 
        // private constructor ka variable siraf class ka fn hi access kar sakta hai (design pattern pai jaa raha hoo) 
        // promise kia hai ki yaa sari values isa danga hum(joo as an argument dia hia constructor mai)

    // 7:12  (String       , String      , String     , int    , int        , int ) (uniqiue combination of same number of arguments) order alag hai argument kaa, jab ki number of argements same hai nicha vala constructor se, tho yaa ik different constructor hoga
        phone(String brand, String model, String color, int ram, int storage, int battery)
        {
            // this use karna iss good practice
            // this => apna class ka local variable ki baad karta hai 
            // brand = brand // error, scope ban gia 
            this.brand = brand;
            this.model = model;
            this.color = color;
            this.ram = ram;
            this.storage = storage;
            this.battery = battery;
        }

        //   (String      , String      , int    ,  int        , int        , String   ) order alag hai argument kaa, jab ki number of argements same hai upar vala constructor se, tho yaa ik different constructor hoga
        phone(String brand, String color, int ram,  int storage, int battery, String model)
        {
            // this use karna iss good practice
            // this => apna class ka local variable ki baad karta hai 
            // brand = brand // error, scope ban gia 
            this.brand = brand;
            this.model = model;
            this.color = color;
            this.ram = ram;
            this.storage = storage;
            this.battery = battery;
        }

        // asa constructor jisma ram nahi milti(Iphone vala case mai)
        phone(String brand, String model, String color, int storage, int battery)
        {
            // this use karna iss good practice
            // this => apna class ka local variable ki baad karta hai 
            // brand = brand // error, scope ban gia 
            this.brand = brand;
            this.model = model;
            this.color = color;
            this.storage = storage;
            this.battery = battery;
        }

        // CONSTRUCTOR OVERLOADING => same name ka doo fn or constructor with same name but with different type and number of arguments
        
        // default consturctor => agar koi constructor nahi bana hua class ka andar tho default constructor chalta hai
        // har language mai default consturctor hota hai, java, C++, c

        /* default consturctor thab chalta hai jab koi hor constructor class mai nahi banaya hua,
        agar koi aur constructor likh dia tho default consturctor ka koi significance nahi rahata, 
        fir default constructor alag se likhna padrta hai */
        
        // aur joo values default constructor mai di hoti hai us ussa variable ki value intialise hoti hai
        phone(){
            this.brand = "Samsumg";
            this.ram = 10;
        }

        // {
        //     System.out.println(this); 
        // }


        
        // ArrayList ki tara display karna chata hai
        // class mai kabi static nahi chalta, siraf class ko static bana doo fir uss class ka andar ka sara data member and member fn ko access kar sakta hai
        public String display(){
            StringBuilder sb = new StringBuilder();
            sb.append("Brand: " + this.brand + "\n" );
            sb.append("Model: " + this.model + "\n" );
            if( this.color != null )sb.append("Color: " + this.color + "\n" );
            if ( this.ram != 0 ) sb.append("Ram: " + this.ram + " GB\n" );
            sb.append("Storage: " + this.storage + " GB\n" );
            sb.append("Battery: " + this.battery + " mAH\n" );
            sb.append("\n" );

            return sb.toString();
        }

        // time complexity same hi raha gii
        // mistake hona ki probality kam karta hai @Override likhna se
        // agar galti se kabi 'tostring()' mai 's' chota likh dia tho error throw kar dai gaa compiler
        // toSting() is better than display() fn
        @Override // it insure that if that function is predefined in java class
        public String toString(){  // yaa toString() fn java ka andar pahla se lika hua hai
            // return "Hello"; 
            StringBuilder sb = new StringBuilder();
            sb.append("Brand: " + this.brand + "\n" );
            sb.append("Model: " + this.model + "\n" );
            if( this.color != null )sb.append("Color: " + this.color + "\n" );
            if ( this.ram != 0 ) sb.append("Ram: " + this.ram + " GB\n" );
            sb.append("Storage: " + this.storage + " GB\n" );
            sb.append("Battery: " + this.battery + " mAH\n" );
            sb.append("\n" );

            return sb.toString(); // sb.toString() => yaa toString() StringBuilder ka fn hai
        }
    }


    public static String display( phone ph )
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Brand: " + ph.brand + "\n" );
        sb.append("Model: " + ph.model + "\n" );
        if( ph.color != null )sb.append("Color: " + ph.color + "\n" );
        if ( ph.ram != 0 ) sb.append("Ram: " + ph.ram + " GB\n" );
        sb.append("Storage: " + ph.storage + " GB\n" );
        sb.append("Battery: " + ph.battery + " mAH\n" );
        sb.append("\n" );

        return sb.toString();

    }

    
    // fn static nahi hai tho main mai isa call nahi kar sakta
    public void test()
    {

    }
    public static void main(String[] args)
    { 
        // test(); // Cannot make a static reference to the non-static method test() from the type classAndObj
        
        // phone ph1 = new phone(); // default constructor ko call kara gaa
        // // ArrayList<Integer> al = new ArrayList<>();
        // ph1.ram = 10;
        // System.out.println(ph1.ram); // 10

        phone ph2 = new phone();
        // System.out.println(ph2.ram); // 0
        // System.out.println(ph2.brand); // null
        System.out.println(ph2); // adderss of that refernce variable(object address) => classAndObj$phone@2d363fb3

        phone ph3 = new phone("one Plus", "9r 5G", "lake Blue", 128, 4500);
        // System.out.println(ph3.ram);
        // System.out.println(ph3.brand);
        // System.out.println(ph3); // classAndObj$phone@2d363fb3
        // System.out.println(display(ph3));

        // phone ph3 = new phone("one Plus", "9r 5G", "lake Blue", 8, 128, 4500);
        phone ph4 = new phone("one Plus", "9 Pro", "lake Green", 12, 256, 4500);
        // System.out.println(ph4.display());

        phone ph5 = new phone("Iphone", "12 Pro", "Mist Black", 256, 4500); // jiss constructor mai ram nahi hai usa call kara gaa
        // System.out.println(ph3.display()); // java => tostring

        // take input of for 1 lack items 
        phone[] arr = new phone[100000]; // array limit => 10^6
        for( int i = 0 ; i < 100000 ; i++ )
        {
            String brand = scr.next();
            String model = scr.next();
            String color = scr.next();
            int ram = scr.nextInt();
            int storage = scr.nextInt();
            int battery = scr.nextInt();
            arr[i] = new phone(brand, model, color, ram, storage, battery);
        }
    }
}

// javac classAndObj.java && java classAndObj

