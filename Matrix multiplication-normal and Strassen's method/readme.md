<h3>Introduction</h3>
<p>This project implements matrix multiplication in Java by using regular matrix multiplication algorithm and Schönhage–Strassen's algorithm. Two input Matrices are generated with random numbers. In my program, I used 0-9 digits. The running time of these two algorithms (theoretical or actual) is being compared.
</p>

<h3>Program test cases and output</h3>
<b>Test Case 1:</b>
<code>
<pre>
Matrix 1:
0 0 1 4 
1 8 8 4 
0 2 2 2 
2 3 0 7 
<br />
Matrix 2:
3 1 3 3 
1 2 3 9 
5 8 2 8 
5 0 6 3 
<br />
<b>Regular product:</b>
25 8 26 20 
71 81 67 151 
22 20 22 40 
44 8 57 54 
<br />
Running time: 24468 ns
<br />
Strassen product:
25 8 26 20 
71 81 67 151 
22 20 22 40 
44 8 57 54 

Running time:535950 ns

Test Case 2:
Please enter the size of matrix (must be power of 2):
8
Matrix 1:
5 8 0 0 8 7 8 4 
6 0 6 0 4 5 3 5 
4 6 4 5 9 7 2 7 
3 2 2 2 1 7 8 6 
0 9 0 9 2 2 1 5 
3 2 8 1 9 3 0 0 
9 5 6 1 8 1 9 8 
9 5 2 6 4 4 5 1 

Matrix 2:
3 5 2 1 2 8 0 1 
1 1 0 5 3 7 5 4 
5 2 8 6 7 8 8 0 
8 4 1 6 7 2 9 6 
4 9 2 9 3 7 9 9 
6 3 8 7 6 2 2 9 
4 8 7 5 1 5 4 6 
8 6 3 8 9 4 0 4 

</pre>
</code>
