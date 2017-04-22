### Big O

The runtime of a recursive function with multiple branches is typically O(branches^depth).

- Eg. iterate through a balanced binary tree:
O(2^lg2) = O(n)
- Eg. sort an array of string, each string needs to be sorted as well
	- Need to specify what each variable in the big o notation means
		- A is length of array
		- S is the length of the **longest** string in the array
	- a*s(lgs) + s*alga because when sorting the array, each string needs to be compared with each other in O(s) time

- Eg. check if a number is prime

* Runtime: O(sqrt(n))

```
boolean isPrime(int n){
	for(int x = 2; x*x <= n; x++){
		if(n%x ==0) return false;
	}
	return true;
}
```
