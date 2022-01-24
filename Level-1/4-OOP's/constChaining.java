public class constChaining{
    public static class sum {
        //this is a kind of constructor
        sum(){
            this(0, 0);
        }

        sum(int a, int b){
            this(a, b, 0);
        }
        
        sum(int a, int b, int c){
            this(a, b, c, 0);
        }

        sum(int a, int b, int c, int d){
            System.out.println("Your result: " + (a+b+c+d));
        }
    }

    public static void main(String[] args) {
        sum s0 = new sum();
        sum s1 = new sum(10, 20);
        sum s2 = new sum(10, 20, 30);
        sum s3 = new sum(10, 20, 30, 40);
    }
}