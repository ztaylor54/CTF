#An apple a day keeps the dinosaur away?
Oh look, it's a perfectly innocent picture of an [apple](https://www.easyctf.com/static/problems/apple/apple.jpg). Nothing to see here!

##Hint:
Apples are suspicious. Don't trust apples. They always have something to hide . . .

##Solution:
This is a cookie-cutter [steganography](https://en.wikipedia.org/wiki/Steganography) problem, with the plaintext flag hidden within `apple.jpg`'s file contents

There are several ways to solve this problem:

1. open the image in a hex editor and Ctrl+F for "flag"
2. in Linux, use the `grep` command to look for "flag"
3. in Windows powershell use `Select-String -Pattern` to look for "flag"

Linux:
```
$strings apple.jpg | grep easyctf
	the flag is easyctf{w0w_much_appl3s}
```

Windows Powershell:
```
> Get-Content apple.jpg | Select-String -Pattern "easyctf"
žpaú9'ºFÞ•_þH$ùcÍZiæÕ¨æ\‚VÀ{E#Ê•Ï¹±µn¢êûšEÑ|µ«yjù›˜¡RIQ'0    DjÛó€]…"4&q›¹¦›s·¥/Äâø°L<U¶ß   the flag is
easyctf{w0w_much_appl3s}   Õ{
```

##Flag: easyctf{w0w_much_appl3s}
