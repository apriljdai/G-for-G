/*
Find the missing number in Arithmetic Progression
Given an array that represents elements of arithmetic progression in order. 
One element is missing in the progression, find the missing number.
*/

public int findMissing(int arr[], int n){
	int diff = (arr[n - 1] - arr[0]) / n;
	return findMissing(arr[], 0, n - 1, diff);
}

public int findMissing(int arr[], int low, int high, int diff){
	if (low >= high)
		return Integer.MAX_VALUE;

	int mid = low + (high - low) / 2;

	if (arr[mid + 1] - arr[mid] != diff)
		return arr[mid] + diff;

	if (mid > 0 && arr[mid] - arr[mid - 1] != diff)
		return arr[mid - 1] + diff;

	if (arr[mid] == arr[0] + mid * diff)
		return findMissing(arr, mid + 1, high, diff);
	else
		return findMissing(arr, low, mid - 1, diff);
}