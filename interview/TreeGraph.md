## Trees
- a type of graph
- a connected graph without cycles

- typically only need a node class, don't need a tree class
- check if the node is null before calling its attributes like left, right, parent

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


## Graphs

- a collection of nodes with edges between (some of) them
- **directed** vs **undirected**
- **connected** vs **several isolated subgraphs**
- **have cycles** vs **acyclic**

- do need both a node and a graph class because can't necessarily reach all the nodes from a single node

##### adjacency list:
```
// class can be replaced with an array or 
// a hashtable of lists(arrays, arraylists, linkedlists)
class Graph{
	Node[] nodes;
}

// we prefer using a node class
class Node{
	String name;
	Node[] adj;
	boolean visited; // or State state; 
}

public enum State {
	Unvisited, Visited, Visiting;
} 
```

##### adjacency matrices:
- N*N boolean(or 0 vs. 1) matrix (where n is # of nodes), true means there is an edge between m[ i ][ j ] from node i to node j

### Operations
- NEED to check if the node is visited or not (different from a tree), otherwise, stuck in an infinite loop
- BFS and DFS should be functions in Graph class (then do not need to pass G to these functions because we are calling G.BFS or G.DFS)

#### Depth-First Search (DFS):
- a bit simpler for visiting every node in the graph

```
// recursive
void DFS(Graph G, Node n){
	if(n == null) return;  // check
	
	// first set all nodes to unvisted 
	for(Node u : G.getNodes()){
		u.visited = false;
    }
	
	visit(n);
	n.visited = true;
	
	for(Node adjNode: n.adj){
		if(!adjNode.visited){
			DFS(G, adjNode);
		}
	}
}
```

#### Breadth-First Search (BFS):
- better for getting the shortest path (or just any path) between two nodes (distance +1 every time)

```
// iterative
void BFS(Graph G, Node n){  
	Queue<Node> queue = new Linkedlist<>();
	
	// first set all nodes to unvisted 
	for(Node u : G.getNodes()){
		u.visited = false;
    }
	
	n.visited = true;
	queue.add(n);  // because its a linkedlist implementation of quque
	
	while(!queue.isEmpty){
		Node t = queue.dequeue(); // from the front
		visit(t);
	
		for(Node adjNode: t.adj){
			if(!adjNode.visited){
				adjNode.visited = true;
				queue.add(adjNode);
			}
		}
	}
}
```

#### Bidirectional Search:
- used to find the shortest path between a source node and a destination node
- ***running two simultaneous BFS, one from each node, when their searches collide, we have found a path***
- eg. "A-B-C-D-E" between node A and node E, after 2 levels each, 4 levels total, their searches collide at node C
- faster than BFS(4 levels for the example above) because if each node has at most k adj nodes and A and B are at distance d, then in BFS, in the first level, we search for k nodes, in the second level, we search for k^2 nodes, thus we have to search for k^d nodes. But in BS, we only need to search for k^(d/2)+k^(d/2) =  O(k^(d/2)) nodes which is k^(d/2) times faster.


#### Practice
[Trees](https://github.com/Yiyun-Liang/Algorithms/tree/master/src/com/isa/Interviews/Trees)

[Graphs](https://github.com/Yiyun-Liang/Algorithms/tree/master/src/com/isa/Interviews/Graphs)