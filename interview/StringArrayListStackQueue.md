### Strings and Arrays

- based on ascii code, total of 128 chars(eg. str.length()>128 = not unique in characters, or > 26 depending on questions)
- ```int val = str.charAt(i) - 'a' ``` converts a char to 0-25 scale
- sorting as first step: 
```
char[] arr = str.toCharArray(); 
Arrays.sort(arr); 
return new String(arr);
```
- ```s.length() != t.length()```: think about conditions that must be met first
- can use 2D arrays sometimes for pairs: 

```
String[][] pairs = {{"apple", "pleap"}, {"waterbottle", "erbottlewat"}, {"camera", "macera"}};
```
- for(char c : word.toCharArray()) instead of charAt(i) where i = 0 to word.length()

#### Binary Search On Arrays
- search space: range(sorted array) vs. value(unsorted array)
- eg (sorted,range=maxIndex-minIndex). 
    - whenever see sorted in the question, likely needs binary search
    - normal binary search
    - binary search on rotated array by comparing value at index
    - find peak/valley element, get two values at index (`nums[mid]`, `nums[mid+1]`), then take either half
        - two neighboring values tell us which side solution is on, so read two values everytime
    - two sum question on sorted array, use two pointers+binary search

- eg (unsorted,value=maxVal-minVal).
   - find the duplicate number, use pigeon-hole principle, count number of elements smaller than mid value
   - kth smallest element in sorted matrix (sorted but in 2D, so not using range), `maxVal - minVal`, count number of elements smaller than mid value, then decide which half to take

### Linked Lists

- for a singly linked list, to delete a node, no need a prev pointer, check value using ```n.next.data = d```
- can insert to a singly linked list by pointing next to current head(CAN be used to reverse a linked list)

- "runner technique"(second pointer), the "fast" pointer might be ahead by a fixed amount, or hopping fixed number of nodes, "slow pointer" goes on by one
  
  eg. fast pointer jumps by 2, slow jumps by 1, when fast reaches end of the list, slow is at midpoint(used when we don't know the len of list)
```
while(fast != null && fast.next != null){}, then if(fast!=null) // odd number of nodes in list, slow.next if middle element
```

- Use stack is better sometimes
- ```while (k > 0 && current != null)```: often two conditions in while, one boundary, one actual
- recusive problems, many linked lists problems rely on recursion, use when stuck on a ll problem

eg1.
find kth to last element in a singly linked list:

- runner: move first pointer to kth position, then both pointer go forward at the same time.
- recursive(like backtracking): recurse first, then do things
  
  ```
  index = recur(head.next)+1; 
  if(index=k) print;
  carry = addList(l1.next, l2.next); 
  sum = carry + l1.data + l2.data;
  ```


### Stacks and Queues

- Stacks more preferable than arrays in some problems (stack or multistack).

- Useful in certain recursive algorithms, push temporary data onto a stack as you recurse, but remove as we backtrack(eg.recursive check failed)

- Used to implement a recursive algorithm iteratively

- Add to queue: 
```
	if(last!=null){
		last.next = node;
	} 
	last = node; 
	if(first==null){first=last};
```

- Queues are often used in Breadth-First Search or in implementing a cache

- Can always augment a data structure(eg. node) to store more attributes so that no additional space is used. 
	- eg. min of a stack: store min with the node being pushed
	- eg. Cats linkedlists and dog linkedlists as one data structure, keep order 1-n in node to know their orders
	
- List of stacks, queues, etc (combination of ADSs), 
	- eg. multiple stacks stored in a arraylist(dynamic) so that when one is full, can add another new stack to the list
	- Sort a stack with another helper stack, one approach as below, another approach mergesort
	
```
	public static void sort(Stack<Integer> s) {
		Stack<Integer> r = new Stack<Integer>();
		while(!s.isEmpty()) {
			/* Insert each element in s in sorted order into r. */
			int tmp = s.pop();
			while(!r.isEmpty() && r.peek() > tmp) {
				s.push(r.pop());
			}
			r.push(tmp);
		}
		
		/* Copy the elements back. */
		while (!r.isEmpty()) {
			s.push(r.pop());
		}
	}
```


```
public static Stack<Integer> mergesort(Stack<Integer> inStack) {
		if (inStack.size() <= 1) {
			return inStack;
		}

		Stack<Integer> left = new Stack<Integer>();
		Stack<Integer> right = new Stack<Integer>();
		int count = 0;
		while (inStack.size() != 0) {
			count++;
			if (count % 2 == 0) {
				left.push(inStack.pop());
			} else {
				right.push(inStack.pop());
			}
		}

		left = mergesort(left);
		right = mergesort(right);

		while (left.size() > 0 || right.size() > 0) {
			if (left.size() == 0) {
				inStack.push(right.pop());
			} else if (right.size() == 0) {
				inStack.push(left.pop());
			} else if (right.peek().compareTo(left.peek()) <= 0) {
				inStack.push(left.pop());
			} else {
				inStack.push(right.pop());
			}
		}

		Stack<Integer> reverseStack = new Stack<Integer>();
		while (inStack.size() > 0) {
			reverseStack.push(inStack.pop());
		}

		return reverseStack;
	}
```

### Heap
- usually see in question 
    - find `kth`, `top k`, etc