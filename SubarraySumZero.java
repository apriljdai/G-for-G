/*
Find if there is a subarray with 0 sum
Given an array of positive and negative numbers, find if there is a subarray with 0 sum.

Examples:

Input: {4, 2, -3, 1, 6}
Output: true 
There is a subarray with zero sum from index 1 to 3.

Input: {4, 2, 0, 1, 6}
Output: true 
There is a subarray with zero sum from index 2 to 2.

Input: {-3, 2, 3, 1, 6}
Output: false
There is no subarray with zero sum.
*/

public boolean subSumtoZero(int arr[]){
	HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
	int sum = 0;

	for (int i = 0; i < arr.length; i++){
		sum += arr[i];

		// a) Current element is 0
        // b) sum of elements from 0 to i is 0
        // c) sum is already present in hash map
		if (arr[i] == 0 || sum == 0 || hm.get(sum) != null)
			return true;
		hm.put(sum, i);
	}
	return false;
}