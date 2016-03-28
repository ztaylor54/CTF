#Unlucky Cheaters | 200 points
##Description
Professor Kyle gives two forms of his tests to deter cheaters, however some of his students don't know this and copy answers off the wrong form! Help him analyse the data and find the cheaters.<br>Note: Submit the last names of the cheaters in alphabetical order, separated only by commas.
##Files
[studentdata.dat](studentdata.dat)  
##Hint
There are only 5 cheaters.","Statistically, you should probably be at least 99.98% confident.
##Solution
This problem was really fun to solve, because it required some fancy statistics. I used a [one proportion z-test](central.d127.org/teachers/sikenn/apstats/Documents/chapter%2012/Notes%20from%201-30.pdf) to determine when a student's incorrect answers were correct on the opposite form more than 1/3rd of the time, meaning they weren't guessing, but rather looking at the other form when they didn't know the correct answer themselves.  
  
In a z-test, 99.7% of th values typically fall in the bounds `-3 < z < 3`. A z-value outside of these bounds would be considered a _very_ strong indicator of cheating.  
  
I had my program add the last names of all student's whose z-value was greater than 4 or less than -4 to a collection, then sorted and printed it out in all caps, delineated by commas.  
  
The competition had been attacked and taken down by the time I completed this challenge, but I know my flag is correct because of a screencapture I have from when the flags were leaked to the IRC chat during the competition.  
  
My solution is [here](Cheaters.java)

##Flag
BILLS, DUCKETT, STROUD, TRAYLOR, WHITESIDE
