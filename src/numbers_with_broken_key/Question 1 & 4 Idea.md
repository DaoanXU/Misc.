Question 1 & 4
-
 * Q1: If the first lable starts with 1 (2 if 1 is broken).
 * Q4: If the first lable starts with 0 (1 if 0 is broken).

If thers are N documents, and k is the broken key.
What is the largest lable?  
Input  : int N, int k  
Output : int result  
>Example  
(10,9)shoud output 11, (10,1) should ouput 22

-

If the broken key is not 0, Q1 and Q4 are Nearly the same. Except what in 1

1. Change N to 9 base number. (in Q4, it is N-1)
2. Create a map from the digits of 0-8 to digits to the numbers without broken numbers.  
For example, if 5 is broken is :
from: 0 1 2 3 4 5 6 7 8  
to  : 0 1 2 3 4 6 7 8 9  
3. Use the digit map in 2 to map the number get in 1, then we get the result number.

-

If the broken key is 0, Q1 and Q4 is excatlly the same.

1. Change N to 9 base number.
2. Seek 0 in the number, from lowest bit. Each time find a 0, do minus 1 on that higer bit in base 9, and replace that bit with 9.
Continue Seeking until reaches the heights digit.  
Example:(use . as concatinate here, e.g. 1.3 = 13)  
100 -> (10-1 in base 9).9 -> 8.9 -> 89  
810 -> (81-1 in base 9).9 -> 80.9 -> (8 - 1 in base 9).99-> 799
