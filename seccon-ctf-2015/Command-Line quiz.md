#Command-Line Quiz | 100 points
##Problem
telnet caitsith.pwn.seccon.jp  
User:root  
Password:seccon  
The goal is to find the flag word by "somehow" reading all *.txt files.  

telnet caitsith.pwn.seccon.jp  
User:root  
Password:seccon  
すべての *.txt ファイルを読め  

##Solution
This was a very simple quiz over text processing commands in the UNIX terminal.

I used [PuTTY](http://www.putty.org/) to TelNet into the server, and here was the interaction:

```shell
$ cat stage1.txt
```
What command do you use when you want to read only top lines of a text file?

Set your answer to environment variable named stage1 and execute a shell.

  `$ stage1=$your_answer_here sh`

If your answer is what I meant, you will be able to access stage2.txt file.
```shell
$ stage1="head" sh

$ cat stage2.txt
```
What command do you use when you want to read only bottom lines of a text file?

Set your answer to environment variable named stage2 and execute a shell.

  `$ stage2=$your_answer_here sh`

If your answer is what I meant, you will be able to access stage3.txt file.
```shell
$ stage2="tail" sh

$ cat stage3.txt
```
What command do you use when you want to pick up lines that match specific patterns?

Set your answer to environment variable named stage3 and execute a shell.

 `$ stage3=$your_answer_here sh`

If your answer is what I meant, you will be able to access stage4.txt file.
```shell
stage3="grep" sh

$ cat stage4.txt
```
What command do you use when you want to process a text file?

Set your answer to environment variable named stage4 and execute a shell.

  `$ stage4=$your_answer_here sh`

If your answer is what I meant, you will be able to access stage5.txt file.
```shell
$ stage4="awk" sh

$ cat stage5.txt
```
OK. You reached the final stage. The flag word is in flags.txt file.

flags.txt can be read by only one specific program which is available
in this server. The program for reading flags.txt is one of commands
you can use for processing a text file. Please find it. Good luck. ;-)
```shell
$ sed -n 1p flags.txt
```
OK. You have read all .txt files. The flag word is shown below.
```shell
$ sed -n 3p flags.txt
```
SECCON{CaitSith@AQUA}
##Flag
SECCON{CaitSith@AQUA}
