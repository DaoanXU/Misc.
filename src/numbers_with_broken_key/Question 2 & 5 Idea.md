Question 2 & 5
-
 * Q2: If the first lable starts with 1 (2 if 1 is broken).
 * Q5: If the first lable starts with 0 (1 if 0 is broken).

If the first lable starts with 1 (2 if 1 is broken).
If the largest lable is N and the broken key is k. How many documents are there?  
This is just the opposite of Question 1  
Input  : int N, int k  
Output : int result  

-

Just do the inverse of [Question 1 & 4](https://github.com/DaoanXU/Misc./blob/master/src/numbers_with_broken_key/Question%201%20%26%204%20Idea.md)  
Note when the broken key is zero, do the revese by replace all 9 with 10.  
For example 8989 = 10 + 80 + 1000 + 8000 in base 9 = 10100 in base 9 = 6642 in base 10
