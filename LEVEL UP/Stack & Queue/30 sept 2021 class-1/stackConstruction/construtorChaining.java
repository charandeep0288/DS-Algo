public class construtorChaining {
    
    construtorChaining(int a, int b){
        sum(a, b, 0, 0);
    }

    construtorChaining(int a, int b, int c){
        sum(a, b, c, 0);
    }

    construtorChaining(int a, int b, int c, int d){
        sum(a, b, c, d);
    }

    public int sum(int a, int b, int c, int d){
        return a + b + c + d;
    }
}
