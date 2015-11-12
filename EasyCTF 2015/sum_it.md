#Sum It! (30 points)  
Use the programming interface to complete this task. You'll be given a list of numbers.  
  
Input: A list of numbers, separated by commas.  
Output: The sum of the numbers.  
  
Read the input from a file called `addition.in` that's in the current working directory, and then write your output to a file called `addition.out`.  
  
##Hint:  
If you need help, try looking at the Python Tutorial in the Learn section!  
  
##Solution:  
This problem can be solved with another simple python script, that does the following:  

1. opens the file and separates the numbers into a list, `x`  
2. adds the numbers together and writes them to `sum`  
3. writes `sum` to a new file, `addition.out`  
  
Here's the full script:  
```python
with open("addition.in", "r") as f:
    for line in f:
        x = line.split(',')
        sum = 0
        for i in x:
            sum +=int(i)
with open("addition.out", 'w') as y:
    y.write('%s\n'%(sum))
    y.close()
```  
  
##Flag: easyctf{'twas_sum_EZ_programming,_am_I_rite?}