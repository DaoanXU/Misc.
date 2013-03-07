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

If the broken key is not 0, Q1 and Q4 are exactly the same.
1. Change N to 9 base number
2. Create a map from the digits of 0-8 to digits to the numbers without broken numbers.  
For example, if 5 is broken is :
from: 0 1 2 3 4 5 6 7 8  
to  : 0 1 2 3 4 6 7 8 9
