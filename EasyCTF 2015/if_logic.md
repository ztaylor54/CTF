#If Logic (30 points)

Use the programming interface to complete this task. You&#39;ll be given a list of numbers.

Input: A list of numbers, separated by commas.

Output: Print `hi`if the number is 0-50 (inclusive), `hey` if the number is 51-100 (inclusive), and `hello` if anything else. Each greeting should have a linebreak after it.

Read the input from a file called `if-logic.in` that's in the current working directory, and then write your output to a file called `if-logic.out`.

##Hint:
If you need help, try looking at the Python Tutorial in the Learn section!

##Solution:
We can solve this easily in Python, by writing a script that does the following

1. opens the input file and splits the numbers into a list
2. checks if the current number lies on intervals 0<=i<=50 or 51<=i<=100
3. appends the appropriate output to to `solution`
4. writes `solution` to `if-logic.out'


```python
with open("if-logic.in", "r") as f:		#
    for line in f:						#  step 1
        x = line.split(',')				#
        solution = ''
        for i in x:						#
            if(0 <= int(i) <= 50):		#
              solution += 'hi\n'		#
            elif(51 <= int(i) <= 100):	#  steps 2 and 3
              solution += 'hey\n'		#
            else:						#
              solution += 'hello\n'		#

with open("if-logic.out", 'w') as y:	#
    y.write(solution)					#  step 4
    y.close()							#
```
##Flag: easyctf{is_it_hi_or_hey_or_something_else}