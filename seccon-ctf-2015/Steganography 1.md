#Steganography 1 | 100 points
##Problem
Find image files in the file
[MrFusion.gpjb](http://scontents.quals.seccon.jp/files/MrFusion.gpjb)
Please input flag like this format-->SECCON{*** ** **** ****}

##Solution
Opening this image in a hex editor such as [HxD](http://mh-nexus.de/en/hxd/) reveals that there are several images appended to the first file.

Here are the different types of files in this problem:

| File Type | Header                            | Trailer                   |
|-----------|-----------------------------------|---------------------------|
| PNG       | `89 50 4E 47 0D 0A 1A 0A`         | `49 45 4E 44 AE 42 60 82` |
| JPG       | `FF D8 FF E0 xx xx 4A 4649 46 00` | `FF D9`                   |
| GIF       | `47 49 46 38 39 61`               | `00 3B`                   |
| BMP       | `42 4D`                           | `none`                    |

One by one, we can separate them into their own seperate files. [All image files](https://github.com/ztaylor54/CTF/tree/master/seccon-ctf-2015/Steganography%201%20Images)

##Flag
SECCON{OCT 21 2015 0728}
