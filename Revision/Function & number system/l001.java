import java.nio.BufferOverflowException;

public class l001{

    public static int DecimalToBinary(int n){

        int ans = 0;
        int pow = 1;
        int rem = 0;
        while(n != 0){
            rem = n % 2;
            ans += (rem * pow);
            n /= 2;
            pow *= 10;
        }
        // System.out.println(ans);
        return ans;
    }

    public static int BinaryToDecimal(int n){
        int ans = 0;
        int pow = 1;
        int rem = 0;
        while(n != 0){
            rem = n % 10;
            ans += (rem * pow);
            n /= 10;
            pow *= 2;
        }

        return ans;
    }

    public static int DecimalToAnyBase(int n, int b){
        int ans = 0;
        int pow = 1;
        int rem = 0;
        while(n != 0){
            rem = n % b;
            ans += (rem * pow);
            n /= b;
            pow *= 10;
        }
        return ans;
    }

    public static int AnyBaseToDecimal(int n, int b){
        int ans = 0;
        int pow = 1;
        int rem = 0;
        while(n != 0){
            rem = n % 10;
            ans += (rem * pow);
            n /= 10;
            pow *= b;
        }
        return ans;
    }

    public static int AnyBaseToAnyBase(int n, int b1, int b2){

        int anyBaseToDecimal = AnyBaseToDecimal(n, b1);
        int res = DecimalToAnyBase(anyBaseToDecimal, b2);

        return res;
    }

    public static int AnyBaseAddition(int b, int n1, int n2){
        // write ur code here
        int sum = 0, pow = 1, carry = 0;
        int ans = 0;
        while(n1 != 0 || n2 != 0 || carry != 0){
            sum = (n1 % 10) + (n2 % 10) + carry;

            n1 /= 10;
            n2 /= 10;

            int digit = sum % b;
            carry = sum / b;

            ans += (digit * pow);
            pow *= 10;
        }

        return ans;
    }


    


    public static int AnyBaseSubtraction(int b, int n1, int n2){
        // write ur code here
        
        int diff = 0, pow = 1, borrow = -1;
        int ans = 0;
        while(n1 != 0 || n2 != 0 || borrow != 0){
            diff = (n2 % 10) - (n1 % 10) + borrow;
            
            n1 /= 10;
            n2 /= 10;

            if(diff < 0){
                borrow = -1;
                diff += b;
            } else {
                borrow = 0;
            }           

            ans += (diff * pow);
            pow *= 10;
        }
        
        return ans;
    }

    public static int MuiltplyDigitWithNumber(int n, int d, int b){
        int ans = 0, pow = 1, carry = 0;
        
        while(n != 0 || carry != 0){
            int product = ((n % 10) * d) + carry;
            
            n /= 10;
            int digit = product % b;
            carry = product / b;
            
            ans += (digit * pow);
            pow *= 10;
        }
        
        // System.out.println("single ans : " + ans );
        return ans;
    }

    public static int AnyBaseMultiplication(int n1, int n2, int b){
        int ans = 0, pow = 1;
        
        while(n2 != 0){
            int digit = n2 % 10;
            n2 /= 10;
            
            int productRec = MuiltplyDigitWithNumber(n1, digit, b) * pow;
            
            ans = AnyBaseAddition( ans, productRec, b);
            
            pow *= 10;
        }
        
        return ans;
    }

    public static void printInRange(int[] arr, int si, int ei){
        while(si <= ei){
            System.out.print(arr[si] + "	");
            si++;
        }
        System.out.println();
    }
    
    public static void printAllSubArray(int[] arr){
        int n = arr.length;
        
        for( int i = 0 ; i < n ; i++){
            for(int j = i ; j < n ;j++){
                printInRange(arr, i, j );
            }
        }
    }


    public static void subarray(int[] arr){
        int count = 0 ,idx = 0; 
        for(int i =0 ; i< arr.length; i++){
           
           
           for(int j = 1; j <= arr.length - i; j++){
               count = j;
               idx = i;
               while(count > 0){
                System.out.print(arr[idx]+" ");
                count--;
                idx++;
               }
               System.out.println();
           
            }


        }
    }


    public static void main(String[] args){
        // DecimalToBinary(4);

        // System.out.println(BinaryToDecimal(1010));
        // System.out.println(DecimalToAnyBase(10, 2));
        // System.out.println(AnyBaseToDecimal(1010, 2));
        System.out.println(AnyBaseAddition(10, 20, 30));
    }
}


// javac l001.java && java l001 < input