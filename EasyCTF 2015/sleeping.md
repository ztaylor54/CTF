#I <3 Sleeping (125 points)  
We received this string, but I have no idea what it means!  
`3845281945283805284526053525260547380516453748164748478317454508`  
  
##Hint:  
ARGH I CAN'T SLEEP PEOPLE KEEP STEALING MY ZZZZs . . . NO MORE ZZZs /cries  
P.S. You're overthinking it.  
P.P.S. Blocks of 2  
Final hint: sqrt(ABCDEFGHIJKLMNOPQRSTUVWXY). Where'd my Z's go?  
  
##Solution:  
This a Polybius square cipher, where each 2-number block in the encrypted text is a coordinate on a 5x5 square.  
If we examine the encrypted string, we see that when divided into blocks of 2 every first letter, `x`, falls on the interval `0<=x<=4` and every second letter, `y`, falls on the interval `5<=y<=9`.  
This knowledge combined with the hint that our cipher will be missing the letter "z", we can construct a 5x5 Polybius square (hence the hint `sqrt(ABCDEFGHIJKLMNOPQRSTUVWXY)`, because the alphabet minus Z is of length `25` and `sqrt(25) = 5`).  
  
Here's the square:  

|   | 0 | 1 | 2 | 3 | 4 |
|---|---|---|---|---|---|
| 5 | A | B | C | D | E |
| 6 | F | G | H | I | J |
| 7 | K | L | M | N | O |
| 8 | P | Q | R | S | T |
| 9 | U | V | W | X | Y |

Now that we have the square, we can split the encrypted string into coordinates:  
`(3,8) (4,5) (2,8) (1,9) (4,5) (2,8) (3,8) (0,5) (2,8) (4,5) (2,6) (0,5) (3,5) (2,5) (2,6) (0,5) (4,7) (3,8) (0,5) (1,6) (4,5) (3,7) (4,8) (1,6) (4,7) (4,8) (4,7) (8,3) (1,7) (4,5) (4,5) (0,8)`  
Which yields the message:  
`servers are had chaosagent go to sleep`  
  
##Flag: easyctf{serversarehadchaosagentgotosleep}
