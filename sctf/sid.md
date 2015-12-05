#SID | 60 points
##Description
Find the name of the song. Submit your answer as `sctf{Name} (case sensitive)`.
##Files
[mystery.sid](http://compete.sctf.io/2015q2/problemfiles/35/mystery.sid)
##Hint
Nice tune...

##Solution
I believe this problem has been the cause of much frustration for many teams in this CTF. There are a few ways you can solve it, each with varying levels of difficulty.

Before we do anything, we need to find out what a `.sid` file is. Some quick Google searches tell us that it's the sound filetype used by the [Commodore 64](https://en.wikipedia.org/wiki/Commodore_64#Sound).

So how do we listen to it? [HVSC](http://www.hvsc.c64.org/) has a great [downloads](http://www.hvsc.c64.org/#players) page where you can find a plethora of SID players.

Here's the one I used: [Sidplay/w 2.6](http://noname.c64.org/csdb/release/?id=103781)

When we open the file, we run into a problem:

![sid player](https://github.com/ztaylor54/CTF/blob/master/sctf/screenshots/sid_screenshot_1.png)

It looks like the song's name, author, and release date have been redacted! The music is really neat, but it seems like it might as well be useless if we can't find the song's name.

Many teams got to this point, and began searching lists of popular SID files to see if this song matched any of them.

I found two good methods for finding the name:
* Grep [HVSC's](http://www.hvsc.c64.org/) database for the SID's file contents
* Use the SID's `MD5` hash to locate it in [HVSC's](http://www.hvsc.c64.org/) songlength database

###Method 1
[HVSC's](http://www.hvsc.c64.org/) website maintains a database of all SID files in existence. The number is currently 46,851. I figured the song MUST be in there.

After downloading the [database](http://www.prg.dtu.dk/HVSC/HVSC_63-all-of-them.zip), which is around 94mb, I pulled up [Windows Grep](http://www.wingrep.com/) to start searching.

I used [HxD](http://mh-nexus.de/en/hxd/) to select a search string, and after a bit of fooling around I decided on `ñEóEñGóGñIóILN`, which is near the end of the file.

![selecting a search string](https://github.com/ztaylor54/CTF/blob/master/sctf/screenshots/sid_screenshot_2.png)

I put that into Windows Grep, set the directory to the database folder, and let it search overnight. (I ran this on a weak [HP Stream](http://www.cnet.com/products/hp-stream-11-6-review/), so it took quite a while)

Sure enough, there was a file that matched our search string.

![search match](https://github.com/ztaylor54/CTF/blob/master/sctf/screenshots/sid_screenshot_3.png)

Windows Grep tells us the file's name is `Berggreen_I_Am.sid`, and if we pull up the song to play it in [Sidplay/w 2.6](http://noname.c64.org/csdb/release/?id=103781), it's a match!

Turns out this song isn't even from a Commodore 64 game at all. It was made recently by Carsten Bergreen (Scarzix) and posted to his [SoundCloud](https://soundcloud.com/scarzix/berggreen-i-am) account for an oldschool music competition.

###Method 2
I stumbled accross a much quicker method of solving this problem as I was listening to the `mystery.sid` file on my phone's [Modo](https://play.google.com/store/apps/details?id=de.illogical.modo&hl=en) player.

I saw that although the song did not have any length information, Modo knew its length from the `MD5` hash of the file, `12e7745248d1ed13d0c6c57d3d41d427`, and said it had been found in a "song length database".

<img src="https://github.com/ztaylor54/CTF/blob/master/sctf/screenshots/sid_screenshot_6.png" height="350">

So maybe if we find this database, we can find the song?

Turns out [HVSC's](http://www.hvsc.c64.org/) database has a file named `Songlengths.txt` under `DOCUMENTS/` which contains the length of every SID file by its `MD5` hash.

If we open the file and <kbd>Ctrl</kbd> + <kbd>F</kbd> for `mystery.sid`'s `MD5` hash, we should get a result.

![searching for hash](https://github.com/ztaylor54/CTF/blob/master/sctf/screenshots/sid_screenshot_4.png)

Looks like we get a match:

![ctrl+f match](https://github.com/ztaylor54/CTF/blob/master/sctf/screenshots/sid_screenshot_5.png)

Revealing the song name, Berggreen I Am.
##Flag
`sctf{Berggreen I Am}`
