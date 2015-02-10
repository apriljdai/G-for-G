/*
Max-k elements question

(1) Given an array of unsorted non-negative integers of length z, write a function that returns the value of the maximum element. What is the running time?
*/

public int findMax(int arr[]){
	int temp = -1;
	for (int a: arr){
		if (temp < a){
			temp = a;
		}
	}
	return temp;
}
//runtime: O(Z)

/*
(2) Same question, except the array is sorted.
*/

public int findMax(int arr[]){
	int len = arr.length - 1;
	return arr[len];
}
//runtime: O(1)

/*
(3) Same question, except the array is unsorted again, and you need to return the maximum two elements, not just one.
*/

public int[] findMax(int arr[]){
	int res[] = new int[2];

	res[0] = Math.max(arr[0], arr[1]);
	res[1] = Math.min(arr[0], arr[1]);

	for (int i = 2; i < arr.length; i++){
		if (arr[i] > res[1]){
			res[1] = arr[i];
			if (res[1] > res[0])
				swap(res[1], res[0]);
		}
	}
	return res;
}
public void swap(int a, int b){
	int temp = a;
	a = b;
	b = temp;
}
//runtime: O(Z)

/*
(4) Same question, except you need to return the maximum k values, where k is a positive integer less than z.
*/

/*
Better Answer: use a minheap data structure to keep track of the k maximum elements. Comparison with the minimum element is O (1) and insertion and deletion from the heap can be done in O(logk). Running time is O(zlogk).
(5) Same question, except you can only use O(1) memory to accomplish the problem.
Answer: Sort the array, using an in-place sort, and return the top k elements. Running time: O(zlogz). At which point I will ask for a...
Better answer (I wouldn't expect anyone to get this): Use a selection algorithm (randomized is good, deterministic is better) to find the k-th largest element in the array. Then, run a partition algorithm with that element as the pivot (partition is a subroutine of quicksort). Running time is O(z). Another good answer: Run a max-heapify procedure on the array and then pop the first k elements off the heap. Running time is O(z + klogz). Another alright answer: Run through the array k times. On the ith iteration (for i = 0 to k-1), print out the n - i'th largest number. Running time is O(zk). This may or may not be better than sorting, depending on how fast z is growing proportional to k (for instance, if k = logz, the solutions have identical running time).
Another good answer: Scott/Joao's quintile solution.
(6) Same question, except that you need to return the k maximum elements in sorted order. Answer: Use selection/partition, and then sort the top k elements. Running time is O(z + klogk).
(7) Given a sorted array of non-negative integers and a value x, write a function that returns the index of the the element in the array if it is found, and -1 if the element does not exist in the array.
Answer: Binary search. Running time is O(logz).
*/