Question 3
-
What is the largest valid lable less or equal to a natural Number N?
Input  : int N, int k  
Output : int result  
>Example  
(1234,3) should output 1299

-

Check from the Highest bit, when hit k:

1. if k is 9, replace that bit and rest bit with 8. 2989 -> 2888
2. if k is 0, replace that bit and rest bit with 9 and previous bit minus 1. 2087 -> 1999
3. other wise minus that bit and replace rest with 9. 3, 1234 -> 1229
