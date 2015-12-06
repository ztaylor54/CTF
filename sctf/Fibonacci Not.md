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
