#PWN1 | 40 points
##Description
First pwnable, this should be nice and easy.  
`nc pwn.problem.sctf.io 1337`
##Files
[pwn1](http://compete.sctf.io/2015q2/problemfiles/54/pwn1)
##Hint
Read up on [Buffer Overflows](https://en.wikipedia.org/wiki/Buffer_overflow).

##Solution
This problem is a simple buffer overflow.
If we disassemble the file `pwn1` we see that the memory address for the function `get_flag` is `0x80484ad`.  
![](/screenshots/pwn_screenshot_1)

In order to call this function, we need to overwrite the return address of the `main` function with our input. By a little trial and error, we see that the program breaks when we enter 39 'a's. This means that after 39 characters, the buffer will begin overwriting memory on the stack.  

The disassembly also shows us that there will be a few bytes of information between our function and the return address, so we can figure that out by trial and error after we input our new return address.  

We need to express `0x80484ad` in [Little Endian](https://en.wikipedia.org/wiki/Endianness) notation, with the least significant bytes first.  

Here it is, in the version using escape characters that our Linux shell can read: `\x08\x04\x84\xAD`  

Now that we have our exploit, we can pipe `echo -e` with our string to the server. (the `-e` on echo forces it to read the hex escape sequences)  

By trial and error, we find that the total number of a's required is 44.  
  
Exploit:
`echo -e 'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\xAD\x84\x04\x08' | nc pwn.problem.sctf.io 1337`  
  
##Flag
flag{that_was_so_easy_i_wont_leetify_this_flag}
