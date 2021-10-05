// dono file same folder mai hai, iss lia hum 'stack' wali class ko extends kar paa raha hai iss class mai 'DynamicStack'  
public class DynamicStack extends stack {
    
    DynamicStack(int size){
        super(size); // parent class ka constructor ko call kar raha hai
    }

    DynamicStack(){
        super();
    }

    // Dynamic stack mai huma sirf push wala fn ko hi override karna ki jarurat hai, tho hum sirf push wala fn ko hi override kara gai bas 


    @Override // yaa ensure kar raha hia ki joo yaa fn hai parent class mai bhi same signature ka sath exist karta hai ki nahi, 
    // agar yaa nahi likha gai tho koi dikat nahi hai but java yaa samja gaa ki yaa 'DynamicStack' class ka fn hai naa ki parent class "stack" kaa
    public void push(int data) throws Exception{
        
    }
}
