#2147483648% Secure (35 points)
Hack my friend's [website](https://www.easyctf.com/static/problems/intro-js/index.html)! From what she tells me, it's super secure. Why don't we prove her wrong :)

##Hint:
Don't try to figure out what the messy JavaScript code means. [Developer tools](https://www.google.com/search?q=developer+tools) help a lot in things like this.

##Solution:
To solve this problem, simply copy the JavaScript found in the source of the webpage into the console, and it will print out the flag.

However, I think it's important to understand what is happening in this chunk of JavaScript:
```javascript
			var _0xa107=["\x64\x65\x76\x65\x6C\x6F\x70\x65\x72\x5F\x63\x6F\x6E\x73\x6F\x6C\x65\x5F\x69\x73\x5F\x79\x6F\x75\x72\x5F\x66\x72\x69\x65\x6E\x64","\x65\x61\x73\x79\x63\x74\x66\x7B","\x7D"];
			var _0x6fdc=[_0xa107[0],_0xa107[1],_0xa107[2]];
			var secret=_0x6fdc[0];
			secret=_0x6fdc[1]+secret+_0x6fdc[2];
		
```
First, an array `_0xa107` is populated with 3 hex encoded ASCII strings, `\x64\x65\x76\x65\x6C\x6F\x70\x65\x72\x5F\x63\x6F\x6E\x73\x6F\x6C\x65\x5F\x69\x73\x5F\x79\x6F\x75\x72\x5F\x66\x72\x69\x65\x6E\x64`, `\x65\x61\x73\x79\x63\x74\x66\x7B`, and `\x7D`.

A new array, `_0x6fdc`, is then created (arbitrarily - there is no reason to do this) as an identical copy of `_0xa107`.

Lastly, a string `secret` is created, taking the first index from `_0x6fdc`. The second item in `_0x6fdc` is then added to the front of `secret`, and the last index in `_0x6fdc` is appended to the end of `secret`.

The ASCII counterparts to the hex values in the array `_0x6fdc`:
```javascript
["\x64\x65\x76\x65\x6C\x6F\x70\x65\x72\x5F\x63\x6F\x6E\x73\x6F\x6C\x65\x5F\x69\x73\x5F\x79\x6F\x75\x72\x5F\x66\x72\x69\x65\x6E\x64","\x65\x61\x73\x79\x63\x74\x66\x7B","\x7D"]

["developer_console_is_your_friend", "easyctf{", "}"]
```

##Flag: easyctf{developer_console_is_your_friend}
