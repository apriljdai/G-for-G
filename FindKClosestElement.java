/*
Find k closest elements to a given value
Given a sorted array arr[] and a value X, find the k closest elements to X in arr[]. 
Examples:

Input: K = 4, X = 35
       arr[] = {12, 16, 22, 30, 35, 39, 42, 
               45, 48, 50, 53, 55, 56}
Output: 30 39 42 45
Note that if the element is present in array, then it should not be in output, only the other closest elements are required.
*/

public int[] findCrossOver(int arr[], int k, int x){
	int[] res = new int[k];

	int left = 0, right = arr.length - 1;
	if (arr[right] < x){
		for (int i = 0; i < k; i++){
			res[i] = arr[right - k + i]; 
		}
		return res;
	}

	if (arr[left] > x){
		for (int i = 0; i < k; i++){
			res[i] = arr[i];
		}
		return res;
	}

	while (left < right){
		int mid = left + (right - left) / 2;

		if (arr[mid] <= x && arr[mid + 1] > x){
			for (int i = 0; i < k; i++){
				res[i] = arr[mid - k / 2 + i];
			}
			return res;
		}

		if (arr[mid] < x)
			left = mid + 1;
		else
			right = mid - 1;
	}
	return res;
}