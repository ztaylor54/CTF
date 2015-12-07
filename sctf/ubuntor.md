#Ubuntor | 55 points
##Description
Find out **about** me.
##Hint
It's all ***about*** me!

##Solution
This problem was around 10% recon, and 90% forensics.

The hint leads us to the [about](http://sctf.io/about) page on the website, where we see that Samuel Kim's rofile picture is what seems to be a [QR](https://en.wikipedia.org/wiki/QR_code) code.  
  
Here is the full downloaded image:  
  
<img src="https://github.com/ztaylor54/CTF/blob/master/sctf/ubuntor/SamuelKim.jpg" height="250">  
  
Which decodes to  
`iVBORw0KGgoAAAANSUhEUgAAAB4AAAAXAQMAAAAm8W0pAAAABlBMVEUAAAD///+l2Z/dAAAAaElEQVQI12M4Uxksw3D1e2gNw5nfwTYMV/+CWMVbZRj+////h6H3WeYahluvVoGIrDkQ1t1nQAIs+2/bciCxavUfhv9Zy0EEiFWe/Qciu3WbZgdDaHjWDoZQ8awZDNHhWXsYdgdndQAAbBA+tIufstkAAAAASUVORK5CYII=`  
  
This looks like [Base64](https://en.wikipedia.org/wiki/Base64) `png` image data!  
  
A quick HTML file in my current project, [Code Editor](http://ztaylor54.github.io/code-editor/#ambiance), yeilds a [file](https://github.com/ztaylor54/CTF/blob/master/sctf/ubuntor/ubuntor.html) with this image:  
  
![ovaltine.png](https://github.com/ztaylor54/CTF/blob/master/sctf/ubuntor/ovaltine.png)  
  
Here's the source:
```html
<!DOCTYPE html>
<html>
  <title>Stupid recon problem</title>
  <img alt="recon" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAB4AAAAXAQMAAAAm8W0pAAAABlBMVEUAAAD///+l2Z/dAAAAaElEQVQI12M4Uxksw3D1e2gNw5nfwTYMV/+CWMVbZRj+////h6H3WeYahluvVoGIrDkQ1t1nQAIs+2/bciCxavUfhv9Zy0EEiFWe/Qciu3WbZgdDaHjWDoZQ8awZDNHhWXsYdgdndQAAbBA+tIufstkAAAAASUVORK5CYII=" />
</html>
```
  
The image says `BE SURE TO DRINK YOUR OVALTINE!`, but other than being a humorous reference to [A Christmas Story](https://en.wikipedia.org/wiki/A_Christmas_Story), what is it?  
  
Well, after some digging around in the original QR image with my hex editor ([HxD](http://mh-nexus.de/en/hxd/)), we I found that there was actually a `pkZIP` file appended at the end of the file!  
  
Heres where it is, with file signature `0x504B0304`  
  
![pkZIP.png](https://github.com/ztaylor54/CTF/blob/master/sctf/ubuntor/pkZIP.png)  
  
Saving this as a new file reveals [this](https://github.com/ztaylor54/CTF/blob/master/sctf/ubuntor/flag.zip?raw=true) zip file containing `flag.txt`.  
  
It's password protected, but if we enter `BE SURE TO DRINK YOUR OVALTINE!`, we get the flag!  
  
##Flag
sctf{all_about_the_ctf}
