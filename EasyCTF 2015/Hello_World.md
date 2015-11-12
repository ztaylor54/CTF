#Hello World (20 points)  
Use the programming interface to complete this task. Print the line, ```Hello, EasyCTF!``` to a file called ```hello-world.out```. For this problem and for future problems, **make sure your program ends with a newline.** Good luck!  
  
##Hint:  
If you're really stuck, contact one of the mods on the [chat](https://www.easyctf.com/chat), or check out our [video tutorial](https://www.youtube.com/watch?v=GP1ZfzRSclQ)!  
  
##Solution:  
This problem can be solved with a simple python program, where we write a line to a file.  
Here's the script:  
```python

f = open('hello-world.out', 'w') 
f.write('Hello, EasyCTF!\n')
f.close()
```  
This program creates a file named `hello-world.out` and sets it to write-only, then writes `Hello, EasyCTF!` to the file as well as a newline, `\n`.  
  
##Flag: easyctf{welc0me_two_easyCtf}