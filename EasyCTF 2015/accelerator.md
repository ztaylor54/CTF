#Accelerator (300 points)
Hey, do you want to learn more about Steganography? Cool, read [this](https://www.easyctf.com/static/problems/accel/steg.pdf) article. Just friendly learning. We're not hiding ANYTHING \*nervous laugh\*

##Hint:
Yeah chaosagent likes Accelerator blah blah blah

##Solution:
This was a fun problem... I always love it when a problem trolls me **HARD** when I'm in the middle of solving it.

There are a few steps to solving this problem, and the first i to find what the .pdf is hiding. The first thing to do when working with steganography is to check for any blatant info in the file. A quick search for things like "secret", "flag", and "easyctf" are of no help, not surprisingly.

Instead, we need to look at the file header to see if there are any suspicious files hidden in the PDF. According to Gary Kessler's [file signature](http://www.garykessler.net/library/file_sigs.html) page, a PDF begins with `0x25 0x50 0x44 0x46`, which is `%PDF` in ASCII. The trailer for a PDF is `0x45 0x4F 0x46 0x0D`, so this should be the last data in the PDF's hex, right?  

Searching for `0x45 0x4F 0x46 0x0D` in the hex editor reveals that we have a file appended to this PDF, with header `0x52 0x49 0x46 0x46` which is `RIFF`, and we see that the file is `WAVE` format.

If we copy all the data after starting at offset `0x00118284` to the end of the file into a new file named `whatever.wav` we get an [audio file](https://github.com/ztaylor54/CTF/blob/master/EasyCTF%202015/soul_sister.wav)!

Upon playing the file, the we hear Train's *Hey, Soul Sister* with a very strange (and annoying) right channel. Opening the file in Audacity allows us to isolate the sound, and it seems to be binary! Slowing it down and recording the high notes as `1` and the low notes as `0` yields:
`1001100111001000010101011000000011001000100100000100000000100111001101011100110110011`
which is 85 bits long.

Factoring `85` into `5 x 17` tells us that this is 17 5-bit chunks of binary information. If the largest any one section can be is `0b11111` (31 in decimal) then the the information in the binary must correspond to a key whose greatest value is less than 31... the alphabet, perhaps?

Breaking up the binary into 17x5 bits gives us `0b10011 0b00111 0b00100 0b00101 0b01011 0b00000 0b00110 0b01000 0b10010 0b00001 0b00000 0b00010 0b01110 0b01101 0b01110 0b01101 0b10011`, which can now be translated to the alphabet using the code below:
```java
public class Accelerator{

     public static void main(String []args){
        int[] bytes = {0b10011, 0b00111, 0b00100, 0b00101, 0b01011, 0b00000, 0b00110,
                        0b01000, 0b10010, 0b00001, 0b00000, 0b00010, 0b01110, 0b01101,
                        0b01110, 0b01101, 0b10011};
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
                            'u', 'v', 'w', 'x', 'y', 'z'};
        String flag = "";
        for(int i = 0; i < 17; i++)
            flag += (char) alphabet[(int)bytes[i]];
            
        System.out.println(flag);
     }
}
```
The output of the code above is `theflagisbaconont`

##Flag: easyctf{theflagisbaconont}
