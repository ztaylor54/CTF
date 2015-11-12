#Teach Me How To Write Like This (30 points)  
My friend Michelle found this cool new site, but you have to pay to read and she doesn't have any money.  
Can you help her read the [fics](https://www.easyctf.com/static/problems/fandoms/index.html) anyway?  
  
##Hint:  
Where can you find out what files are in a server?  
  
##Solution:  
When we visit the site, we see that the fanfic we need to view has been blurred out and is requesting that we pay exactly £314159265358 (pi, if you hadn't noticed, `3.14159...`) to view it. We are perfectly willing to comply, but unfortunately the link to pay is not functional. Darn.  
  
Instead, we decide to see how the website is blurring the text. By viewing the source on the page (`f12`) we see  
```html
<div class="pay">
	<p>You must pay exactly £314159265358 to read this fanfic</p>
    <p>
    	PAY <a href="#" style="color: red;">HERE</a>
    </p>
</div>
````  

