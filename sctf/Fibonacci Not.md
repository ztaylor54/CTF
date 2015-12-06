#Fibonacci_Not! | 65 points
##Description
What would be a CTF without a typical algorithm problem? This will test your system more than anything. Seeing as the Fibonacci sequence is overused, lets change it slightly shall we?

```
Given F(x) = G(x) - W(x)

G(x) = [G(x-1)+G(x-2)]^2

W(x) = [W(x-1)]^2 + [W(x-2)]^2
```

What is the sum of the digits of F(30)?

```
G(0) = 0 G(1) = 1

W(0) = 0 W(1) = 1
```

##Solution
This is a crazy twist on a normal [Fibonacci Sequence](https://en.wikipedia.org/wiki/Fibonacci_number).  

Here is a breakdown of a ***normal*** sequence:  
The formula,
![fibonacci formula](https://upload.wikimedia.org/math/0/c/e/0cebc512d9a3ac497eda6f10203f792e.png) with seed values ![seed values](https://upload.wikimedia.org/math/a/9/2/a92c5f0981136ba333124cdfe6d3c3ce.png)  
basically means that starting with the numbers `0` and `1`, each number is the sum of the previous two.  

The sequence normally looks like this:  
![normal sequence](https://upload.wikimedia.org/math/c/a/b/cabe91689f6a1af616ace02827c6e89c.png)  

This problem takes the normal sequence, and adds the twist, `^2`. Unfortunately for our CPU, this causes the numbers to get HUGE.  
  
I used Java's [BigInteger](http://docs.oracle.com/javase/7/docs/api/java/math/BigInteger.html), which can hold the huge amounts of data dealt with in this problem.

###F method
This method simply needs to return `G(x).subtract(W(x))`

###G method
`G`'s sequence is identical to the noral sequence shown above, but it squares the sum of the previous two numbers.  
  
For example, `G`'s first few digits are: `0, 1, 1, 4, 25, 841, 749956, ...`

As you can see, it increases ***very*** quickly.  

###W method
`W`'s sequence is very similar to `G`'s, except it squares the first and second value ***before*** adding them together.

For example, `W`'s first few digits are: `0, 1, 1, 2, 5, 29, 866, ...`

`W` doesn't increase at the same rate as `G` does, but we are still dealing with massive numbers.

###The script
Here is the full Java program, complete with `stdout` logging to help track progress. File can be downloaded [here](https://github.com/ztaylor54/CTF/blob/master/sctf/Fibonacci_Not.java).

```java
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
```  

Here are the logs from a successful execution, with took 45 minutes.

```
Calling F(30)
Calling G(30)
G: 2
G: 3
G: 4
G: 5
G: 6
G: 7
G: 8
G: 9
G: 10
G: 11
G: 12
G: 13
G: 14
G: 15
G: 16
G: 17
G: 18
G: 19
G: 20
G: 21
G: 22
G: 23
G: 24
G: 25
G: 26
G: 27
G: 28
G: 29
G: 30
G has finished evaluating
Calling W(30)
W: 2
W: 3
W: 4
W: 5
W: 6
W: 7
W: 8
W: 9
W: 10
W: 11
W: 12
W: 13
W: 14
W: 15
W: 16
W: 17
W: 18
W: 19
W: 20
W: 21
W: 22
W: 23
W: 24
W: 25
W: 26
W: 27
W: 28
W: 29
W: 30
W has finished evaluating
Processing length...done.
443589491

BUILD SUCCESSFUL (total time: 45 minutes 5 seconds)
```

##Flag
443589491
