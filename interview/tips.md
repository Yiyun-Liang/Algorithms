!!! read every piece of information in the question carefully!!!

- sorted array?
- 32-bit integers?

##### Interview tips

- thorough test in the end
- check boundary cases for out of bound or isDigit if needed, etc
- hash a value

```
int code(char c){
  switch(c){
    case 'A':
      return 0;   // no need to break!
    case 'B':
      return 1;
    ...
    default:
      return -1;
  }
}
```

- often, may need a class to store result that contains multiple values
- when using a hashmap on a char or int, can choose to use an array
- preprocessing is an option for processing or scanning type of questions, discuss with interviewer to see if we want to do the task multiple times.
- use enums (eg. operators in stack)

```
public enum Operator {
    ADD, SUBTRACT, MULTIPLY, DIVIDE, BLANK
}
```

##### 2D Array

- find path
  - if recursion, keep an arraylist of points(row,col), and keep adding to it
- iterate
  - sometimes, keep an additional boolean[][] visited array to avoid recounting a cell that has already been counted

##### Lines and Graphs

- represent lines as a pair (slope, y-intercept) -> able to check if two
  inifinite lines are the same
  - slope = (a.y-b.y)/(a.x-b.x)
  - y intercept = a.y - slope * a.x  -> y=mx+b -> b = y-mx
- completely vertical line have infinite slope, be careful

##### General

- subarray: contiguous subarray?
- subsequent: elements whose subscripts are increasing in the original sequence
- subset: any possible combinations of original set
- the use of int vs. long, ask if 64 bit long is necessary
- in the end after completing the problem, think about a test cases that have very long and large input, see if the algorithm needs to deal with smaller ones. eg. really long String may cause a running out of heap space.
