import java.math.BigInteger;

public class Fibonacci_Not {
    public static void main(String[] args) throws Exception {
        System.out.println(processLength(F(30)).toString());
    }
    
    public static BigInteger F (int x) {
        System.out.println("Calling F(" + x + ")"); //debug
        return G(x).subtract(W(x)); //F(x) = G(x) - W(x)
    }
    
    public static BigInteger G (int x) {
        System.out.println("Calling G(" + x + ")"); //debug
        BigInteger num1 = BigInteger.ZERO;
        BigInteger num2 = BigInteger.ONE;
        BigInteger temp;
        for(int i = 2; i <= x; i++)
        {
            temp = (num1.add(num2)).pow(2); //G(x) = [G(x-1)+G(x-2)]^2
            num1 = num2;
            num2 = temp;
            System.out.println("G: " + i); //dubug
        }
        System.out.println("G has finished evaluating"); //debug
        return num2;
    }
    
    public static BigInteger W (int x) {
        System.out.println("Calling W(" + x + ")"); //debug
        BigInteger num1 = BigInteger.ZERO;
        BigInteger num2 = BigInteger.ONE;
        BigInteger temp;
        for(int i = 2; i <= x; i++)
        {
            temp = (num1.pow(2)).add(num2.pow(2)); //[W(x-1)]^2 + [W(x-2)]^2
            num1 = num2;
            num2 = temp;
            System.out.println("W: " + i); //debug
        }
        System.out.println("W has finished evaluating"); //debug
        return num2;
    }
    
    public static BigInteger processLength (BigInteger b) {
        System.out.print("Processing length...");
        String s = b.toString();
        BigInteger num = BigInteger.ZERO;
        for(BigInteger i = BigInteger.ZERO; i.compareTo(BigInteger.valueOf(s.length())) < 0; i = i.add(BigInteger.ONE))
        {
            int digit = Integer.parseInt(s.charAt(i.intValue())+"");
            num = num.add(BigInteger.valueOf(digit));
        }
        System.out.println("done.");
        return num;
    }
}
