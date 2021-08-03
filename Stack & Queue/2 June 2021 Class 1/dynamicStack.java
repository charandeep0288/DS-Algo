public class dynamicStack extends stack{

    // by default, all member function & member are public in java

    // super ik medium hia joo parent class mai laa kai jata child class se 
    // super ka matlab parent ki class mai chala jaa
    // super private chod kaa sari chiza inherite kar lata hai
    public dynamicStack(){
        super(); 
    }

    public dynamicStack( int data ){
        super(data);
    }

    // 2 cases hoo sakta hai override ka case mai
    // 1) fn galat call kia hai
    // 2) override galat lagia hai
    //lakin iss case mai mai override tho karna chata hu, tho fn ka name galat likh hoo gia(signatute galat likh dia)
    // @Override
    // public void push() { // argument mai kuch nahi pass kia tho yaa apna parent se alag hai tho "Hi" print hoo jai gaa
    //     System.out.println("hi");
    // }

    // stack full hona pai duble size ka array create hota hai, woo bhi kabi kabi jab double size ka created array full hota hai -------- GP mai grow karta hai size
    @Override // insure that yaa function joo hamna likha hia woo parent class mai fn hai ki nahi, agar nahi hai tho error throw kar dai gaa
    public void push( int data ) throws Exception{
        // System.out.println("Hi");
        // System.out.println(super.maxSize);
        // super.push(data); // parent class ka push() fn ko call kia 

        if( super.size() == super.maxSize() ){
            int[] temp = new int[this.size()]; // super.size()
            int idx = super.size() - 1;

            while( super.size() != 0 ) 
                temp[idx--] = super.pop();
            
            super.initialize( super.maxSize() * 2 ); // double size kar dia stack kaa

            for( int ele : temp )
                super.push(ele);
        }

        super.push(data);
    }

}


// // function overloading => fn with same name but with different types or number of arguments 
    // public void push(){

    // }

    // public void push( int data ){

    // }

    // public void push( long data ){
        
    // }

    // public void push( String data ){
        
    // }

    // public void push( char data ){
        
    // }

