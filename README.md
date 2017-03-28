# Algorithms

Some practice problems and notes I have been keeping while I am learning
algorithms and data structures.

# Random Notes

+ percolation problem, top row to bottom row, instead, have a vitural top and a virtural bottom so that the problem is simplified.

### Math
+ \sum_{i=1}^{n} i = 1+2+...+n = n(n+1)/2
+ \sum_{i=1}^{n} i-1 = 1+2+...+(n-1) = n(n-1)/2

### Complexity Analysis
+ ϴ: tight, upper and lower bound
+ O: upper bound
+ π: lower bound
+ o: never-reached upper bound 

### Performance
+ multiplication vs. bit shifting: some compilers optimizes multiplication to bit shifting. For us, sometimes optimization compromises readability so choose wise.


### Truly Random Notes
- instead of using a dynamic array, can use a stack sometimes
- base case for small data set(<=3), call use brute force solution 
- sorting optimized to O(n)
- return min(A, B, C)
- places where master algorithm cannot be applied, find O(?)
- double for loop can be O(n) rather than O(n^2) if second for loop has more
  conditions
- 1 xor 2 xor 1 = 2
- insert/access to map in Java
- in C, it is O(lgn) for ordered map(internally uses a red-black tree), and
  O(1) or unordered map = hashmap
- interview: naive solutions handle edge cases
- non dp fibonacci: T(n) = T(n-1) + T(n-2) + O(1) = O(n^2)

#### Linkedlist
- deletion is O(1) in doubly linked list
- but can also be O(1) in singly linked list if we copy content of next node to current and then remove the next node in O(1)


### Getting Better
leetcode, topCoder, career cup, high scalability, Github GitBook (eg. coding interview university), Tech Blogs (eg. [cenalulu](http://cenalulu.github.io/)), 一亩三分地, 米群网, codeforce

industrial coding conventions, readability, concise, reusability, speed, edge case, bug free

### References
[Solutions to CLRS](http://www.math.rutgers.edu/~ajl213/CLRS/CLRS.html)
