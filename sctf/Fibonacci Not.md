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
G's sequence is identical to the noral sequence shown above, but it squares the sum of the previous two numbers.  
  
For example, G's first few digits are: `0, 1, 1, 4, 25, 841, 749956`

As you can see, it increases ***very*** quickly.
###W method

