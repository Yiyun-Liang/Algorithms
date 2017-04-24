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

