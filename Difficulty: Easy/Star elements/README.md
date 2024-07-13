<h2><a href="https://www.geeksforgeeks.org/problems/start-elements3447/1?page=2&difficulty=Easy&status=unsolved&sortBy=difficulty">Star elements</a></h2><h3>Difficulty Level : Difficulty: Easy</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size:18px">Given an unsorted array <strong>arr</strong> of size <strong>n</strong>. The task is to find all the star and super star elements in the array. Star are those elements which are strictly greater than all the elements on its right side. Super star are those elements which are strictly greater than all the elements on its left and right side.</span></p>

<p><span style="font-size:18px"><strong>Note: </strong>Assume first element (arr[0]) is greater than all the elements on its left side, And last element (arr[n-1]) is&nbsp;greater than all the elements on its right side.</span></p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:
</strong>n = 10
arr[] = {1, 6, 5, 4, 7, 8, 4, 3, 2, 1}
<strong>Output:</strong> 
8 4 3 2 1 
8
<strong>Explanation:</strong> Star elements are 8, 4, 3, 2 and 1.
Super star element is 8.
</span></pre>

<p><span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:
</strong>a = 9
arr[] = {1, 2, 10, 3, 4, 5, 8, 10, 4}
<strong>Output:</strong> 
10 4 
-1
<strong>Explanation:</strong>&nbsp;Star elements are 10 and 4.
No super star element present here.
</span></pre>

<p><span style="font-size:18px"><strong>Your Task:</strong><br>
You don't need to read input or print anything. Your task is to complete the function&nbsp;<strong>getStarAndSuperStar</strong><strong>()</strong>&nbsp;which takes the array of integers&nbsp;<strong>arr</strong>&nbsp;and&nbsp;<strong>n&nbsp;</strong>as parameters and returns an&nbsp;array of integers&nbsp;denoting the answer where first element is the super star element and rest are star elements. Return <strong>-1</strong>&nbsp;in first element of the array if&nbsp;no super star element is present. The driver code itself prints the star elements in first line and super star element in second line.</span></p>

<p><span style="font-size:18px"><strong>Expected Time Complexity:</strong>&nbsp;O(n)<br>
<strong>Expected Auxiliary Space:</strong>&nbsp;O(1)</span></p>

<p><span style="font-size:18px"><strong>Constraints:</strong><br>
1 &lt;= n &lt;= 10<sup>6</sup><br>
0 &lt;= |arr[i]| &lt;= 10<sup>6</sup></span></p>

<p>&nbsp;</p>
</div><p><span style=font-size:18px><strong>Company Tags : </strong><br><code>Amazon</code>&nbsp;<br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Arrays</code>&nbsp;<code>Data Structures</code>&nbsp;