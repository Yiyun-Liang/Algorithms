## Trees and Graphs 

#### Binary trees

- *Duplicate values* (handled differently for different definitions of a binary tree, eg. not allowed, be on the right, either side)
- **Binary tree vs. binary search tree**, make sure to clarify
- **Balanced vs. unbalanced**, make sure to clarify
Balanced does not mean the left and right subtrees are exactly the same size(actually means not terribly imbalanced, takes roughly O(lgn) for insert and find)
	- **Red-Black Trees vs. AVL Trees**
- **Full Binary Trees** (every node has either zero or two children) 
- **Complete Binary Trees** (every level is fully filled, except for perhaps the last level, eg. heaps) 
- **Perfect Binary Trees** (both full and complete, all leaf nodes at same level, exactly 2^k-1 nodes, k is # level)

#### Heaps(min): 
each node is smaller than its children

- bubble down with *smaller of the two children* to main heap properties

#### Tries(Prefix Trees)
variant of an n-ary tree, characters are stored in each node, each path down the tree may represent a word

- Usually * nodes(*null nodes*) are used to indicate complete words(boolean flag in parent node or a terminatingTrieNode inherits from TrieNode)
- **Quick prefix lookup** for english language, compared to hashtable which is fast for lookup but not fast for prefix lookup or has same run time for word lookup O(len)
