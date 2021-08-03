
import java.util.Scanner;

public class Main{

public static Scanner scr = new Scanner(System.in);

public static void fibo( int n )
{
int a = 0, b = 1, c = 0;
for( int i = 0 ; i < n ; i++ )
{
System.out.println(a);
c = a + b;
a = b;
b = c;
}
}
public static void solve()
{
int n = scr.nextInt();
fibo(n);
}
public static void main(String[] args) {
// write your code here
solve();
}
}

// javac Main.java && java Main