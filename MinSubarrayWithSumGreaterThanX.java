/*
Smallest subarray with sum greater than a given value
Given an array of integers and a number x, find the smallest subarray with sum greater than the given value.

Examples:
arr[] = {1, 4, 45, 6, 0, 19}
   x  =  51
Output: 3
Minimum length subarray is {4, 45, 6}

arr[] = {1, 10, 5, 2, 7}
   x  = 9
Output: 1
Minimum length subarray is {10}

arr[] = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250}
    x = 280
Output: 4
Minimum length subarray is {100, 1, 0, 200}
*/

public int smallestSubWithSum(int arr[], int x){
	int curr = 0;
	int len = arr.length;

	int start = 0, end = 0;
	while (end < arr.length){

		while (curr <= x && end < arr.length)
			curr += arr[end++];

		while (curr > x && start < arr.length){
			if (end - start < len)
				len = end - start;

			curr -= arr[start++];
		}
	}
	return len;
}