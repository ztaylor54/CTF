#Borkened (400 points)  
There's a team that's breaking the rules and hiding flags on the site! Find the flag.  
  
##Hint:  
The flag is on this site.  
  
##Solution:  
This problem was frustrating for quite some time, but after you find the first clue everything falls into place.  
  
I began my search for the flag by checking the source on several different pages on the site for clues (which caused me to stumble on a few [Easter eggs](https://www.easyctf.com/95125f09551360c5294d180b013d047d.html), but I had no luck until I checked the scoreboard page. Upon reflection I should have checked there sooner, because it's the one place where every team is listed.  
  
**Or is it?**  
  
If we view the source on the page where the team list is, we find a very suspicious line that has been commented out:  
```html
<!-- <tr><td>0</td><td><a href='/team?EasyCTF'>EasyCTF</a></td><td>Various Schools</td><td>Infinity</td></tr> -->
```  
If we uncomment this line, we get:  
```html
<tr>
	<td>0</td>
    <td>
    	<a href="/team?EasyCTF">EasyCTF<a/>
    </td>
    <td>Various Schools</td>
    <td>Infinity</td>
</tr>
```  
Which places a team named "EasyCTF" at the top of the scoreboard with infinity points! If that's not the cheating mentioned in the hint, I don't know what is.  
  
If we click the link to visit EasyCTF's webpage, we see that there are even more than 5 members on this team. We are definitely on the right track.  
  
If we view the source and head over the the console where every team's information is called from `team.js:1`, we can dig around and find the hidden flag under `score progression`.  
  
##Flag: easyctf{h4xxing_th3_c0mpetition_s1t3}
