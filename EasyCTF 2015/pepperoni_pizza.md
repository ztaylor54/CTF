#Rest in Pepperoni-Pizzas (100 points)
I gave my little sister a flag, but she cut it up and hid the pieces! Retrieve it here: [ripinpizzas.pdf](https://github.com/EasyCTF/easyctf-2015-writeups/blob/master/files/ripinpizzas.pdf).

##Hint:
Have fun! If you do it by the paper-and-scissors method, share it to [@easyctf](http://twitter.com/easyctf) !

##Solution:
The first step to solving this problem is to open the PDF file in a PDF editor, such as Adobe Illustrator. This allows us to move the layer that says "Nothing to see here", revealing:

![asdf.jpg](https://github.com/ztaylor54/CTF/blob/master/EasyCTF%202015/asdf.jpg)

It's a puzzle! We can either print it out and solve it by hand as mentioned in the hint, or we can be lazy and solve it in photoshop. Here's a .psd of all the pieces separated out: [separated_pieces.psd](https://github.com/ztaylor54/CTF/raw/master/EasyCTF%202015/separated_pieces.psd)

If we rearrange them we get:

![together.jpg](https://github.com/ztaylor54/CTF/blob/master/EasyCTF%202015/together.jpg)

##Flag: easyctf{can_y0u_put_4ll_the_pieces_2gether?}